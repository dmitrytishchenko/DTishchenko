package ru.job4j.tracker;

import org.apache.logging.log4j.Logger;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static org.apache.logging.log4j.LogManager.getLogger;


public class TrackerSQL implements ITracker, AutoCloseable {
    private Connection connection;
    private String name = "postgres";
    private String password = "password";
    private String url = "jdbc:postgresql://localhost:5432/java_a_from_z";
    private static final Logger LOG = getLogger(TrackerSQL.class);

    public boolean init() throws Exception {
        try {
            connection = DriverManager.getConnection(url, name, password);
        } catch (SQLException e) {
            LOG.error(e.getMessage(), e);
        }
        return connection != null;
    }

    public boolean createTable() {
        boolean result = false;
        try (Statement st = connection.createStatement()) {
            result = st.execute("CREATE TABLE IF NOT EXISTS item "
                    + "(id varchar(100) primary key, "
                    + "name varchar (100),"
                    + "description varchar(100))");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public Item add(Item item) {
        Item result = null;
        String sql = "INSERT INTO item(name, description) VALUES(?, ?)";
        try (PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            ps.setString(1, item.getName());
            ps.setString(2, item.getDesc());
            ps.executeUpdate();
            result = item;
        } catch (SQLException e) {
            LOG.error("Error occured in creating item", e);
        }
        return result;
    }

    @Override
    public boolean replace(String id, Item item) {
        boolean result = false;
        String sql = "UPDATE item AS i SET name = ?, description = ? WHERE i.id = id";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setString(1, item.getName());
            ps.setString(2, item.getDesc());
            int value = ps.executeUpdate();
            if (value > 0) {
                result = true;
            }
        } catch (SQLException e) {
            LOG.error("Error replaced the item", e);
        }

        return result;
    }

    @Override
    public boolean delete(String id) {
        boolean result = false;
        String sql = "DELETE FROM item WHERE id = ?";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setString(1, id);
            int value = ps.executeUpdate();
            if (value > 0) {
                result = true;
            }
        } catch (SQLException e) {
            LOG.error("Error delete the item", e);
        }
        return result;
    }

    @Override
    public List<Item> findAll() {
        List<Item> list = new ArrayList<>();
        String sql = "SELECT * FROM item";
        try (Statement st = connection.createStatement();
             ResultSet rs = st.executeQuery(sql)) {
            while (rs.next()) {
                list.add(new Item(rs.getString("name"), rs.getString("description")));
            }
        } catch (SQLException e) {
            LOG.error("Error find the items", e);
        }
        return list;
    }

    @Override
    public List<Item> findByName(String key) {
        List<Item> list = new ArrayList<>();
        String sql = "SELECT name FROM item WHERE name = ?";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setString(1, key);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Item(rs.getString("name")));
            }
        } catch (SQLException e) {
            LOG.error("Error find the item", e);
        }
        return list;
    }

    @Override
    public Item findById(String id) {
        Item item = null;
        String sql = "SELECT id FROM item WHERE id = ?";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setString(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                item = new Item(rs.getString(id));
            }
        } catch (SQLException e) {
            LOG.error("Error find the item", e);
        }
        return item;
    }

    @Override
    public void close() throws Exception {
        if (this.connection != null) {
            connection.close();
        }
    }
}

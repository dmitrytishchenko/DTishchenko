package ru.job4j.xmlxslt;

import javax.xml.bind.annotation.XmlRootElement;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@XmlRootElement
public class StoreSQL implements AutoCloseable {
    private Config config;
    private Connection connection;
    public List<Entry> list = new ArrayList<>();

    public StoreSQL(Config config) {
        this.config = config;
        try {
            this.connection = DriverManager.getConnection("jdbc:sqlite:");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public StoreSQL(List<Entry> list) {
        this.list = list;
    }

    public StoreSQL() {
    }

    /**
     * создание базы данных
     */
    public void createNewDatabase(String storage) {
        try (Connection connection = DriverManager.getConnection("jdbc:sqlite:" + storage)) {
            if (connection != null) {
                DatabaseMetaData metaData = connection.getMetaData();
                System.out.println("The driver name is " + metaData.getDriverName());
                System.out.println("A new database has been created.");
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * создание таблицы с полем int field
     */
    public void createTable() {
        try (Statement st = connection.createStatement()) {
            String sql = "CREATE TABLE IF NOT EXISTS entry (field INT)";
            st.execute(sql);
            System.out.println("Table entry is created");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * очистка таблицы
     */
    public void clearTable() {
        try (Statement st = connection.createStatement()) {
            String clearTable = "DELETE FROM entry";
            st.execute(clearTable);
            System.out.println("Table entry is cleared");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void generate(int size) {
        this.clearTable();
        String sql = "INSERT INTO entry (field)VALUES(?)";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            connection.setAutoCommit(false);
            for (int i = 1; i <= size; i++) {
                ps.setInt(1, i);
                ps.addBatch();
            }
            ps.executeBatch();
            System.out.println("Table is full");
            connection.commit();
        } catch (Exception e) {
            e.printStackTrace();
            try {
                connection.rollback();
            } catch (Exception e1) {
                e1.printStackTrace();
            }
        }
    }

    public List<Entry> load() {
        String sql = "SELECT * FROM entry";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Entry entry = new Entry(rs.getInt("field"));
                list.add(entry);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public void close() throws Exception {
        if (connection != null) {
            connection.close();
        }
    }
}

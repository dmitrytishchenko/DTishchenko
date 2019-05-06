package ru.job4j.xmlxslt;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StoreSQL implements AutoCloseable {
    private final Config config;
    private Connection connection;

    public StoreSQL(Config config) {
        this.config = config;
        try {
            this.connection = DriverManager.getConnection("jdbc:sqlite:test.db");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * создание базы данных
     */
    public void createNewDatabase(String storage) {
        try (Connection connection = DriverManager.getConnection("jdbc:sqlite:test.db" + storage)) {
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
     * очистка таблицы
     */
    public void createTable() {
        String sql = "CREATE TABLE IF NOT EXISTS Entries (field INT)";
        String clearTable = "DELETE FROM Entries";
        try (Statement st = connection.createStatement()) {
            st.execute(sql);
            System.out.println("Table Entries is created");
            st.execute(clearTable);
            System.out.println("Table Entries is cleared");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void generate(int size) {
        String sql = "INSERT INTO Entries (field) VALUES(?)";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            connection.setAutoCommit(false);
            for (int i = 1; i <= size; i++) {
                ps.setInt(1, i);
            }
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
        List<Entry> list = new ArrayList<>();
        String sql = "SELECT field FROM Entries";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Entry entry = new Entry(rs.getInt("field"));
                list.add(entry);
                System.out.println(list);
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

    public static void main(String[] args) {
        Config config = new Config();
        StoreSQL st = new StoreSQL(config);
        config.init();
        st.createNewDatabase("magnit");
        st.createTable();
        st.generate(5);
        st.load();
    }
}

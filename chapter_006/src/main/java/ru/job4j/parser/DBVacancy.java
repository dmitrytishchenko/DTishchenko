package ru.job4j.parser;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;

public class DBVacancy {
    private ConfigPars config;
    private Connection connection;

    public DBVacancy(ConfigPars config) {
        this.config = config;
        try {
            Class.forName(this.config.get("driver-class-name"));
            this.connection = DriverManager.getConnection(
                    config.get("url"),
                    config.get("username"),
                    config.get("password"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * создание таблицы БД
     */
    public void createTable() {
        try (Statement st = connection.createStatement()) {
            String sql = "CREATE TABLE Vacancies (id SERIAL PRIMARY KEY, Name UNIQUE VARCHAR(200), Text TEXT, Link TEXT)";
            st.executeUpdate(sql);
            System.out.println("Table Vacancies is create");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * создание БД
     */
    public void createDB() {
        try {
            Class.forName(this.config.get("driver-class-name"));
            this.connection = DriverManager.getConnection(
                    config.get("url"),
                    config.get("username"),
                    config.get("password"));
            Statement st = connection.createStatement();
            st.execute("CREATE DATABASE parserDB");
            System.out.println("DB is create");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void add(Vacancy vacancy) {
        String sql = "INSERT INTO vacancies(Name, Text, Link) VALUES(?, ?, ?)";
        try (PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            ps.setString(1, vacancy.getName());
            ps.setString(2, vacancy.getText());
            ps.setString(3, vacancy.getLink());
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

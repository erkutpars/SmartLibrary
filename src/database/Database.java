package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Database {

    private static final String DB_URL = "jdbc:sqlite:SmartLibrary.db";

    public static Connection connect() throws SQLException {
        return DriverManager.getConnection(DB_URL);
    }

    public static void createTables() {

        String bookTable =
            "CREATE TABLE IF NOT EXISTS books (" +
            "id INTEGER PRIMARY KEY AUTOINCREMENT," +
            "title TEXT NOT NULL," +
            "author TEXT NOT NULL," +
            "year INTEGER);";

        String studentTable =
            "CREATE TABLE IF NOT EXISTS students (" +
            "id INTEGER PRIMARY KEY AUTOINCREMENT," +
            "name TEXT NOT NULL," +
            "department TEXT);";

        String loanTable =
            "CREATE TABLE IF NOT EXISTS loans (" +
            "id INTEGER PRIMARY KEY AUTOINCREMENT," +
            "bookId INTEGER NOT NULL," +
            "studentId INTEGER NOT NULL," +
            "dateBorrowed TEXT NOT NULL," +
            "dateReturned TEXT);";

        try (Connection conn = connect(); Statement stmt = conn.createStatement()) {
            stmt.execute(bookTable);
            stmt.execute(studentTable);
            stmt.execute(loanTable);
        } catch (SQLException e) {
            System.out.println("[DB] Hata: " + e.getMessage());
        }
    }
}

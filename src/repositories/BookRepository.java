package repositories;

import database.Database;
import models.Book;

import java.sql.*;
import java.util.ArrayList;
import java.util.Optional;

public class BookRepository {

    public void add(Book book) {
        String sql = "INSERT INTO books(title, author, year) VALUES(?,?,?)";
        try (Connection conn = Database.connect();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, book.getTitle());
            ps.setString(2, book.getAuthor());
            ps.setInt(3, book.getYear());
            ps.executeUpdate();

        } catch (SQLException e) {
            System.out.println("[BookRepo] Ekleme hatası: " + e.getMessage());
        }
    }

    public ArrayList<Book> getAll() {
        ArrayList<Book> list = new ArrayList<>();
        String sql = "SELECT * FROM books";

        try (Connection conn = Database.connect();
             Statement st = conn.createStatement();
             ResultSet rs = st.executeQuery(sql)) {

            while (rs.next()) {
                list.add(new Book(
                    rs.getInt("id"),
                    rs.getString("title"),
                    rs.getString("author"),
                    rs.getInt("year")
                ));
            }
        } catch (SQLException e) {
            System.out.println("[BookRepo] Listeleme hatası: " + e.getMessage());
        }
        return list;
    }
}

package com.samples.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.samples.domain.Book;
import com.samples.domain.Chapter;

public class BookstoreService {

	public void addBook(Book book) {
		
		Connection connection = null;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://localhost/bookstore", "root", "1182511");
			
			PreparedStatement stmt = connection.prepareStatement("insert into publisher (code, publisher_name) values (?, ?)");
			stmt.setString(1, book.getPublisher().getCode());
			stmt.setString(2, book.getPublisher().getName());
			stmt.executeUpdate();
			stmt.close();
			
			stmt = connection.prepareStatement("insert into book (isbn, book_name, publisher_code) values (?, ?, ?)");
			stmt.setString(1, book.getIsbn());
			stmt.setString(2, book.getName());
			stmt.setString(3, book.getPublisher().getCode());
			stmt.executeUpdate();
			stmt.close();
			
			stmt = connection.prepareStatement("insert into chapter (book_isbn, chapter_num, title) values (?, ?, ?)");
			for (Chapter chapter : book.getChapters()) {
				stmt.setString(1, book.getIsbn());
				stmt.setInt(2, chapter.getChapterNumber());
				stmt.setString(3, chapter.getTitle());
				stmt.executeUpdate();
			}
			stmt.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
	}

	
	
}
package com.samples;

import java.util.ArrayList;
import java.util.List;

import com.samples.domain.Book;
import com.samples.domain.Chapter;
import com.samples.domain.Publisher;
import com.samples.service.BookstoreService;

public class BookstoreTest {

	public static void main(String[] args) {
		
		Publisher publisher = new Publisher("cann", "canning");
		
		Book book = new Book("isbn-000117jd93302", "Java tBible", publisher);
		
		List<Chapter> chapters = new ArrayList<>();
		Chapter chapter1 = new Chapter(1, "Introduction");
		Chapter chapter2 = new Chapter(2, "Datatypes");
		Chapter chapter3 = new Chapter(3, "Loops");
		chapters.add(chapter1);
		chapters.add(chapter2);
		chapters.add(chapter3);
		
		book.setChapters(chapters);
		
		BookstoreService bookStoreService = new BookstoreService();
		bookStoreService.addBook(book);
		
	}
	
}
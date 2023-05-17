package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.dto.BookDTO;
import com.service.BookService;

@RestController
@RequestMapping("book")
@CrossOrigin(origins = "http://localhost:4200")
public class BookController {

	@Autowired
	BookService bookService;

	@RequestMapping(path = "", method = RequestMethod.GET)
	public List<BookDTO> getBookList() {
		return bookService.getBookList();
	}

	@RequestMapping(path = "", method = RequestMethod.POST)
	public ResponseEntity<String> addBook(@RequestBody BookDTO bookDTO) {
		boolean flag = bookService.add(bookDTO);
		if (flag) {
			return ResponseEntity.status(HttpStatus.CREATED).body("Record Insert Successful...");
		} else {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST)
					.body("Oops, Something Went Wrong. Please Try Again Later...");
		}
	}

	@RequestMapping(path = "/{id}", method = RequestMethod.DELETE)
	public void deleteBook(@PathVariable("id") int id) {
		bookService.deleteById(id);
	}
}

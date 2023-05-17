package com.service;

import java.util.List;

import com.dto.BookDTO;

public interface BookService {

	List<BookDTO> getBookList();

	Boolean add(BookDTO BookDTO);

	void deleteById(int id);
}

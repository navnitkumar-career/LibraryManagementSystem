package com.serviceimpl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dto.BookDTO;
import com.model.Book;
import com.repository.BookRepository;
import com.service.BookService;

@Service
public class BookServiceimpl implements BookService {

	@Autowired
	BookRepository bookRepository;

	@Autowired
	ModelMapper modelMapper;

	@Override
	public List<BookDTO> getBookList() {
		List<Book> bookList = bookRepository.findAll();
		List<BookDTO> books = bookList.stream().map(t -> {
			BookDTO book = new BookDTO();
			modelMapper.map(t, book);
			return book;
		}).collect(Collectors.toList());
		return books;
	}

	@Override
	public Boolean add(BookDTO bookDTO) {
		Book book = bookRepository.findByTitle(bookDTO.getTitle());
		if(book!=null) {
			return false;
		}
		Book addBook = new Book();
		modelMapper.map(bookDTO, addBook);
		bookRepository.save(addBook);
		return true;
	}

	@Override
	public void deleteById(int id) {
		bookRepository.deleteById(id);
	}

}

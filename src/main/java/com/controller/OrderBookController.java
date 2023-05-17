package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dto.OrderBookDTO;
import com.service.OrderBookService;

@RestController
@RequestMapping("order")
public class OrderBookController {

	@Autowired
	OrderBookService orderBookService;

	@GetMapping("")
	public List<OrderBookDTO> getList() {
		return orderBookService.getOrderList(1);
	}

}






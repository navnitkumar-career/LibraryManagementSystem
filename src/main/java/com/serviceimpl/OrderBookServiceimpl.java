package com.serviceimpl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dto.OrderBookDTO;
import com.model.OrderBook;
import com.repository.OrderBookRepository;
import com.service.OrderBookService;

@Service
public class OrderBookServiceimpl implements OrderBookService {

	@Autowired
	OrderBookRepository orderBookRepository;

	@Autowired
	ModelMapper modelMapper;

	@Override
	public List<OrderBookDTO> getOrderList(int userId) {

		List<OrderBook> orders = orderBookRepository.findByUserId(userId);

		List<OrderBookDTO> ordersDTO = orders.stream().map(t -> {
			OrderBookDTO orderDTO = new OrderBookDTO();
			modelMapper.map(t, orderDTO);
			return orderDTO;
		}).collect(Collectors.toList());
		return ordersDTO;
	}
}

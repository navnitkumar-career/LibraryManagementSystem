package com.service;

import java.util.List;

import com.dto.OrderBookDTO;

public interface OrderBookService {

	List<OrderBookDTO> getOrderList(int userId);
}

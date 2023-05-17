package com.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.model.OrderBook;

@Repository
public interface OrderBookRepository extends JpaRepository<OrderBook, Integer> {

	List<OrderBook> findByUserId(int id);
}

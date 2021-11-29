package com.first.rapi.repositories;

import com.first.rapi.domain.Order;

import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order,Long> {
}

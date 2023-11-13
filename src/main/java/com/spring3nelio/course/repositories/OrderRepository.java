package com.spring3nelio.course.repositories;

import com.spring3nelio.course.entities.Order;
import com.spring3nelio.course.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
}

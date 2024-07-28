package org.mahmoud.orderservice.repsoitories;


import org.mahmoud.orderservice.entities.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, String> {
}

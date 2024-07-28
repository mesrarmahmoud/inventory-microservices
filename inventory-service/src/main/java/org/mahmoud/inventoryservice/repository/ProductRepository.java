package org.mahmoud.inventoryservice.repository;

import org.mahmoud.inventoryservice.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, String> {
}

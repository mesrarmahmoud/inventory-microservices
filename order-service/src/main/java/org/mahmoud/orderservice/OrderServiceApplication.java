package org.mahmoud.orderservice;

import org.mahmoud.orderservice.entities.Order;
import org.mahmoud.orderservice.entities.OrderState;
import org.mahmoud.orderservice.entities.ProductItem;
import org.mahmoud.orderservice.repsoitories.OrderRepository;
import org.mahmoud.orderservice.repsoitories.ProductItemRepository;
import org.mahmoud.orderservice.restclients.InventoryRestClient;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;
import java.util.List;
import java.util.Random;
import java.util.UUID;

@SpringBootApplication
public class OrderServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(OrderServiceApplication.class, args);
	}
	@Bean
	CommandLineRunner commandLineRunner(
			OrderRepository orderRepository,
			ProductItemRepository productItemRepository
	){
		return args -> {
			List<String> productsIds = List.of("P01","P02","P03");
			for (int i = 0; i < 5; i++) {
				Order order = Order.builder()
						.id(UUID.randomUUID().toString())
						.date(LocalDate.now())
						.state(OrderState.PENDING)
						.build();
				Order savedOrder = orderRepository.save(order);
				productsIds.forEach(pId->{
						ProductItem productItem = ProductItem.builder()
							.productId(pId)
							.quantity(new Random().nextInt(20))
							.price(Math.random()*6000+100)
							.order(savedOrder)
							.build();
					productItemRepository.save(productItem);
				});

			}
		};
	}

}

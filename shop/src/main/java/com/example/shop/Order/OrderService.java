package com.example.shop.Order;

import jakarta.persistence.criteria.Order;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor

public class OrderService {
    private final OrderRepository orderRepository;

    public Long createOrder(OrderCreateRequest request) {

        Order existing = orderRepository.findByOrderId(request.getOrderId());
        if (existing != null) {
            throw new RuntimeException("이미 존재하는 주문입니다: " + request.getOrderId());
        }


        Order order = new Order(
                request.getOrderId(),
                request.getLoginId(),
                request.getOrderItems(),
                request.getTotalPrice()
        );

        return order.getId();
    }


    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }


    public Order getOrderById(Long id) {
        Order order = orderRepository.findById(id);
        if (order == null) {
            throw new RuntimeException("해당 주문을 찾을 수 없습니다.");
        }
        return order;
    }


    public void deleteOrder(Long id) {
        Order order = orderRepository.findById(id);
        if (order == null) {
            throw new RuntimeException("해당 주문을 찾을 수 없습니다.");
        }

        orderRepository.deleteById(id);
    }
}


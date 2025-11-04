package com.example.shop.Order;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.criteria.Order;
import org.springframework.stereotype.Repository;

import java.lang.reflect.Member;
import java.util.List;

@Repository
public class OrderRepository {
    @PersistenceContext
    private EntityManager em;



    public Order findById(Long id) {
        return em.find(Order.class, id);
    }

    public List<Order> findAll() {
        return em.createQuery("SELECT m FROM Order m", Order.class)
                .getResultList();
    }
    public Order findByOrderId(String orderId) {
        List<Order> result = em.createQuery(
                        "SELECT m FROM Order m WHERE m.orderId = :orderId", Order.class)
                .setParameter("orderId", orderId).getResultList();

        return result.isEmpty() ? null : result.get(0);
    }

    public void deleteById(Long id) {
        Order order = em.find(Order.class, id);
        em.remove(order);
    }
}

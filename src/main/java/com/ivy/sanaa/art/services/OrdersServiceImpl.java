package com.ivy.sanaa.art.services;

import java.util.List;

public class OrdersServiceImpl<OrdersRepository> {

    private OrdersRepository ordersRepository;

    public OrdersServiceImpl(OrdersRepository ordersRepository) {
        this.ordersRepository = ordersRepository;
    }

    public <Orders, User, Artwork> void save(Orders orders, User user, Artwork artwork) {
        orders.setStatus("Ordered");
        orders.setUser_id(user.getId());
        orders.setArtwork_id(artwork.getId());
        ordersRepository.save(orders);
        System.out.println("Inside order service: " + orders);
    }

    public <Orders> List<Orders> getOrders() {
        return ordersRepository.getOrders();
    }

    public <Orders> List<Orders> findOrdersByUser(int id) {
        return ordersRepository.findOrderByUser(id);
    }

    public <Orders> void updateOrders(Orders orders) {
        ordersRepository.updateOrder(orders);
    }

    public <Orders> Orders findByOrderId(int id) {
        return ordersRepository.findByOrderId(id);
    }
}

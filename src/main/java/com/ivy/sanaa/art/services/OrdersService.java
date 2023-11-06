package com.ivy.sanaa.art.services;


import java.util.List;

import com.ivy.sanaa.art.application.model.entities.Artwork;

public interface OrdersService {

    <Orders, User> void save(Orders orders, User user, Artwork artwork);
    <Orders> List<Orders> getOrders();
    <Orders> List<Orders> findOrdersByUser(int id);
    <Orders> void updateOrders(Orders orders);
    <Orders> Orders findByOrderId(int id);

}

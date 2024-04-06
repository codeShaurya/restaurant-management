package service.impl;

import dto.MenuItem;
import dto.OrderItem;
import dto.Orders;
import enums.OrderStatus;
import exceptions.BadRequestException;
import repository.IMenuRepository;
import repository.IOrderRepository;
import service.IOrderService;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Random;

public class OrderServiceImpl implements IOrderService {

   private final IOrderRepository orderRepository;
   private final IMenuRepository menuRepository;

   public OrderServiceImpl(IOrderRepository orderRepository, IMenuRepository menuRepository) {

      this.orderRepository = orderRepository;
      this.menuRepository = menuRepository;
   }

   @Override
   public Orders createOrder(Integer cusId, Integer tableId) throws BadRequestException {

      return this.orderRepository.createOrder(
            new Orders(getNextOrderId(), cusId, tableId, OrderStatus.CREATED, new ArrayList<>()));
   }

   @Override
   public Orders addItemInOrder(Integer customerId, String name, Integer quantity) throws BadRequestException {

      MenuItem menuItem = this.menuRepository.getMenuItem(null, name);
      List<Orders> orders = this.orderRepository.getOrder(customerId, OrderStatus.CREATED);

      if (Objects.isNull(orders) || orders.isEmpty()) {
         throw new BadRequestException("Customer need to create the order first");
      }

      Orders order = orders.get(0);
      order.getOrderItems().add(new OrderItem(order.getOrderId(), menuItem.getMenuId(), menuItem.getName(), quantity,
            menuItem.getPrice()));

      return this.orderRepository.addOrderItem(order);
   }

   private Integer getNextOrderId() {

      Random rand = new Random();

      // Generating a random integer within the specified range
      return rand.nextInt((1000 - 1) + 1) + 1;
   }
}


package service.impl;

import dto.MenuItem;
import dto.OrderItem;
import dto.Orders;
import enums.OrderStatus;
import exceptions.BadRequestException;
import repository.MenuRepository;
import repository.OrderRepository;
import service.MenuService;
import service.OrderService;

import java.util.ArrayList;

public class IOrderService implements OrderService {

   private OrderRepository orderRepository;
   private MenuRepository menuRepository;

   public IOrderService(OrderRepository orderRepository, MenuRepository menuRepository) {

      this.orderRepository = orderRepository;
      this.menuRepository = menuRepository;
   }

   @Override
   public Orders createOrder(Integer orderId, Integer cusId, Integer tableId) {
      try {
         return this.orderRepository.createOrder(
               new Orders(orderId, cusId, tableId, OrderStatus.PLACED, new ArrayList<>())
         );
      } catch (BadRequestException e) {
         return new Orders();
      }
   }

   @Override
   public Orders addItemInOrder(Integer customerId, String name, Integer quantity) {
      try {
         MenuItem menuItem = this.menuRepository.getMenuItem(null, name);
         Orders order = this.orderRepository.getOrder(customerId);
         order.getOrderItems().add(
               new OrderItem(
                     order.getOrderId(),
                     menuItem.getMenuId(),
                     menuItem.getName(),
                     quantity,
                     menuItem.getPrice()
               )
         );

         return this.orderRepository.addOrderItem(order);
      } catch (BadRequestException e) {
         return null;
      }
   }
}

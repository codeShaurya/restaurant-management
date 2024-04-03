package repository.impl;

import dto.Orders;
import exceptions.BadRequestException;
import repository.BillRepository;
import repository.MenuRepository;
import repository.OrderRepository;

import java.util.HashMap;
import java.util.Map;

public class IOrderRepository implements OrderRepository {
   private static OrderRepository instance;
   public Map<Integer, Orders> orders = new HashMap<Integer, Orders>();
   public Map<Integer, Integer> cusOrders = new HashMap<Integer, Integer>();

   private IOrderRepository() {
      // Initialization code if needed
   }

   public static IOrderRepository getInstance() {

      if (instance == null) {
         synchronized (OrderRepository.class) {
            if (instance == null) {
               instance = new IOrderRepository();
            }
         }
      }

      return (IOrderRepository) instance;
   }

   @Override
   public Orders createOrder(Orders order) throws BadRequestException {

      orders.put(order.getOrderId(), order);
      cusOrders.put(order.getCustomerId(), order.getOrderId());

      return order;
   }

   @Override
   public Orders addOrderItem(Orders order) throws BadRequestException {
      orders.put(order.getOrderId(), order);

      return order;
   }

   @Override
   public Orders getOrder(Integer customerId) throws BadRequestException {
      return orders.get(cusOrders.get(customerId));
   }
}

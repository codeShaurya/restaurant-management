package repository.impl;

import dto.Orders;
import enums.OrderStatus;
import exceptions.BadRequestException;
import repository.IOrderRepository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

public class OrderRepositoryImpl implements IOrderRepository {
   public Map<Integer, List<Orders>> orders = new HashMap<Integer, List<Orders>>();
   private static IOrderRepository instance;

   private OrderRepositoryImpl() {
      // Initialization code if needed
   }

   public static OrderRepositoryImpl getInstance() {

      if (instance == null) {
         synchronized (IOrderRepository.class) {
            if (instance == null) {
               instance = new OrderRepositoryImpl();
            }
         }
      }

      return (OrderRepositoryImpl) instance;
   }

   @Override
   public Orders createOrder(Orders order) throws BadRequestException {

      if (Objects.isNull(orders.get(order.getCustomerId()))) {
         orders.put(order.getCustomerId(), new ArrayList<>());
      }

      List<Orders> customerOrders = orders.get(order.getCustomerId());
      customerOrders.add(order);

      orders.put(order.getCustomerId(), customerOrders);
      return order;
   }

   @Override
   public Orders addOrderItem(Orders order) throws BadRequestException {

      if (Objects.isNull(orders.get(order.getCustomerId()))) {
         throw new BadRequestException("No order for this customer");
      }

      List<Orders> allCusOrder = orders.get(order.getCustomerId());
      Optional<Orders> orderToRemove = allCusOrder.stream().filter(o -> order.getOrderId().equals(order.getOrderId()))
            .findFirst();

      orderToRemove.map(allCusOrder::remove).orElse(false);

      allCusOrder.add(order);

      orders.put(order.getCustomerId(), allCusOrder);

      return order;
   }

   @Override
   public List<Orders> getOrder(Integer customerId, OrderStatus status) throws BadRequestException {

      if (Objects.isNull(orders.get(customerId))) {
         throw new BadRequestException("No order for this customer");
      }

      List<Orders> allCusOrders = orders.get(customerId);

      return allCusOrders.stream().filter(order -> order.getStatus().equals(status)).collect(Collectors.toList());
   }
}

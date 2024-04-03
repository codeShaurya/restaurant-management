package service;

import dto.Orders;

public interface OrderService {
   public Orders createOrder(Integer orderId, Integer cusId, Integer tableId);
   public Orders addItemInOrder(Integer customerId, String name, Integer quantity);
}

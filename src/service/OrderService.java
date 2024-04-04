package service;

import dto.Orders;
import exceptions.BadRequestException;

public interface OrderService {
   public Orders createOrder(Integer cusId, Integer tableId) throws BadRequestException;
   public Orders addItemInOrder(Integer customerId, String name, Integer quantity) throws BadRequestException;
}

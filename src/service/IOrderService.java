package service;

import dto.Orders;
import exceptions.BadRequestException;

public interface IOrderService {
   Orders createOrder(Integer cusId, Integer tableId) throws BadRequestException;

   Orders addItemInOrder(Integer customerId, String name, Integer quantity) throws BadRequestException;
}

package repository;

import dto.Orders;
import enums.OrderStatus;
import exceptions.BadRequestException;

import java.util.List;

public interface IOrderRepository {
   Orders createOrder(Orders order) throws BadRequestException;

   Orders addOrderItem(Orders orders) throws BadRequestException;

   List<Orders> getOrder(Integer customerId, OrderStatus status) throws BadRequestException;
}

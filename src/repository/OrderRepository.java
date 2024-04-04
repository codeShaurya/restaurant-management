package repository;

import dto.Orders;
import enums.OrderStatus;
import exceptions.BadRequestException;

import java.util.List;

public interface OrderRepository {
   public Orders createOrder(Orders order) throws BadRequestException;
   public Orders addOrderItem(Orders orders) throws BadRequestException;
   public List<Orders> getOrder(Integer customerId, OrderStatus status) throws BadRequestException;
}

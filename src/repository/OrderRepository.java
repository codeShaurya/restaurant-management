package repository;

import dto.Orders;
import exceptions.BadRequestException;

public interface OrderRepository {
   public Orders createOrder(Orders order) throws BadRequestException;
   public Orders addOrderItem(Orders orders) throws BadRequestException;
   public Orders getOrder(Integer customerId) throws BadRequestException;
}

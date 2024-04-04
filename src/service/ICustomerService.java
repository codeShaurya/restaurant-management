package service;

import dto.Response;

public interface ICustomerService {
   public Response browseMenu();
   public Response createOrder(Integer customerId, Integer tableId);
   public Response createOrderItem(Integer customerId, String name, Integer quantity);
   public Response payBill();
}

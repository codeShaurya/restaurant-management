package service;

import dto.Response;

public interface ICustomerService {
   Response browseMenu();

   Response createOrder(Integer customerId, Integer tableId);

   Response addOrderItem(Integer customerId, String name, Integer quantity);

   Response payBill();
}

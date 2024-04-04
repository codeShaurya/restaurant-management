package service.impl;

import dto.Response;
import exceptions.BadRequestException;
import service.ICustomerService;

public class CustomerService implements ICustomerService {
   private final IMenuService menuService;
   private final IOrderService orderService;

   public CustomerService(IMenuService menuService, IOrderService orderService) {

      this.menuService = menuService;
      this.orderService = orderService;
   }

   @Override
   public Response browseMenu() {
      try {
         return new Response(menuService.showMenu(), "OK", 20);
      } catch (BadRequestException e) {
         return  new Response(null, e.getMessage(), 400);
      }
   }

   @Override
   public Response createOrder(Integer customerId, Integer tableId) {
      try {
         return new Response(
               orderService.createOrder(customerId, tableId),
               "OK",
               200
         );
      } catch (BadRequestException e) {
         return  new Response(null, e.getMessage(), 400);
      }
   }

   @Override
   public Response createOrderItem(Integer customerId, String name, Integer quantity) {
      try {
         return new Response(
               orderService.addItemInOrder(customerId, name, quantity),
               "OK",
               200
         );
      } catch (BadRequestException e) {
         return  new Response(null, e.getMessage(), 400);
      }
   }

   @Override
   public Response payBill() {

      return null;
   }
}

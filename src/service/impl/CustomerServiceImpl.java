package service.impl;

import dto.Response;
import exceptions.BadRequestException;
import service.ICustomerService;
import service.IMenuService;
import service.IOrderService;
import service.IReservationService;

public class CustomerServiceImpl implements ICustomerService {
   private final IMenuService menuService;
   private final IOrderService orderService;
   private final IReservationService reservationService;

   public CustomerServiceImpl(IMenuService menuService, IOrderService orderService,
         IReservationService reservationService) {

      this.menuService = menuService;
      this.orderService = orderService;
      this.reservationService = reservationService;
   }

   @Override
   public Response browseMenu() {

      try {
         return new Response(menuService.showMenu(), "OK", 20);
      } catch (BadRequestException e) {
         return new Response(null, e.getMessage(), 400);
      }
   }

   @Override
   public Response createOrder(Integer customerId, Integer tableId) {

      try {
         reservationService.reserveTable(customerId, tableId);
         return new Response(orderService.createOrder(customerId, tableId), "OK", 200);
      } catch (BadRequestException e) {
         return new Response(null, e.getMessage() + "Could Not create Order", 400);
      }
   }

   @Override
   public Response addOrderItem(Integer customerId, String name, Integer quantity) {

      try {
         return new Response(orderService.addItemInOrder(customerId, name, quantity), "OK", 200);
      } catch (BadRequestException e) {
         return new Response(null, e.getMessage(), 400);
      }
   }

   @Override
   public Response reserveTable(Integer customerId, Integer tableId) {
      try {
         return new Response(
               reservationService.reserveTable(customerId, tableId),
               "OK",
               200
         );
      } catch (BadRequestException e) {
         return new Response(null, e.getMessage(), 400);
      }
   }

   @Override
   public Response freeTable(Integer customerId, Integer tableId) {
      try {
         return new Response(
               reservationService.freeTable(customerId, tableId),
               "OK",
               200
         );
      } catch (BadRequestException e) {
         return new Response(null, e.getMessage(), 400);
      }
   }

   @Override
   public Response payBill() {

      return null;
   }
}

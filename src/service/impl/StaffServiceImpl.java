package service.impl;

import dto.MenuItem;
import dto.Response;
import enums.MenuItemCategory;
import exceptions.BadRequestException;
import service.IMenuService;
import service.IReservationService;
import service.IStaffService;
import service.ITableService;

public class StaffServiceImpl implements IStaffService {
   private final IMenuService menuService;
   private final ITableService tableService;
   private final IReservationService reservationService;

   public StaffServiceImpl(IMenuService menuService, ITableService tableService,
         IReservationService reservationService) {

      this.menuService = menuService;
      this.tableService = tableService;
      this.reservationService = reservationService;
   }

   @Override
   public Response addMenuItem(Integer id, String name, double price, MenuItemCategory category) {

      try {
         MenuItem menuItem = menuService.addMenuItem(id, name, price, category);
         return new Response(menuItem, "OK", 200);
      } catch (BadRequestException e) {
         return new Response(null, e.getMessage(), 400);
      }
   }

   @Override
   public Response updateMenuItem(Integer id, String name, double price) {

      return null;
   }

   @Override
   public Response browseMenu() {

      return null;
   }

   @Override
   public Response generateBill() {

      return null;
   }

   @Override
   public Response addTable(Integer tableId, Integer capacity) {
      try {
         return new Response(tableService.addTable(tableId, capacity), "OK", 200);
      } catch (BadRequestException e) {
         return new Response(null, e.getMessage(), 400);
      }
   }
}

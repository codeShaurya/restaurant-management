package service.impl;

import dto.MenuItem;
import dto.Response;
import enums.MenuItemCategory;
import exceptions.BadRequestException;
import service.IStaffService;
import service.MenuService;

import java.util.List;

public class StaffService implements IStaffService {
   private MenuService menuService;

   public StaffService(MenuService menuService) {

      this.menuService = menuService;
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
}

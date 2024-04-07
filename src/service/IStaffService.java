package service;

import dto.Response;
import enums.MenuItemCategory;

public interface IStaffService {
   public Response addMenuItem(Integer id, String name, double price, MenuItemCategory category);
   public Response updateMenuItem(Integer id, String name, double price);
   public Response browseMenu();
   public Response generateBill();
   public Response addTable(Integer tableId, Integer capacity);
}

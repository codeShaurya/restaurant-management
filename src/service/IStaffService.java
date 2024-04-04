package service;

import dto.MenuItem;
import dto.Response;
import enums.MenuItemCategory;

import java.util.List;

public interface IStaffService {
   public Response addMenuItem(Integer id, String name, double price, MenuItemCategory category);
   public Response updateMenuItem(Integer id, String name, double price);
   public Response browseMenu();
   public Response generateBill();
}

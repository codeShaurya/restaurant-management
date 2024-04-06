package service;

import dto.Response;
import enums.MenuItemCategory;

public interface IStaffService {
   Response addMenuItem(Integer id, String name, double price, MenuItemCategory category);

   Response updateMenuItem(Integer id, String name, double price);

   Response browseMenu();

   Response generateBill();
}

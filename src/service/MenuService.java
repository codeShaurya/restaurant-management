package service;

import dto.MenuItem;
import enums.MenuItemCategory;
import exceptions.BadRequestException;

import java.util.List;

public interface MenuService {
   public MenuItem addMenuItem(Integer id, String  name, double price, MenuItemCategory category);
   public MenuItem updateMenuItemPrice(Integer id, double newPrice);

   public List<MenuItem> showMenu();

   public MenuItem getItem(Integer id, String name) throws BadRequestException;
}

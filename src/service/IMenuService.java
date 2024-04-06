package service;

import dto.MenuItem;
import enums.MenuItemCategory;
import exceptions.BadRequestException;

import java.util.List;

public interface IMenuService {
   MenuItem addMenuItem(Integer id, String name, double price, MenuItemCategory category) throws BadRequestException;

   MenuItem updateMenuItemPrice(Integer id, double newPrice) throws BadRequestException;

   List<MenuItem> showMenu() throws BadRequestException;

   MenuItem getItem(Integer id, String name) throws BadRequestException;
}

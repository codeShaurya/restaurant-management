package repository;

import dto.MenuItem;
import exceptions.BadRequestException;

import java.util.List;

public interface MenuRepository {
   public MenuItem addMenuItem(MenuItem menuItem) throws BadRequestException;
   public MenuItem updateMenuItem(MenuItem menuItem) throws BadRequestException;
   public MenuItem getMenuItem(Integer id, String name) throws BadRequestException;
   public List<MenuItem> getMenuItems() throws BadRequestException;
}

package repository;

import dto.MenuItem;
import exceptions.BadRequestException;

import java.util.List;

public interface IMenuRepository {
   MenuItem addMenuItem(MenuItem menuItem) throws BadRequestException;

   MenuItem updateMenuItem(MenuItem menuItem) throws BadRequestException;

   MenuItem getMenuItem(Integer id, String name) throws BadRequestException;

   List<MenuItem> getMenuItems() throws BadRequestException;
}

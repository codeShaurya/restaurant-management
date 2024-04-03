package repository.impl;

import dto.MenuItem;
import exceptions.BadRequestException;
import repository.BillRepository;
import repository.MenuRepository;

import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class IMenuRepository implements MenuRepository {
   private static MenuRepository instance;
   private Map<Integer, MenuItem> menuItems = new HashMap<Integer, MenuItem>();
   private Map<String, Integer> reverseIndexing = new HashMap<String, Integer>();

   private IMenuRepository() {
      // Initialization code if needed
   }

   public static IMenuRepository getInstance() {

      if (instance == null) {
         synchronized (MenuRepository.class) {
            if (instance == null) {
               instance = new IMenuRepository();
            }
         }
      }

      return (IMenuRepository) instance;
   }

   @Override
   public MenuItem addMenuItem(MenuItem menuItem) {
      menuItems.put(menuItem.getMenuId(), menuItem);
      reverseIndexing.put(menuItem.getName(), menuItem.getMenuId());

      return menuItem;
   }

   @Override
   public MenuItem updateMenuItem(MenuItem menuItem) {

      return null;
   }

   @Override
   public MenuItem getMenuItem(Integer id, String name) throws BadRequestException {
      if(Objects.nonNull(name)) {
         id = reverseIndexing.get(name);
      }

      if(!menuItems.containsKey(id)) {
         throw new BadRequestException("Item Not Found");
      }

      return menuItems.get(id);
   }

   @Override
   public List<MenuItem> getMenuItems() throws BadRequestException {
      List<MenuItem> valuesList = new ArrayList<>(menuItems.values());

      return valuesList;
   }
}

package repository.impl;

import dto.MenuItem;
import exceptions.BadRequestException;
import repository.IMenuRepository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class MenuRepositoryImpl implements IMenuRepository {
   private static IMenuRepository instance;
   private final Map<Integer, MenuItem> menuItems = new HashMap<Integer, MenuItem>();
   private final Map<String, Integer> reverseIndexing = new HashMap<String, Integer>();

   private MenuRepositoryImpl() {
      // Initialization code if needed
   }

   public static MenuRepositoryImpl getInstance() {

      if (instance == null) {
         synchronized (IMenuRepository.class) {
            if (instance == null) {
               instance = new MenuRepositoryImpl();
            }
         }
      }

      return (MenuRepositoryImpl) instance;
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

      if (Objects.nonNull(name)) {
         id = reverseIndexing.get(name);
      }

      if (!menuItems.containsKey(id)) {
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

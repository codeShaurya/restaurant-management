package service.impl;

import dto.MenuItem;
import enums.MenuItemCategory;
import exceptions.BadRequestException;
import repository.MenuRepository;
import service.MenuService;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class IMenuService implements MenuService {
   private MenuRepository menuRepository;

   public IMenuService(MenuRepository menuRepository) {

      this.menuRepository = menuRepository;
   }

   @Override
   public MenuItem addMenuItem(Integer id, String name, double price, MenuItemCategory category) {
      MenuItem menuItem = new MenuItem(id, name, price, category);

      try {
         return menuRepository.addMenuItem(menuItem);
      } catch (BadRequestException e) {
         return new MenuItem();
      }
   }

   @Override
   public MenuItem updateMenuItemPrice(Integer id, double newPrice) {

      return null;
   }

   @Override
   public List<MenuItem> showMenu() {
      try {
         return menuRepository.getMenuItems();
      } catch (BadRequestException e) {
         return new ArrayList<MenuItem>();
      }
   }

   @Override
   public MenuItem getItem(Integer id, String name) throws BadRequestException {
      if(Objects.isNull(id) && Objects.isNull(name)) {
         throw new BadRequestException("wrong input");
      }

      return menuRepository.getMenuItem(id, name);
   }
}

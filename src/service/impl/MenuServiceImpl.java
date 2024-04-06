package service.impl;

import dto.MenuItem;
import enums.MenuItemCategory;
import exceptions.BadRequestException;
import repository.IMenuRepository;
import service.IMenuService;

import java.util.List;
import java.util.Objects;

public class MenuServiceImpl implements IMenuService {
   private final IMenuRepository menuRepository;

   public MenuServiceImpl(IMenuRepository menuRepository) {

      this.menuRepository = menuRepository;
   }

   @Override
   public MenuItem addMenuItem(Integer id, String name, double price, MenuItemCategory category)
         throws BadRequestException {

      MenuItem menuItem = new MenuItem(id, name, price, category);

      return menuRepository.addMenuItem(menuItem);
   }

   @Override
   public MenuItem updateMenuItemPrice(Integer id, double newPrice) {

      return null;
   }

   @Override
   public List<MenuItem> showMenu() throws BadRequestException {

      return menuRepository.getMenuItems();
   }

   @Override
   public MenuItem getItem(Integer id, String name) throws BadRequestException {

      if (Objects.isNull(id) && Objects.isNull(name)) {
         throw new BadRequestException("wrong input");
      }

      return menuRepository.getMenuItem(id, name);
   }
}

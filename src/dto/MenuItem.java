package dto;

import enums.MenuItemCategory;

public class MenuItem {
   private Integer menuId;
   private String name;
   private double price;
   private MenuItemCategory category;

   // Constructors, getters, and setters
   public MenuItem() {

   }

   public MenuItem(Integer menuId, String name, double price, MenuItemCategory category) {

      this.menuId = menuId;
      this.name = name;
      this.price = price;
      this.category = category;
   }

   public Integer getMenuId() {

      return menuId;
   }

   public void setMenuId(Integer menuId) {

      this.menuId = menuId;
   }

   public String getName() {

      return name;
   }

   public void setName(String name) {

      this.name = name;
   }

   public double getPrice() {

      return price;
   }

   public void setPrice(double price) {

      this.price = price;
   }

   public MenuItemCategory getCategory() {

      return category;
   }

   public void setCategory(MenuItemCategory category) {

      this.category = category;
   }

   @Override
   public String toString() {

      return "MenuItem{" + "menuId=" + menuId + ", name='" + name + '\'' + ", price=" + price + ", category=" + category
            + '}';
   }
}

package dto;

public class OrderItem {
   private Integer orderId;
   private Integer menuId;
   private String name;
   private Integer quantity;
   private double price;

   // Constructors, getters, and setters
   public OrderItem() {}

   public OrderItem(Integer orderId, Integer menuId,String name, Integer quantity, double price) {
      this.orderId = orderId;
      this.menuId = menuId;
      this.name = name;
      this.quantity = quantity;
      this.price = price;
   }

   public String getName() {
      return name;
   }

   public void setName(String name) {
      this.name = name;
   }

   public Integer getOrderId() {
      return orderId;
   }

   public void setOrderId(Integer orderId) {
      this.orderId = orderId;
   }

   public Integer getMenuId() {
      return menuId;
   }

   public void setMenuId(Integer menuId) {
      this.menuId = menuId;
   }

   public Integer getQuantity() {
      return quantity;
   }

   public void setQuantity(Integer quantity) {
      this.quantity = quantity;
   }

   public double getPrice() {
      return price;
   }

   public void setPrice(double price) {
      this.price = price;
   }
}

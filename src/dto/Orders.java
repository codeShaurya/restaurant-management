package dto;

import enums.OrderStatus;

import java.util.List;

public class Orders {
   private Integer orderId;
   private Integer customerId;
   private Integer tableId;
   private OrderStatus status;
   private List<OrderItem> orderItems;

   // Constructors, getters, and setters
   public Orders() {

   }

   public Orders(Integer orderId, Integer customerId, Integer tableId, OrderStatus status, List<OrderItem> orderItems) {

      this.orderId = orderId;
      this.customerId = customerId;
      this.tableId = tableId;
      this.status = status;
      this.orderItems = orderItems;
   }

   public Integer getOrderId() {

      return orderId;
   }

   public void setOrderId(Integer orderId) {

      this.orderId = orderId;
   }

   public Integer getCustomerId() {

      return customerId;
   }

   public void setCustomerId(Integer customerId) {

      this.customerId = customerId;
   }

   public Integer getTableId() {

      return tableId;
   }

   public void setTableId(Integer tableId) {

      this.tableId = tableId;
   }

   public OrderStatus getStatus() {

      return status;
   }

   public void setStatus(OrderStatus status) {

      this.status = status;
   }

   public List<OrderItem> getOrderItems() {

      return orderItems;
   }

   public void setOrderItems(List<OrderItem> orderItems) {

      this.orderItems = orderItems;
   }
}

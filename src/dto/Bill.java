package dto;

public class Bill {
   private Integer billId;
   private Integer orderId;
   private double totalAmount;
   private String paymentMethod;
   private String paymentStatus;
   private String paymentTime;

   // Constructors, getters, and setters
   public Bill() {}

   public Bill(Integer billId, Integer orderId, double totalAmount, String paymentMethod, String paymentStatus, String paymentTime) {
      this.billId = billId;
      this.orderId = orderId;
      this.totalAmount = totalAmount;
      this.paymentMethod = paymentMethod;
      this.paymentStatus = paymentStatus;
      this.paymentTime = paymentTime;
   }

   public Integer getBillId() {
      return billId;
   }

   public void setBillId(Integer billId) {
      this.billId = billId;
   }

   public Integer getOrderId() {
      return orderId;
   }

   public void setOrderId(Integer orderId) {
      this.orderId = orderId;
   }

   public double getTotalAmount() {
      return totalAmount;
   }

   public void setTotalAmount(double totalAmount) {
      this.totalAmount = totalAmount;
   }

   public String getPaymentMethod() {
      return paymentMethod;
   }

   public void setPaymentMethod(String paymentMethod) {
      this.paymentMethod = paymentMethod;
   }

   public String getPaymentStatus() {
      return paymentStatus;
   }

   public void setPaymentStatus(String paymentStatus) {
      this.paymentStatus = paymentStatus;
   }

   public String getPaymentTime() {
      return paymentTime;
   }

   public void setPaymentTime(String paymentTime) {
      this.paymentTime = paymentTime;
   }

   @Override
   public String toString() {

      return "Bill{" + "billId=" + billId + ", orderId=" + orderId + ", totalAmount=" + totalAmount
            + ", paymentMethod='" + paymentMethod + '\'' + ", paymentStatus='" + paymentStatus + '\''
            + ", paymentTime='" + paymentTime + '\'' + '}';
   }
}

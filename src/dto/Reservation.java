package dto;

public class Reservation {
   private Integer reservationId;
   private Integer customerId;
   private Integer tableId;
   private String reservationTime;
   private String status;

   // Constructors, getters, and setters
   public Reservation() {}

   public Reservation(Integer reservationId, Integer customerId, Integer tableId, String reservationTime, String status) {
      this.reservationId = reservationId;
      this.customerId = customerId;
      this.tableId = tableId;
      this.reservationTime = reservationTime;
      this.status = status;
   }

   public Integer getReservationId() {
      return reservationId;
   }

   public void setReservationId(Integer reservationId) {
      this.reservationId = reservationId;
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

   public String getReservationTime() {
      return reservationTime;
   }

   public void setReservationTime(String reservationTime) {
      this.reservationTime = reservationTime;
   }

   public String getStatus() {
      return status;
   }

   public void setStatus(String status) {
      this.status = status;
   }
}

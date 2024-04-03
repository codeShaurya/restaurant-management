package dto;

public class Table {
   private Integer tableId;
   private Integer tableNumber;
   private Integer capacity;
   private boolean isReserved;
   private String reservationTime;
   private String reservationStatus;

   // Constructors, getters, and setters
   public Table() {}

   public Table(Integer tableId, Integer tableNumber, Integer capacity, boolean isReserved, String reservationTime, String reservationStatus) {
      this.tableId = tableId;
      this.tableNumber = tableNumber;
      this.capacity = capacity;
      this.isReserved = isReserved;
      this.reservationTime = reservationTime;
      this.reservationStatus = reservationStatus;
   }

   public Integer getTableId() {
      return tableId;
   }

   public void setTableId(Integer tableId) {
      this.tableId = tableId;
   }

   public Integer getTableNumber() {
      return tableNumber;
   }

   public void setTableNumber(Integer tableNumber) {
      this.tableNumber = tableNumber;
   }

   public Integer getCapacity() {
      return capacity;
   }

   public void setCapacity(Integer capacity) {
      this.capacity = capacity;
   }

   public boolean isReserved() {
      return isReserved;
   }

   public void setReserved(boolean reserved) {
      isReserved = reserved;
   }

   public String getReservationTime() {
      return reservationTime;
   }

   public void setReservationTime(String reservationTime) {
      this.reservationTime = reservationTime;
   }

   public String getReservationStatus() {
      return reservationStatus;
   }

   public void setReservationStatus(String reservationStatus) {
      this.reservationStatus = reservationStatus;
   }
}


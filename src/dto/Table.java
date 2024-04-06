package dto;

import enums.TableStatus;

public class Table {
   private Integer tableNumber;
   private Integer capacity;
   private TableStatus tableStatus;

   public Table() {

   }

   public Table(Integer tableNumber, Integer capacity, TableStatus tableStatus) {

      this.tableNumber = tableNumber;
      this.capacity = capacity;
      this.tableStatus = tableStatus;
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

   public TableStatus getTableStatus() {

      return tableStatus;
   }

   public void setTableStatus(TableStatus tableStatus) {

      tableStatus = tableStatus;
   }

   @Override
   public String toString() {

      return "Table{" + "tableNumber=" + tableNumber + ", capacity=" + capacity + ", tableStatus=" + tableStatus + '}';
   }
}


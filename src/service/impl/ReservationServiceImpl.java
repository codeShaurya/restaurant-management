package service.impl;

import dto.Table;
import enums.TableStatus;
import exceptions.BadRequestException;
import repository.ITableRepository;

import java.util.Objects;

public class ReservationServiceImpl implements service.IReservationService {
   private final ITableRepository tableRepository;

   public ReservationServiceImpl(ITableRepository tableRepository) {

      this.tableRepository = tableRepository;
   }

   @Override
   public Table reserveTable(Integer customerId, Integer tableNumber) throws BadRequestException {

      Table table = tableRepository.getTable(tableNumber);
      if(Objects.isNull(table)) {
         throw new BadRequestException("Table Not Found");
      }

      if (table.getTableStatus().equals(TableStatus.BOOKED)) {
         throw new BadRequestException("Table Already Booked");
      }

      table.setTableStatus(TableStatus.BOOKED);
      return tableRepository.updateTable(table);
   }

   @Override
   public Table freeTable(Integer customerId, Integer tableNumber) throws BadRequestException {

      Table table = tableRepository.getTable(tableNumber);
      if(Objects.isNull(table)) {
         throw new BadRequestException("Table Not Found");
      }

      if (table.getTableStatus().equals(TableStatus.FREE)) {
         throw new BadRequestException("Table Was not Booked");
      }

      table.setTableStatus(TableStatus.FREE);
      return tableRepository.updateTable(table);
   }
}

package service.impl;

import dto.Table;
import exceptions.BadRequestException;
import repository.ITableRepository;
import service.ITableService;

import java.util.Objects;

public class TableServiceImpl implements ITableService {
   private final ITableRepository tableRepository;

   public TableServiceImpl(ITableRepository tableRepository) {

      this.tableRepository = tableRepository;
   }

   @Override
   public Table addTable(Integer tableNumber, Integer capacity) throws BadRequestException {

      Table table = tableRepository.getTable(tableNumber);
      if (Objects.nonNull(table)) {
         throw new BadRequestException("Table Already Present with this numebr");
      }

      return tableRepository.addTable(tableNumber, capacity);
   }

   @Override
   public Table removeTable(Integer tableNumber) throws BadRequestException {

      Table table = tableRepository.getTable(tableNumber);
      if (Objects.nonNull(table)) {
         throw new BadRequestException("Table Not Present with this numebr");
      }

      return tableRepository.removeTable(tableNumber);
   }

   @Override
   public void updateCapacity() {

   }
}

package repository.impl;

import dto.Table;
import enums.TableStatus;
import exceptions.BadRequestException;
import repository.ITableRepository;

import java.util.HashMap;
import java.util.Map;

public class TableRepositoryImpl implements ITableRepository {
   private static ITableRepository instance;
   private final Map<Integer, Table> tableList = new HashMap<>();

   private TableRepositoryImpl() {
      // Initialization code if needed
   }

   public static TableRepositoryImpl getInstance() {

      if (instance == null) {
         synchronized (ITableRepository.class) {
            if (instance == null) {
               instance = new TableRepositoryImpl();
            }
         }
      }

      return (TableRepositoryImpl) instance;
   }

   @Override
   public Table addTable(Integer tableNumber, Integer capacity) throws BadRequestException {

      Table table = new Table(tableNumber, capacity, TableStatus.FREE);

      tableList.put(tableNumber, table);

      return null;
   }

   @Override
   public Table getTable(Integer tableNumber) {

      return tableList.get(tableNumber);
   }

   @Override
   public Table removeTable(Integer tableNumber) throws BadRequestException {

      return tableList.remove(tableNumber);
   }

   @Override
   public Table getTableByStatus(Integer tableNumber, TableStatus status) {

      return null;
   }

   @Override
   public Table updateTableStatus(Integer tableNumber, TableStatus status) {

      return null;
   }

   @Override
   public Table updateTable(Table table) {

      return tableList.put(table.getTableNumber(), table);
   }
}

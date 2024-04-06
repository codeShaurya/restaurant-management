package repository;

import dto.Table;
import enums.TableStatus;
import exceptions.BadRequestException;

public interface ITableRepository {

   Table addTable(Integer tableNumber, Integer capacity) throws BadRequestException;

   Table getTable(Integer tableNumber) throws BadRequestException;

   Table removeTable(Integer tableNumber) throws BadRequestException;

   Table getTableByStatus(Integer tableNumber, TableStatus status) throws BadRequestException;

   Table updateTableStatus(Integer tableNumber, TableStatus status) throws BadRequestException;

   Table updateTable(Table table) throws BadRequestException;
}

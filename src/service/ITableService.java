package service;

import dto.Table;
import exceptions.BadRequestException;

public interface ITableService {
   Table addTable(Integer tableNumber, Integer capacity) throws BadRequestException;

   Table removeTable(Integer tableNumber) throws BadRequestException;

   void updateCapacity() throws BadRequestException;
}

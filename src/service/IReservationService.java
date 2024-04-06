package service;

import dto.Table;
import exceptions.BadRequestException;

public interface IReservationService {
   Table reserveTable(Integer customerId, Integer tableNumber) throws BadRequestException;

   Table freeTable(Integer customerId, Integer tableNumber) throws BadRequestException;
}

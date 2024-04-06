import enums.MenuItemCategory;
import repository.IMenuRepository;
import repository.IOrderRepository;
import repository.ITableRepository;
import repository.impl.MenuRepositoryImpl;
import repository.impl.OrderRepositoryImpl;
import repository.impl.TableRepositoryImpl;
import service.ICustomerService;
import service.IMenuService;
import service.IOrderService;
import service.IReservationService;
import service.IStaffService;
import service.ITableService;
import service.impl.CustomerServiceImpl;
import service.impl.MenuServiceImpl;
import service.impl.OrderServiceImpl;
import service.impl.ReservationServiceImpl;
import service.impl.StaffServiceImpl;
import service.impl.TableServiceImpl;

public class Main {
   public static void main(String[] args) {

      // All Repository
      IMenuRepository menuRepository = MenuRepositoryImpl.getInstance();
      IOrderRepository orderRepository = OrderRepositoryImpl.getInstance();
      ITableRepository tableRepository = TableRepositoryImpl.getInstance();

      // All Internal Service
      IMenuService menuService = new MenuServiceImpl(menuRepository);
      IOrderService orderService = new OrderServiceImpl(orderRepository, menuRepository);
      ITableService tableService = new TableServiceImpl(tableRepository);
      IReservationService reservationService = new ReservationServiceImpl(tableRepository);

      // All exposable Service
      ICustomerService customerService = new CustomerServiceImpl(menuService, orderService, reservationService);
      IStaffService staffService = new StaffServiceImpl(menuService, tableService, reservationService);

      System.out.println(staffService.addMenuItem(1, "Sweet", 10.0, MenuItemCategory.DESERT));
      System.out.println(staffService.addMenuItem(2, "Idli", 10.0, MenuItemCategory.MAIN_COURSE));
      System.out.println(staffService.addMenuItem(3, "Sambhar", 10.0, MenuItemCategory.MAIN_COURSE));
      System.out.println(staffService.addMenuItem(4, "Gulab Jamub", 10.0, MenuItemCategory.DESERT));

      System.out.println(customerService.browseMenu());

      System.out.println(customerService.createOrder(1234, 1234));
      System.out.println(customerService.addOrderItem(1234, "Sweet", 5));
      System.out.println(customerService.addOrderItem(1234, "Idli", 4));
      System.out.println(customerService.addOrderItem(1234, "Sambhar", 1));
      System.out.println(customerService.addOrderItem(1234, "Gulab Jamub", 2));

   }
}
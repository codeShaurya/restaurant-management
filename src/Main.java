import enums.MenuItemCategory;
import repository.impl.IMenuRepository;
import repository.impl.IOrderRepository;
import service.IStaffService;
import service.impl.CustomerService;
import service.impl.IMenuService;
import service.impl.IOrderService;
import service.impl.StaffService;

public class Main {
   public static void main(String[] args) {

      IMenuRepository menuRepository = IMenuRepository.getInstance();
      IOrderRepository orderRepository = IOrderRepository.getInstance();
      IMenuService menuService = new IMenuService(menuRepository);
      IOrderService orderService = new IOrderService(orderRepository, menuRepository);
      CustomerService customerService = new CustomerService(menuService, orderService);
      IStaffService staffService = new StaffService(menuService);

      System.out.println(staffService.addMenuItem(1,"Sweet", 10.0, MenuItemCategory.DESERT));
      System.out.println(staffService.addMenuItem(2,"Idli", 10.0, MenuItemCategory.MAIN_COURSE));
      System.out.println(staffService.addMenuItem(3,"Sambhar", 10.0, MenuItemCategory.MAIN_COURSE));
      System.out.println(staffService.addMenuItem(4,"Gulab Jamub", 10.0, MenuItemCategory.DESERT));

      System.out.println(customerService.browseMenu());

      System.out.println(customerService.createOrder(1234, 1234));
      System.out.println(customerService.createOrderItem(1234, "Sweet", 5));
      System.out.println(customerService.createOrderItem(1234, "Idli", 4));
      System.out.println(customerService.createOrderItem(1234, "Sambhar", 1));
      System.out.println(customerService.createOrderItem(1234, "Gulab Jamub", 2));

   }
}
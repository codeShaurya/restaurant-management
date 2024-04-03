import enums.MenuItemCategory;
import repository.MenuRepository;
import repository.OrderRepository;
import repository.impl.IMenuRepository;
import repository.impl.IOrderRepository;
import service.MenuService;
import service.OrderService;
import service.impl.IMenuService;
import service.impl.IOrderService;

public class Main {
   public static void main(String[] args) {

      MenuRepository menuRepository = IMenuRepository.getInstance();
      MenuService menuService = new IMenuService(menuRepository);
      OrderRepository orderRepository = IOrderRepository.getInstance();
      OrderService orderService = new IOrderService(orderRepository, menuRepository);

      menuService.addMenuItem(1,"dosa", 10.0, MenuItemCategory.DESERT);
      menuService.addMenuItem(2,"Idli", 10.0, MenuItemCategory.MAIN_COURSE);
      menuService.addMenuItem(3,"Sambhar", 10.0, MenuItemCategory.DESERT);
      menuService.addMenuItem(4,"Poha", 10.0, MenuItemCategory.MAIN_COURSE);

      menuService = new IMenuService(menuRepository);
      System.out.println(menuService.showMenu().toString());

      orderService = new IOrderService(orderRepository, menuRepository);
   }
}
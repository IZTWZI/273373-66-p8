//ไฟล์ App.java มี code ดังนี้ :
import java.util.*;

public class App {

  private static int yourInput;
  private static String username;
  private static String password;
  private static String confirmPassword;
  private static String phone;
  private static boolean chack;
  private static String chack2;

  static Customer customer;
  static Employee employee;
  static Place_Status place_status;
  static Table table;
  static Reservation reservation;
  static Reservation reservation1;
  static Basket basket;

  public static void main(String[] args) {
    chack = false;
    customer = new Customer();
    employee = new Employee();
    place_status = new Place_Status();
    table = new Table();
    reservation = new Reservation();
    reservation1 = new Reservation(customer);
    basket = new Basket();

    //เริ่มต้นแอพ
    RunApp();
  }

  //หน้าเริ่มต้น App
  public static void RunApp() {
    displayLine();
    displayMessageLine("Welcome, please select a number.");
    displayMessageLine("(1) I am Customer");
    displayMessageLine("(2) I am Employee");
    displayMessageLine("(0) Exit");
    displayMessage("Your input : ");
    yourInput = inputInt();

    //ถ้าเหลือ (0) Exit หลุดการทำงานของ app ทันที
    if (yourInput == 0) {
      displayMessageLine("Thank You.");
    } else if (yourInput == 1) {
      displayCustomerRL();
    } else if (yourInput == 2) {
      displayEmployeeL();
    } else {
      displayMessageLine("try again.");
      RunApp();
    }
  }

  //หน้าของ Customer เลือก register หรือ login
  public static void displayCustomerRL() {
    displayLineCustomer();
    displayMessageLine("Please select a number.");
    displayMessageLine("(1) Register");
    displayMessageLine("(2) Login");
    displayMessageLine("(0) Back");
    displayMessage("Your input : ");
    yourInput = inputInt();

    if (yourInput == 0) {
      RunApp();
    } else if (yourInput == 1) {
      displayCustomerR();
    } else if (yourInput == 2) {
      displayCustomerL();
    } else {
      displayMessageLine("try again.");
      displayCustomerRL();
    }
  }

  //หน้าของ Customer หน้า Register
  public static void displayCustomerR() {
    displayLineCustomer();
    displayMessageLine("Register!");
    displayMessage("input username : ");
    username = input();
    displayMessage("input password : ");
    password = input();
    displayMessage("input confirm password : ");
    confirmPassword = input();
    displayMessage("input phone : ");
    phone = input();

    //ตรวจสอบว่ารหัสผ่านตรงกันหรือไม่
    if (!password.equals(confirmPassword)) {
      displayMessageLine("Passwords don't match");
      displayCustomerRL();
    } else {
      chack = customer.register(username, password, phone);
    }

    //ถ้า register ผ่านจะไปที่หน้าหลักของ Customer
    if (chack) {
      displayCustomer();
    } else {
      displayCustomerR();
    }
  }

  //หน้าของ Customer หน้า Login
  public static void displayCustomerL() {
    displayLineCustomer();
    displayMessageLine("Login!");
    displayMessage("input username : ");
    username = input();
    displayMessage("input password : ");
    password = input();

    //ถ้า login ผ่านจะไปที่หน้าหลักของ Customer
    chack = customer.login(username, password, 1);
    if (chack) {
      displayCustomer();
    } else {
      displayCustomerRL();
    }
  }

  //หน้าของ Customer หน้าหลักของ Customer
  public static void displayCustomer() {
    displayLineCustomer();
    displayMessageLine("Place_Status : " + place_status.Get_place_status());
    displayMessageLine("Hi : " + customer.Get_person_username());
    displayMessageLine("Please select a number.");
    displayMessageLine("(1) จองโต๊ะ");
    displayMessageLine("(2) ข้อมูลการจอง");
    displayMessageLine("(3) สั่งอาหาร");
    displayMessageLine("(4) รายการอาหารที่สั่ง");
    displayMessageLine("(0) LogOut");
    displayMessage("Your input : ");
    yourInput = inputInt();

    if (yourInput == 0) {
      displayCustomerRL();
    } else if (yourInput == 1) {
      displayReservationTable();
    } else if (yourInput == 2) {
      reservation.Display_reservation();
    } else if (yourInput == 3) {
      displayCustomerMenu(); //
    } else if (yourInput == 4) {
      displayOrderedItems(); // เรียกเมธอดเพื่อแสดงรายการอาหารที่สั่ง
    } else {
      displayMessageLine("try again.");
      displayCustomer();
    }
  }

  //หน้าของ Customer หน้าตรวจสอบสถาณะโต๊ะ Customer
  public static void displayReservationTable() {
    displayLineCustomer();
    displayMessageLine("Place_Status : " + place_status.Get_place_status());
    displayMessageLine("Hi : " + customer.Get_person_username());
    displayMessageLine("Please select a number.");
    reservation.Check_table_status();
    displayMessageLine("(0) Back");
    displayMessage("Your input : ");
    yourInput = inputInt();

    if (yourInput == 0) {
      displayCustomer();
    } else if (yourInput >= 1 || yourInput <= 20) {
      displayMessage("Enter Y to confirm : ");
      chack2 = input();
      if (chack2.equals("Y")) {
        reservation.Save_table_reservation_information(
          yourInput,
          customer.Get_person_id()
        );
      } else {
        displayMessageLine("try again.");
        displayReservationTable();
      }
    } else {
      displayMessageLine("try again.");
      displayReservationTable();
    }
  }

  //หน้าของ Customer หน้าดู Menu ของ Customer
  public static void displayCustomerMenu() {
    displayLineCustomer();
    displayMessageLine("Place_Status : " + place_status.Get_place_status());
    displayMessageLine("Hi : " + customer.Get_person_username());
    displayMessageLine("Please select a number.");
    displayMessageLine("(1) อาหาร");
    displayMessageLine("(2) เครื่องดื่ม");
    displayMessageLine("(0) back");
    displayMessage("Your input : ");
    yourInput = inputInt();

    if (yourInput == 0) {
      displayCustomer();
    } else if (yourInput == 1) {
      displayFoodMenu(); // เรียกเมธอดใหม่เพื่อแสดงเมนูอาหาร
    } else if (yourInput == 2) {
      displayMessageLine("ยังไม่มี");
    } else {
      displayMessageLine("try again.");
      displayCustomerMenu();
    }
  }

  // เพิ่มเมธอดใหม่เพื่อแสดงเมนูอาหาร
  public static void displayFoodMenu() {
    displayLineCustomer();
    displayMessageLine("Food Menu");
    // แสดงรายการอาหารจากฐานข้อมูลหรือรายการที่คุณกำหนด
    // ตัวอย่าง:
    Menu menu1 = new Menu();
    menu1.Set_menu_name("Pad Thai");
    menu1.Set_menu_price(100.0);
    Menu menu2 = new Menu();
    menu2.Set_menu_name("Tom Yum Soup");
    menu2.Set_menu_price(80.0);

    displayMessageLine(
      "1. " + menu1.Get_menu_name() + " - " + menu1.Get_menu_price() + " Baht"
    );
    displayMessageLine(
      "2. " + menu2.Get_menu_name() + " - " + menu2.Get_menu_price() + " Baht"
    );
    displayMessageLine("(0) Back");
    displayMessage("Your input : ");
    yourInput = inputInt();

    if (yourInput == 0) {
      displayCustomer();
    } else if (yourInput == 1) {
      displayOrderFood(menu1); // เรียกเมธอดเพื่อสั่งอาหาร
    } else if (yourInput == 2) {
      displayOrderFood(menu2); // เรียกเมธอดเพื่อสั่งอาหาร
    } else {
      displayMessageLine("try again.");
      displayFoodMenu();
    }
  }

  // เพิ่มเมธอดใหม่เพื่อสั่งอาหาร
  public static void displayOrderFood(Menu menu) {
    displayLineCustomer();
    displayMessage("Enter quantity for " + menu.Get_menu_name() + " : ");
    int quantity = inputInt();
    basket.AddToBasket(menu, quantity); // เพิ่มรายการอาหารใน Basket
    displayMessageLine("Added to your basket.");
    displayMessageLine(
      "Total Price: " + basket.CalculateTotalPrice() + " Baht"
    );
    displayMessageLine("(0) Back");
    displayMessage("Your input : ");
    yourInput = inputInt();

    if (yourInput == 0) {
      displayCustomer();
    } else {
      displayMessageLine("try again.");
      displayOrderFood(menu);
    }
  }

  // เพิ่มเมธอดเพื่อแสดงรายการอาหารใน Basket
  public static void displayOrderedItems() {
    displayLineCustomer();
    displayMessageLine("Your Ordered Items");
    basket.DisplayOrderedItems();
    displayMessageLine(
      "Total Price: " + basket.CalculateTotalPrice() + " Baht"
    );
    displayMessageLine("(0) Back");
    displayMessage("Your input : ");
    yourInput = inputInt();

    if (yourInput == 0) {
      displayCustomer();
    } else {
      displayMessageLine("try again.");
      displayOrderedItems();
    }
  }

    //หน้าของ Employee หน้า Login
  public static void displayEmployeeL() {
    displayLineEmployee();
    displayMessageLine("Login!");
    displayMessage("input username : ");
    username = input();
    displayMessage("input password : ");
    password = input();

    //ถ้า login ผ่านจะไปที่หน้าหลักของ Employee
    chack = employee.login(username, password, 0);
    if (chack) {
      displayEmployee();
    } else {
      RunApp();
    }
  }


  //หน้าของ Customer หน้าหลักของ Customer
  public static void displayEmployee() {
    displayLineCustomer();
    displayMessageLine("Place_Status : " + place_status.Get_place_status());
    displayMessageLine("Hi : " + employee.Get_person_username());
    displayMessageLine("Please select a number.");
    displayMessageLine("(1) แก้ไขสถานะร้าน ");
    displayMessageLine("(2) แก้ไข Menu");
    displayMessageLine("(3) แก้ไขโปรโมชัน");
    displayMessageLine("(4) ดูข้อมูลโต๊ะ");
    displayMessageLine("(5) ดูข้อมูลออร์เดอร์");
    displayMessageLine("(6) แก้ไขสถานณะ Menu");
    displayMessageLine("(7) ปริ้นใบเสร็จ");
    displayMessageLine("(0) LogOut");
    displayMessage("Your input : ");
    yourInput = inputInt();

    if (yourInput == 0) {
      displayCustomerRL();
    } else if (yourInput == 1) {
      displayMessageLine("ยังไม่มี");
    } else if (yourInput == 2) {
      displayMessageLine("ยังไม่มี");
    } else if (yourInput == 3) {
      displayMessageLine("ยังไม่มี");
    } else if (yourInput == 4) {
      displayMessageLine("ยังไม่มี");
    } else {
      displayMessageLine("try again.");
      displayEmployee();
    }
  }


  //ใช้รับค่าแบบ ตัวอักษร
  public static String input() {
    Scanner scanner = new Scanner(System.in);

    return scanner.next();
  }

  //ใช้รับค่าแบบ ตัวเลข
  public static int inputInt() {
    Scanner scanner = new Scanner(System.in);

    return scanner.nextInt();
  }

  //print และ ไม่ขึ้นบรรทัดใหม่
  public static void displayMessage(String message) {
    System.out.print(message);
  }

  //print และ ขึ้นบรรทัดใหม่
  public static void displayMessageLine(String message) {
    System.out.println(message);
  }

  //print ข้อความกั้นหน้า
  public static void displayLine() {
    System.out.println("----------------------------------------");
  }

  //print ข้อความกั้นหน้าของ Customer
  public static void displayLineCustomer() {
    System.out.println("------------*Customer Page*------------");
  }

    //print ข้อความกั้นหน้าของ Employee
  public static void displayLineEmployee() {
    System.out.println("------------*Employee Page*------------");
  }
}

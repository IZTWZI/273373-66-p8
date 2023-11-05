import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class App {

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

  private static int yourInput;
  private static String username;
  private static String password;
  private static String confirmPassword;
  private static int phone;
  private static boolean chack;
  private static String chack2;

  private static Customer customer;
  private static Employee employee;
  private static Place_Status place_status;
  private static Table table;
  private static Reservation reservation;
  private static Menu menu;
  private static Menu menu2;
  private static Basket basket;
  private static Order order;
  private static Receipt receipt;
  private static Promotion promotion;

  private static ArrayList<Transaction> Transactions;

  public static void main(String[] args) {
    reservation = new Reservation();
    place_status = new Place_Status();
    customer = new Customer();
    employee = new Employee(404, "em1", "em1");
    basket = new Basket();
    order = new Order();
    receipt = new Receipt();
    table = new Table(1, "null");
    promotion = new Promotion(1, "Delicious water.", 45.00);

    menu = new Menu(1, "Fried rice", 45.00, "Food", "On", promotion);
    menu2 = new Menu(2, "Coke", 20.00, "Drink", "On", promotion);
    
    Transactions = new ArrayList<>();
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
    phone = inputInt();

    //ตรวจสอบว่ารหัสผ่านตรงกันหรือไม่
    if (!password.equals(confirmPassword)) {
      displayMessageLine("Passwords don't match");
      displayCustomerRL();
    } else {
      chack = customer.checkRegister(1, username, password, phone);
    }
    //ถ้า register ผ่านจะไปที่หน้าหลักของ Customer
    if (chack) {
      displayCustomer();
    } else {
      displayCustomerRL();
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

    chack = customer.checkLogin(username, password, 1);

    //ถ้า login ผ่านจะไปที่หน้าหลักของ Customer
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
    displayMessageLine("(1) Reserve a table");
    displayMessageLine("(2) View table reservation info");
    displayMessageLine("(3) Order Menu.");
    displayMessageLine("(4) View Ordered Menu List");
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
      displayLineCustomer();
      displayMessageLine("Your Ordered Menu");
      basket.Display_Basket_all(); // เรียกเมธอดเพื่อแสดงรายการอาหารที่สั่ง
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
    //reservation.Check_table_status();
    displayMessageLine(
      "Table ID : " +
      table.Get_table_id() +
      " - Status : " +
      table.Get_table_status()
    );
    displayMessageLine("(0) Back");
    displayMessage("Your input : ");
    yourInput = inputInt();

    if (yourInput == 0) {
      displayCustomer();
    } else if (yourInput >= 1 && yourInput <= 20 && table.Get_table_status().equals("null")) {
      displayMessage("Enter Y to confirm : ");
      chack2 = input();
      if (chack2.equals("Y")) {
        table.Set_table_status("Full");
        int randomNumber = ThreadLocalRandom.current().nextInt(1000, 10000);
        reservation = new Reservation();
        reservation.Save_table_reservation_information(
          randomNumber,
          LocalDate.now(),
          LocalTime.now(),
          customer,
          table
        );
        reservation.Display_reservation();
        yourInput = App.inputInt();

        if (yourInput == 0) {
          App.displayCustomer();
        } else {
          App.displayMessageLine("try again.");
          reservation.Display_reservation();
        }
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
    displayMessageLine("Hi : " + customer.Get_person_id());
    displayMessageLine("Promotion "+menu.Get_promotion_details());
    displayMessageLine("Please select a number.");
    displayMessageLine("(1) Food");
    displayMessageLine("(2) Beverages");
    displayMessageLine("(0) Back");
    displayMessage("Your input : ");
    yourInput = inputInt();

    if (yourInput == 0) {
      displayCustomer();
    } else if (yourInput == 1) {
      displayFoodMenu(); // เรียกเมธอดใหม่เพื่อแสดงเมนูอาหาร
    } else if (yourInput == 2) {
      displayMessageLine("Do not have yet.");
    } else {
      displayMessageLine("try again.");
      displayCustomerMenu();
    }
  }

  //เพิ่มเมธอดใหม่เพื่อแสดงเมนูอาหาร
  public static void displayFoodMenu() {
    displayLineCustomer();
    displayMessageLine("Food Menu");
    // แสดงรายการอาหารจากฐานข้อมูลหรือรายการที่คุณกำหนด
    // ตัวอย่าง:
    // Menu menu1 = new Menu();
    // menu1.Set_menu_name("Pad Thai");
    // menu1.Set_menu_price(100.0);
    displayMessageLine("Please select a number.");
    displayMessageLine(
      "(1) " + menu.Get_menu_name() + " - " + menu.Get_menu_price() + " Baht"
    );
    displayMessageLine("(0) Back");
    displayMessage("Your input : ");
    yourInput = inputInt();

    if (yourInput == 0) {
      displayCustomer();
    } else if (yourInput == 1) {
      displayOrderFood(menu); // เรียกเมธอดเพื่อสั่งอาหาร
    } else {
      displayMessageLine("try again.");
      displayFoodMenu();
    }
  }

  // เพิ่มเมธอดใหม่เพื่อสั่งอาหาร
  public static void displayOrderFood(Menu menu) {
    displayMessage("Enter quantity for " + menu.Get_menu_name() + " : ");
    int quantity = inputInt();
    displayMessage("Enter your note : ");
    String note = input();
    basket.AddToBasket(menu, quantity, reservation, note); // เพิ่มรายการอาหารใน Basket
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
    //basket.DisplayOrderedItems();
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

    chack = employee.checkLogin(username, password, 1);

    //ถ้า login ผ่านจะไปที่หน้าหลักของ Employee
    if (chack) {
      displayEmployee();
    } else {
      RunApp();
    }
  }

  //หน้าของ Employee หน้าหลักของ Employee
  public static void displayEmployee() {
    displayLineEmployee();
    displayMessageLine("Place_Status : " + place_status.Get_place_status());
    displayMessageLine("Hi : " + employee.Get_person_username());
    displayMessageLine("Please select a number.");
    displayMessageLine("(1) Edit Place Status");
    displayMessageLine("(2) Edit Menu");
    displayMessageLine("(3) Edit Promotion");
    displayMessageLine("(4) View Reservation Table");
    displayMessageLine("(5) View Order");
    displayMessageLine("(6) Edit Status Menu (On/Off)");
    displayMessageLine("(7) Print Receipt");
    displayMessageLine("(0) LogOut");
    displayMessage("Your input : ");
    yourInput = inputInt();

    if (yourInput == 0) {
      RunApp();
    } else if (yourInput == 1) {
      editPlaceStatus();
    }else if (yourInput == 2) {
      displayEmployeeMenu();
    }else if (yourInput == 3) {
      displayEmployeeEditPromotion();
    }else if (yourInput == 4) {
      viewReservationTable();
    }else if (yourInput == 5) {
      displayLineEmployee();
      displayMessageLine("Ordered Menu");
      basket.Display_Basket_alle();
    }else if (yourInput == 6) {
      displayEmployeeMenuOnOff();
    }else if (yourInput == 7) {
      displayEmployeeReceipt();
    }else {
      displayMessageLine("try again.");
      displayEmployee();
    }
  }

  //หน้าของ Employee หน้าแก้ไขสถานะร้านของ Employee
  public static void editPlaceStatus() {
    displayLineEmployee();
    displayMessageLine("Edit Place Status");
    displayMessageLine("Place_Status : " + place_status.Get_place_status());
    displayMessageLine("Hi : " + employee.Get_person_username());
    displayMessageLine("Please select a number.");
    displayMessageLine("(1) OPEN");
    displayMessageLine("(2) CLOSE");
    displayMessageLine("(0) Back");
    displayMessage("Your input : ");
    yourInput = inputInt();

    if (yourInput == 0) {
      RunApp();
    } else if (yourInput == 1) {
      place_status.Set_places_status("Open");
      displayEmployee();
    } else if (yourInput == 2) {
      place_status.Set_places_status("Close");
      displayEmployee();
    } else {
      displayMessageLine("try again.");
      editPlaceStatus();
    }
  }

  //หน้าของ Employee หน้าดูข้อมูลการจองโต๊ะของ Employee
  public static void viewReservationTable() {
    displayLineEmployee();
    displayMessageLine("View Table");
    displayMessageLine("Place_Status : " + place_status.Get_place_status());
    displayMessageLine("Hi : " + employee.Get_person_username());
    reservation.Get_table_reservation_information();
  }


    //หน้าของ Employee หน้าดู Menu ของ Employee
  public static void displayEmployeeMenu() {
    displayLineEmployee();
    displayMessageLine("Place_Status : " + place_status.Get_place_status());
    displayMessageLine("Hi : " + employee.Get_person_id());
    displayMessageLine("Please select a number.");
    displayMessageLine("(1) Edit Food");
    displayMessageLine("(2) Edit Beverages");
    displayMessageLine("(0) back");
    displayMessage("Your input : ");
    yourInput = inputInt();

    if (yourInput == 0) {
      displayCustomer();
    } else if (yourInput == 1) {
      displayEmployeeFoodMenu(); // เรียกเมธอดใหม่เพื่อแสดงเมนูอาหาร
    } else if (yourInput == 2) {
      displayMessageLine("Do not have yet.");
    } else {
      displayMessageLine("try again.");
      displayEmployeeMenu();
    }
  }

  //เพิ่มเมธอดใหม่เพื่อแสดงเมนูอาหาร
  public static void displayEmployeeFoodMenu() {
    displayLineEmployee();
    displayMessageLine("Food Menu");
    displayMessageLine("Please select a number.");
    displayMessageLine(
      "(1) ID : "+ menu.Get_menu_id() +" - "+ menu.Get_menu_name() + " - " + menu.Get_menu_price() + " Baht"
    );
    displayMessageLine("(1) Edit Price");
    displayMessageLine("(2) Add Menu");
    displayMessageLine("(3) Delete Menu");
    displayMessageLine("(0) Back");
    displayMessage("Input Menu ID : ");
    yourInput = inputInt();

    if (yourInput == 0) {
      displayCustomer();
    } else if (yourInput == 1) {
      displayEmployeeEditFoodPrice(menu); // เรียกเมธอดเพื่อสั่งอาหาร
    } else if (yourInput == 2) {
      displayMessageLine("Do not have yet.");
    }else if (yourInput == 3) {
      displayMessageLine("Do not have yet.");
    }else {
      displayMessageLine("try again.");
      displayEmployeeFoodMenu();
    }
  }

  // เพิ่มเมธอดใหม่เพื่อสั่งอาหาร
  public static void displayEmployeeEditFoodPrice(Menu menu) {
    displayMessageLine("Menu ID : " + menu.Get_menu_id());
    displayMessageLine("Menu Name : " + menu.Get_menu_name());
    displayMessage("edit Price : ");
    menu.Set_menu_price(inputInt());
    displayMessageLine("Edit Price succeed.");
    displayEmployeeFoodMenu();
  }


      //หน้าของ Employee หน้าดู Menu ของ Employee
  public static void displayEmployeeMenuOnOff() {
    displayLineEmployee();
    displayMessageLine("Place_Status : " + place_status.Get_place_status());
    displayMessageLine("Hi : " + employee.Get_person_id());
    displayMessageLine("Please select a number.");
    displayMessageLine("(1) Edit Food Status");
    displayMessageLine("(2) Edit Beverages Status");
    displayMessageLine("(0) Back");
    displayMessage("Your input : ");
    yourInput = inputInt();

    if (yourInput == 0) {
      displayCustomer();
    } else if (yourInput == 1) {
      displayEmployeeFoodMenuOnOff(); // เรียกเมธอดใหม่เพื่อแสดงเมนูอาหาร
    } else if (yourInput == 2) {
      displayMessageLine("Do not have yet.");
    } else {
      displayMessageLine("try again.");
      displayEmployee();
    }
  }

  //เพิ่มเมธอดใหม่เพื่อแสดงเมนูอาหาร
  public static void displayEmployeeFoodMenuOnOff() {
    displayLineEmployee();
    displayMessageLine("Edit Food Status");
    displayMessageLine("Please select a number.");
    displayMessageLine(
      "(1) ID : "+ menu.Get_menu_id() +" - "+ menu.Get_menu_name() + " - Status : " + menu.Get_menu_status()
    );
    displayMessageLine("(0) Back");
    displayMessage("Input Menu ID : ");
    yourInput = inputInt();
    if (yourInput == 0) {
      displayEmployee();
    } else if (yourInput == 1) {
      displayEmployeeEditFoodOnoff(menu); // เรียกเมธอดเพื่อสั่งอาหาร
    } else {
      displayMessageLine("try again.");
      displayEmployeeFoodMenuOnOff();
    }
  }

  // เพิ่มเมธอดใหม่เพื่อสั่งอาหาร
  public static void displayEmployeeEditFoodOnoff(Menu menu) {
    displayMessageLine("Please select a number.");
    displayMessageLine("(1) ON");
    displayMessageLine("(2) OFF");
    displayMessageLine("(0) Back");
    displayMessage("Your input : ");
    yourInput = inputInt();
    
    if (yourInput == 0) {
      displayEmployeeFoodMenuOnOff();
    } else if (yourInput == 1) {
      menu.Set_menu_status("ON");
      displayMessageLine("EditFood succeed.");
      displayEmployeeFoodMenuOnOff();
    } else if (yourInput == 2) {
      menu.Set_menu_status("OFF");
      displayMessageLine("EditFood succeed.");
      displayEmployeeFoodMenuOnOff();
    } else {
      displayMessageLine("try again.");
      displayEmployeeEditFoodOnoff(menu);
    }

  }

  //หน้าของ Employee หน้าปริ้นใบเสร็จ Employee
  public static void displayEmployeeReceipt() {
    displayLineEmployee();
    displayMessageLine("View Table");
    displayMessageLine("Place_Status : " + place_status.Get_place_status());
    displayMessageLine("Hi : " + employee.Get_person_username());
    displayMessageLine("Order ID : " + basket.Get_Transaction_id());
    displayMessageLine("Reserve ID : " + reservation.Get_reserve_id());
    displayMessageLine("Table ID : " + reservation.Get_reserve_table().Get_table_id());
    displayMessageLine("Time : " + reservation.Get_reserve_date());
    displayMessageLine("Date : " + reservation.Get_reserve_time());
    displayMessageLine("Input Order ID for Print Receipt : ");
    yourInput = inputInt();

    if(yourInput == receipt.Get_Transaction_id()){
      displayMessageLine("Total : "+receipt.Get_transaction_menu_total_amount() + " Bath");
      displayMessage("input money : ");
      receipt.Set_money_received(inputInt()+0.0);
      int randomNumber = ThreadLocalRandom.current().nextInt(1000, 10000);
      displayMessageLine("Receipt Number : "+ randomNumber);
      displayMessageLine("Table Number : "+ receipt.Get_Transaction_table_id());
      displayMessageLine("Date : " + LocalDate.now());
      displayMessageLine("Time : " + LocalTime.now());
      displayMessageLine("Menu Name : "+ receipt.Get_transaction_menu_name() + "จำนวน x" + receipt.Get_transaction_menu_amount() + "ราคา" + receipt.Get_transaction_total_price() +  "Baht");
      displayMessageLine("Note : " + receipt.Get_note());
      displayMessageLine("VAT 7% : " + receipt.Get_receipt_vat()*receipt.Get_transaction_total_price() + " Baht"  );
      displayMessageLine("Total : " + receipt.Get_transaction_total_price() + " Baht");
      displayMessageLine("Amount Received : " + receipt.Get_money_received() + " Baht");
      displayMessageLine("Change : " + receipt.Get_receipt_change() + " Baht" );
      table.Set_table_status("null");
      reservation.Cancel_table_reservation(reservation.Get_reserve_id());
      receipt.Get_transaction_menu_total_amount();
      displayEmployee();

    }else{
      displayMessageLine("try again.");
      displayEmployeeReceipt();
    }


  }

     //เพิ่มเมธอดใหม่เพื่อแสดงเมนูอาหาร
  public static void displayEmployeeEditPromotion() {
    displayLineEmployee();
    displayMessageLine("Promotion Edit Page");
    displayMessageLine("Please select a number.");
    displayMessageLine(
      "(1) ID : "+ menu.Get_promotion_id() +" - "+ menu.Get_promotion_details() + " - " + menu.Get_menu_price() + " Baht"
    );
    displayMessageLine("(1) Edit");
    displayMessageLine("(0) Back");
    displayMessage("Input Menu ID : ");
    yourInput = inputInt();

    if (yourInput == 0) {
      displayCustomer();
    } else if (yourInput == 1) {
      displayEmployeeEditPromotion(menu); // เรียกเมธอดเพื่อสั่งอาหาร
    }else {
      displayMessageLine("try again.");
      displayEmployeeEditPromotion();
    }
  }

    // เพิ่มเมธอดใหม่เพื่อสั่งอาหาร
  public static void displayEmployeeEditPromotion(Menu menu) {
    displayMessageLine("Menu ID : " + menu.Get_menu_id());
    displayMessage("edit Details : ");
    menu.Set_promotion_details(input());
    displayMessage("edit Price : ");
    menu.Set_promotion_price(inputInt()+0.0);
    displayMessageLine("Edit Promotion succeed.");
    displayEmployeeEditPromotion();
  }

}

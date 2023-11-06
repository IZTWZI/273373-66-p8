import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;
import java.util.*;

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
  private static Table tables[];
  private static Reservation reservation;
  private static Menu menu;
  private static Menu menus[];
  private static Basket basket;
  private static Order order;
  private static Receipt receipt;
  private static Promotion promotion;

  public static void main(String[] args) {
    reservation = new Reservation();
    place_status = new Place_Status();
    customer = new Customer(0, "0", "0", 0111111111);
    employee = new Employee(404, "em1", "em1");
    basket = new Basket(reservation);
    order = new Order();
    receipt = new Receipt();
    promotion = new Promotion(1, "Delicious water.", 45.00);

    table = new Table(30, "null");

    tables = new Table[20];
    for (int i = 0; i < tables.length; i++) {
      tables[i] = new Table(i + 1, "null");
    }
    menu = new Menu (999,"Fried rice2" , 300 , "FOOD" ,"ON", promotion);

    menus = new Menu[20];
    menus[0] = new Menu(1,"Pizza" , 300 , "FOOD" ,"ON", promotion);
    menus[1] = new Menu(2,"Burger" , 70 , "FOOD" ,"ON", promotion);
    menus[2] = new Menu(3,"Fried rice" , 50 , "FOOD" ,"ON", promotion);
    menus[3] = new Menu(4,"Fried chicken" , 40 , "FOOD" ,"ON", promotion);
    menus[4] = new Menu(5,"Stir-fried basil" , 50 , "FOOD" ,"ON", promotion);
    menus[5] = new Menu(6,"ale1" , 80 , "DRINK" ,"ON", promotion);
    menus[6] = new Menu(7,"ale2" , 90 , "DRINK" ,"ON", promotion);
    menus[7] = new Menu(8,"ale3" , 100 , "DRINK" ,"ON", promotion);
    menus[8] = new Menu(9,"ale4" , 110 , "DRINK" ,"ON", promotion);
    menus[9] = new Menu(10,"ale5" , 120 , "DRINK" ,"ON", promotion);

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
      System.exit(0);
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
    if(place_status.Get_place_status().equals("Close")){
      displayMessageLine("-----------------*CLOSE*----------------");
      RunApp();
    }
    displayMessageLine("Please select a number.");
    displayMessageLine("(1) Reserve a table");
    displayMessageLine("(2) View table reservation info");
    displayMessageLine("(3) Order Menu");
    displayMessageLine("(4) View Ordered Menu List");
    displayMessageLine("(0) LogOut");
    displayMessage("Your input : ");
    yourInput = inputInt();

    if (yourInput == 0) {
      RunApp();
    } else if (yourInput == 1) {
      displayReservationTable();
    } else if (yourInput == 2) {
      reservation.Display_reservation();
    } else if (yourInput == 3) {
      displayCustomerMenu(); //
    } else if (yourInput == 4) {
      basket.Display_Basket_all(); // เรียกเมธอดเพื่อแสดงรายการอาหารที่สั่ง
    } else {
      displayMessageLine("try again.");
      displayCustomer();
    }
  }


  //หน้าของ Customer หน้าตรวจสอบสถานะโต๊ะ+จองโต๊ะ Customer
  public static void displayReservationTable() {
    displayLineCustomer();
    displayMessageLine("Place_Status : " + place_status.Get_place_status());
    displayMessageLine("Hi : " + customer.Get_person_username());
    displayMessageLine("Please select a number.");
    for (int i = 0; i < tables.length; i++) {
      if (tables[i].Get_table_status().equals("null")) {
        displayMessageLine( "Table ID : " + (tables[i].Get_table_id()) + " - Status : " + tables[i].Get_table_status()
        );
      }
    }
    displayMessageLine("(0) Back");
    displayMessage("Your input : ");
    yourInput = inputInt();

    if (yourInput == 0) {
      displayCustomer();
    } else if (
      yourInput >= 1 &&
      yourInput <= 20 &&
      tables[yourInput - 1].Get_table_status().equals("null")
    ) {
      displayMessage("Enter Y to confirm : ");
      chack2 = input();
      if (chack2.equals("Y")) {
        if ((reservation.Get_reserve_customer().Get_person_id() > 0)) {
          displayMessageLine("You have already reserved a table.");
          displayCustomer();
        }
        tables[yourInput - 1].Set_table_status("Full");
        int randomNumber = ThreadLocalRandom.current().nextInt(1000, 10000);
        reservation.Save_table_reservation_information(
          randomNumber,
          LocalTime.now(),
          LocalDate.now(),
          customer,
          tables[yourInput - 1]
        );
        reservation.Display_reservation();
        yourInput = App.inputInt();

        if (yourInput == 0) {
          displayCustomer();
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
    if (
      reservation.Get_reserve_table() == null ||
      reservation.Get_reserve_table().Get_table_id() < 1
    ) {
      displayMessageLine("Pless reserved a table.");
      displayCustomer();
    } else {
      displayLineCustomer();
      displayMessageLine("Place_Status : " + place_status.Get_place_status());
      displayMessageLine("Hi : " + customer.Get_person_id());
      displayMessageLine("Promotion " + menu.Get_promotion_details());
      displayMessageLine("Please select a number.");
      displayMessageLine("(1) Food");
      displayMessageLine("(2) Beverages");
      displayMessageLine("(0) Back");
      displayMessage("Your input : ");
      yourInput = inputInt();
      if (yourInput == 0) {
        displayCustomer();
      } else if (yourInput == 1) {
        displayFoodMenu(yourInput); // เรียกเมธอดใหม่เพื่อแสดงเมนู (1) คืออาหาร
      } else if (yourInput == 2) {
        displayFoodMenu(yourInput); // เรียกเมธอดใหม่เพื่อแสดงเมนู (2) คือเครื่องดื่ม
      } else {
        displayMessageLine("try again.");
        displayCustomerMenu();
      }
    }
  }


  //หน้าของ Customer สำหรับดู Menu + เลือก Menu เพื่อบันทึกลง Basket
  public static void displayFoodMenu(int x) {
    displayLineCustomer();
    displayMessageLine("Menu Page");
    displayMessageLine("Please select a number.");
    for (int i = 0; i < menus.length; i++) {
        if (x == 1) {
            if (menus[i] != null && menus[i].Get_menu_status().equals("ON") && menus[i].Get_menu_type().equals("FOOD")) {
                displayMessageLine("Menu ID: " + menus[i].Get_menu_id() + " - Name: " + menus[i].Get_menu_name() + " - " + menus[i].Get_menu_price() + " Baht");
            }
        } else {
            if (menus[i] != null && menus[i].Get_menu_status().equals("ON") && menus[i].Get_menu_type().equals("DRINK")) {
                displayMessageLine("Menu ID: " + menus[i].Get_menu_id() + " - Name: " + menus[i].Get_menu_name() + " - " + menus[i].Get_menu_price() + " Baht");
            }
        }
    }    
    displayMessage("Input Menu ID (or (0) for Back): ");
    yourInput = inputInt();

    if (yourInput == 0) {
      displayCustomerMenu();
    } else if (menus[yourInput-1] != null && yourInput >= 1 && yourInput <= menus.length) {
      displayOrderFood(menus[yourInput-1]); // เรียกเมธอดเพื่อใส่จำนวน Menu
    } else {
      displayMessageLine("try again.");
      displayFoodMenu(x);
    }
  }


  // หน้าของ Customer สำหรับใส่จำนวน Menu + บันทึก Menu ลงใน Basket
  public static void displayOrderFood(Menu menu) {
    displayMessage("Enter quantity for " + menu.Get_menu_name() + " : ");
    int quantity = inputInt();
    displayMessage("Enter your note : ");
    String note = input();
    basket.AddToBasket(menu, quantity, reservation, note); // เพิ่ม menu ใน Basket
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
    } else if (yourInput == 2) {
      displayEmployeeMenu();
    } else if (yourInput == 3) {
      displayEmployeeEditPromotion();
    } else if (yourInput == 4) {
      viewReservationTable();
    } else if (yourInput == 5) {
      displayLineEmployee();
      displayMessageLine("Ordered Menu");
      basket.Display_Basket_alle();
    } else if (yourInput == 6) {
      displayEmployeeMenuOnOff();
    } else if (yourInput == 7) {
      displayEmployeeReceipt();
    } else {
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
      displayEmployee();
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


  //หน้าของ Employee หน้าดูข้อมูลการจองโต๊ะ
  public static void viewReservationTable() {
    displayLineEmployee();
    displayMessageLine("View Table");
    displayMessageLine("Place_Status : " + place_status.Get_place_status());
    displayMessageLine("Hi : " + employee.Get_person_username());
    reservation.Get_table_reservation_information();
  }


  //หน้าของ Employee หน้าแก้ไข Menu ของ Employee (เลือกว่าจะแก้ไข อาหาร หรือ เครื่องดื่ม)
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
      displayEmployee();
    } else if (yourInput == 1) {
      displayEmployeeMenu(yourInput); // เรียกเมธอดเพื่อแสดง Menu (1) อาหาร
    } else if (yourInput == 2) {
      displayEmployeeMenu(yourInput); // เรียกเมธอดเพื่อแสดง Menu (2) เครื่องดื่ม
    } else {
      displayMessageLine("try again.");
      displayEmployeeMenu();
    }
  }


  //หน้าของ Employee หน้าแก้ไข Menu ของ Employee (เลือกว่าจะแก้ไข ราคา, เพิ่ม Menu, ลบ Menu)
  public static void displayEmployeeMenu(int x) {
    displayLineEmployee();
    displayMessageLine("Please select a number.");
    displayMessageLine("(1) Edit Price");
    displayMessageLine("(2) Add Menu");
    displayMessageLine("(3) Delete Menu");
    displayMessageLine("(0) Back");
    displayMessage("Your input : ");
    yourInput = inputInt();

    if (yourInput == 0) {
      displayEmployeeMenu();
    } else if (yourInput == 1) {
      displayEmployeeEditFoodPrice(x); // เรียกเมธอดเพื่อ แก้ไข ราคา
    } else if (yourInput == 2) {
      displayEmployeeAddMenu(x); // เรียกเมธอดเพื่อ เพิ่ม Menu
    } else if (yourInput == 3) {
      displayEmployeeDeleteMenu(x); // เรียกเมธอดเพื่อ ลบ Menu
    } else {
      displayMessageLine("try again.");
      displayEmployeeMenu(x);
    }
  }


  //หน้าของ Employee หน้าแก้ไข Menu ของ Employee (เลือกว่าจะแก้ไข ราคา ของ Menu ID ไหน)
  public static void displayEmployeeEditFoodPrice(int x) {
    displayLineEmployee();
    displayMessageLine("Edit Menu Price");
    displayMessageLine("Please select a number.");
    for (int i = 0; i < menus.length; i++) {
        if (x == 1) {
            if (menus[i] != null && menus[i].Get_menu_status().equals("ON") && menus[i].Get_menu_type().equals("FOOD")) {
                displayMessageLine("Menu ID: " + menus[i].Get_menu_id() + " - Name: " + menus[i].Get_menu_name() + " - " + menus[i].Get_menu_price() + " Baht");
            }
        } else {
            if (menus[i] != null && menus[i].Get_menu_status().equals("ON") && menus[i].Get_menu_type().equals("DRINK")) {
                displayMessageLine("Menu ID: " + menus[i].Get_menu_id() + " - Name: " + menus[i].Get_menu_name() + " - " + menus[i].Get_menu_price() + " Baht");
            }
        }
    }    
    displayMessage("Input Menu ID (or (0) for Back): ");
    yourInput = inputInt();

    if (yourInput == 0) {
      displayEmployeeMenu(x);
    } else if (menus[yourInput-1] != null && yourInput >= 1 && yourInput <= menus.length) {
      displayEmployeeEditFoodPrice2(menus[yourInput-1],x); // เรียกเมธอดเพื่อ แก้ไข ราคา จาก Menu ID
    }else {
      displayMessageLine("try again.");
      displayEmployeeEditFoodPrice(x);
    }
  }

  
  //หน้าของ Employee หน้าแก้ไข Menu ของ Employee (แก้ไข ราคา ของ Menu ตาม ID ที่ใส่เข้ามา)
  public static void displayEmployeeEditFoodPrice2(Menu menu,int x) {
    displayMessageLine("Menu ID : " + menu.Get_menu_id());
    displayMessageLine("Menu Name : " + menu.Get_menu_name());
    displayMessage("edit Price : ");
    menu.Set_menu_price(inputInt());
    displayMessageLine("Edit Price succeed.");
    displayEmployeeEditFoodPrice(x);
  }


  //หน้าของ Employee หน้าแก้ไข Menu ของ Employee (เพิ่ม Menu)
  public static void displayEmployeeAddMenu(int x) {
    displayLineEmployee();
    displayMessageLine("Add Menu Page");
    
    for (int i = 0; i < menus.length; i++) {
        if (x == 1) {
            if (menus[i] == null) {
                menus[i] = new Menu();
                displayMessageLine("add Menu ID : " + (i+1));
                menus[i].Set_menu_id(i+1);
                displayMessage("add Menu Name : ");
                menus[i].Set_menu_name(input());
                displayMessage("add Menu Price : ");
                menus[i].Set_menu_price(inputInt()+0.0);
                displayMessageLine("add Menu Type : FOOD");
                menus[i].Set_menu_type("FOOD");
                menus[i].Set_menu_status("ON");
                menus[i].Set_promotion(promotion);
                displayMessageLine("Add Menu succeed.");
                displayEmployeeMenu(x);
            }
        } else {
            if (menus[i] == null) {
                menus[i] = new Menu();
                displayMessageLine("add Menu ID : " + (i+1));
                menus[i].Set_menu_id(i+1);
                displayMessage("add Menu Name : ");
                menus[i].Set_menu_name(input());
                displayMessage("add Menu Price : ");
                menus[i].Set_menu_price(inputInt()+0.0);
                displayMessageLine("add Menu Type : DRINK");
                menus[i].Set_menu_type("DRINK");
                menus[i].Set_menu_status("ON");
                menus[i].Set_promotion(promotion);
                displayMessageLine("Add Menu succeed.");
                displayEmployeeMenu(x);
            }
        }
    }
    displayMessageLine("FULL MENU");
    displayEmployeeMenu(x);
  }


  //หน้าของ Employee หน้าแก้ไข Menu ของ Employee (ลบ Menu จาก ID ที่ใส่เข้าไป)
  public static void displayEmployeeDeleteMenu(int x) {
    displayLineEmployee();
    displayMessageLine("Delete Menu Page");
    displayMessageLine("Please select a number.");
    for (int i = 0; i < menus.length; i++) {
        if (x == 1) {
            if (menus[i] != null && menus[i].Get_menu_status().equals("ON") && menus[i].Get_menu_type().equals("FOOD")) {
                displayMessageLine("Menu ID: " + menus[i].Get_menu_id() + " - Name: " + menus[i].Get_menu_name() + " - " + menus[i].Get_menu_price() + " Baht");
            }
        } else {
            if (menus[i] != null && menus[i].Get_menu_status().equals("ON") && menus[i].Get_menu_type().equals("DRINK")) {
                displayMessageLine("Menu ID: " + menus[i].Get_menu_id() + " - Name: " + menus[i].Get_menu_name() + " - " + menus[i].Get_menu_price() + " Baht");
            }
        }
    }    
    displayMessage("Input Menu ID (or (0) for Back): ");
    yourInput = inputInt();

    if (yourInput == 0) {
      displayEmployeeMenu(x);
    } else if (menus[yourInput-1] != null && yourInput >= 1 && yourInput <= menus.length) {
      menus[yourInput-1] = null; // เรียกเมธอดเพื่อสั่งอาหาร
      displayMessageLine("Deleted Menu succeed.");
      displayEmployeeMenu(x);
    }else {
      displayMessageLine("try again.");
      displayEmployeeDeleteMenu(x);
    }
  }


  //หน้าของ Employee หน้าก่อนแก้ไขสถานะ (ON/OFF) ของ Menu
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
      displayEmployee();
    } else if (yourInput == 1) {
      displayEmployeeFoodMenuOnOff(yourInput); // เรียกเมธอดใหม่เพื่อแสดงเมนูอาหาร
    } else if (yourInput == 2) {
      displayEmployeeFoodMenuOnOff(yourInput);
    } else {
      displayMessageLine("try again.");
      displayEmployee();
    }
  }


  //หน้าของ Employee หน้าดูสถานะ (ON/OFF) ของ Menu
  public static void displayEmployeeFoodMenuOnOff(int x) {
    displayLineEmployee();
    displayMessageLine("Edit Menu Status");
    displayMessageLine("Please select a number.");
    for (int i = 0; i < menus.length; i++) {
        if (x == 1) {
            if (menus[i] != null && menus[i].Get_menu_type().equals("FOOD")) {
                displayMessageLine("Menu ID: " + menus[i].Get_menu_id() + " - Name: " + menus[i].Get_menu_name() + " - Status : " + menus[i].Get_menu_status());
            }
        } else {
            if (menus[i] != null && menus[i].Get_menu_type().equals("DRINK")) {
                displayMessageLine("Menu ID: " + menus[i].Get_menu_id() + " - Name: " + menus[i].Get_menu_name() + " - Status : " + menus[i].Get_menu_status());
            }
        }
    }
    displayMessage("Input Menu ID (or (0) for Back): ");
    yourInput = inputInt();
    if (yourInput == 0) {
      displayEmployeeMenuOnOff();
    } else if (menus[yourInput-1] != null && yourInput >= 1 && yourInput <= menus.length) {
      displayEmployeeEditFoodOnoff(menus[yourInput-1],x); // เรียกเมธอดเพื่อ แก้ไขสถานะของ Menu
    } else {
      displayMessageLine("try again.");
      displayEmployeeFoodMenuOnOff(x);
    }
  }


  //หน้าของ Employee หน้าแก้ไขสถานะ (ON/OFF) ของ Menu ตาม ID ของ Menu ที่ใส่เข้ามา
  public static void displayEmployeeEditFoodOnoff(Menu menus,int x) {
    displayMessageLine("Please select a number.");
    displayMessageLine("(1) ON");
    displayMessageLine("(2) OFF");
    displayMessageLine("(0) Back");
    displayMessage("Your input : ");
    yourInput = inputInt();

    if (yourInput == 0) {
      displayEmployeeMenuOnOff();
    } else if (yourInput == 1) {
      menus.Set_menu_status("ON");
      displayMessageLine("Edit Status Menu succeed.");
      displayEmployeeFoodMenuOnOff(x);
    } else if (yourInput == 2) {
      menus.Set_menu_status("OFF");
      displayMessageLine("Edit Status Menu succeed.");
      displayEmployeeFoodMenuOnOff(x);
    } else {
      displayMessageLine("try again.");
      displayEmployeeEditFoodOnoff(menus,x);
    }
  }


  //หน้าของ Employee หน้าปริ้นใบเสร็จ Employee
  public static void displayEmployeeReceipt() {
    displayLineEmployee();
    displayMessageLine("Print Receipt Page.");
    displayMessageLine("Place_Status : " + place_status.Get_place_status());
    displayMessageLine("Hi : " + employee.Get_person_username());
    displayMessageLine("Order ID : " + basket.Get_Transaction_id());
    displayMessageLine("Reserve ID : " + reservation.Get_reserve_id());
    displayMessageLine(
      "Table ID : " + reservation.Get_reserve_table().Get_table_id()
    );
    displayMessageLine("Time : " + reservation.Get_reserve_date());
    displayMessageLine("Date : " + reservation.Get_reserve_time());
    displayMessage("Input Order ID for Print Receipt : ");
    
    yourInput = inputInt();

    if (yourInput == basket.Get_Transaction_id()) {
      displayMessageLine(
        "Total : " + receipt.Get_transaction_menu_total_amount() + " Bath"
      );
      displayMessage("input money : ");
      receipt.Set_money_received(inputInt() + 0.0);
      int randomNumber = ThreadLocalRandom.current().nextInt(1000, 10000);
      displayMessageLine("Receipt Number : " + randomNumber);
      displayMessageLine(
        "Table Number : " + receipt.Get_Transaction_table_id()
      );
      displayMessageLine("Date : " + LocalDate.now());
      displayMessageLine("Time : " + LocalTime.now());
      displayMessageLine(
        "Menu Name : " +
        receipt.Get_transaction_menu_name() +
        " - x" +
        receipt.Get_transaction_menu_amount() +
        " Price " +
        receipt.Get_transaction_total_price() +
        " Baht"
      );
      displayMessageLine("Note : " + receipt.Get_note());
      displayMessageLine(
        "VAT 7% : " +
        receipt.Get_receipt_vat() *
        receipt.Get_transaction_total_price() +
        " Baht"
      );
      displayMessageLine(
        "Total : " + receipt.Get_transaction_total_price() + " Baht"
      );
      displayMessageLine(
        "Amount Received : " + receipt.Get_money_received() + " Baht"
      );
      displayMessageLine("Change : " + receipt.Get_receipt_change() + " Baht");
      table.Set_table_status("null");
      reservation.Cancel_table_reservation(reservation.Get_reserve_id());
      receipt.Get_transaction_menu_total_amount();
      displayEmployee();
    } else {
      displayMessageLine("try again.");
      displayEmployeeReceipt();
    }
  }


  //หน้าของ Employee หน้าก่อนแก้ไข Promotion
  public static void displayEmployeeEditPromotion() {
    displayLineEmployee();
    displayMessageLine("Promotion Edit Page");
    displayMessageLine("Please select a number.");
    displayMessageLine(
      "(1) ID : " +
      menu.Get_promotion_id() +
      " - " +
      menu.Get_promotion_details() +
      " - " +
      menu.Get_menu_price() +
      " Baht"
    );
    displayMessage("Input Menu ID (or (0) for Back): ");
    yourInput = inputInt();

    if (yourInput == 0) {
      displayEmployee();
    } else if (yourInput == 1) {
      displayEmployeeEditPromotion(menu); // เรียกเมธอดเพื่อสั่งอาหาร
    } else {
      displayMessageLine("try again.");
      displayEmployeeEditPromotion();
    }
  }


  //หน้าของ Employee หน้าแก้ไข Promotion
  public static void displayEmployeeEditPromotion(Menu menu) {
    displayMessageLine("Promotion ID : " + menu.Get_menu_id());
    displayMessage("edit Details : ");
    menu.Set_promotion_details(input());
    displayMessage("edit Price : ");
    menu.Set_promotion_price(inputInt() + 0.0);
    displayMessageLine("Edit Promotion succeed.");
    displayEmployeeEditPromotion();
  }
}

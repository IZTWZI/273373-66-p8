import java.time.LocalDate;
import java.time.LocalTime;
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
  private static Place_Status place_status;
  private static Table table;
  private static Reservation reservation;
  private static Menu menu;

  public static void main(String[] args) {
    reservation = new Reservation();
    place_status = new Place_Status();
    customer = new Customer();
    table = new Table(1, "null");
    menu = new Menu(1,"ข้าวผัด", 45.00, "อาหาร", "On");
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
      //displayEmployeeL();
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

    chack = customer.checkLogin(username, password);

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
      //displayCustomerMenu(); //
    } else if (yourInput == 4) {
      //displayOrderedItems(); // เรียกเมธอดเพื่อแสดงรายการอาหารที่สั่ง
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
    } else if (yourInput >= 1 || yourInput <= 20) {
      displayMessage("Enter Y to confirm : ");
      chack2 = input();
      if (chack2.equals("Y")) {
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
    displayMessageLine(
      "Hi : " + customer.Get_person_id()
    );
    displayMessageLine("Please select a number.");
    displayMessageLine("(1) อาหาร");
    displayMessageLine("(2) เครื่องดื่ม");
    displayMessageLine("(0) back");
    displayMessage("Your input : ");
    yourInput = inputInt();

    if (yourInput == 0) {
      displayCustomer();
    } else if (yourInput == 1) {
      //displayFoodMenu(); // เรียกเมธอดใหม่เพื่อแสดงเมนูอาหาร
    } else if (yourInput == 2) {
      displayMessageLine("ยังไม่มี");
    } else {
      displayMessageLine("try again.");
      displayCustomerMenu();
    }
  }
}

import java.util.*;

public class App {

  private static int yourInput;
  private static String username;
  private static String password;
  private static String confirmPassword;
  private static String phone;
  private static boolean chack;
  private static String chack2;

  static Customer customer = new Customer();
  static Place_Status place_status = new Place_Status();
  static Table table = new Table();
  static Reservation reservation = new Reservation();

  public static void main(String[] args) {
    chack = false;

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
      //displayEmployee();
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
    displayMessageLine("Register");
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

  //หน้าของ Customer หน้า Register
  public static void displayCustomerL() {
    displayLineCustomer();
    displayMessageLine("Login");
    displayMessage("input username : ");
    username = input();
    displayMessage("input password : ");
    password = input();

    //ถ้า login ผ่านจะไปที่หน้าหลักของ Customer
    chack = customer.login(username, password);
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
      displayMessageLine("ยังไม่มี");
    } else if (yourInput == 3) {
      displayMessageLine("ยังไม่มี");
    } else if (yourInput == 4) {
      displayMessageLine("ยังไม่มี");
    } else {
      displayMessageLine("try again.");
      displayCustomer();
    }
  }

    //หน้าของ Customer หน้าหลักของ Customer
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
      if (chack2 == "Y"){
        reservation.Save_table_reservation_information(yourInput,customer.Get_person_id());
      }else {
      displayMessageLine("try again.");
      displayReservationTable();
      }
    } else {
      displayMessageLine("try again.");
      displayReservationTable();
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
}

import java.util.*;

public class App {

  private static int yourInput;
  private static String username;
  private static String password;
  private static String confirmPassword;
  private static String phone;
  static Customer customer = new Customer();

  public static void main(String[] args) {
    RunApp();

    // customer.Set_person_username("test01");
    // customer.Set_person_password("test02");

    // displayMessage("สมัคร");
    // displayMessage("ใส่ username : ");
    // customer.Set_person_username(input());
    // displayMessage("ใส่ password : ");
    // customer.Set_person_password(input());
    // displayMessageLine("สมัครเสร็จสิ้น");

    // displayMessage("เข้าสู้ระบบ");
    // displayMessage("ใส่ username : ");
    // String username = input();
    // displayMessage("ใส่ password : ");
    // String password = input();
    // int login = customer.login(username,password);
    // displayMessage("ค่า login ที่ได้ : " + login);

    //เริ่ม App
    while (true) {
      //หน้าเลือกก่อน เข้าสู้ระบบ
      displayLine();
      displayMessageLine("Welcome, please select a number.");
      displayMessageLine("(1) I am Customer");
      displayMessageLine("(2) I am Employee");
      displayMessageLine("(0) Exit");
      displayMessage("Your input : ");

      yourInput = inputInt();

      //(0) Exit
      if (yourInput == 0) {
        break;
      } else if (yourInput == 1) {
        //หน้าหลังจากเลือก (1) Customer
        displayLineCustomer();
        displayMessageLine("Please select a number.");
        displayMessageLine("(1) Register");
        displayMessageLine("(2) Login");
        displayMessageLine("(0) Back");
        displayMessage("Your input : ");

        yourInput = inputInt();

        if (yourInput == 0) {
          break;
        } else if (yourInput == 1) {
          //หน้าหลังจากเลือก (1) Register
          displayLineCustomer();
          displayMessage("Register");
          displayMessage("input username : ");
          username = input();
          displayMessage("input password : ");
          password = input();
          displayMessage("input confirm password : ");
          confirmPassword = input();
          displayMessage("input phone : ");
          phone = input();

          //ถ้ารหัสไม่ตรงกันให้ใส่ใหม่
          if (password != confirmPassword) {
            break;
          } else {
            customer.register(username, password, phone);
          }
        }
      }
    }
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
    } else if (yourInput == 2) {} else {
      displayMessageLine("try again.");
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
    } else if (yourInput == 2) {} else {
      //displayCustomerL();
    }
  }

  //หน้าของ Customer หน้า Register
  public static void displayCustomerR() {
    displayLineCustomer();
    displayMessage("Register");
    displayMessage("input username : ");
    username = input();
    displayMessage("input password : ");
    password = input();
    displayMessage("input confirm password : ");
    confirmPassword = input();
    displayMessage("input phone : ");
    phone = input();

    if (password != confirmPassword) {
      displayMessageLine("Passwords don't match");
      displayCustomerRL();
    } else {
      customer.register(username, password, phone);

    }
  }

  //หน้าของ Customer หน้าหลักของ Customer
  public static void displayCustomer() {
    displayLineCustomer();
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
displayMessageLine("ยังไม่มี");
    } else if (yourInput == 2) {
displayMessageLine("ยังไม่มี");
    } else if (yourInput == 3) {
      displayMessageLine("ยังไม่มี");
    } else if (yourInput == 4) {
      displayMessageLine("ยังไม่มี");
    } 
    else {
  
    }
  }

  //ใช้รับค่าแบบ ตัวอักษร
  public static String input() {
    Scanner scanner = new Scanner(System.in);

    return scanner.nextLine();
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

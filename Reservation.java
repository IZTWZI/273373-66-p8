//ไฟล์ Reservation.java มี code ดังนี้ :
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.concurrent.ThreadLocalRandom;

public class Reservation {

  private int reserve_id;
  private LocalTime reserve_time;
  private LocalDate reserve_date;
  private Table table[];
  private Customer customer;

  public Reservation() {
    table = new Table[20];
    for (int i = 0; i < 20; i++) {
      table[i] = new Table(i + 1, "null");
    }
  }

  public Reservation(Customer customer) {
    this.customer = customer;
  }
  //หน้าของ Customer บันทึกการจองโต๊ะของ Customer
  public void Save_table_reservation_information(
    int table_id,
    int customer_id
  ) {
    //สุ่มเลข reserve_id
    int randomNumber = ThreadLocalRandom.current().nextInt();
    // กำหนดข้อมูลการจอง
    this.reserve_id = randomNumber;
    this.reserve_time = LocalTime.now();
    this.reserve_date = LocalDate.now();
    int customerId = customer_id;

    table[table_id-1].Set_table_status();
    Display_reservation();
  }

  public void Set_reserve_time(LocalTime reserve_time) {}

  public LocalTime Get_reserve_time() {
    return LocalTime.now();
  }

  public void Set_reserve_date(LocalDate reserve_date) {}

  public LocalDate Get_reserve_date() {
    return LocalDate.now();
  }

  public void Set_reserve_table_id(int reserve_table_id) {}

  public int Get_reserve_table_id() {
    return 0;
  }

  public String Get_table_reservation_information() {
    return "";
  }

  //เรียกใช้เพื่อนแสดงข้อมูลโต๊ะที่ว่างและไม่ว่าง
  public void Cancel_table_reservation(int reserve_id) {}

  public void Check_table_status() {
    for (int i = 0; i < 20; i++) {
      App.displayMessageLine(
        "ID : " + (i + 1) + " - Status : " + table[i].Get_table_status()
      );
    }
  }

  //หน้าของ แสดงข้อมูลการจองของ Customer
  public void Display_reservation() {
    App.displayLineCustomer();
    App.displayMessageLine("Reserve ID : " + reserve_id);
    App.displayMessageLine("Date : " + reserve_date);
    App.displayMessageLine("Time : " + reserve_time);
    App.displayMessageLine("(0) Back");
    App.displayMessage("Your input : ");
    int yourInput = App.inputInt();

    if (yourInput == 0) {
      App.displayCustomer();
    } else {
      App.displayMessageLine("try again.");
      Display_reservation();
    }
  }
}

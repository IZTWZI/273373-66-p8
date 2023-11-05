import java.time.LocalDate;
import java.time.LocalTime;

public class Reservation {

  private int reserve_id;
  private LocalTime reserve_time;
  private LocalDate reserve_date;
  private Table table;
  private Customer customer;

  public Reservation() {
    table = new Table();
    customer = new Customer();
  }

  public void Set_reserve_id(int id) {
    this.reserve_id = id;
  }

  public int Get_reserve_id() {
    return this.reserve_id;
  }

  public void Set_reserve_time(LocalTime reserve_time) {
    this.reserve_time = reserve_time;
  }

  public LocalTime Get_reserve_time() {
    return this.reserve_time;
  }

  public void Set_reserve_date(LocalDate reserve_date) {
    this.reserve_date = reserve_date;
  }

  public Customer Get_reserve_customer() {
    //return this.customer.Get_phone();
        return this.customer;
  }

  public LocalDate Get_reserve_date() {
    return this.reserve_date;
  }

  public void Set_reserve_table(Table table) {
    this.table = table;
  }

  public Table Get_reserve_table() {
    return this.table;
  }

  public void Set_reserve_customer(Customer customer) {
    this.customer = customer;
  }

  public void Save_table_reservation_information(
    int reserve_id,
    LocalDate reservationDate,
    LocalTime reservationTime,
    Customer customer,
    Table table
  ) {
    Set_reserve_id(reserve_id);
    Set_reserve_time(reservationTime);
    Set_reserve_date(reservationDate);
    Set_reserve_table(table);
    Set_reserve_customer(customer);
    table.Set_table_status("Full");
  }

  public void Cancel_table_reservation(int reserve_id) {

    Set_reserve_id(-1);
    Set_reserve_time(null);
    Set_reserve_date(null);
    Set_reserve_table(null);
    Set_reserve_customer(null);
    App.displayEmployee();
  }

  //หน้าของ Customer แสดงข้อมูลจองโต๊ะ
  public void Display_reservation() {
    App.displayLineCustomer();
    App.displayMessageLine("Reserve ID : " + Get_reserve_id());
    App.displayMessageLine("Table ID : " + Get_reserve_table().Get_table_id());
    App.displayMessageLine(
      "Customer Name : " +  Get_reserve_customer().Get_person_username()
    );
    App.displayMessageLine("Time : " + Get_reserve_date());
    App.displayMessageLine("Date : " + Get_reserve_time());
    App.displayMessageLine("(0) Back");
    App.displayMessage("Your input : ");

    int yourInput = App.inputInt();

    if (yourInput == 0) {
        App.displayCustomer();
    }else{
        App.displayMessageLine("try again.");
        Display_reservation();
    }
    
  }

  //หน้าของ Employee แสดงข้อมูลจองโต๊ะ
  public void Get_table_reservation_information() {
    App.displayLineEmployee();
    if(Get_reserve_id() == -1){
        App.displayMessageLine("There are no tables currently reserved.");
    }else{
        App.displayMessageLine("Reserve ID : " + Get_reserve_id());
        App.displayMessageLine("Table ID : " + Get_reserve_table().Get_table_id());
        App.displayMessageLine("Customer Phone : 0" + Get_reserve_customer().Get_phone());
        App.displayMessageLine("Time : " + Get_reserve_date());
        App.displayMessageLine("Date : " + Get_reserve_time());
    }


    App.displayMessageLine("Please select a number.");
    App.displayMessageLine("(1) Cancel");
    App.displayMessageLine("(0) Back");
    App.displayMessage("Your input : ");
    int yourInput = App.inputInt();

    if (yourInput == 0) {
      App.displayEmployee();
    }else if(yourInput == 1 && Get_reserve_id() != -1) {
      App.displayMessage("Input Reserve ID for Cancel : ");
      yourInput = App.inputInt();
      Cancel_table_reservation(yourInput);
    } else {
      App.displayMessageLine("try again.");
      Get_table_reservation_information();
    }
  }
}

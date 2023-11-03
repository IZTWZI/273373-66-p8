import java.time.LocalTime;
import java.time.LocalDate;

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
    public void Set_reserve_id(int id){
        this.reserve_id = id;
    }
    public void Set_reserve_time(LocalTime reserve_time) {
    }

    public LocalTime Get_reserve_time() {
        return LocalTime.now();
    }

    public void Set_reserve_date(LocalDate reserve_date) {
    }

    public LocalDate Get_reserve_date() {
        return LocalDate.now();
    }

    public void Set_reserve_table_id(int reserve_table_id) {
    }

    public int Get_reserve_table_id() {
        return 0;
    }

    public String Get_table_reservation_information() {
        return "";
    }

    public void Save_table_reservation_information(int reserve_id, LocalDate reservationDate, LocalTime reservationTime, Customer customer, Table table) {
        this.reserve_id = reserve_id;
        this.reserve_time = reservationTime;
        this.reserve_date = reservationDate;
        this.table = table;
        this.customer = customer;

    }

    public void Cancel_table_reservation(int reserve_id) {
    }

    public String Check_table_status() {
        return this.table.Get_table_status();
    }

    public void Display_reservation() {
        App.displayLineCustomer();
        App.displayMessageLine("Reserve ID : "+this.reserve_id);
        App.displayMessageLine("Table ID : "+this.table.Get_table_id());
        App.displayMessageLine("Customer ID : "+this.customer.Get_person_username());
        App.displayMessageLine("Time : "+this.reserve_time);
        App.displayMessageLine("Date : "+this.reserve_date);
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

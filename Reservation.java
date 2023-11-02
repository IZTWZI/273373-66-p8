import java.time.LocalTime;
import java.time.LocalDate;

public class Reservation {
    private int reserve_id;
    private LocalTime reserve_time;
    private LocalDate reserve_date;
    private Table table;
    private Customer customer;

    public Reservation() {

    }

    public void Save_table_reservation_information(int table_id, int customer_id) {
                // กำหนดข้อมูลการจอง
                this.reserve_id = customer_id;
                this.reserve_time = LocalTime.now();
                this.reserve_date = LocalDate.now();

                App.displayMessageLine("Table " + table_id + " ถูกจองโดยลูกค้ารหัส " + customer_id);
                App.displayMessageLine("วันที่ " + reserve_date + " เวลา " + reserve_time);
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

    public void Cancel_table_reservation(int reserve_id) {
    }

    public void Check_table_status() {
    }

    public void Display_reservation() {
    }
}

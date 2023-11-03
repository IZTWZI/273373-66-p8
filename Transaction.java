//ไฟล์ Transaction.java มี code ดังนี้ :
import java.time.LocalDate;
import java.time.LocalTime;

public class Transaction {
    private int transaction_id;
    private int transaction_table_id;
    private double transaction_total_price;
    private LocalDate transaction_date;
    private LocalTime transaction_time;
    private String transaction_menu_name;
    private int transaction_menu_amount;
    private String transaction_note;
    private double transaction_menu_price;
    private int transaction_menu_total_amount;

    public Transaction() {
    }

    public void Transact() {
    }

    public void Set_Transaction_table_id(int transaction_table_id) {
    }

    public int Get_Transaction_table_id() {
        return 0;
    }

    public void Set_transaction_total_price(double transaction_total_price) {
    }

    public double Get_transaction_total_price() {
        return 0.0;
    }

    public void Set_transaction_date(LocalDate transaction_date) {
    }

    public LocalDate Get_transaction_date() {
        return LocalDate.now();
    }

    public void Set_transaction_time(LocalTime transaction_time) {
    }

    public LocalTime Get_transaction_time() {
        return LocalTime.now();
    }

    public void Set_note(String transaction_note) {
    }

    public String Get_note() {
        return "";
    }

    public void Set_transaction_menu_name(String transaction_menu_name) {
    }

    public String Get_transaction_menu_name() {
        return "";
    }

    public void Set_transaction_menu_price(double transaction_menu_price) {
    }

    public double Get_transaction_menu_price() {
        return 0.0;
    }

    public void Set_transaction_menu_amount(int transaction_menu_amount) {
    }

    public int Get_transaction_menu_amount() {
        return 0;
    }

    public void Set_transaction_menu_total_amount(int transaction_menu_total_amount) {
    }

    public int Get_transaction_menu_total_amount() {
        return 0;
    }
}

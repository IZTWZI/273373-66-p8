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
    private Reservation reservation;

    public Transaction() {
    }

    public void Transact() {
    }

    public void Set_transaction_id(int transaction_id) {
        this.transaction_id = transaction_id;
    }

    public int Get_Transaction_id() {
        return this.transaction_id;
    }

    public void Set_transaction_table_id(int transaction_table_id) {
    }

    public int Get_Transaction_table_id() {
        return 0;
    }

    public void Set_transaction_total_price(double transaction_total_price) {
        this.transaction_total_price = transaction_total_price;
    }

    public double Get_transaction_total_price() {
        return this.transaction_total_price;
    }

    public void Set_transaction_date() {
        this.transaction_date = LocalDate.now();
    }

    public LocalDate Get_transaction_date() {
        return this.transaction_date;
    }

    public void Set_transaction_time(LocalTime transaction_time) {
        this.transaction_time = transaction_time;
    }

    public LocalTime Get_transaction_time() {
        return this.transaction_time;
    }

    public void Set_note(String transaction_note) {
        this.transaction_note = transaction_note;
    }

    public String Get_note() {
        return this.transaction_note;
    }

    public void Set_transaction_menu_name(String transaction_menu_name) {
        this.transaction_menu_name = transaction_menu_name;
    }

    public String Get_transaction_menu_name() {
        return this.transaction_menu_name;
    }

    public void Set_transaction_menu_price(double transaction_menu_price) {
        this.transaction_menu_price = transaction_menu_price;
    }

    public double Get_transaction_menu_price() {
        return this.transaction_menu_price;
    }

    public void Set_transaction_menu_amount(int transaction_menu_amount) {
        this.transaction_menu_amount = transaction_menu_amount;
    }

    public int Get_transaction_menu_amount() {
        return this.transaction_menu_amount;
    }

    public void Set_transaction_menu_total_amount(int transaction_menu_total_amount) {
        this.transaction_menu_total_amount = transaction_menu_total_amount;
    }

    public int Get_transaction_menu_total_amount() {
        return this.transaction_menu_total_amount;
    }
}

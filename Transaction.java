import java.time.LocalDate;
import java.time.LocalTime;
import java.util.concurrent.ThreadLocalRandom;

public class Transaction {
    private int transaction_id;
    private int transaction_table_id;
    private LocalDate transaction_date;
    private LocalTime transaction_time;
    private String transaction_menu_name;
    private int transaction_menu_amount;
    private String transaction_note;
    private double transaction_menu_price;
    private String transaction_menu_type;
    private int transaction_menu_total_amount;
    private double transaction_total_price;

    public Transaction() {
        
    }

    public Transaction(Menu menu, Reservation reservation, String note) {
        // int randomNumber = ThreadLocalRandom.current().nextInt(1000, 10000);
        // this.transaction_id = randomNumber;
        // this.transaction_table_id = reservation.Get_reserve_table_id();
        // //this.transaction_total_price;
        // this.transaction_date = LocalDate.now();
        // this.transaction_time = LocalTime.now();
        // this.transaction_menu_name = menu.Get_menu_name();
        // //this.transaction_menu_amount = menu.Get_quantity();
        // this.transaction_note = note;
        // this.transaction_menu_price = menu.Get_menu_price();
        // this.transaction_menu_type = menu.Get_menu_type();
        // //this.transaction_menu_total_amount;
    }


    public void Transact() {
    }

    public void Set_transaction_menu_type(String transaction_menu_type) {
        this.transaction_menu_type = transaction_menu_type;
    }

    public String Get_transaction_menu_type() {
        return this.transaction_menu_type;
    }

    public void Set_transaction_id(int transaction_id) {
        this.transaction_id = transaction_id;
    }

    public int Get_Transaction_id() {
        return this.transaction_id;
    }

    public void Set_transaction_table_id(int transaction_table_id) {
        this.transaction_table_id = transaction_table_id;
    }

    public int Get_Transaction_table_id() {
        return transaction_table_id;
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

    public void Set_transaction_time() {
        this.transaction_time = LocalTime.now();
    }

    public LocalTime Get_transaction_time() {
        return this.transaction_time;
    }

    public void Set_transaction_note(String transaction_note) {
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

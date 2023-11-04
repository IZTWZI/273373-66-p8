import java.time.*;
import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

public class Basket extends Transaction{

    private ArrayList<Menu> orderedItems;
    private Menu menu;
    private Reservation reservation;


    public Basket() {
        orderedItems = new ArrayList<>();
        menu = new Menu();
        reservation = new Reservation();
    }
    public Basket(Menu menu,Reservation reservation, String note) {
        super(menu, reservation, note);
    }


    public void AddToBasket(Menu menu, int quantity,Reservation reservation, String note) {
        //menu.Set_quantity(quantity);
        orderedItems.add(menu);

        int randomNumber = ThreadLocalRandom.current().nextInt(1000, 10000);
        Set_transaction_id(randomNumber);
        Set_transaction_table_id(reservation.Get_reserve_table().Get_table_id());
        Set_transaction_date();
        Set_transaction_time();
        Set_transaction_menu_name(menu.Get_menu_name());
        Set_transaction_menu_amount(quantity);
        Set_transaction_note(note);
        Set_transaction_menu_price(menu.Get_menu_price());
        Set_transaction_menu_type(menu.Get_menu_type());
        Set_transaction_total_price(menu.Get_menu_price()*quantity);

    }

    // เพิ่มเมธอดเพื่อคำนวณราคารายการอาหารทั้งหมดใน Basket
    public double CalculateTotalPrice() {
        // double total = 0.0;
        // for (Menu menu : orderedItems) {
        //  //   total += menu.CalculateTotalPrice();
        // }
        
        return Get_transaction_total_price();
    }

    // เพิ่มเมธอดเพื่อแสดงรายการอาหารที่สั่ง
    // public void DisplayOrderedItems() {
    //     for (Menu menu : orderedItems) {
    //         System.out.println("Name: " + menu.Get_menu_name());
    //         System.out.println("Quantity: " + menu.Get_quantity());
    //         System.out.println("Price: " + menu.CalculateTotalPrice());
    //         System.out.println("-----------");
    //     }
    // }

    // เพิ่มเมธอดเพื่อลบรายการอาหารออกจาก Basket
    public void RemoveFromBasket(Menu menu) {
        orderedItems.remove(menu);
    }

    // เพิ่มเมธอดเพื่อลบรายการอาหารทั้งหมดออกจาก Basket
    public void ClearBasket() {
        orderedItems.clear();
    }

    public void Order() {

    }

    public void Delete_Basket(int order_id) {
    }

    public void Display_Basket_all() {
        App.displayMessageLine("Date : " + Get_transaction_date());
        App.displayMessageLine("Time : " + Get_transaction_time());
        App.displayMessageLine("Table Number : " + Get_Transaction_table_id());
        App.displayMessageLine("Menu name : " + Get_transaction_menu_name());
        App.displayMessageLine("price : " + Get_transaction_menu_price());
        App.displayMessageLine("amount : x" + Get_transaction_menu_amount());
        App.displayMessageLine("Note : " + Get_note() );
        App.displayMessageLine("Total : " + Get_transaction_total_price());
        App.displayMessageLine("(0) Back");
        App.displayMessage("Your input : ");
        int yourInput = App.inputInt();

        if (yourInput == 0) {
            App.displayCustomer();
          }else {
            App.displayMessageLine("try again.");
            Display_Basket_all();
          }

    }

    public void Display_Basket_alle() {
        App.displayMessageLine("Date : " + Get_transaction_date());
        App.displayMessageLine("Time : " + Get_transaction_time());
        App.displayMessageLine("Table Number : " + Get_Transaction_table_id());
        App.displayMessageLine("Menu name : " + Get_transaction_menu_name());
        App.displayMessageLine("price : " + Get_transaction_menu_price());
        App.displayMessageLine("amount : x" + Get_transaction_menu_amount());
        App.displayMessageLine("Note : " + Get_note() );
        App.displayMessageLine("Total : " + Get_transaction_total_price());
        App.displayMessageLine("(0) Back");
        App.displayMessage("Your input : ");
        int yourInput = App.inputInt();

        if (yourInput == 0) {
            App.displayEmployee();
          }else {
            App.displayMessageLine("try again.");
            Display_Basket_alle();
          }
    }
}

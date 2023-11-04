public class Order extends Transaction{


    public Order() {

    }


    public void Delete_order(int order_id) {
    }

    public void Display_order_all() {
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
            Display_order_all();
          }
    }
}

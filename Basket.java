//ไฟล์ Basket.java มี code ดังนี้ :
import java.util.ArrayList;

public class Basket extends Transaction{

    private ArrayList<Menu> orderedItems; //
    
    public Basket() {
        orderedItems = new ArrayList<>();
    }

    // เพิ่มเมธอดเพื่อเพิ่มรายการอาหารลงใน Basket
    public void AddToBasket(Menu menu, int quantity) {
        menu.Set_quantity(quantity);
        orderedItems.add(menu);
    }

    // เพิ่มเมธอดเพื่อคำนวณราคารายการอาหารทั้งหมดใน Basket
    public double CalculateTotalPrice() {
        double total = 0.0;
        for (Menu menu : orderedItems) {
            total += menu.CalculateTotalPrice();
        }
        return total;
    }

    // เพิ่มเมธอดเพื่อแสดงรายการอาหารที่สั่ง
    public void DisplayOrderedItems() {
        for (Menu menu : orderedItems) {
            System.out.println("Name: " + menu.Get_menu_name());
            System.out.println("Quantity: " + menu.Get_quantity());
            System.out.println("Price: " + menu.CalculateTotalPrice());
            System.out.println("-----------");
        }
    }

    // เพิ่มเมธอดเพื่อลบรายการอาหารออกจาก Basket
    public void RemoveFromBasket(Menu menu) {
        orderedItems.remove(menu);
    }

    // เพิ่มเมธอดเพื่อลบรายการอาหารทั้งหมดออกจาก Basket
    public void ClearBasket() {
        orderedItems.clear();
    }

    public void Delete_order(int order_id) {
    }

    public void Display_order_all() {
    }
}

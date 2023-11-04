public class Menu {
    private int menu_id;
    private String menu_name;
    private double menu_price;
    private String menu_status;
    private String menu_type;
    //private int quantity;
    private Promotion promotion;
    
    public Menu() {
        promotion = new Promotion();
    }

    public Menu(int menu_id, String menu_name, double menu_price, String menu_type, String menu_status, Promotion promotion) {
        this.menu_id = menu_id;
        this.menu_name = menu_name;
        this.menu_price = menu_price;
        this.menu_type = menu_type;
        this.menu_status = menu_status;
        this.promotion = promotion;
    }

    // // เพิ่มเมธอดเพื่อกำหนดจำนวนอาหารในรายการ
    // public void Set_quantity(int quantity) {
    //     this.quantity = quantity;
    // }

    // // เพิ่มเมธอดเพื่อรับข้อมูลจำนวนอาหารในรายการ
    // public int Get_quantity() {
    //     return this.quantity;
    // }
    

    public int Get_promotion_id(){
        return this.promotion.Get_promotion_id();
    }

    public String Get_promotion_details() {
        return this.promotion.Get_promotion_details();
    }

    public Double Get_promotion_price() {
        return this.promotion.Get_promotion_price();
    }

    public void Set_promotion_details(String details) {
        this.promotion.Set_promotion_details(details);
    }

    public void Set_promotion_price(double price) {
        this.promotion.Set_promotion_price(price);
    }

    public int Get_menu_id(){
        return this.menu_id;
    }

    public String Get_menu_name() {
        return menu_name;
    }

    public void Set_menu_name(String menu_name) {
        this.menu_name = menu_name;
    }

    
    public double Get_menu_price() {
        return menu_price;
    }

    public void Set_menu_price(double menu_price) {
        this.menu_price = menu_price;
    }

    
    public String Get_menu_status() {
        return menu_status;
    }

    public void Set_menu_status(String menu_status) {
        this.menu_status = menu_status;
    }

    
    public String Get_menu_type() {
        return menu_type;
    }

    public void Set_menu_type(String menu_type) {
        this.menu_type = menu_type;
    }

    
    public void Deleted_menu(int menu_id) {
        
    }

    
    public void Set_changes_to_menu (String changes) {
        
    }

    
    public String Get_promotion_menu() {
        return Get_promotion_menu();
    }

    
    public void Display_menu_all() {
        App.displayLineCustomer();
        App.displayMessageLine("Menu ID: " + menu_id);
        App.displayMessageLine("Menu Name: " + menu_name);
        App.displayMessageLine("Menu Price: " + menu_price);
        App.displayMessageLine("Menu Status: " + menu_status);
        App.displayMessageLine("Menu Type: " + menu_type);
        

    }
}


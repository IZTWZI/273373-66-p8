public class Menu {
    private int menu_id;
    private String menu_name;
    private double menu_price;
    private String menu_status;
    private String menu_type;

    
    public Menu() {
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

    
    public void Set_changes_tomenu(String changes) {
        
    }

    
    public String Get_promotion_menu() {
        return Get_promotion_menu();
    }

    
    public void Display_menu_all() {
        System.out.println("Menu ID: " + menu_id);
        System.out.println("Menu Name: " + menu_name);
        System.out.println("Menu Price: " + menu_price);
        System.out.println("Menu Status: " + menu_status);
        System.out.println("Menu Type: " + menu_type);
    }
}


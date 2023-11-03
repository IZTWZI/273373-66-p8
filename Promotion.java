public class Promotion {
    private int promotion_id;
    private String promotion_name;
    private double promotion_price;
    private String promotion_details;

    public Promotion() {
    }

    public String Get_promotion_name() {
        return promotion_name;
    }

    public void Set_promotion_name(String promotion_name) {
        this.promotion_name = promotion_name;
    }

    public double Get_promotion_price() {
        return promotion_price;
    }

    public void Set_promotion_price(double promotion_price) {
        this.promotion_price = promotion_price;
    }

    public String Get_promotion_details() {
        return promotion_details;
    }

    public void Set_promotion_details(String promotion_details) {
        this.promotion_details = promotion_details;
    }

    public void Save_promotions_detail() {
    }

    public void Delete_promotions(int promotion_id) {
    }

    public void Save_information() {
    }
}

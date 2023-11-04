public class Promotion {
    private int promotion_id;
    private String promotion_details;
    private double promotion_price;

    public Promotion() {

    }

    public Promotion(int id, String details,double price) {
        this.promotion_id = id;
        this.promotion_details = details;
        this.promotion_price = price;
    }

    public int Get_promotion_id() {
        return this.promotion_id;
    }
    public void Set_promotion_id(int id) {
        this.promotion_id = id;
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

    public void Delete_promotions(int promotion_id) {
    }


}

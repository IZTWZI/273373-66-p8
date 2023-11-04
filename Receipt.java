import java.util.concurrent.ThreadLocalRandom;

public class Receipt extends Transaction{
    private double receipt_vat;
    private double receipt_change;
    private double receipt_money;

    public Receipt() {
        Set_receipt_vat(0.07);
    }

    public void Set_receipt_vat(Double receipt_vat) {
        this.receipt_vat = receipt_vat;
    }

    public Double Get_receipt_vat() {
        return this.receipt_vat;
    }

    public void Set_receipt_change(Double receipt_change) {
        this.receipt_change = receipt_change;
    }

    public Double Get_receipt_change() {
        return this.receipt_change;
    }

    private Double Calculate_menu_VAT_prices(int menu_id) {
        return 0.0;
    }

    public void Set_money_received(Double money_received) {
        Calculate_change(money_received);
        this.receipt_money = money_received;
    }

    public Double Get_money_received() {
        return this.receipt_money;
    }

    private void Calculate_change(Double money) {
        this.receipt_change = (Get_transaction_total_price()*receipt_vat)+Get_transaction_total_price();
    }

    public void Print_receipt(int receipt_id) {

    }

    private void Delete_receipt_detail(int receipt_id) {
        Set_transaction_id(-1);


    }
}

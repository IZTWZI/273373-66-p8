//ไฟล์ Receipt.java มี code ดังนี้ :
public class Receipt extends Transaction{
    private double receipt_vat;
    private double receipt_change;

    public Receipt() {
    }

    public void Set_receipt_vat(Double receipt_vat) {
    }

    public Double Get_receipt_vat() {
        return 0.0;
    }

    public void Set_receipt_change(Double receipt_change) {
    }

    public Double Get_receipt_change() {
        return 0.0;
    }

    private Double Calculate_menu_VAT_prices(int menu_id) {
        return 0.0;
    }

    public void Set_money_received(Double money_received) {
    }

    private Double Calculate_change(int menu_id) {
        return 0.0;
    }

    public void Print_receipt(int receipt_id) {
    }

    private void Delete_receipt_detail(int receipt_id) {
    }
}

import java.util.ArrayList;

public class Customer extends Person {

  private ArrayList<String> customer_phones = new ArrayList<String>();
  private String customer_phone;

  public Customer() {}

  public void Set_phone(String customer_phone) {
    this.customer_phones.add(customer_phone);
    this.customer_phone = customer_phone;
  }

  public ArrayList<String> Get_phone() {
    return this.customer_phones;
  }
}

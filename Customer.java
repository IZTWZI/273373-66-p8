import java.util.ArrayList;

public class Customer extends Person {

  private ArrayList<String> customer_phones = new ArrayList<String>(); 
  private String customer_phone;

  public Customer() {

  }

  public void Set_phone(String customer_phone) {
    this.customer_phones.add(customer_phone);
  }

  public ArrayList<String> Get_phone() {
    return this.customer_phones;
  }

  public void register(String username,String password,String phone){
    Set_person_username(username);
    Set_person_password(password);
    Set_phone(phone);
}
}

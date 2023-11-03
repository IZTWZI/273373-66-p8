//ไฟล์ Customer.java มี code ดังนี้ :
import java.util.ArrayList;

public class Customer extends Person {

  private ArrayList<String> customer_phones = new ArrayList<String>();
  private String customer_phone;

  public Customer() {
    
  }

  public void Set_phone(String customer_phone) {
    this.customer_phones.add(customer_phone);
    this.customer_phone = customer_phone;
  }

  public ArrayList<String> Get_phone() {
    return this.customer_phones;
  }

  //ตรวจสอบและ register
  public boolean register(String username, String password, String phone) {
    int chackU = Get_person_usernames().indexOf(username);
    int chackId = Get_person_ids().size();
    int addId = chackId+1;

    if (chackU > -1) {
      App.displayMessageLine("Username already exists.");
      return false;
    } else {
      Set_person_id(addId);
      Set_person_username(username);
      Set_person_password(password);
      Set_phone(phone);
      return true;
    }
  }
}

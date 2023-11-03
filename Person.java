//ไฟล์ Person.java มี code ดังนี้ :
import java.util.ArrayList;

public class Person {

  private ArrayList<Integer> person_ids = new ArrayList<Integer>();
  private ArrayList<String> person_usernames = new ArrayList<String>();
  private ArrayList<String> person_passwords = new ArrayList<String>();
  private int person_id;
  private String person_username;
  private String person_password;

  public Person() {}

  //รับค่า
  public void Set_person_username(String person_username) {
    this.person_usernames.add(person_username);
    this.person_username = person_username;
  }

  public void Set_person_password(String person_password) {
    this.person_passwords.add(person_password);
    this.person_password = person_password;
  }

  public void Set_person_id(int person_id) {
    this.person_ids.add(person_id);
    this.person_id = person_id;
  }

  //ส่งค่า
  public ArrayList<Integer> Get_person_ids() {
    return this.person_ids;
  }

  public ArrayList<String> Get_person_usernames() {
    return this.person_usernames;
  }

  public int Get_person_id() {
    return this.person_id;
  }

  public String Get_person_username() {
    return this.person_username;
  }

  public boolean login(String username, String password, int x) {
    if (x == 1) {
      int chackU = this.person_usernames.indexOf(username);
      int chackP = this.person_passwords.indexOf(password);
      if (chackU == chackP && chackU == -1) {
        App.displayMessageLine("Username/Password is incorrect.");
        return false;
      } else {
        this.person_id = this.person_ids.get(chackU);
        this.person_username = this.person_usernames.get(chackU);
        return true;
      }
    } else {
      if (username.equals("e1")  && password.equals("e1")) {
        this.person_id = 1000;
        this.person_username = username;
        return true;
      } else {
        App.displayMessageLine("Username/Password is incorrect.");
        return false;
      }
    }
  }
}

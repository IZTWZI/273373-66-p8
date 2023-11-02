import java.util.ArrayList;

public class Person {
    private ArrayList<Integer> person_ids = new ArrayList<Integer>(); 
    private ArrayList<String> person_usernames = new ArrayList<String>(); 
    private ArrayList<String> person_passwords = new ArrayList<String>();
    private int person_id;
    private String person_username;
    private String person_password;
    public Person(){

    }

    public void Set_person_username(String person_username){
        this.person_usernames.add(person_username);
    }
    public void Set_person_password(String person_password){
        this.person_passwords.add(person_password);
    }
    public ArrayList<String> Get_person_username(){
        return this.person_usernames;
    }

    public int login(String person_username, String person_password){
        int x = this.person_usernames.indexOf(person_username);
        int y = this.person_passwords.indexOf(person_password);
        if(x == y){
            return this.person_id = x;
        }
        if(x != y){
            return this.person_id = -9999;
        }
        //this.person_username = person_usernames.get(x);
        //this.person_password = person_passwords.get(y);
        return this.person_id = 20;
    }

}

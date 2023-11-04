public class Person {
    private int person_id;
    private String person_username;
    private String person_password;
    
    public Person() {
        
    }
    public Person(int person_id,String person_username,String person_password) {
        this.person_id = person_id;
        this.person_username = person_username;
        this.person_password = person_password;
    }

    public void Set_person_id (int person_id){
        this.person_id = person_id;
    }
    public void Set_person_username (String person_username){
        this.person_username = person_username;
        
    }
    public void Set_person_password(String person_password) {
        this.person_password = person_password;
    }
    public String Get_person_username(){
        return this.person_username;
    }
    public String Get_person_password(){
        return this.person_password;
    }
    public int Get_person_id(){
        return this.person_id;
    }

    public boolean checkLogin(String username, String password, int x){
        if(this.person_username.equals(username)&&this.person_password.equals(password) && x == 1){
            return true;
        }else if(this.person_username.equals(username)&&this.person_password.equals(password) && x == 0){
            return true;
        }else{
            App.displayMessageLine("Username/Password is incorrect.");
            return false;
        }

    }
}


public class Customer extends Person{

    private int customer_phone;

    public Customer() {
       
    }
    public Customer(int person_id,String person_username,String person_password,int customer_phone) {
        super(person_id, person_username, person_password);
        this.customer_phone = customer_phone;
    }

    public void Set_phone(int customer_phone){
        this.customer_phone = customer_phone;
    }
    public int Get_phone(){
        return this.customer_phone ;
    }
    public boolean checkRegister(int id,String username, String password,int phone){
        if(Get_person_username()  != username){
            Set_person_id(id);
            Set_person_username(username);
            Set_person_password(password);
            Set_phone(phone);
            return true;
        }else{
            App.displayMessage("Username already exists.");
            return false;
        }

    }

}


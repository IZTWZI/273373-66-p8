public class Employee extends Person{
    private double employee_salary;
    
    public Employee() {

    }
    public Employee(int id,String name, String password) {
        super(id,name,password);
    }

    public void Set_employee_salary(double employee_salary) {
        this.employee_salary = employee_salary;
    }

    public double Get_employee_salary() {
        return this.employee_salary;
    }
}

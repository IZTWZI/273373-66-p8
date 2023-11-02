import java.util.ArrayList;

public class Employee extends Person {

  private ArrayList<Double> employee_salary = new ArrayList<Double>();

  public Employee() {

  }

  public void Set_employee_salary(double employee_salary) {}

  public ArrayList<Double> Get_employee_salary() {
    return this.employee_salary;
  }
}

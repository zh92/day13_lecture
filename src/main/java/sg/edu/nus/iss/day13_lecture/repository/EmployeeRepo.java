package sg.edu.nus.iss.day13_lecture.repository;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Repository;

import sg.edu.nus.iss.day13_lecture.model.Employee;

@Repository
public class EmployeeRepo {

    // Repo class is for CRUD functionality
    
    private List<Employee> employees;

    public EmployeeRepo() throws ParseException {
        if (employees == null) {
            employees = new ArrayList<Employee>();
        }

    DateFormat df = new SimpleDateFormat("yyyy-MM-dd");

    Date dt = df.parse("1980-10-15");
    Employee emp = new Employee("Derrick", "Tan", "derrick@gmail.com", "91234567", 7500, dt, "10 Ghim Moh", 272210);
    employees.add(emp);

    dt = df.parse("1979-11-03");
    emp = new Employee("John", "Goh", "john@gmail.com", "83245341", 4500, dt, "8 Pasir Ris", 343456);
    employees.add(emp);
    }

    public List<Employee> findAll() {
        return employees;
    }

    public Boolean save(Employee employee) {

        Boolean results = employees.add(employee);
        return results;
    }

    public Boolean delete(Employee employee) {

        Boolean result = false;
        int employeeIndex = employees.indexOf(employee);
        if (employeeIndex >= 0) {
            employees.remove(employeeIndex);
            result = true;
        }
        return result;
    }
}

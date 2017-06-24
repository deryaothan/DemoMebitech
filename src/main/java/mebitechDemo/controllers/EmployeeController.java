package mebitechDemo.controllers;

import mebitechDemo.models.Employee;
import mebitechDemo.daos.EmployeeDao;

import mebitechDemo.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;


/**
 * @author Derya Othan
 * @version 0.0.1
 */


@Controller
@RequestMapping(value = "/user")
public class EmployeeController {

    @Autowired
    private EmployeeDao employeeDao;

    @Autowired
    private EmployeeRepository employeeRepository;

    @RequestMapping(value = "/delete")
    @ResponseBody
    public String delete(long id) {
        try {
            Employee employee = employeeDao.getById(id);
            employeeDao.delete(employee);
        } catch (Exception ex) {
            return ex.getMessage();
        }
        return "Employee succesfully deleted!";
    }

    @RequestMapping(value = "/save")
    @ResponseBody
    public String create(String name, String surname, double salary) {
        try {
            Employee employee = new Employee(name, surname, salary);
            employeeDao.save(employee);
        } catch (Exception ex) {
            return ex.getMessage();
        }
        return "Employee succesfully saved!";
    }

    @RequestMapping(value = "/update")
    @ResponseBody
    public String updateName(long id, String name, String surname) {
        try {
            Employee employee = employeeDao.getById(id);
            employee.setName(name);
            employee.setSurname(surname);
            employeeDao.update(employee);
        } catch (Exception ex) {
            return "Error updating the user: " + ex.toString();
        }
        return "User succesfully updated!";
    }

    @RequestMapping(value = "/list")
    @ResponseBody
    public String list(long id, String name, String surname) {
        try {
            List<Employee> employees = employeeRepository.findAll();
            for (Employee employee : employees ) {
                String emp = employee.getName() + employee.getSurname();
                System.out.println(emp);
            }
        } catch (Exception ex) {
            return "Error listing the user: " + ex.toString();
        }
        return "User succesfully list!";
    }
}

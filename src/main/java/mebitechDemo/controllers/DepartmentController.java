package mebitechDemo.controllers;

import mebitechDemo.daos.DepartmentDao;
import mebitechDemo.models.Department;
import mebitechDemo.models.Employee;
import mebitechDemo.repository.DepartmentRepository;
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
public class DepartmentController {

    @Autowired
    private DepartmentDao departmentDao;

    @Autowired
    private DepartmentRepository departmentRepository;

    @RequestMapping(value = "/delete")
    @ResponseBody
    public String delete(long id) {
        try {
            Department department = departmentDao.getById(id);
            departmentDao.delete(department);
        } catch (Exception ex) {
            return ex.getMessage();
        }
        return "Employee succesfully deleted!";
    }

    @RequestMapping(value = "/save")
    @ResponseBody
    public String create(String name, Employee employee, String description) {
        try {
            Department department = new Department(name, employee, description);
            departmentDao.save(department);
        } catch (Exception ex) {
            return ex.getMessage();
        }
        return "Employee succesfully saved!";
    }

    @RequestMapping(value = "/update")
    @ResponseBody
    public String updateName(long id, String name, Employee employee, String description) {
        try {
            Department department = departmentDao.getById(id);
            department.setName(name);
            department.setDescription(description);
            department.setEmployee(employee);
            departmentDao.update(department);
        } catch (Exception ex) {
            return "Error updating the user: " + ex.toString();
        }
        return "User succesfully updated!";
    }

    @RequestMapping(value = "/list")
    @ResponseBody
    public String list(long id, String name, Employee employee, String description) {
        try {
            List<Department> departments = departmentRepository.findAll();
            for (Department department: departments) {
                String dep = department.getName() + department.getEmployee() + department.getDescription();
                System.out.println(dep);
            }
        } catch (Exception ex) {
            return "Error listing the user: " + ex.toString();
        }
        return "User succesfully list!";
    }

}

package mebitechDemo.controllers;

import mebitechDemo.daos.MeetingsDao;
import mebitechDemo.models.Department;
import mebitechDemo.models.Meetings;
import mebitechDemo.repository.MeetingsRepository;
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
public class MeetingsController {

    @Autowired
    private MeetingsDao meetingsDao;

    @Autowired
    private MeetingsRepository meetingsRepository;

    @RequestMapping(value = "/delete")
    @ResponseBody
    public String delete(long id) {
        try {
            Meetings meetings = meetingsDao.getById(id);
            meetingsDao.delete(meetings);
        } catch (Exception ex) {
            return ex.getMessage();
        }
        return "Employee succesfully deleted!";
    }

    @RequestMapping(value = "/save")
    @ResponseBody
    public String create(String name, String description, Department department) {
        try {
            Meetings meetings = new Meetings(name,description,department);
            meetingsDao.save(meetings);
        } catch (Exception ex) {
            return ex.getMessage();
        }
        return "Employee succesfully saved!";
    }

    @RequestMapping(value = "/update")
    @ResponseBody
    public String updateName(long id, String name, Department department) {
        try {
            Meetings meetings = meetingsDao.getById(id);
            meetings.setName(name);
            meetings.setDepartment(department);
            meetingsDao.update(meetings);
        } catch (Exception ex) {
            return "Error updating the user: " + ex.toString();
        }
        return "User succesfully updated!";
    }

    @RequestMapping(value = "/list")
    @ResponseBody
    public String list(String name,String description, Department department) {
        try {
            List<Meetings> meetingses = meetingsRepository.findAll();
            for (Meetings meetings : meetingses){
               String meet =  meetings.getDepartment()+
                meetings.getDescription() +
                meetings.getName();

                System.out.println(meet);
            }
        } catch (Exception ex) {
            return "Error listing the user: " + ex.toString();
        }
        return "User succesfully list!";
    }

}

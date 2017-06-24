package mebitechDemo.daos;

import mebitechDemo.models.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import javax.transaction.Transactional;


/**
 * @author Derya Othan
 * @version 0.0.1
 */


@Repository//BURANIN SERVİS ALANI OLDUĞUNU GÖSTERİYOR (GETALLDATA)
@Transactional//ATABLODA Bİ DEĞİŞİKLİK YAPILDIĞINDA DİĞER TABLODADA DEĞİŞSİN DİYE
public class EmployeeDao {

    @Autowired//SÜÜREKLİ ÇALIŞTIRMAK İSTEDİĞİMİZ ŞEYİ BİR KERE ÇALIŞTIRIR
    private SessionFactory _sessionFactory;

    private Session getSession() {
        return _sessionFactory.getCurrentSession();
    }

    public void save(Employee employee) {
        getSession().save(employee);
        return;
    }

    public void delete(Employee employee) {
        getSession().delete(employee);
        return;
    }


    public Employee getById(long id) {
        return (Employee) getSession().load(Employee.class, id);
    }

    public void update(Employee employee) {
        getSession().update(employee);
        return;
    }

    public void list(Employee employee){
        //getSession().createQuery("from Employee").list();
        return;
    }

}

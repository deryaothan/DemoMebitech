package mebitechDemo.daos;

import mebitechDemo.models.Department;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;


/**
 * @author Derya Othan
 * @version 0.0.1
 */


@Repository
@Transactional
public class DepartmentDao {

    @Autowired
    private SessionFactory _sessionFactory;

    private Session getSession() {
        return _sessionFactory.getCurrentSession();
    }

    public void save(Department department) {
        getSession().save(department);
        return;
    }

    public void delete(Department department) {
        getSession().delete(department);
        return;
    }


    public Department getById(long id) {
        return (Department) getSession().load(Department.class, id);
    }

    public void update(Department department) {
        getSession().update(department);
        return;
    }

    public void list(Department department){
        //getSession().createQuery("from Department").list();
        return;
    }

}

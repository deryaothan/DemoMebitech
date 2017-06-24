package mebitechDemo.daos;

import mebitechDemo.models.Meetings;
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
public class MeetingsDao {

    @Autowired
    private SessionFactory _sessionFactory;

    private Session getSession() {
        return _sessionFactory.getCurrentSession();
    }

    public void save(Meetings meetings) {
        getSession().save(meetings);
        return;
    }

    public void delete(Meetings meetings) {
        getSession().delete(meetings);
        return;
    }


    public Meetings getById(long id) {
        return (Meetings) getSession().load(Meetings.class, id);
    }

    public void update(Meetings meetings) {
        getSession().update(meetings);
        return;
    }

    public void list(Meetings meetings){
        //getSession().createQuery("from Meetings").list();
        return;
    }

}

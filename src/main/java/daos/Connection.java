package daos;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Connection {
    public SessionFactory getConnection(){
        return new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
    }
}

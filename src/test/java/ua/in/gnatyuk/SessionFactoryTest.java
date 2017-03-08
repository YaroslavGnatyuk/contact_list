package ua.in.gnatyuk;

import org.hibernate.SessionFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;
import ua.in.gnatyuk.configuration.PersistentTestContext;
import ua.in.gnatyuk.entity.Client;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {PersistentTestContext.class})
public class SessionFactoryTest {
    @Autowired
    SessionFactory sessionFactory;

    @Test
    @Transactional
    public void addNewClientThroughSessionFactory(){
        Client client = new Client("session", "factory", "aa-eee");
        sessionFactory.getCurrentSession().saveOrUpdate(client);
        sessionFactory.close();
    }
}

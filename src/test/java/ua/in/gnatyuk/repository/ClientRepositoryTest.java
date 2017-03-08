package ua.in.gnatyuk.repository;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import ua.in.gnatyuk.configuration.PersistentTestContext;
import ua.in.gnatyuk.entity.Client;

import static junit.framework.TestCase.assertTrue;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {PersistentTestContext.class})
/*@TestExecutionListeners({DependencyInjectionTestExecutionListener.class,
        TransactionalTestExecutionListener.class,
        DbUnitTestExecutionListener.class})*/
public class ClientRepositoryTest {
    @Autowired
    private ClientRepository clientRepository;

    @Test
    public void addAndDeletingNewClient() {
        long countClientBefore = clientRepository.count();
        Client client = new Client("qqq", "www", "eee");

        client = clientRepository.save(client);
        long countAfterCreateNewClient = clientRepository.count();
        assertTrue(countClientBefore+1 == countAfterCreateNewClient);

        clientRepository.delete(client);
        long countAfterDeletingClient = clientRepository.count();
        assertTrue(countClientBefore == countAfterDeletingClient);
    }
}

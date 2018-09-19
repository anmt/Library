import org.junit.Test;
import repository.BorrowerRepository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class DatabaseConnectorTest {

    @Test
    public void testConnection(){
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("examplePersistenceUnit");
        EntityManager entityManager = factory.createEntityManager();
    }

}

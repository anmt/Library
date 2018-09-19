package repository;

import model.BorrowerDetails;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class BorrowerDetailsRepository implements IBorrowerDetailsRepository {

    private EntityManagerFactory managerFactory;
    private EntityManager entityManager;

    public BorrowerDetailsRepository(){
        managerFactory = Persistence.createEntityManagerFactory("examplePersistenceUnit");
        entityManager = managerFactory.createEntityManager();
    }

    @Override
    public void add(BorrowerDetails borrowerDetails) {
        EntityTransaction transaction = null;
        try{
            transaction = entityManager.getTransaction();
            transaction.begin();
            entityManager.persist(borrowerDetails);
            transaction.commit();
        } catch (Exception e) {
            if(transaction!=null){
                transaction.rollback();
            }
        }
    }

    @Override
    public void modify(BorrowerDetails borrowerDetails) {
        EntityTransaction transaction = null;
        try{
            transaction = entityManager.getTransaction();
            transaction.begin();
            entityManager.merge(borrowerDetails);
            transaction.commit();
        } catch (Exception e) {
            if(transaction!=null){
                transaction.rollback();
            }
        }
    }

    @Override
    public void remove(Long id) {
        EntityTransaction transaction = null;
        try{
            transaction = entityManager.getTransaction();
            transaction.begin();
            BorrowerDetails borrowerDetails = entityManager.find(BorrowerDetails.class, id);
            entityManager.remove(borrowerDetails);
            transaction.commit();
        }catch (Exception e){
            if (transaction!=null){
                transaction.rollback();
            }
        }
    }

    @Override
    public BorrowerDetails findById(Long id) {
        return entityManager.find(BorrowerDetails.class, id);
    }


}

package repository;

import model.Borrower;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class BorrowerRepository implements IBorrowerRepository {

    private EntityManagerFactory managerFactory;
    private EntityManager entityManager;

    public BorrowerRepository(){
        managerFactory = Persistence.createEntityManagerFactory("examplePersistenceUnit");
        entityManager = managerFactory.createEntityManager();
    }

    @Override
    public void add(Borrower borrower) {
        EntityTransaction transaction = null;
        try{
            transaction = entityManager.getTransaction();
            transaction.begin();
            entityManager.persist(borrower);
            transaction.commit();
        } catch (Exception e) {
            if(transaction!=null){
                transaction.rollback();
            }
        }
    }

    @Override
    public void modify(Borrower borrower) {
        EntityTransaction transaction = null;
        try{
            transaction = entityManager.getTransaction();
            transaction.begin();
            entityManager.merge(borrower);
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
            Borrower borrower = entityManager.find(Borrower.class, id);
            entityManager.remove(borrower);
            transaction.commit();
        }catch (Exception e){
            if (transaction!=null){
                transaction.rollback();
            }
        }
    }

    @Override
    public Borrower findById(Long id) {
        return entityManager.find(Borrower.class, id);
    }


}

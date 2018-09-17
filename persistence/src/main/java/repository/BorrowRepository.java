package repository;

import model.Borrow;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class BorrowRepository implements IBorrowRepository {

    private EntityManagerFactory managerFactory;
    private EntityManager entityManager;

    public BorrowRepository(){
        managerFactory = Persistence.createEntityManagerFactory("examplePersistenceUnit");
        entityManager = managerFactory.createEntityManager();
    }


    @Override
    public void add(Borrow borrow) {
        EntityTransaction transaction = null;
        try{
            transaction = entityManager.getTransaction();
            transaction.begin();
            entityManager.persist(borrow);
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
            Borrow borrow = entityManager.find(Borrow.class, id);
            entityManager.remove(borrow);
            transaction.commit();
        }catch (Exception e){
            if (transaction!=null){
                transaction.rollback();
            }
        }
    }

    @Override
    public Borrow findById(Long id) {
        return entityManager.find(Borrow.class, id);
    }

    @Override
    public void cleanUp() {
        entityManager.close();
        managerFactory.close();
    }
}

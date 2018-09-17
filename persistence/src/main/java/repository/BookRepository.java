package repository;

import model.Book;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class BookRepository implements IBookRepository {

    private EntityManagerFactory managerFactory;
    private EntityManager entityManager;

    public BookRepository(){
        managerFactory = Persistence.createEntityManagerFactory("examplePersistenceUnit");
        entityManager = managerFactory.createEntityManager();
    }

    @Override
    public void add(Book book) {
        EntityTransaction transaction = null;
        try{
            transaction = entityManager.getTransaction();
            transaction.begin();
            entityManager.persist(book);
            transaction.commit();
        } catch (Exception e) {
            if(transaction!=null){
                transaction.rollback();
            }
        }
    }

    @Override
    public void modify(Book book) {
        EntityTransaction transaction = null;
        try{
            transaction = entityManager.getTransaction();
            transaction.begin();
            entityManager.merge(book);
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
            Book book = entityManager.find(Book.class, id);
            entityManager.remove(book);
            transaction.commit();
        }catch (Exception e){
            if (transaction!=null){
                transaction.rollback();
            }
        }
    }

    @Override
    public Book findById(Long id) {
        return entityManager.find(Book.class, id);
    }

    @Override
    public void cleanUp() {
        entityManager.close();
        managerFactory.close();
    }
}

package repository;

import model.Author;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class AuthorRepository implements IAuthorRepository {

    private EntityManagerFactory managerFactory;
    private EntityManager entityManager;

    public AuthorRepository(){
        managerFactory = Persistence.createEntityManagerFactory("examplePersistenceUnit");
        entityManager = managerFactory.createEntityManager();
    }


    @Override
    public void add(Author author) {
        EntityTransaction transaction = null;
        try{
            transaction = entityManager.getTransaction();
            transaction.begin();
            entityManager.persist(author);
            transaction.commit();
        } catch (Exception e) {
            if(transaction!=null){
                transaction.rollback();
            }
        }
    }

    @Override
    public void modify(Author author) {
        EntityTransaction transaction = null;
        try{
            transaction = entityManager.getTransaction();
            transaction.begin();
            entityManager.merge(author);
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
            Author author = entityManager.find(Author.class, id);
            entityManager.remove(author);
            transaction.commit();
        }catch (Exception e){
            if (transaction!=null){
                transaction.rollback();
            }
        }
    }

    @Override
    public Author findById(Long id) {
        return entityManager.find(Author.class, id);
    }


}

package model.dao;

import jakarta.persistence.EntityManager;
import model.connection.ConnectionFactory;
import model.entity.User;
import java.util.List;

public class UserDAO {

    public User Create(User user){
        EntityManager em = new ConnectionFactory().getConnection();

        try{
            em.getTransaction().begin();
            em.persist(user);
            em.getTransaction().commit();

        }catch (Exception e){
            em.getTransaction().rollback();

        }finally {
            em.close();
        }
        return user;
    }

    public User Update(User user){
        EntityManager em = new ConnectionFactory().getConnection();

        try{
            em.getTransaction().begin();
            em.merge(user);
            em.getTransaction().commit();
        }catch (Exception e){
            em.getTransaction().rollback();
            e.printStackTrace();
        }
        finally {
            em.close();
        }
        return user;

    }

    public User FindByEmail(String email){
        EntityManager em = new ConnectionFactory().getConnection();
        User user = null;

        try{
             user = em.find(User.class, email);
         }catch (Exception e){
             e.printStackTrace();
         }finally{
            em.close();
        }
        return user;
    }

    public List<User> FindAll(){
        EntityManager em = new ConnectionFactory().getConnection();
        List<User> users = null;

        try{
            users = em.createQuery("from User u").getResultList();

        }catch (Exception e){
            e.printStackTrace();
        }finally{
            em.close();
        }
        return users;
    }

    public User Delete(String email){
        EntityManager em = new ConnectionFactory().getConnection();
        User user = null;

        try {
            user = em.find(User.class, email);
            em.getTransaction().begin();
            em.remove(user);
            em.getTransaction().commit();
        }catch (Exception e){
            em.getTransaction().rollback();
            e.printStackTrace();
        }finally {
            em.close();
        }
        return user;
    }
}


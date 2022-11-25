package jm.task.core.jdbc.dao;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.util.Util;
import org.hibernate.Session;
import org.hibernate.query.Query;
import java.util.List;

public class UserDaoHibernateImpl implements UserDao {

    public UserDaoHibernateImpl() {

    }

    @Override
    public void createUsersTable() {
        try (Session session = Util.getSessionFactory().openSession()) {
            session.beginTransaction();
            String createSql = "CREATE TABLE IF NOT EXISTS users (id BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY, name VARCHAR (50) NOT NULL, lastName VARCHAR (50) NOT NULL, age TINYINT NOT NULL)";
            Query query = session.createSQLQuery(createSql).addEntity(User.class);
            query.executeUpdate();
            session.getTransaction().commit();
            System.out.println("Create Table OK! ");

        } catch (Exception e) {
            System.out.println("Connection failed: " + e);
            throw new RuntimeException(e);
        }
    }

    @Override
    public void saveUser(String name, String lastName, byte age) {

        User user = new User(name, lastName, age);
        try (Session session = Util.getSessionFactory().openSession()) {
            session.beginTransaction();
            session.save(user);
            session.getTransaction().commit();
            System.out.println("User saved OK! ");

        }catch (Exception e) {
            System.out.println("Connection failed: " + e);
            throw new RuntimeException(e);
        }
    }

    @Override
    public void removeUserById(long id) {

        try (Session session = Util.getSessionFactory().openSession()) {
            session.beginTransaction();
            String removeSql = "DELETE User where id = :id";
            Query query = session.createQuery(removeSql);
            query.setParameter("id", id).executeUpdate();
            session.getTransaction().commit();
            System.out.println("User deleted OK! ");

        } catch (Exception e) {
            System.out.println("Connection failed: " + e);
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<User> getAllUsers() {
        List<User> userList;

        try (Session session = Util.getSessionFactory().openSession()){

            userList = session.createQuery("From User").list();
            System.out.println("Table List OK! ");

        } catch (Exception e) {
            System.out.println("Connection failed: " + e);
            throw new RuntimeException(e);
        }
        System.out.println(userList);
        return userList;
    }

    @Override
    public void cleanUsersTable() {
        try (Session session = Util.getSessionFactory().openSession()) {
            session.beginTransaction();
            String cleanSql = "TRUNCATE users";
            Query query = session.createSQLQuery(cleanSql).addEntity(User.class);
            query.executeUpdate();
            session.getTransaction().commit();
            System.out.println("Table cleaned OK! ");

        } catch (Exception e) {
            System.out.println("Connection failed: " + e);
            throw new RuntimeException(e);
        }
    }
    @Override
    public void dropUsersTable() {
        try (Session session = Util.getSessionFactory().openSession()) {
            session.beginTransaction();
            String dropSQL = "DROP TABLE IF EXISTS users";
            Query query = session.createSQLQuery(dropSQL).addEntity(User.class);
            query.executeUpdate();
            session.getTransaction().commit();
            System.out.println("Table deleted OK! ");

        } catch (Exception e) {
            System.out.println("Connection failed: " + e);
            throw new RuntimeException(e);
        }
    }

}

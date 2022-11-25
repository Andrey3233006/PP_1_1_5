package jm.task.core.jdbc.service;

import jm.task.core.jdbc.dao.UserDao;
import jm.task.core.jdbc.dao.UserDaoHibernateImpl;
import jm.task.core.jdbc.model.User;
import java.sql.*;
import java.util.List;

public class UserServiceImpl implements UserService {
    UserDao userDaoHibernate = new UserDaoHibernateImpl();

    public UserServiceImpl() throws SQLException {
    }

    @Override
    public void createUsersTable() throws ClassNotFoundException, SQLException {
        userDaoHibernate.createUsersTable();

    }

    @Override
    public void dropUsersTable() throws SQLException {
        userDaoHibernate.dropUsersTable();

    }

    @Override
    public void saveUser(String name, String lastName, byte age) throws ClassNotFoundException, SQLException {
        userDaoHibernate.saveUser(name, lastName, age);

    }

    @Override
    public void removeUserById(long id) throws SQLException {
        userDaoHibernate.removeUserById(id);

    }

    @Override
    public List<User> getAllUsers() {
        try {
            return userDaoHibernate.getAllUsers();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void cleanUsersTable() throws SQLException {
        userDaoHibernate.cleanUsersTable();

    }
}


package jm.task.core.jdbc.dao;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.util.Util;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.sql.ResultSet;
//public class UserDaoJDBCImpl  implements UserDao {


//    Создание таблицы для User(ов) – не должно приводить к исключению, если такая таблица уже существует
//    Удаление таблицы User(ов) – не должно приводить к исключению, если таблицы не существует
//    Очистка содержания таблицы
//    Добавление User в таблицу
//    Удаление User из таблицы ( по id )
//    Получение всех User(ов) из таблицы



//   Connection connection = Util.getConnection();
//
//    public UserDaoJDBCImpl() throws SQLException {
//    }
//
//    @Override
//    public void createUsersTable() throws ClassNotFoundException, SQLException {
//
//        String createSql = "CREATE TABLE IF NOT EXISTS users (id BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY, name VARCHAR (50) NOT NULL, lastName VARCHAR (50) NOT NULL, age TINYINT NOT NULL)";
//        try (Statement statement = connection.createStatement()) {
//            statement.execute(createSql);
//            connection.commit();
//        } catch (SQLException e) {
//            connection.rollback();
//            throw new RuntimeException(e);
//        }
//    }
//
//    @Override
//    public void dropUsersTable() throws SQLException {
//
//        String dropSql = "DROP TABLE IF EXISTS users";
//        try (Statement statement = connection.createStatement()) {
//            statement.execute(dropSql);
//            connection.commit();
//
//        } catch (SQLException e) {
//            Util.getConnection().rollback();
//            throw new RuntimeException(e);
//        }
//    }
//
//
//    @Override
//    public void saveUser(String name, String lastName, byte age) throws SQLException {
//
//        String saveSql = "INSERT INTO users ( NAME, LASTNAME, AGE) VALUES ( ?, ?, ?)";
//
//        try (PreparedStatement preparedStatement = connection.prepareStatement(saveSql)) {
//
//            preparedStatement.setString(1, name);
//            preparedStatement.setString(2, lastName);
//            preparedStatement.setByte(3, age);
//
//            preparedStatement.executeUpdate();
//            connection.commit();
//            System.out.println("User "+ name + " успешно добавлен в базу данных.");
//
//        } catch (SQLException e){
//            Util.getConnection().rollback();
//            throw new RuntimeException(e);
//        }
//    }
//
//    @Override
//    public void removeUserById ( long id) throws SQLException {
//
//        PreparedStatement preparedStatement = null;
//
//        String removeSql = "DELETE FROM users WHERE ID = ?";
//
//
//        try {
//            preparedStatement = connection.prepareStatement(removeSql);
//
//            preparedStatement.setLong(1,id);
//            preparedStatement.executeUpdate();
//            connection.commit();
//
//
//        } catch (SQLException e){
//            Util.getConnection().rollback();
//            throw new RuntimeException(e);
//        }
//    }
//
//    @Override
//    public List<User> getAllUsers () throws SQLException {
//        List<User> userList = new ArrayList<>();
//        String getAllSql = "SELECT id, name, lastname, age FROM users";
//        PreparedStatement preparedStatement = null;
//        try {
//            preparedStatement = connection.prepareStatement(getAllSql);
//            ResultSet  resultSet= preparedStatement.executeQuery(getAllSql);
//            while (resultSet.next()) {
//
//                User users = new User();
//                users.setId(resultSet.getLong("id"));
//                users.setName(resultSet.getString("name"));
//                users.setLastName(resultSet.getString("lastName"));
//                users.setAge(resultSet.getByte("age"));
//
//                userList.add(users);
//            }
//            connection.commit();
//
//        } catch (SQLException e){
//            Util.getConnection().rollback();
//            throw new RuntimeException(e);
//        }
//
//        System.out.println(userList);
//        return userList;
//    }
//    @Override
//    public void cleanUsersTable () throws SQLException {
//        Statement statement = null;
//        String cleanSql = "TRUNCATE users";
//        try {
//            statement = connection.createStatement();
//            statement.executeUpdate(cleanSql);
//
//            connection.commit();
//
//        } catch (SQLException e){
//            Util.getConnection().rollback();
//            throw new RuntimeException(e);
//        }
//    }
//}
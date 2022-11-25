package jm.task.core.jdbc;


import jm.task.core.jdbc.service.UserService;
import jm.task.core.jdbc.service.UserServiceImpl;
import java.sql.SQLException;

public class Main  {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {

//    В методе main класса Main должны происходить следующие операции:
//
//        Создание таблицы User(ов)
//        Добавление 4 User(ов) в таблицу с данными на свой выбор. После каждого добавления должен быть вывод в консоль ( User с именем – name добавлен в базу данных )
//        Получение всех User из базы и вывод в консоль ( должен быть переопределен toString в классе User)
//        Очистка таблицы User(ов)
//        Удаление таблицы

        UserService userService = new UserServiceImpl();

        userService.createUsersTable();

        userService.saveUser("Name2", "LastName2", (byte) 22);
        userService.saveUser("Name3", "LastName3", (byte) 23);
        userService.saveUser("Name4", "LastName4", (byte) 24);
        userService.saveUser("Name1", "LastName1", (byte) 21);

        userService.removeUserById(2);

        userService.getAllUsers();

        userService.cleanUsersTable();

        userService.dropUsersTable();
    }
}



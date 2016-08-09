package springbook.user;

import java.sql.SQLException;

import springbook.user.dao.NUserDao;
import springbook.user.dao.AbstractUserDao;
import springbook.user.domain.User;

/**
 * @author Jisung Lim <iejisung@gmail.com>
 */
public class UserTest {
  public static void main(String[] args) throws ClassNotFoundException, SQLException {
    AbstractUserDao userDao = new NUserDao();

    User user = new User();
    user.setId("Sidney");
    user.setName("Sidney Lee");
    user.setPassword("sidneylee");

    userDao.add(user);

    System.out.println("USER_ID : " + user.getId() + " successfully registered.");

    User user2 = userDao.get(user.getId());

    System.out.println(user2.getName());
    System.out.println(user2.getPassword());

    System.out.println("USER_ID : " + user2.getId() + " successfully accessed.");
  }
}

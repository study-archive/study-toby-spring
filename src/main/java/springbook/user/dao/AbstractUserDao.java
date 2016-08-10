package springbook.user.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import springbook.user.domain.User;

/**
 * Abstract User Dao.
 *
 * @author  Jisung Lim ( iejisung@gmail.com )
 * @version 1.3 (deprecated)
 * @since   1.1
 */
@Deprecated
public abstract class AbstractUserDao {

  protected abstract Connection getConnection() throws ClassNotFoundException, SQLException;

  public void add(User user) throws ClassNotFoundException, SQLException {

    Connection con = getConnection();

    PreparedStatement pstmt = con.prepareStatement(
        "INSERT INTO users(id, name, password) values(?, ?, ?)"
    );

    pstmt.setString(1, user.getId());
    pstmt.setString(2, user.getName());
    pstmt.setString(3, user.getPassword());

    pstmt.executeUpdate();

    pstmt.close();
    con.close();
  }

  public User get(String id) throws ClassNotFoundException, SQLException {

    Connection con = getConnection();

    PreparedStatement pstmt = con.prepareStatement(
        "SELECT * FROM users WHERE id = ?"
    );

    pstmt.setString(1, id);

    ResultSet rs = pstmt.executeQuery();

    User user = new User();

    if (rs.next()) {
      user.setId(rs.getString("id"));
      user.setName(rs.getString("name"));
      user.setPassword(rs.getString("password"));
    }

    rs.close();
    pstmt.close();
    con.close();

    return user;
  }
}
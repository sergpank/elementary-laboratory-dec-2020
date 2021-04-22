package org.hillel;

import org.hillel.dao.UserDao;
import org.hillel.entity.User;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class JdbcDemo {
  public static void main(String[] args) {

    createUsersTable();

    try (Connection connection = getConnection()) {
      UserDao dao = new UserDao(connection);
      User user = new User(100, "Ivan", "student", "123456");

      dao.create(user);
      System.out.println("CREATE :: " + user);

      User user100 = dao.read(100);
      System.out.println("READ   :: " + user100);

      user100.setName("updated-student");
      dao.update(user100);
      System.out.println("UPDATE :: " + user100);

      dao.delete(100);

      System.out.println("DONE!");
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  private static void createUsersTable() {
    try (Connection con = getConnection()) {
      final Statement statement = con.createStatement();
      statement.execute("create table users" +
        "(" +
        "  id integer primary key," +
        "  name text," +
        "  login text," +
        "  password text" +
        ");");

      statement.execute("insert into users (name, login, password) values" +
              "  ('Alexandr Alexandrov', 'alex', 'asd123')");
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }

  private static Connection getConnection() {
    Connection connection = null;
    try
    {
      connection = DriverManager.getConnection("jdbc:sqlite:resources/jdbc-demo.sqlite3");
      connection = DriverManager.getConnection("jdbc:postgres://localhost:5432/lab-24");
    }
    catch (SQLException e)
    {
      e.printStackTrace();
    }
    return connection;
  }
}

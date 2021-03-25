package org.hillel;

import org.hillel.dao.UserDao;
import org.hillel.entity.User;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JdbcDemo
{
  public static void main(String[] args)
  {
    try (Connection connection = getConnection())
    {
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
    }
    catch (Exception e)
    {
      e.printStackTrace();
    }
  }

  private static Connection getConnection()
  {
    Connection connection = null;
    try
    {
      connection = DriverManager.getConnection("jdbc:sqlite:resources/jdbc-demo.sqlite3");
    }
    catch (SQLException e)
    {
      e.printStackTrace();
    }
    return connection;
  }
}

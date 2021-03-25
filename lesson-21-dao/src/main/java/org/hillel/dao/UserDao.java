package org.hillel.dao;

import org.hillel.entity.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class UserDao implements DAO<User>{

  private Connection con;

  public UserDao(Connection con) {
    this.con = con;
  }

  @Override
  public void create(User entity) {
    try (PreparedStatement ps = con.prepareStatement("INSERT INTO users(id, name, login, password) VALUES (?, ?, ?, ?)"))
    {
      ps.setLong(1, entity.getId());
      ps.setString(2, entity.getName());
      ps.setString(3, entity.getLogin());
      ps.setString(4, entity.getPassword());

      ps.execute();
    }
    catch (SQLException e) {
      e.printStackTrace();
    }
  }

  @Override
  public User read(long id) {
    User user = null;
    try (PreparedStatement preparedStatement = con.prepareStatement("SELECT * from users WHERE id = ?")) {
      preparedStatement.setLong(1, id);
      try (ResultSet resultSet = preparedStatement.executeQuery()) {
        List<User> users = new ArrayList<>();

        String name = resultSet.getString("name");
        String login = resultSet.getString("login");
        String password = resultSet.getString("password");

        user = new User(id, name, login, password);
      }
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return user;
  }

  @Override
  public void update(User entity) {
    try (PreparedStatement ps = con.prepareStatement("UPDATE users SET name = ? , login = ?, password = ? WHERE id = ?"))
    {
      ps.setString(1, entity.getName());
      ps.setString(2, entity.getLogin());
      ps.setString(3, entity.getPassword());
      ps.setLong(4, entity.getId());

      ps.execute();
    }
    catch (SQLException e) {
      e.printStackTrace();
    }
  }

  @Override
  public void delete(long id) {
    try (Statement stmt = con.createStatement()) {
      stmt.execute("DELETE FROM users WHERE id = " + id);
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }
}

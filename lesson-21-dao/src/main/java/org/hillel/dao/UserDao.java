package org.hillel.dao;

import org.hillel.entity.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class UserDao implements DAO<User> {

  public static final String INSERT_USER = "INSERT INTO users(id, name, login, password) VALUES (?, ?, ?, ?)";
  public static final String SELECT_USER = "SELECT * from users WHERE id = ?";
  public static final String UPDATE_SQL = "UPDATE users SET name = ? , login = ?, password = ? WHERE id = ?";
  public static final String DELETE_SQL = "DELETE FROM users WHERE id = ";

  private Connection con;

  public UserDao(Connection con) {
    this.con = con;
  }

  @Override
  public void create(User entity) {
    try (PreparedStatement ps = con.prepareStatement(INSERT_USER)) {
      ps.setLong(1, entity.getId());
      ps.setString(2, entity.getName());
      ps.setString(3, entity.getLogin());
      ps.setString(4, entity.getPassword());

      ps.execute();
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }

  @Override
  public User read(long id) {
    User user = null;
    try (PreparedStatement preparedStatement = con.prepareStatement(SELECT_USER)) {
      preparedStatement.setLong(1, id);
      try (ResultSet resultSet = preparedStatement.executeQuery()) {

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
    try (PreparedStatement ps = con.prepareStatement(UPDATE_SQL)) {
      ps.setString(1, entity.getName());
      ps.setString(2, entity.getLogin());
      ps.setString(3, entity.getPassword());
      ps.setLong(4, entity.getId());

      ps.execute();
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }

  @Override
  public void delete(long id) {
    try (Statement stmt = con.createStatement()) {
      stmt.execute(DELETE_SQL + id);
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }
}

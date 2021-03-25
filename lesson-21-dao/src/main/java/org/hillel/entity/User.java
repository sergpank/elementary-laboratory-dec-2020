package org.hillel.entity;

public class User
{
  private long id;
  private String name;
  private String login;
  private String password;

  public User(long id, String name, String login, String password)
  {
    this.id = id;
    this.name = name;
    this.login = login;
    this.password = password;
  }

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getLogin() {
    return login;
  }

  public void setLogin(String login) {
    this.login = login;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  @Override
  public String toString()
  {
    final StringBuilder sb = new StringBuilder("User{");
    sb.append("id=").append(id);
    sb.append(", name='").append(name).append('\'');
    sb.append(", login='").append(login).append('\'');
    sb.append(", password='").append(password).append('\'');
    sb.append('}');
    return sb.toString();
  }
}

package notebook.entity;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "user")
public class User {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = "user_id")
  private int id;

  @Column(name = "email")
  private String email;

  @Column(name = "password")
  @Transient
  private String password;

  @Column(name = "name")
  private String name;

  @Column(name = "last_name")
  private String lastName;

  @Column(name = "active")
  private int active;

  @ManyToMany(cascade = CascadeType.ALL)
  @JoinTable(name = "user_role", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "role_id"))
  private Set<Role> roles;

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public int getActive() {
    return active;
  }

  public void setActive(int active) {
    this.active = active;
  }

  public Set<Role> getRoles() {
    return roles;
  }

  public void setRoles(Set<Role> roles) {
    this.roles = roles;
  }

  public User() {
    this.setActive(0);
  }
}

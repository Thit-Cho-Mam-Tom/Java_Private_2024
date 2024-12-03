package model;

public class Account extends Person{
    protected String username;
    protected String password;
    protected Role role;
    protected Status status;

    public Account(String user2, String password2, String user) {
        super();
    }

    public Account(String id, String fullName, int age, Address address, String birthday, String username, String password, Role role, Status status) {
        super(id, fullName, age, address, birthday);
        this.username = username;
        this.password = password;
        this.role = role;
        this.status = status;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Account{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", role=" + role +
                ", status=" + status +
                ", id='" + id + '\'' +
                ", fullName='" + fullName + '\'' +
                ", age=" + age +
                ", address=" + address +
                ", birthday='" + birthday + '\'' +
                '}';
    }
}

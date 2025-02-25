import java.util.List;

public class Person {
    private String firstaname, lastname, username, password, phone, email;
    private int age;
    private List<String> hobbies;

    public Person(String firstaname, String lastname, String username, String password, String phone, String email, int age) {
        this.firstaname = firstaname;
        this.lastname = lastname;
        this.username = username;
        this.password = password;
        this.phone = phone;
        this.email = email;
        this.age = age;
    }

    public String getFirstaname() {
        return firstaname;
    }

    public void setFirstaname(String firstaname) {
        this.firstaname = firstaname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
    public static List<String> getHobbies() {
        return List.of("Tennis", "Hiking", "Golf");
    }


}

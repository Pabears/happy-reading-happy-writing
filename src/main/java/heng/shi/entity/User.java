package heng.shi.entity;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import java.util.Date;
import java.util.List;

@Entity
public class User extends BaseEntity {
    private String username;
    private String password;
    private boolean man;
    private int age;
    private Date birthday;
    private String interesting;
    private String email;
    @ManyToMany
    private List<Book> books;
    @OneToMany(mappedBy = "user")
    private List<Caption> captions;

    public User() {
    }

    ;

    public User(User user) {
        this.username = user.getUsername();
        this.password = user.getPassword();
        this.man = user.getMan();
        this.age = user.getAge();
        this.birthday = user.getBirthday();
        this.interesting = user.getInteresting();
        this.email = user.getEmail();
        this.books = user.getBooks();
        this.captions = user.getCaptions();
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

    public boolean getMan() {
        return man;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getInteresting() {
        return interesting;
    }

    public void setInteresting(String interesting) {
        this.interesting = interesting;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }

    public List<Caption> getCaptions() {
        return captions;
    }

    public void setCaptions(List<Caption> captions) {
        this.captions = captions;
    }

    public boolean isMan() {
        return man;
    }

    public void setMan(boolean man) {
        this.man = man;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", man=" + man +
                ", age=" + age +
                ", birthday=" + birthday +
                ", interesting='" + interesting + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}

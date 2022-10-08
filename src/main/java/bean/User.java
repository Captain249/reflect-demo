package bean;

import java.time.LocalDate;

/**
 * @author shenzhuojun
 * @version 1.0 2022/10/1 10:16 上午
 * @Description
 */
public class User extends GenericiBean<User> {

    private String name;
    private Integer age;
    private LocalDate birth;
    private Dog dog;

    public User() {
    }

    public User(String name, Integer age, LocalDate birth) {
        this.name = name;
        this.age = age;
        this.birth = birth;
    }

    public User(String name, Integer age, LocalDate birth, Dog dog) {
        this.name = name;
        this.age = age;
        this.birth = birth;
        this.dog = dog;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public LocalDate getBirth() {
        return birth;
    }

    public void setBirth(LocalDate birth) {
        this.birth = birth;
    }

    public Dog getDog() {
        return dog;
    }

    public void setDog(Dog dog) {
        this.dog = dog;
    }

    public static class Dog {

        private String name;
        private User master;

        public Dog() {
        }

        public Dog(String name, User master) {
            this.name = name;
            this.master = master;
        }
    }
}

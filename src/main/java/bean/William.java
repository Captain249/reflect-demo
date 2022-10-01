package bean;

import java.time.LocalDate;

/**
 * @author shenzhuojun
 * @version 1.0 2022/10/1 10:19 上午
 * @Description
 */
public class William extends User implements Worker {

    public String publicName;
    private String privateName;

    public William() {
    }

    private William(String name, Integer age, LocalDate birth) {
        super(name, age, birth);
    }

    public William(String name, Integer age, LocalDate birth, Dog dog) {
        super(name, age, birth, dog);
    }

    @Override
    public void work() {
        System.out.println("I'm working");
    }

    @Override
    public boolean isLeader() {
        return true;
    }
}

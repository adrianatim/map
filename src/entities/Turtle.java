package entities;

public class Turtle implements Animal {
    private int id;
    private int age;
    private String name;

    public Turtle(int id, int age, String name) {
        this.id = id;
        this.age = age;
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Turtle: " + this.id + " " + this.name + " " + this.age;
    }


    @Override
    public int getAge() {
        return age;
    }

    @Override
    public int getId() {
        return id;
    }
}

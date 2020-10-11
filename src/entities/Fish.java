package entities;

public class Fish implements Animal {
    private int id;
    private int age;
    private String name;

    @Override
    public String toString() {
        return "Fish: " + this.id + " " + this.name + " " + this.age;
    }

    public Fish(int id, int age, String name) {
        this.id = id;
        this.age = age;
        this.name = name;
    }

    public void setAge(int newAge) {
        this.age = newAge;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public void setId(int id) {
        this.id = id;
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

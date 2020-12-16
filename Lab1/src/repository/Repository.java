package repository;

import entities.Animal;

import java.io.Serializable;

public class Repository implements Serializable, RepositoryInterface {
    private final Animal[] animals;
    private int size;

    public Repository() {
        this.animals = new Animal[100];
        this.size = 0;
    }

    @Override
    public void addAnimal(Animal a) throws Exception {
        int id= a.getId();
        int position = getPositionOfAnElement(id);
        if (position == -1) {
            this.animals[size++] = a;
        } else throw new Exception("This object already exists");
    }

    @Override
    public void removeAnimal(int id) throws Exception {
        int position = getPositionOfAnElement(id);
        if (position == -1) {
            throw new Exception("Can't delete something you don't have!");
        } else {
            //    if (this.animals[i].equals(a)) - condition for identical objects
            for (int j = position; j < this.size; j++) {
                this.animals[j] = this.animals[j + 1];
            }
            this.size -= 1;
        }
    }


    @Override
    public int getSize() {
        return this.size;
    }

    @Override
    public Animal[] getAll() {
        return this.animals;
    }


    public int getPositionOfAnElement(int id) {
        for (int i = 0; i < this.size; i++) {
            if (this.animals[i].getId() == id)
                return i;
        }
        return -1;
    }
}

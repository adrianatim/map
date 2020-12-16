package repository;

import entities.Animal;

public interface RepositoryInterface {
    void addAnimal(Animal a) throws Exception;
    void removeAnimal(int id) throws Exception;
    Animal[] getAll();
    int getSize();
}

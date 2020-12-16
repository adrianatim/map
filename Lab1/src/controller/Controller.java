package controller;

import entities.Animal;
import repository.Repository;
import repository.RepositoryInterface;

public class Controller {

    private final RepositoryInterface repo;

    public Controller(RepositoryInterface repo) {
        this.repo = repo;
    }

    public void controllerAddAnimal(Animal a) throws Exception {
        this.repo.addAnimal(a);
    }

    public void controllerRemoveAnimal(int id) throws Exception {
        this.repo.removeAnimal(id);
    }

    public Animal[] controllerGetAll() {
        return this.repo.getAll();
    }

    public int controllerGetSize()
    {
        return this.repo.getSize();
    }
}

package main;

import controller.Service;
import repository.Repository;
import view.View;

public class Main {

    public static void main(String[] args) {
        Repository repository = new Repository();
        Service service = new Service(repository, 1);
        View view = new View(service);
        view.run();
    }
}

import controller.Controller;
import repository.Repository;
import repository.RepositoryInterface;
import view.View;
import entities.Fish;
import entities.Turtle;

public class Main {

    public static void main(String[] args) {

        RepositoryInterface repo = new Repository();
        Controller controller = new Controller(repo);
        View view = new View(controller);

        try {
            controller.controllerAddAnimal(new Fish(1, 3, "fma"));
            controller.controllerAddAnimal(new Turtle(2, 100, "tna"));
            controller.controllerAddAnimal(new Fish(6, 2, "fgn"));
            controller.controllerAddAnimal(new Turtle(7, 1, "pgn"));
            controller.controllerAddAnimal(new Fish(10, 10, "mama"));
        }
        catch (Exception e) {
            System.err.println(e.getMessage());
        }
        view.run();

    }
}

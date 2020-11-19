package view;

import controller.Service;

import java.io.IOException;

public class RunExample extends Command {

    private final Service crt;

    public RunExample(String key, String desc, Service crt) {
        super(key, desc);
        this.crt = crt;
    }

    @Override
    public void execute() {
        try {
            this.crt.allStep();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

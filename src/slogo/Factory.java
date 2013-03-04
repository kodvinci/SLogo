package slogo;

import object.Turtle;


public class Factory {

    private Controller myController;

    public Factory (Controller controller) {
        myController = controller;
    }

    public void createTurtle (int model) {
        Turtle turtle = new Turtle();
        myController.getMyModels().get(model).getMyTurtles().add(turtle);
    }

}

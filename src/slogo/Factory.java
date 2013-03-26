package slogo;

/**
 * 
 * @author Jerry
 * 
 */
public class Factory {

    private Controller myController;

    /**
     * Constructs factory for controller
     * 
     * @param controller the controller
     */
    public Factory (Controller controller) {
        myController = controller;
    }

    /**
     * Creates turtle
     * 
     * @param model the model id to identify model turtle is created in
     */
    public void createTurtle (int model) {
        myController.getMyModels().get(model).addNewTurtle();
        myController.getMyModels().get(model).addCurrentActivatedTurtles(0);
        myController.getMyModels().get(model).addFutureActivatedTurtles(0);
        System.out.println("turtle number : " +
                           myController.getMyModels().get(model).getMyTurtles().size());
        myController.getMyModels().get(model).addFutureActivatedTurtles(0);
        System.out.println("turtle number : " +
                           myController.getMyModels().get(model).getMyTurtles().size());
    }

}

package utilities;

import java.util.ArrayList;
import java.util.List;


/**
 * 
 * @author Richard Yang
 * 
 */
public class Controller {

    private List<Model> myModels = new ArrayList<Model>();

    private Interpreter myInter;

    public Controller () {
        System.out.println("model");
        addModel();
        myInter = new Interpreter();
        System.out.println("model done");

    }

    public void processUserInput (int seq , String string) {
        myInter.process(myModels.get(seq),string);
      }
    
    public void addModel(){
        myModels.add(new Model(this));
    }
    
    public void addModel(Model model){
        myModels.add(model);
    }
    
    public void removeModel(int seq){
        myModels.remove(seq);
    }
    
    public void removeModel(Model model){
        myModels.remove(model);
    }
   
    public Model getModel(int seq){
        return myModels.get(seq);
    }
    
    public List<Model> getMyModels () {
        return myModels;
    }

    public Interpreter getMyInter () {
        return myInter;
    }
    
    
}

package exceptions;

public class ParameterException extends Exception {

    /**
     * set serial version ID
     */
    private static final long serialVersionUID = 1L;

    
    public ParameterException(){
        
    }
    
    public ParameterException(String message){
        super(message);
    } 
    
    
    
}

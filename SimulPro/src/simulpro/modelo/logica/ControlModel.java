

package simulpro.modelo.logica;

/**
 *
 * @author Ariel Arnedo
 */
public class ControlModel {
    
    private static ControlModel controlModel = null;
    private Animation animation;
    
    
    private  ControlModel() {   
    }

    public static ControlModel getControlModel(){
        if(controlModel == null){
            controlModel = new ControlModel();
        }
        return controlModel;
    }

    public Animation getAnimation() {
        return animation;
    }

    public void setAnimation(Animation animation) {
        this.animation = animation;
    }
    
    public void runThread(Runnable run){
        new Thread(run).start();
    }
}

package presenter;


public class SimulationThread extends Thread{

    private final Object Monitor = new Object();
    private boolean pauseThreadFlag = false;
    private Presenter presenter;
    private int animationSpeed = 1000;

    public SimulationThread(){
        start();
        try{
            pauseThread();
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }

    public void run(){
        while (true){
            try {
                checkForPaused();
                presenter.getWorld().produceNewWorldState();
                presenter.getWireWorldView().updateCellsColor(presenter.getWorld().getGrid());
                Thread.sleep(animationSpeed);
            }catch (InterruptedException e){break;}
        }
    }

    private void checkForPaused(){
        synchronized (Monitor){
            while (pauseThreadFlag){
                try{
                    Monitor.wait();
                }catch (Exception ignored){}
            }
        }
    }

    public void pauseThread() throws InterruptedException{
        pauseThreadFlag = true;
    }

    public void resumeThread(){
        synchronized (Monitor){
            pauseThreadFlag = false;
            Monitor.notify();
        }
    }

    public void setPresenter(Presenter presenter) {
        this.presenter = presenter;
    }

    public void setAnimationSpeed(int animationSpeed) {
        this.animationSpeed = animationSpeed;
    }
}

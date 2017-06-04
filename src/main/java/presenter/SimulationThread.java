package presenter;

/**
 * Klasa obsługująca symulację. Tworzy nowy wątek i z zadanym opóźnieniem generuje kolejne stany generacji
 */
public class SimulationThread extends Thread{ //To pozwala na wiele wątków. W sensie, że

    private final Object Monitor = new Object();
    private boolean pauseThreadFlag = false;
    private Presenter presenter;

    /**
     * Opóźnienie animacji w milisekundach
     */
    private int animationSpeed = 1000;
    private int numberOfGenerations = 1000;
    int i;

    public SimulationThread(){
        start();
        try{
            pauseThread();
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }

    public void run(){
        while (i<numberOfGenerations){
            try {
                checkForPaused();
                presenter.getWorld().produceNewWorldState();
                presenter.getWireWorldView().updateCellsColor(presenter.getWorld().getGrid());
                Thread.sleep(animationSpeed);
                i++;
// Tu ograniczyć liczbę generacji!
            }catch (InterruptedException e){break;} //catch - karze wrzucic tego try catcha i tyle, żeby na wszelki wyp.
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
    public void setNumberOfGenerations(int numberOfGenerations) {
        this.numberOfGenerations = numberOfGenerations;
    }
}
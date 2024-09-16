import java.util.concurrent.Semaphore;

public class Light extends Thread {
    private int x; 
    private int y; 
    private boolean state;
    Semaphore semLightHorizontale;
    Semaphore semLightVertical;
    Panneau panneau;

    public Light(int x, int y, boolean state, Panneau panneau){
        this.x = x;
        this.y = y;
        this.state = state;
        this.start();
        this.panneau = panneau;
    }

    public void run() {
        while (true) {
            try {
                sleep(5000);
            } catch (InterruptedException e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            }
            if (state) {
                //Panneau.semLightHorizontal.release();
                try {
                    Panneau.semLightVertical.acquire();
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
                Panneau.semLightHorizontal.release();
                state = false;
                this.panneau.revalidate();
			    this.panneau.repaint();
                feu1Vert();
            } else {
               // Panneau.semLightVertical.release();
                try {
                    Panneau.semLightHorizontal.acquire();
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
                Panneau.semLightVertical.release();
                state = true;
                this.panneau.revalidate();
			    this.panneau.repaint();
                feu1Rouge();
            }
            
        }
    }

        private void feu1Vert() {
            System.out.println("feu1 est vert");
        }
    
        private void feu1Rouge() {
            System.out.println("feu1 est rouge");
        }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public boolean isState() {
        return state;
    }

    public void setState(boolean state) {
        this.state = state;
    }
}

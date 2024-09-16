import java.util.Random;

public class Car extends Thread{
    private String name;
    private int sleepTime;
    private int x;
    private int y;
    private int id;
    private Panneau panneau;
    private String type;

    public Car(int id,String name, String type, int x, int y, Panneau panneau) {
        this.id = id;
        this.name = name;
        this.type = type; 
         this.panneau = panneau;
        this.x = x;
        this.y = y;
        this.start();
    }

    public int getX(){
        return this.x;
    }
    public int getY(){
        return this.y;
    }

    public String getType(){
        return this.type;
    }

    public void run() {
        sleepTime = new Random().nextInt(10);
		try {
			sleep(sleepTime * 1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
        this.initXandY();
        this.panneau.revalidate();
		this.panneau.repaint();
        moveZeroToLight();
        try {
            if(type.equals("vertical")){
                Panneau.semRoadVertical.acquire();
                Panneau.semLightVertical.acquire();
                crossRoad();
                moveLightToEndInter();
                Panneau.semLightVertical.release();
                Panneau.semRoadVertical.release();
            }
            else {
                Panneau.semRoadHorizontal.acquire();
                Panneau.semLightHorizontal.acquire();
                crossRoad();
                moveLightToEndInter();
                Panneau.semLightHorizontal.release();
                Panneau.semRoadHorizontal.release();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        moveLightToInter();
        this.panneau.revalidate();
		this.panneau.repaint();
    }

    private void initXandY(){
        if(type.equals("vertical")){
            this.x = 320;
            this.y = 600;
        }
        else {
            this.x = 0;
            this.y = 320;
        }
    }

    private void crossRoad() {
        System.out.println(this.name + " crossing road");
    }

    private void moveZeroToLight(){
        for (int i = 0; i<97; i ++){
            if(type.equals("vertical")){
                this.y -=2;
                this.panneau.revalidate();
		        this.panneau.repaint();
            }
            else {
                this.x +=2;
                this.panneau.revalidate();
		        this.panneau.repaint();
            }
            try {
                sleep(30);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        

    }

    private void moveLightToEndInter(){
        for (int i = 0; i<100; i ++){
            try {
                sleep(30);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if(type.equals("vertical")){
                this.y -=2;
                this.panneau.revalidate();
		        this.panneau.repaint();
            }
            else {
                this.x +=2;
                this.panneau.revalidate();
		        this.panneau.repaint();
            }
            
        }
    }
    private void moveLightToInter(){
        for (int i = 0; i<250; i ++){
            try {
                sleep(30);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if(type.equals("vertical")){
                this.y -=2;
                this.panneau.revalidate();
		        this.panneau.repaint();
            }
            else {
                this.x +=2;
                this.panneau.revalidate();
		        this.panneau.repaint();
            }
            
        }
        
    }
}

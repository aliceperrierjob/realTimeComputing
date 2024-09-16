import javax.swing.JPanel;


import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import javax.imageio.ImageIO;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.Semaphore;
import java.awt.image.BufferedImage;
import java.awt.RenderingHints;


public class Panneau extends JPanel {

    private Light light;  
    public static Semaphore semLightHorizontal = new Semaphore(1);
    public static Semaphore semLightVertical = new Semaphore(0);
	public static Semaphore semRoadHorizontal = new Semaphore(1);
	public static Semaphore semRoadVertical = new Semaphore(1);	
    private static List<Car> cars = new ArrayList<>();
	  
    private static int NB_CARS = 100;

    private static BufferedImage rotateImage(BufferedImage buffImage, double angle) {
        double radian = Math.toRadians(angle);
        double sin = Math.abs(Math.sin(radian));
        double cos = Math.abs(Math.cos(radian));

        int width = buffImage.getWidth();
        int height = buffImage.getHeight();

        int nWidth = (int) Math.floor((double) width * cos + (double) height * sin);
        int nHeight = (int) Math.floor((double) height * cos + (double) width * sin);

        BufferedImage rotatedImage = new BufferedImage(nWidth, nHeight, BufferedImage.TYPE_INT_ARGB);
       
    
       Graphics2D graphics = rotatedImage.createGraphics();

        graphics.setRenderingHint(
                RenderingHints.KEY_INTERPOLATION,
                RenderingHints.VALUE_INTERPOLATION_BICUBIC);

        graphics.translate((nWidth - width) / 2, (nHeight - height) / 2);
        // rotation around the center point
        graphics.rotate(radian, (double) (width / 2), (double) (height / 2));
        graphics.drawImage(buffImage, 0, 0, null);
        graphics.dispose();
        return rotatedImage;
    }
        
    public Panneau(){
        this.light = new Light(0, 0, false,this);

        for (int i = 0; i<NB_CARS; i++ ){
            final String[] proper_noun = {"horizontal", "vertical"};
            Random random = new Random();
            int index = random.nextInt(proper_noun.length);
            String type = proper_noun[index];
            Car car = new Car(i,"car"+i,type,-100,-100,this);
            cars.add(car);
        }
		

    }
    
    public void paintComponent(Graphics g){
		g.setFont(g.getFont().deriveFont(20f));
		g.setColor(Color.white);
		this.paintGround(g);
        this.paintRoad(g);
        this.paintLights(g);
        this.paintCar(g);
    }


    public void paintCar(Graphics g){
        try {
            BufferedImage bufferImgCar = ImageIO.read(new File("res/car.png"));
            for (int i = 0; i<cars.size(); i++){
                int x = cars.get(i).getX();
                int y = cars.get(i).getY();
                if (cars.get(i).getType().equals("vertical")){
                    g.drawImage(bufferImgCar, x, y, this);
                }
                else {
                    g.drawImage(rotateImage(bufferImgCar,90), x,y , this);
                }
                
            } 
            
		} catch (IOException e) {
			e.printStackTrace();
		}
    }

    public void paintLights(Graphics g){
        try {
            BufferedImage bufferImgRed = ImageIO.read(new File("res/red.jpg"));
            BufferedImage bufferImgGreen = ImageIO.read(new File("res/green.jpg"));
            if(this.light.isState()){
                g.drawImage(bufferImgGreen, 385, 385, this);
                g.drawImage(rotateImage(bufferImgRed, 90),186,385,this);
            }
            else{
                g.drawImage(bufferImgRed, 385, 385, this);
                g.drawImage(rotateImage(bufferImgGreen, 90) ,186,385,this);
            }
		} catch (IOException e) {
			e.printStackTrace();
		}
        
        
    }

    public void paintGround(Graphics g){
        try {
			Image img = ImageIO.read(new File("res/ground.jpg"));
			for (int i=0 ; i < 11; i++) {
				for (int j=0 ; j < 11 ; j ++) {
					g.drawImage(img, 64*i, 64*j, this);
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
    }

    public void paintCar(Graphics g, BufferedImage img){
		g.drawImage(img, 385, 385 , this);
    }


 
    

    public void paintRoad(Graphics g){
        try {
		    Image imgRoad = ImageIO.read(new File("res/road.jpg"));
            Image imgInter = ImageIO.read(new File("res/road2.jpg"));
            BufferedImage bufferImgRoad = ImageIO.read(new File("res/road.jpg"));
            BufferedImage bufferImgInter = ImageIO.read(new File("res/road2.jpg"));
            Graphics2D g2d = (Graphics2D)g;          
            for(int i = 0; i<12; i++){
            if (i == 4){
                g2d.drawImage(imgInter, 256, imgRoad.getWidth(getFocusCycleRootAncestor())*i, this);
                g2d.drawImage(rotateImage(bufferImgInter, 90), 256+imgRoad.getHeight(getFocusCycleRootAncestor()), imgRoad.getWidth(getFocusCycleRootAncestor())*i, this);
            }
            else if (i == 5){
                g2d.drawImage(rotateImage(bufferImgInter, 270),256, imgRoad.getWidth(getFocusCycleRootAncestor())*5 , this);
                g2d.drawImage(rotateImage(bufferImgInter, 180), 256+imgRoad.getHeight(getFocusCycleRootAncestor()), imgRoad.getWidth(getFocusCycleRootAncestor())*i, this);

            }
            else {
            g2d.drawImage(rotateImage(bufferImgRoad, 180), 256+imgRoad.getHeight(getFocusCycleRootAncestor()), imgRoad.getWidth(getFocusCycleRootAncestor())*i, this);
            g2d.drawImage(imgRoad, 256, bufferImgInter.getWidth(getFocusCycleRootAncestor())*i, this);
            g2d.drawImage(rotateImage(bufferImgRoad, 90), imgRoad.getHeight(getFocusCycleRootAncestor())*i,256, this);
            g2d.drawImage(rotateImage(bufferImgRoad, 270), imgRoad.getHeight(getFocusCycleRootAncestor())*i,256+imgRoad.getHeight(getFocusCycleRootAncestor()), this);
            g2d.drawImage(imgRoad, 256, bufferImgInter.getWidth(getFocusCycleRootAncestor())*i, this);
            }
            
            }
                
		} catch (IOException e) {
			e.printStackTrace();
		}
    }
}

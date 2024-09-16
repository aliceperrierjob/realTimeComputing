import javax.swing.JFrame;


public class Fenetre extends JFrame{
    public Fenetre(){
    this.setTitle("Intersection");
    this.setSize(658, 687);
    this.setLocationRelativeTo(null);
    this.setResizable(false);
    this.setAlwaysOnTop(true);
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
 

    this.setContentPane(new Panneau());

    this.setVisible(true);
  }
}
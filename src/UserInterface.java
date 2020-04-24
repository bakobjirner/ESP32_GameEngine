import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.LinkedList;
import java.util.List;

public class UserInterface extends JFrame {

    Graphics g;
    JPanel gamePanel;
    List<JLabel> labels=new LinkedList<JLabel>();
    private int zoomFactor = 3;

    public UserInterface(){

        gamePanel=new JPanel();
        gamePanel.setBounds(10,10,320*zoomFactor,240*zoomFactor);
        gamePanel.setBackground(Color.lightGray);
        gamePanel.setLayout(null);
        add(gamePanel);


        setLayout(new BorderLayout());
        setSize(1300,1000);
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
        g = gamePanel.getGraphics();

    }






    void drawImage(BufferedImage image,int xPos, int yPos){


        int scaledWidth = image.getWidth()*zoomFactor;
        int scaledHeight = image.getHeight()*zoomFactor;
        Image scaledImage = image.getScaledInstance(scaledWidth,scaledHeight,Image.SCALE_FAST);


        JLabel a = new JLabel();
        a.setBounds(100,100,100,100);
        a.setBackground(Color.green);
        a.setIcon(new ImageIcon(scaledImage));
        labels.add(a);
        gamePanel.add(a);
        gamePanel.revalidate();
        validate();
        repaint();
    }
}

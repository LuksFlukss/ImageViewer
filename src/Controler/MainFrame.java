package Controler;

import Persistence.ImageLoader;
import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.WindowConstants;
import UI.ImageDisplay;
import UI.SwingImageDisplay;

/**
 * 
 * @author Louka Vanhoucke
 */

public class MainFrame extends JFrame {
    
    private ImageDisplay imageDisplay;
    final ImageLoader imageLoader;
    
    public MainFrame(ImageLoader imageLoader) {
        this.imageLoader = imageLoader; 
        this.setTitle("Image Viewer IS2");
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setSize(800,600);
        this.setLocationRelativeTo(null);
        this.getContentPane().add(imageDisplay());
        this.getContentPane().add(toolBar(),BorderLayout.SOUTH);
        currentImage();
        this.repaint();
        this.setVisible(true);
    }
    
    public ImageDisplay getImageDisplay() {
        return imageDisplay;
    }
 
    private JPanel imageDisplay() {
        SwingImageDisplay sid = new SwingImageDisplay();
        this.imageDisplay = sid;
        return sid;
    }
    
    private JPanel toolBar() {
        JPanel panel = new JPanel();
        panel.add(prevButton());
        panel.add(nextButton());
        return panel;
    }
      
    private JButton prevButton() {
        JButton button = new JButton("<");
        button.addActionListener(prevImage());
        return button;
    }
    
    private JButton nextButton() {
        JButton button = new JButton(">");
        button.addActionListener(nextImage());
        return button;
    }
    
    private ActionListener prevImage() {
        return e -> imageDisplay.show(imageLoader.prev());
    }

    private ActionListener nextImage() {
        return e -> imageDisplay.show(imageLoader.next());
    }
    
    private ActionListener currentImage() {
        return e -> imageDisplay.show(imageLoader.load());
    }
} 

    


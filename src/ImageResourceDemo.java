
import javax.swing.*;
import java.awt.*;
import java.awt.image.*;
import java.io.*;
import javax.imageio.*;
import java.net.URL;

public final class ImageResourceDemo {
    private static BufferedImage bi;

    public static void main(String[] args) throws IOException{
        try {
            loadImage();

            SwingUtilities.invokeLater(new Runnable(){
                @Override
                public void run() {
                    createAndShowGUI();
                }
            });
        } catch (IOException e) {
            e.printStackTrace();
        }
    }



    private static void loadImage() throws IOException{
        bi = ImageIO.read(
                ImageResourceDemo.class.getResource("sheet.jpeg"));

    }

    private static void createAndShowGUI(){
        final JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        JTextField strength = new JTextField("");
        strength.setBounds(10, 10, 100, 100);






        frame.add(strength);

        frame.getContentPane().setBackground(Color.WHITE);

        frame.add(new JLabel(new ImageIcon(bi)));
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
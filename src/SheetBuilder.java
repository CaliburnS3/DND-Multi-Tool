
import javax.swing.*;
import java.awt.*;
import java.awt.image.*;
import java.io.*;
import javax.imageio.*;
import java.util.ArrayList;
import java.util.Random;

public class SheetBuilder {
    private static BufferedImage bi;
    private static ArrayList<JTextField> stats;
    private static Random rand;

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
                SheetBuilder.class.getResource("CharacterSheets/BaseSheet.jpeg"));

    }

    public static void createStats(int range, int offset){

        rand = new Random();
        for(int i = 0; i < stats.size() - 1; i++){
            stats.get(i).setText(String.valueOf(rand.nextInt(range) + 1 + offset));
        }


    }

    private static void createAndShowGUI(){
        final JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        stats = new ArrayList<JTextField>();

        JTextField strength = new JTextField("");
        strength.setBounds(45, 120, 50, 50);

        JTextField dexterity = new JTextField("");
        dexterity.setBounds(45, 210, 50, 50);

        JTextField constitution = new JTextField("");
        constitution.setBounds(45, 300, 50, 50);

        JTextField intelligence = new JTextField("");
        intelligence.setBounds(45, 390, 50, 50);

        JTextField wisdom = new JTextField("");
        wisdom.setBounds(45, 480, 50, 50);

        JTextField charisma = new JTextField("");
        charisma.setBounds(45, 570, 50, 50);

        stats.add(strength);
        stats.add(dexterity);
        stats.add(constitution);
        stats.add(intelligence);
        stats.add(wisdom);
        stats.add(charisma);

        frame.add(strength);
        frame.add(dexterity);
        frame.add(constitution);
        frame.add(intelligence);
        frame.add(wisdom);
        frame.add(charisma);


        frame.getContentPane().setBackground(Color.WHITE);
        frame.add(new JLabel(new ImageIcon(bi)));
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
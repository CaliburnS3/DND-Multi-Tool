/*
 * Copyright (c) 1995, 2008, Oracle and/or its affiliates. All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions
 * are met:
 *
 *   - Redistributions of source code must retain the above copyright
 *     notice, this list of conditions and the following disclaimer.
 *
 *   - Redistributions in binary form must reproduce the above copyright
 *     notice, this list of conditions and the following disclaimer in the
 *     documentation and/or other materials provided with the distribution.
 *
 *   - Neither the name of Oracle or the names of its
 *     contributors may be used to endorse or promote products derived
 *     from this software without specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS
 * IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO,
 * THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR
 * PURPOSE ARE DISCLAIMED.  IN NO EVENT SHALL THE COPYRIGHT OWNER OR
 * CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL,
 * EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO,
 * PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR
 * PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF
 * LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING
 * NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
 * SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */
//import sun.print.ServiceDialog;
//import sun.security.provider.ConfigFile;

/*
import java.awt.*;
import javax.swing.JFrame;

public class MyCanvas extends Canvas{

    public void paint(Graphics g) {

        Toolkit t=Toolkit.getDefaultToolkit();
        Image i=t.getImage("p3.gif");
        g.drawImage(i, 120,100,this);

    }
        public static void main(String[] args) {
        MyCanvas m=new MyCanvas();
        JFrame f=new JFrame();
        f.add(m);
        f.setSize(400,400);
        f.setVisible(true);
    }

}
 */

import java.awt.*;
import java.awt.Canvas;
import java.awt.event.*;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.Shape;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.geom.Ellipse2D;

import java.util.ArrayList;
import java.util.Random;

import javax.swing.*;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.KeyStroke;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.JFrame;
import javax.swing.JPanel;


public class GUI extends JPanel implements ActionListener {
    public static JFrame frame;
    public static ArrayList buttons = new ArrayList();

    static String[] args = {};

    public Random rand;



    public GUI(){
        frame = new JFrame("GUI");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        //Buttons
       JButton DiceButton = new JButton("Dice Roll");
        DiceButton.setBounds(0, 0, 120, 30);
        DiceButton.addActionListener(e -> DiceButton());

        JButton SpellButton = new JButton("Spell Search");
        SpellButton.setBounds(0, 25, 120, 30);
        SpellButton.addActionListener(e -> SpellButton());

        JButton CharacterButton = new JButton("Character Creator");
        CharacterButton.setBounds(0, 50, 120, 30);
        CharacterButton.addActionListener(e -> CharacterButton());

        /*

        JButton NMButton = new JButton("Node Map");
        NMButton.setBounds(0, 75, 120, 30);
        NMButton.addActionListener(e -> NMButton());

        JButton SGButton = new JButton("Shape Gen");
        SGButton.setBounds(0, 100, 120, 30);
        SGButton.addActionListener(e -> SGButton());

        JButton CSButton = new JButton("Copy Seed");
        CSButton.setBounds(0, 125, 120, 30);
        CSButton.addActionListener(e -> CSButton());

        JButton ClSButton = new JButton("Clear Seed");
        ClSButton.setBounds(0, 150, 120, 30);
        ClSButton.addActionListener(e -> ClSButton());

        SeedBox = new JTextField();
        SeedBox.setBounds(0, 175, 120, 30);
        SeedBox.addActionListener(this);

        outBox = new JTextField();
        outBox.setBounds(0, 200, 120, 30);*/


        //Add Components to this panel.
        //GridBagConstraints H = new GridBagConstraints();
        //H.fill = GridBagConstraints.HORIZONTAL;
        frame.add(DiceButton);
        frame.add(SpellButton);
        frame.add(CharacterButton);



        //Display the window.
        frame.setSize(120, 250);
        frame.setLayout(null);
        frame.setVisible(true);
        frame.getContentPane().setBackground(Color.GRAY);
        //TODO: CanvasHost.main(args);
    }

    private void DiceButton(){
        SwingWorker myWorker= new SwingWorker<String, Void>() {
            @Override
            protected String doInBackground() throws Exception {
                //Execute your logic
                    DiceRoll.main(args);

                return null;
            }
        };
        myWorker.execute();
    }

    private void SpellButton(){
        SwingWorker myWorker= new SwingWorker<String, Void>() {
            @Override
            protected String doInBackground() throws Exception {
                //Execute your logic
                return null;
            }
        };
        myWorker.execute();
    }

    private void CharacterButton(){
        SwingWorker myWorker= new SwingWorker<String, Void>() {
            @Override
            protected String doInBackground() throws Exception {
                //Execute your logic
                Creator.main(args);
                return null;
            }
        };
        myWorker.execute();
    }


    public void actionPerformed(ActionEvent evt) {
    }

    public static void main(String[] args) {
        //Schedule a job for the event dispatch thread:
        //creating and showing this application's GUI.
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                //createGUI();
                Object runnable = new GUI();
            }
        });
    }
}
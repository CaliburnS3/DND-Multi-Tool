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

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;


public class DiceRoll extends JPanel implements ActionListener {

    static String[] args = {};
    private static JFrame frame;
    public Random rand;
    private int width, height;
    private JButton totalDisplay;
    private ArrayList<ArrayList<Component>> masterList;
    private ArrayList<JTextField> diceCounter;




    public DiceRoll() {
        frame = new JFrame("Dice");
        frame.setLocation(120, 0);
        masterList = new ArrayList();
        diceCounter = new ArrayList();

        //Buttons
        totalDisplay = new JButton("Total:");
        totalDisplay.setBounds(0, 0, 120, 30);

        JButton roll = new JButton("Roll All");
        roll.setBounds(0, 25, 120, 30);
        roll.addActionListener(e -> RollAll());

        JButton addDice = new JButton("Add Dice");
        addDice.setBounds(0, 50, 120, 30);
        addDice.addActionListener(e -> addDiceButton());

        JButton removeDice = new JButton("Remove Dice");
        removeDice.setBounds(0, 75, 120, 30);
        removeDice.addActionListener(e -> removeDiceButton());






        //Add Components to this panel.
        //GridBagConstraints H = new GridBagConstraints();
        //H.fill = GridBagConstraints.HORIZONTAL;
        //frame.add(imageIcon);
        frame.add(totalDisplay);
        frame.add(roll);
        frame.add(addDice);
        frame.add(removeDice);
        //frame.add(diceResults);


        //Display the window.
        frame.setSize(120, 250);
        width = 120;
        height = 250;
        frame.setLayout(null);
        frame.setVisible(true);
        frame.getContentPane().setBackground(Color.GRAY);


        addDiceButton();
        //TODO: CanvasHost.main(args);
    }

    public static void main(String[] args) {
        //Schedule a job for the event dispatch thread:
        //creating and showing this application's GUI.
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                //createGUI();
                Object runnable = new DiceRoll();
            }
        });
    }

    private void addDiceButton() {
        ArrayList<Component> diceList = new ArrayList<Component>();
        masterList.add(diceList);


        JTextField diceSides = new JTextField("20");
        diceSides.setBounds(width + 40, 7, 40, 20);
        diceSides.setBorder(BorderFactory.createLineBorder(Color.GRAY));
        diceSides.setHorizontalAlignment(JTextField.CENTER);

        JButton remove = new JButton("-");
        remove.setBounds(width + 18, 7, 25, 20);
        remove.setBorder(BorderFactory.createLineBorder(Color.GRAY));
        remove.setBackground(Color.LIGHT_GRAY);
        remove.setOpaque(true);
        remove.addActionListener(e -> componentSearch(0, -1, -1));

        JButton add = new JButton("+");
        add.setBounds(width + 77, 7, 25, 20);
        add.setBorder(BorderFactory.createLineBorder(Color.GRAY));
        add.setBackground(Color.LIGHT_GRAY);
        add.setOpaque(true);
        add.addActionListener(e -> componentSearch(1, -1, -1));

        JButton rollButton = new JButton("Roll");
        rollButton.setBounds(width + 15, 25, 90, 30);
        rollButton.addActionListener(e -> componentSearch(2, -1, -1));

        JTextField fieldOne = new JTextField("");
        fieldOne.setBounds(width + 15, 50, 90, 30);
        fieldOne.setHorizontalAlignment(JTextField.CENTER);


        /*
         JTextField diceSides = new JTextField("20");
        diceSides.setBounds(width + 40, 5, 40, 20);
        diceSides.setHorizontalAlignment(JTextField.CENTER);

        JButton remove = new JButton("-");
        remove.setBounds(width + 5, 30, 25, 20);
        remove.addActionListener(e -> componentSearch(0, -1, -1));

        JButton add = new JButton("+");
        add.setBounds(width + 90, 30, 25, 20);
        add.addActionListener(e -> componentSearch(1, -1, -1));

        JButton rollButton = new JButton("Roll");
        rollButton.setBounds(width + 20, 25, 80, 30);
        rollButton.addActionListener(e -> componentSearch(2, -1, -1));

        JTextField fieldOne = new JTextField("");
        fieldOne.setBounds(width, 50, 120, 30);
        fieldOne.setHorizontalAlignment(JTextField.CENTER);

         */



        diceList.add(diceSides);
        diceList.add(remove);
        diceList.add(add);
        diceList.add(rollButton);
        diceList.add(fieldOne);

        diceCounter.add(diceSides);

        frame.add(remove);

        frame.add(add);

        frame.add(rollButton);
        frame.add(diceSides);
        frame.add(fieldOne);

        width += 120;
        frame.setSize(width, height);
    }

    private void removeDiceButton() {
        ArrayList<Component> diceList = masterList.get(masterList.size() - 1);
        for (int i = 0; i < diceList.size(); i++) {
            frame.remove(diceList.get(i));
        }
        diceList.clear();
        diceCounter.remove(diceCounter.size() - 1);
        masterList.remove(masterList.size() - 1);
        width -= 120;
        frame.setSize(width, height);
    }

    private void componentSearch(int toggle, int inputValue, int override) {
        Point point = frame.getMousePosition();
        int i = ((point.x - 120) / 120);
        if(override > -1){
            i = override;
        }
        if (toggle == 0) {
            removeRollSlot(masterList.get(i));
        } else if (toggle == 2) {
            rollSlot(masterList.get(i), i, override);
        } else {
            addRollSlot(masterList.get(i), inputValue);
        }
        frame.repaint();
    }

    private void addRollSlot(ArrayList<Component> input, int randInput) {
        int x = masterList.indexOf(input);
        JTextField diceSlot;


        if (randInput > -1) {
            diceSlot = new JTextField(String.valueOf(randInput));
        } else {
            diceSlot = new JTextField("");
        }


        //fieldOne.setBounds(width + 15, 50, 90, 30);
        diceSlot.setBounds(((x + 1) * 120) + 15, 25 * (input.size() - 2), 90, 30);
        diceSlot.setHorizontalAlignment(JTextField.CENTER);
        frame.add(diceSlot);
        input.add(diceSlot);
        masterList.set(x, input);
    }

    private void removeRollSlot(ArrayList<Component> input) {
        if (input.size() > 4) {
            int x = masterList.indexOf(input);
            frame.remove(input.get(input.size() - 1));
            input.remove(input.get(input.size() - 1));
            masterList.set(x, input);

        }
    }

    private int rollSlot(ArrayList<Component> input, int counterPos, int override) {
        rand = new Random();
        int x = input.size() - 1;
        int randInput = Integer.valueOf(diceCounter.get(counterPos).getText());


        for (int i = 3; i < x; i++) {
            componentSearch(0, 0, override);
        }
        int total = 0;
        for (int i = 3; i < x; i++) {
            if (randInput > -1) {
                int temp = rand.nextInt(randInput) + 1;
                total+= temp;
                componentSearch(1, temp, override);
            } else {
                componentSearch(1, -1, override);
            }
        }
        return total;
    }

    private void RollAll() {
        int total = 0;
        for(int i = 0; i <= masterList.size() - 1; i++){
            total += rollSlot(masterList.get(i), i, i);
        }
        totalDisplay.setText("Total: " + total);
    }

    public void actionPerformed(ActionEvent evt) {
    }
}
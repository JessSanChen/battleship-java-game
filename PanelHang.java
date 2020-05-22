//Jessica Chen, PanelHang.java, 18 May 2017

import java.io.*;     					 //the File class
import java.util.*;    				    //the Scanner class
import javax.swing.JOptionPane;
import java.util.Arrays;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class PanelHang extends JPanel
{

   //private ScoreboardHang scoreboard;
   private JPanel picPanel;
   private JPanel trashPanel;
   private JPanel inputPanel;
   private JPanel targetPanel;
   private JLabel[][] trashLabels;
   private JTextField inputBox;
   private JButton charInput, stringInput;
   private JLabel inputLabel;
   public PanelHang()
   {
      setLayout(new BorderLayout());
   
      //scoreboard = new ScoreboardHang();
      //add(scoreboard, BorderLayout.NORTH);
   
      picPanel = new JPanel();
      trashPanel.setLayout(new FlowLayout());
      ///
      add(picPanel, BorderLayout.CENTER);
   
      trashPanel = new JPanel();
      trashPanel.setLayout(new GridLayout(3,3));
      ///
      add(trashPanel, BorderLayout.SOUTH);
      // trash display (added to trashPanel)
      trashLabels = new JLabel[3][3];
      for(int r = 0; r < 3; r++)
         for(int c = 0; c < 3; c++)
         {
            trashLabels[r][c] = new JLabel("");
            //trashLabels[r][c].setFont(new Font("Serif", 18));
            trashLabels[r][c].setForeground(Color.blue);
            trashPanel.add(trashLabels[r][c]);
         }
      //INPUT PANEL
      inputPanel = new JPanel(); 
      inputPanel.setLayout(new BorderLayout());
      inputBox = new JTextField(); //TEXTFIELD (USER ENTERS WORD OR LETTER)
      inputPanel.add(inputBox, BorderLayout.NORTH);
      JPanel buttonSubPanel = new JPanel();
      buttonSubPanel.setLayout(new GridLayout(1,2)); //SUBPANEL WITH TWO BUTTONS
      inputPanel.add(buttonSubPanel, BorderLayout.CENTER); 
      charInput = new JButton("Guess Letter"); //CHECK LETTER
     // charInput.addActionListener(new Listener1());//action listener 1
      stringInput = new JButton("Guess Word"); //CHECK WORD
      //stringInput.addActionListener(new Listener2());//action listener 2
      buttonSubPanel.add(charInput);
      buttonSubPanel.add(stringInput);
      JLabel inputLabel = new JLabel("");//Label that states if guess is correct or incorrect
      //inputLabel.setFont(new Font("Serif", 18));
      inputPanel.add(inputLabel, BorderLayout.SOUTH);      
      
      
      }
   /*private class Listener1 implements ActionListener
   {
      public void actionPerformed(ActionEvent e)
      {
 
      }
   }
   private class Listener2 implements ActionListener
   {
      public void actionPerformed(ActionEvent e)
      {
 
      }
   }*/

}
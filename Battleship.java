//Jessica Chen, Battleship.java, 7 March 2017
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class Battleship extends JPanel
{
   private JButton[][] board;
   private int[][] matrix;
   private int hits, torpedoes;
   private JLabel label;
   private JButton reset;
   public Battleship()
   {
      setLayout(new BorderLayout());
      hits = 0;
      torpedoes = 20;
   
      JPanel north = new JPanel();
      north.setLayout(new FlowLayout());
      add(north, BorderLayout.NORTH);
      label = new JLabel("Welcome to Battleship -- You have 20 torpedoes.");
      north.add(label);
   
      JPanel center = new JPanel();
      center.setLayout(new GridLayout(10,10));
      add(center, BorderLayout.CENTER);
   
      board = new JButton[10][10];
      matrix = new int[10][10];
      for(int r = 0; r < 10; r++)
         for(int c = 0; c < 10; c++)
         {
            board[r][c] = new JButton();
            board[r][c].setBackground(Color.blue);
            board[r][c].addActionListener( new Handler1(r, c) );
            center.add(board[r][c]);
         }
   
      reset = new JButton("Reset");
      reset.addActionListener( new Handler2() );
      reset.setEnabled(false);
      add(reset, BorderLayout.SOUTH);
   
      placeShip();
   }
   private void placeShip()
   {
      int coin = (int)(Math.random()*2);
      if(coin==1)
      {            
         int rpos = (int)(Math.random()*10);
         int cpos = (int)(Math.random()*7);
         for(int c = cpos; c < cpos+4; c++)
            matrix[rpos][c]=1;
      }  
      else
      {            
         int rpos = (int)(Math.random()*7);
         int cpos = (int)(Math.random()*10);
         for(int r = rpos; r < rpos+4; r++)
            matrix[r][cpos]=1;
      }     
   }
   private class Handler1 implements ActionListener
   {
      private int myRow, myCol;
      public Handler1(int r, int c)
      {
         myRow = r;
         myCol = c;
      }
      public void actionPerformed(ActionEvent e)
      {
         torpedoes-=1;
         if(matrix[myRow][myCol]==1)
         {
            hits++;
            board[myRow][myCol].setBackground(Color.red);
            matrix[myRow][myCol]=0;
            board[myRow][myCol].setEnabled(false);
            label.setText("Hit! "+torpedoes+" torpedoes remaining.");
            if(hits==4)
            {
               for(int r = 0; r < 10; r++)
                  for(int c = 0; c < 10; c++)
                     board[r][c].setEnabled(false);
               label.setText("You sunk my battleship!");
               reset.setEnabled(true);
            }
            else if(torpedoes==0)
            {
               for(int r = 0; r < 10; r++)
                  for(int c = 0; c < 10; c++)
                  {
                     board[r][c].setEnabled(false);
                     if(matrix[r][c]==1)
                        board[r][c].setBackground(Color.black);
                  }
               label.setText("L O S E R");
               reset.setEnabled(true);
            }
         }
         else
         {               
            board[myRow][myCol].setBackground(Color.white);
            board[myRow][myCol].setEnabled(false);
            label.setText("Miss! "+torpedoes+" torpedoes remaining.");
            if(torpedoes==0 && hits!=4)
            {
               for(int r = 0; r < 10; r++)
                  for(int c = 0; c < 10; c++)
                  {
                     board[r][c].setEnabled(false);
                     if(matrix[r][c]==1)
                        board[r][c].setBackground(Color.black);
                  }
               label.setText("L O S E R");
               reset.setEnabled(true);
            }
         }      
      }
   }
   private class Handler2 implements ActionListener
   {
      public void actionPerformed(ActionEvent e)
      {
         label.setText("Welcome to Battleship -- You have 20 torpedoes.");
         torpedoes=20;
         hits=0;
         for(int r = 0; r < 10; r++)
            for(int c = 0; c < 10; c++)
            {
               board[r][c].setBackground(Color.blue);
               board[r][c].setEnabled(true);
               matrix[r][c]=0;
            }            
         reset.setEnabled(false);
         placeShip();
      
      }
   }
}
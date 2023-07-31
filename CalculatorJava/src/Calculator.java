import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;

import java.awt.event.ActionListener;
import javax.swing.Timer;

public class Calculator {

    JFrame window = new JFrame("Calculator");
    JPanel boardPanel = new JPanel();
    JPanel buttonPanel = new JPanel();

    JLabel calculField = new JLabel("0");
    JButton[] buttons = new JButton[20];


    Calculator() {

      /* Window (JFrame) */
      window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      window.setSize(360, 600);
      window.setLayout(new BorderLayout());
      window.setVisible(true);
      window.getContentPane().setBackground(new Color(50, 50, 50));
      window.setResizable(false);

      /* Board Panel (Jpanel) */
      boardPanel.setBounds(20, 20, 350, 150);
      boardPanel.setLayout(new BorderLayout());
      boardPanel.setBackground(new Color(75, 75, 75));

      /* Calcul Field (JLabel) */
      calculField.setBounds(50, 30, 320, 60);
      calculField.setForeground(new Color(25, 120, 255));
      calculField.setHorizontalAlignment(JLabel.RIGHT);
      calculField.setOpaque(true);

      /* Button Panel (Jpanel) */
      buttonPanel.setLayout(new GridLayout(5, 4, 2, 3));
      buttonPanel.setBackground(new Color(50, 50, 50));

      /* Imbrication */
      
    }
}
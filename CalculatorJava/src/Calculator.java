import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;

import java.awt.event.ActionListener;
import javax.swing.Timer;

public class Calculator {

    JFrame window = new JFrame("Calculator");
    JPanel globalPanel = new JPanel();
    JPanel boardPanel = new JPanel();
    JPanel buttonPanel = new JPanel();

    JLabel calculField = new JLabel("0");
    JButton[] buttons = new JButton[16];
    String[] buttonLabels = { "7", "8", "9", "/", "4", "5", "6", "*", "1", "2", "3", "-", "0", ".", "=", "+" };

    Calculator() {

      /* Window (JFrame) */
      /* La fenêtre de l'application */
      window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      window.setSize(360, 500);
      window.setLayout(new BorderLayout());
      window.setVisible(true);
      window.getContentPane().setBackground(new Color(50, 50, 50));
      window.setResizable(false);

      /* Global Panel (JPanel) */
      /* La page dans son ensemble */
      globalPanel.setSize(350, 490);
      globalPanel.setLayout(new GridLayout(2, 1));
      // TODO change to gridBagLayout + adjuste the page to put screen on top and number at the bottom

      /* Board Panel (JPanel) */
      /* "L'écran" de la calculette */
      boardPanel.setLayout(new BorderLayout());
      boardPanel.setBounds(14, 12, 318, 40);

      /* Calcul Field (JLabel) */
      /* Le texte qui apparait dans boardPanel */
      calculField.setForeground(new Color(25, 120, 255));
      calculField.setBackground(new Color(75, 90, 75));
      calculField.setHorizontalAlignment(JLabel.RIGHT);
      calculField.setOpaque(true);

      /* Button Panel (JPanel) */
      /* La zone qui contient tout les boutons de la calculette */
      
      buttonPanel.setLayout(new GridLayout(5, 4, 2, 3));
      buttonPanel.setBackground(new Color(50, 50, 50));
      for(int i = 0; i < buttons.length; i++){ 
        // Créer un bouton de type Jbutton (Swing library) 
        // et le remplis avec le texte du bouton associé
        buttons[i] = new JButton(buttonLabels[i]);
        buttonPanel.add(buttons[i]); // Ajoute chaque bouton à la zone buttonPanel
      }

      /* Imbrication de tout les éléments */
      globalPanel.add(boardPanel); // Ajoute l'écran à la page
      globalPanel.add(buttonPanel); // Ajoute "le clavier" à la page
      window.add(globalPanel); // Ajoute la page à la fenêtre
      boardPanel.add(calculField); // Ajoute le texte de calcul à l'écran
      
      window.setVisible(true);
    }
}
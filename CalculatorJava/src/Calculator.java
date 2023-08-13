import java.awt.*;
import java.awt.event.*;
import java.util.*;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.swing.*;
import javax.swing.Timer;

public class Calculator {

  JFrame window = new JFrame("Calculator");
  JPanel globalPanel = new JPanel();
  JPanel boardPanel = new JPanel();
  JPanel buttonPanel = new JPanel();

  JLabel calculField = new JLabel("0");
  JButton[] buttons = new JButton[16];
  String[] buttonLabels = { "7", "8", "9", "/", "4", "5", "6", "*", "1", "2", "3", "-", ".", "0", "=", "+" };

  String currentInput = "";
  double currentResult = 0.0;
  String currentOperator = "";

  Calculator() {

    /* Window (JFrame) */
    /* La fenêtre de l'application */
    window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    window.setSize(360, 450);
    window.setLayout(new BorderLayout());
    window.setVisible(true);
    window.getContentPane().setBackground(new Color(242, 159, 5));
    window.setResizable(false);

    /* Global Panel (JPanel) */
    /* La page dans son ensemble */
    globalPanel.setSize(350, 400);
    globalPanel.setLayout(new GridLayout(2, 1));

    /* Board Panel (JPanel) */
    /* "L'écran" de la calculette */
    boardPanel.setLayout(new BorderLayout());
    boardPanel.setBackground(new Color(29, 79, 78));
    boardPanel.setBorder(BorderFactory.createLineBorder(new Color(50, 50, 50), 3));
    GridBagConstraints gbc = new GridBagConstraints();
    gbc.gridx = 0;
    gbc.gridy = 0;
    gbc.fill = GridBagConstraints.BOTH;
    gbc.weightx = 1.0;
    gbc.weighty = 0.8;
    globalPanel.add(boardPanel, gbc);

    /* Calcul Field (JLabel) */
    /* Le texte qui apparait dans boardPanel */
    calculField.setForeground(new Color(242, 203, 5));
    calculField.setBackground(new Color(29, 79, 78));
    calculField.setHorizontalAlignment(JLabel.RIGHT);
    calculField.setOpaque(true);
    calculField.setFont(new Font("Arial", Font.PLAIN, 60));

    /* Button Panel (JPanel) */
    /* La zone qui contient tout les boutons de la calculette */
    buttonPanel.setLayout(new GridLayout(5, 4, 5, 5));
    buttonPanel.setBackground(new Color(40, 40, 40));
    buttonPanel.setBorder(BorderFactory.createLineBorder(new Color(50, 50, 50), 3));

    for (int i = 0; i < buttons.length; i++) {
      // Créer un bouton de type Jbutton (Swing library)
      // et le remplis avec le texte du bouton associé
      buttons[i] = new JButton(buttonLabels[i]);
      buttons[i].setFont(new Font("Arial", Font.PLAIN, 30));

      // Ajout d'un ActionListener pour chaque bouton (= instance de
      // ButtonClickListener pour chacun)
      buttons[i].addActionListener(new ButtonClickListener());

      if (i == 14) {
        buttons[i].setForeground(new Color(242, 203, 5));
        buttons[i].setBackground(new Color(242, 48, 48));
      } else {
        buttons[i].setForeground(new Color(242, 159, 5));
        buttons[i].setBackground(new Color(29, 89, 78));
      }
      buttonPanel.add(buttons[i]); // Ajoute chaque bouton à la zone buttonPanel
    }

    /* Imbrication de tout les éléments */
    globalPanel.add(boardPanel); // Ajoute l'écran à la page
    globalPanel.add(buttonPanel); // Ajoute "le clavier" à la page
    window.add(globalPanel); // Ajoute la page à la fenêtre
    boardPanel.add(calculField, BorderLayout.CENTER); // Ajoute le texte de calcul à l'écran

    window.setVisible(true);
  }

  class ButtonClickListener implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
      String command = e.getActionCommand();

      if (command.matches("[0-9]")) {
        handleNumber(command);
      } else if (command.matches("=")) {
        handleEqual();
      } else {
        handleOperator(command);
      }
    }

    private void handleNumber(String number) {
      currentInput += number;
      updateDisplay();
    }

    private void handleOperator(String operator) {
      currentOperator = operator;
      currentResult = Double.parseDouble(currentInput);
      currentInput = "";
      updateDisplay();
    }

    private void handleEqual() {
      Double firstOperand = currentResult;
      Double secondOperand = Double.parseDouble(currentInput);

      switch (currentOperator) {
        case "+":
          firstOperand += secondOperand;
          break;
        case "-":
          firstOperand -= secondOperand;
          break;
        case "*":
          firstOperand *= secondOperand;
          break;
        case "/":
          if (secondOperand == 0) {
            currentInput = "Error, cannot divide by 0";
            break;
          } else {
            firstOperand /= secondOperand;
          }
        default:
          break;
      }

      currentInput = Double.toString(currentResult);
      currentOperator = "";
      updateDisplay();
    }

    private void updateDisplay() {
      calculField.setText(currentInput.isEmpty() ? "0" : currentInput);
    }
  }
}

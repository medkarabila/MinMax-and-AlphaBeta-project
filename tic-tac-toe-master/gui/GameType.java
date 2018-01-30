package gui;

import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

/**
 * Menu to choose the game type.
 */

public class GameType extends JDialog {

  /**
   * 
   */
  private static final long serialVersionUID = 1L;
  private JButton playerOpponent;
  private JButton computerOpponent;
  private JButton goBack;
  private JPanel mainPanel;

  public GameType() {

    setTitle("Choisir le type du jeu!");
    setSize(250, 200);
    setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    setModal(true);
    setLocationRelativeTo(null);
    setResizable(false);

    mainPanel = new JPanel();
    mainPanel.setLayout(new GridLayout(3, 1, 1, 20));
    mainPanel.setBackground(java.awt.Color.DARK_GRAY);
    mainPanel.setBorder(new EmptyBorder(new Insets(10, 10, 10, 10)));

    playerOpponent = new JButton("Jouer conte un humain");
    playerOpponent.setBackground(java.awt.Color.PINK);
    computerOpponent = new JButton("Jouer contre la machine");
    computerOpponent.setBackground(java.awt.Color.PINK);
    goBack = new JButton("Menu principal");
    goBack.setBackground(java.awt.Color.PINK);
    mainPanel.add(playerOpponent);
    mainPanel.add(computerOpponent);
    mainPanel.add(goBack);

    add(mainPanel);

    playerOpponentConfig(playerOpponent, this);
    computerOpponentConfig(computerOpponent, this);
    goBackConfig(goBack, this);
  }

  public void playerOpponentConfig(final JButton playerOpponent,
      final GameType gameType) {
    playerOpponent.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        PlayFirst playFirst = new PlayFirst(false, "Premier joueur commence",
            "Deuxieme joueur commence");
        gameType.dispose();
        playFirst.setVisible(true);
      }
    });
  }

  public void computerOpponentConfig(final JButton computerOpponent,
      final GameType gameType) {
    computerOpponent.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        PlayFirst playFirst = new PlayFirst(true, "L'humain commence",
            "La machine commence");
        gameType.dispose();
        playFirst.setVisible(true);
      }
    });
  }

  public void goBackConfig(final JButton goBack, final GameType gameType) {
    goBack.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        MainWindow mainWindow = new MainWindow();
        gameType.dispose();
        mainWindow.setVisible(true);
      }
    });
  }
}

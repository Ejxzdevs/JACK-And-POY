import javax.swing.*;
import java.awt.*;
import javax.swing.border.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.Objects;
import java.util.Random;

public class Main {
        private static JPanel PlayerPanelChoice, ComputerPanelChoice;
        private static JFrame Container;
        private static JLabel playerScore;
        private static JLabel ComputerScore;
        private static JLabel Result;
        private static JLabel RoundLabel;
        private static int playerCountScore = 0 , computerCountScore = 0 , RoundCount = 1;

        public static void main(String[] args)  {

                int width = 600;
                int height = 400;
                Color panelColor = new Color(68, 91, 113);
                Border border = BorderFactory.createLineBorder(Color.BLACK, 2);
                Border borderLR = BorderFactory.createMatteBorder(0, 2, 0, 2, java.awt.Color.BLACK);

                // Create a Container using JFrame
                Container = new JFrame("JACK N POY");

                // Set the size of the Container
                Container.setSize(width, height);
                Container.setResizable(true); 
                Container.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 

                // Create main panel
                JPanel mainPanel = new JPanel();
                mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));

                // Create Panel For Round Label
                JPanel Round = new JPanel();
                Round.setBackground(panelColor);
                RoundLabel = new JLabel("Round 1");
                RoundLabel.setForeground(Color.WHITE);
                Round.setAlignmentY(SwingConstants.CENTER);
                Round.setBorder(border);
                Round.add(RoundLabel);


                // Create a Panel row For Score Board
                JPanel ScoreBoard = new JPanel(new GridLayout(1, 3));
                ScoreBoard.setBackground(new Color(65, 65, 65));
                ScoreBoard.setBorder(borderLR);
                ScoreBoard.setPreferredSize(new Dimension(width, 70));
                // Create 3 JPanel For Column
                // Player Score
                JPanel PlayerScorePanel = new JPanel();
                PlayerScorePanel.setAlignmentY(SwingConstants.CENTER);
                // Computer Score
                JPanel ComputerScorePanel = new JPanel();
                ComputerScorePanel.setAlignmentY(SwingConstants.CENTER);
                // Result
                JPanel ResultPanel = new JPanel();
                ResultPanel.setAlignmentY(SwingConstants.CENTER);

                // create 3 new JLabel
                // for player score
                ImageIcon PathPlayerScoreIcon = new ImageIcon(Objects.requireNonNull(Main.class.getResource("./assets/gamer.png")));
                Image PlayerScoreIconSize =  PathPlayerScoreIcon.getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH);
                ImageIcon SetPlayerScoreIconSize = new ImageIcon(PlayerScoreIconSize);
                JLabel playerScoreIcon = new JLabel(SetPlayerScoreIconSize );

                playerScore = new JLabel();
                playerScore.setFont(new Font("Arial", Font.BOLD, 17));

                // Icon For Computer Score
                ImageIcon PathComputerScoreIcon = new ImageIcon(Objects.requireNonNull(Main.class.getResource("./assets/ai.png")));
                Image ComputerScoreIconSize = PathComputerScoreIcon.getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH);
                ImageIcon SetComputerScoreIcon = new ImageIcon(ComputerScoreIconSize);
                JLabel computerScoreIcon = new JLabel(SetComputerScoreIcon);
                ComputerScore = new JLabel();
                ComputerScore.setFont(new Font("Arial", Font.BOLD, 17));
                // For Result
                Result = new JLabel();
                Result.setFont(new Font("Verdana", Font.BOLD, 17));

                // Add Space for Each Panel Score to look better
                // create Label for Spaces
                JLabel space = new JLabel();
                // Player
                PlayerScorePanel.add(playerScoreIcon);
                PlayerScorePanel.add(space);
                PlayerScorePanel.add(space);
                PlayerScorePanel.add(space);
                PlayerScorePanel.add(playerScore);
                // Computer
                ComputerScorePanel.add(computerScoreIcon);
                ComputerScorePanel.add(space);
                ComputerScorePanel.add(space);
                ComputerScorePanel.add(space);
                ComputerScorePanel.add(ComputerScore);
                // Result
                ResultPanel.add(Result);
                // Add all Scores
                ScoreBoard.add(PlayerScorePanel);
                ScoreBoard.add(ResultPanel);
                ScoreBoard.add(ComputerScorePanel);


                // Create A panel row for Battle Field
                JPanel battleField = new JPanel();
                battleField.setLayout(new GridLayout(1, 2));
                battleField.setBorder(border);
                // Column 1 for Player , Column 2 For Computer
                // Player Battle Field
                PlayerPanelChoice = new JPanel();
                PlayerPanelChoice.setPreferredSize(new Dimension(width / 2, height));
                PlayerPanelChoice.setBackground(new Color(3, 198, 252));
                // Computer Battle Field
                ComputerPanelChoice = new JPanel();
                ComputerPanelChoice.setPreferredSize(new Dimension(width / 2, height));
                ComputerPanelChoice.setBackground(new Color(222, 50, 2));
                // Add Both Panel two the Battle Field Panel
                battleField.add(PlayerPanelChoice);
                battleField.add(ComputerPanelChoice);


                // create Panel row for Choose One label
                JPanel Rules = new JPanel();
                Rules.add(new JLabel("Choose One"));
                Rules.setAlignmentY(SwingConstants.CENTER);
                Rules.setBorder(borderLR);


                // Create a Panel row for Choices container
                JPanel PlayerChoices = new JPanel(new GridLayout(1, 3));
                PlayerChoices.setBorder(border);

                // create 3 components panel
                JPanel Rock = new JPanel();
                JPanel Scissor = new JPanel();
                JPanel Paper = new JPanel();
                // make image button

                // Scissor Button
                ImageIcon ScissorIcon = new ImageIcon(Objects.requireNonNull(Main.class.getResource("./assets/scissor.png")));
                Image ScissorImage = ScissorIcon.getImage().getScaledInstance(75, 75, Image.SCALE_SMOOTH);
                ImageIcon SetScissorIcons = new ImageIcon(ScissorImage);

                JButton btnScissor = new JButton(SetScissorIcons);
                btnScissor.putClientProperty("value", "Scissor");
                btnScissor.putClientProperty("value", "Rock");
                btnScissor.setBorderPainted(false);
                btnScissor.setFocusPainted(false);
                btnScissor.setContentAreaFilled(false);

                // Rock Button
                ImageIcon RockIcon = new ImageIcon(Objects.requireNonNull(Main.class.getResource("./assets/rock.png")));
                Image Rockimage = RockIcon.getImage().getScaledInstance(75, 75, Image.SCALE_SMOOTH);
                ImageIcon SetRockIcons = new ImageIcon(Rockimage);

                JButton btnRock = new JButton(SetRockIcons);
                btnRock.setBackground(Color.red);
                btnRock.putClientProperty("value","Rock");
                btnRock.setBorderPainted(false);
                btnRock.setFocusPainted(false);
                btnRock.setContentAreaFilled(false);

                // Paper button
                ImageIcon PaperIcon = new ImageIcon(Objects.requireNonNull(Main.class.getResource("./assets/paper.png")));
                Image PaperImage = PaperIcon.getImage().getScaledInstance(75, 75, Image.SCALE_SMOOTH);
                ImageIcon SetPaperIcons = new ImageIcon(PaperImage);

                JButton btnPaper = new JButton(SetPaperIcons);
                btnPaper.putClientProperty("value", "Paper");
                btnPaper.setBorderPainted(false);
                btnPaper.setFocusPainted(false);
                btnPaper.setContentAreaFilled(false);
                // add function for every button
                // Add the button to the frame
                btnRock.addActionListener(new GenerateChoose());
                btnScissor.addActionListener(new GenerateChoose());
                btnPaper.addActionListener(new GenerateChoose());

                // add it to the PlayerChoices Panel
                Rock.setLayout(new GridBagLayout());
                Scissor.setLayout(new GridBagLayout());
                Paper.setLayout(new GridBagLayout());
                GridBagConstraints gbc = new GridBagConstraints();
                gbc.gridx = 0;
                gbc.gridy = 0;
                gbc.anchor = GridBagConstraints.CENTER;
                Rock.add(btnRock , gbc);
                Scissor.add(btnScissor , gbc);
                Paper.add(btnPaper , gbc);

                // add all button the Chose Panel
                PlayerChoices.add(Scissor);
                PlayerChoices.add(Rock);
                PlayerChoices.add(Paper);

                // Added sub-panels to the main panel
                mainPanel.add(Round);
                mainPanel.add(ScoreBoard);
                mainPanel.add(battleField);
                mainPanel.add(Rules);
                mainPanel.add(PlayerChoices);

                // Add main panel to the frame

                Container.add(mainPanel);
                Container.setLocationRelativeTo(null); // center the frame
                Container.setVisible(true); // Make the Container visible
        }

        private static class GenerateChoose implements ActionListener {
                public void actionPerformed(ActionEvent choose) {
                        String playerChoice = (String) ((JButton) choose.getSource()).getClientProperty("value");
                        System.out.print(playerChoice);
                        switch (playerChoice) {
                                case "Rock":
                                        displayImage("assets/PR.png", playerChoice);
                                        break;
                                case "Scissor":
                                        displayImage("assets/PS.png", playerChoice);
                                        break;
                                case "Paper":
                                        displayImage("assets/PP.png", playerChoice);
                                        break;
                                default:
                                        break;
                        }
                }

                private void displayImage(String PlayerPath, String playerChoice) {
                        RoundCount++;
                        RoundLabel.setText("Round: " + RoundCount);
                        String[] choices = {"Rock", "Paper", "Scissor"};
                        Random random = new Random();
                        String computerChoice = choices[random.nextInt(choices.length)];
                        System.out.println("Player Choice:" + playerChoice);
                        System.out.println("Computer Choice:" + computerChoice);

                        Result.setText("");

                        String labelText;
                        if (playerChoice.equals(computerChoice)) {
                                labelText = "TIE";
                        } else if ((playerChoice.equals("Rock") && computerChoice.equals("Scissor")) ||
                                (playerChoice.equals("Paper") && computerChoice.equals("Rock")) ||
                                (playerChoice.equals("Scissor") && computerChoice.equals("Paper"))) {
                                labelText = "Player Win";
                                playerCountScore++;
                        } else {
                                labelText = "Computer Win";
                                computerCountScore++;
                        }
                        Result.setText(labelText);
                        playerScore.setText("" + playerCountScore);
                        ComputerScore.setText(""+computerCountScore);

                        if (playerCountScore == 5 || computerCountScore == 5) {

                                String winner = playerCountScore == 5 ? "Player" : "Computer";
                                JOptionPane.showMessageDialog(Container, winner + " wins the game!");
                                // End the game
                                Container.dispose();
                        }

                        String ComputerPath = "";
                        switch (computerChoice) {
                                case "Rock":
                                        ComputerPath = "./assets/CR.png";
                                        break;
                                case "Scissor":
                                        ComputerPath = "./assets/CS.png";
                                        break;
                                case "Paper":
                                        ComputerPath = "./assets/CP.png";
                                        break;
                                default:
                                        break;
                        }

                        JLabel playerImage = new JLabel();
                        ImageIcon icon = new ImageIcon(Objects.requireNonNull(Main.class.getResource("./" + PlayerPath)));
                        Image image = icon.getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH);
                        ImageIcon scaledIcon = new ImageIcon(image);
                        playerImage.setIcon(scaledIcon);

                        JLabel ComputerImage = new JLabel();
                        ImageIcon ComputerIcon = new ImageIcon(Objects.requireNonNull(Main.class.getResource("./" + ComputerPath)));
                        Image Cimage = ComputerIcon.getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH);
                        ImageIcon ComputerScaledIcon = new ImageIcon(Cimage);
                        ComputerImage.setIcon(ComputerScaledIcon);

                        // Clear the panels before adding new images
                        PlayerPanelChoice.removeAll();
                        ComputerPanelChoice.removeAll();

                        // Set the layout to GridBagLayout and add the image with constraints
                        PlayerPanelChoice.setLayout(new GridBagLayout());
                        ComputerPanelChoice.setLayout(new GridBagLayout());
                        GridBagConstraints gbc = new GridBagConstraints();
                        gbc.gridx = 0;
                        gbc.gridy = 0;
                        gbc.anchor = GridBagConstraints.CENTER;
                        PlayerPanelChoice.add(playerImage, gbc);
                        ComputerPanelChoice.add(ComputerImage, gbc);
                        Container.repaint();
                        Container.revalidate();
                }

        }
}

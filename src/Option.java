import javax.swing.*;
import java.awt.*;
import java.util.Objects;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Option {

    public static void main(String[] args){

        int width = 600;
        int height = 400;
        Color panelColor = new Color(68, 91, 113);
        Font buttonFont = new Font("Arial", Font.BOLD, 14);
        Color fontColor = Color.decode("#586F69");

        JFrame Container = new JFrame("Jack 'N Poy");

        // Set the size of the Container
        Container.setSize(width, height);
        Container.setResizable(false); // Set the Container to be non-resizable
        Container.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Set default close operation

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));


        // Icon
        JPanel Title = new JPanel();
        Title.setBackground(panelColor);

        ImageIcon ScissorIcon = new ImageIcon(Objects.requireNonNull(Main.class.getResource("./assets/Artboard 14_1.png")));
        Image ScissorImage = ScissorIcon.getImage().getScaledInstance(450, 180, Image.SCALE_SMOOTH);
        ImageIcon SetScissorIcons = new ImageIcon(ScissorImage);

        JLabel label = new JLabel(SetScissorIcons, JLabel.CENTER);
//        JLabel label = new JLabel("Jack N Poy");
        Title.add(label);

        // Menu
        Dimension buttonSize = new Dimension(100, 30);

        JPanel Option = new JPanel();
        Option.setBackground(new Color(8, 111, 105));
        Option.setLayout(new GridLayout(3, 1));
        // Set empty border to remove any border

        // Button Play
        JPanel PlayContainer = new JPanel();
        PlayContainer.setBackground(panelColor);
        JButton BtnPlay = new JButton("Play");
        BtnPlay.setForeground(fontColor);
        BtnPlay.setFont(buttonFont);
        BtnPlay.setPreferredSize(buttonSize);
        PlayContainer.add(BtnPlay);

        // Button Play Function
        BtnPlay.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Open Main.java here
                Container.dispose(); // Close the Settings window
                Main.main(null); // Call the main method of the Main class
            }
        });

        // Settings
        JPanel SettingsContainer = new JPanel();
        SettingsContainer.setBackground(panelColor);
        JButton Settings = new JButton("Settings");
        Settings.setForeground(fontColor);
        Settings.setPreferredSize(buttonSize);
        SettingsContainer.add(Settings);


        // Quit
        JPanel ExitContainer = new JPanel();
        ExitContainer.setBackground(panelColor);
        JButton BtnExit = new JButton("Quit");
        BtnExit.setForeground(fontColor);
        BtnExit.setPreferredSize(buttonSize);
        ExitContainer.add(BtnExit);

        // Quit Function
        BtnExit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Container.dispose(); // close
            }
        });

        Option.add(PlayContainer);
        Option.add(SettingsContainer);
        Option.add(ExitContainer );

        // add all panels to the main panel
        mainPanel.add(Title);
        mainPanel.add(Option);

        // add all panels to the container of JFrame
        Container.add(mainPanel);

        // Center the JFrame on the screen
        Container.setLocationRelativeTo(null);
        Container.setVisible(true); // Make the Container visible
    }
}

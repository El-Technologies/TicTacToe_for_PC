import javax.swing.*;
import java.awt.*;

public class main extends process{

    public JFrame frmTictactoeBySommy;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                main window = new main();
                window.frmTictactoeBySommy.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    /**
     * Create the application.
     */
    public main() {
        initialize();
        start();
    }

    /**
     * Initialise the contents of the frame.
     */

    public void initialize() {
        frmTictactoeBySommy = new JFrame();
        frmTictactoeBySommy.setTitle("TicTacToe by Sommy");
        frmTictactoeBySommy.setResizable(false);
        frmTictactoeBySommy.getContentPane().setBackground(Color.WHITE);
        frmTictactoeBySommy.getContentPane().setLayout(null);

        One = new JButton("");
        One.setFont(new Font("Segoe UI Light", Font.BOLD, 17));
        One.addActionListener(e -> {
            N = 1;
            onClickBox();
        });
        One.setBackground(Color.WHITE);
        One.setBounds(46, 111, 60, 60);
        frmTictactoeBySommy.getContentPane().add(One);

        Two = new JButton("");
        Two.setFont(new Font("Segoe UI Light", Font.BOLD, 17));
        Two.addActionListener(e -> {
            N = 2;
            onClickBox();
        });
        Two.setBackground(Color.WHITE);
        Two.setBounds(110, 111, 60, 60);
        frmTictactoeBySommy.getContentPane().add(Two);

        Three = new JButton("");
        Three.setFont(new Font("Segoe UI Light", Font.BOLD, 17));
        Three.addActionListener(e -> {
            N = 3;
            onClickBox();
        });
        Three.setBackground(Color.WHITE);
        Three.setBounds(174, 111, 60, 60);
        frmTictactoeBySommy.getContentPane().add(Three);

        Four = new JButton("");
        Four.setFont(new Font("Segoe UI Light", Font.BOLD, 17));
        Four.addActionListener(e -> {
            N = 4;
            onClickBox();
        });
        Four.setBackground(Color.WHITE);
        Four.setBounds(46, 176, 60, 60);
        frmTictactoeBySommy.getContentPane().add(Four);

        Five = new JButton("");
        Five.setFont(new Font("Segoe UI Light", Font.BOLD, 17));
        Five.addActionListener(e -> {
            N = 5;
            onClickBox();
        });
        Five.setBackground(Color.WHITE);
        Five.setBounds(110, 176, 60, 60);
        frmTictactoeBySommy.getContentPane().add(Five);

        Six = new JButton("");
        Six.setFont(new Font("Segoe UI Light", Font.BOLD, 17));
        Six.addActionListener(e -> {
            N = 6;
            onClickBox();
        });
        Six.setBackground(Color.WHITE);
        Six.setBounds(174, 176, 60, 60);
        frmTictactoeBySommy.getContentPane().add(Six);

        Seven = new JButton("");
        Seven.setFont(new Font("Segoe UI Light", Font.BOLD, 17));
        Seven.addActionListener(e -> {
            N = 7;
            onClickBox();
        });
        Seven.setBackground(Color.WHITE);
        Seven.setBounds(46, 241, 60, 60);
        frmTictactoeBySommy.getContentPane().add(Seven);

        Eight = new JButton("");
        Eight.setFont(new Font("Segoe UI Light", Font.BOLD, 17));
        Eight.addActionListener(e -> {
            N = 8;
            onClickBox();
        });
        Eight.setBackground(Color.WHITE);
        Eight.setBounds(110, 241, 60, 60);
        frmTictactoeBySommy.getContentPane().add(Eight);

        Nine = new JButton("");
        Nine.setFont(new Font("Segoe UI Light", Font.BOLD, 17));
        Nine.addActionListener(e -> {
            N = 9;
            onClickBox();
        });
        Nine.setBackground(Color.WHITE);
        Nine.setBounds(174, 241, 60, 60);
        frmTictactoeBySommy.getContentPane().add(Nine);

        info = new JLabel(enterLetter() + "'s Turn");
        info.setFont(new Font("Segoe UI Light", Font.PLAIN, 30));
        info.setHorizontalAlignment(SwingConstants.CENTER);
        info.setBounds(46, 27, 188, 35);
        frmTictactoeBySommy.getContentPane().add(info);

        resetButton = new JButton("Reset");
        resetButton.addActionListener(e -> reset());
        resetButton.setForeground(Color.WHITE);
        resetButton.setBackground(Color.ORANGE);
        resetButton.setFont(new Font("Segoe UI Light", Font.BOLD, 17));
        resetButton.setBounds(145, 317, 89, 40);
        frmTictactoeBySommy.getContentPane().add(resetButton);

        menuButton = new JButton("Menu");
        menuButton.addActionListener(e -> start());
        menuButton.setForeground(Color.WHITE);
        menuButton.setFont(new Font("Segoe UI Light", Font.BOLD, 17));
        menuButton.setBackground(Color.GREEN);
        menuButton.setBounds(46, 317, 89, 40);
        frmTictactoeBySommy.getContentPane().add(menuButton);
        frmTictactoeBySommy.setBounds(100, 100, 300, 426);
        frmTictactoeBySommy.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        PVPBtn = new JButton("Player VS Player");
        PVPBtn.addActionListener(e -> {
            PlayervsPlayer = true;
            PVP();
        });
        PVPBtn.setBackground(Color.YELLOW);
        PVPBtn.setFont(new Font("Segoe UI Light", Font.PLAIN, 15));
        PVPBtn.setBounds(46, 114, 188, 60);
        frmTictactoeBySommy.getContentPane().add(PVPBtn);

        PVCBtn = new JButton("Player VS Computer");
        PVCBtn.addActionListener(e -> {
            PlayervsPlayer = false;
            PVC();
        });
        PVCBtn.setBackground(Color.YELLOW);
        PVCBtn.setFont(new Font("Segoe UI Light", Font.PLAIN, 15));
        PVCBtn.setBounds(46, 199, 188, 60);
        frmTictactoeBySommy.getContentPane().add(PVCBtn);
        frmTictactoeBySommy.setBounds(100, 100, 300, 426);
        frmTictactoeBySommy.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        EasyBtn = new JButton("Easy");
        EasyBtn.addActionListener(e -> {
            level = 1;
            PV_();
        });
        EasyBtn.setBackground(Color.YELLOW);
        EasyBtn.setFont(new Font("Segoe UI Light", Font.PLAIN, 15));
        EasyBtn.setBounds(46, 95, 188, 60);
        frmTictactoeBySommy.getContentPane().add(EasyBtn);

        MediumBtn = new JButton("Medium");
        MediumBtn.addActionListener(e -> {
            level = 2;
            PV_();
        });
        MediumBtn.setBackground(Color.YELLOW);
        MediumBtn.setFont(new Font("Segoe UI Light", Font.PLAIN, 15));
        MediumBtn.setBounds(46, 160, 188, 60);
        frmTictactoeBySommy.getContentPane().add(MediumBtn);

        HardBtn = new JButton("Hard");
        HardBtn.setBackground(Color.YELLOW);
        HardBtn.setFont(new Font("Segoe UI Light", Font.PLAIN, 15));
        HardBtn.addActionListener(e -> {
            level = 3;
            PV_();
        });
        HardBtn.setBounds(46, 225, 188, 60);
        frmTictactoeBySommy.getContentPane().add(HardBtn);
        frmTictactoeBySommy.setBounds(100, 100, 300, 426);
        frmTictactoeBySommy.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        XLabel = new JLabel("X:");
        XLabel.setFont(new Font("Segoe UI Light", Font.PLAIN, 14));
        XLabel.setBounds(50, 73, 16, 14);
        frmTictactoeBySommy.getContentPane().add(XLabel);

        XScore = new JLabel("0");
        XScore.setHorizontalAlignment(SwingConstants.CENTER);
        XScore.setFont(new Font("Segoe UI Light", Font.PLAIN, 14));
        XScore.setBounds(64, 73, 16, 14);
        frmTictactoeBySommy.getContentPane().add(XScore);

        OLabel = new JLabel("O:");
        OLabel.setFont(new Font("Segoe UI Light", Font.PLAIN, 14));
        OLabel.setBounds(200, 73, 16, 14);
        frmTictactoeBySommy.getContentPane().add(OLabel);

        OScore = new JLabel("0");
        OScore.setHorizontalAlignment(SwingConstants.CENTER);
        OScore.setFont(new Font("Segoe UI Light", Font.PLAIN, 14));
        OScore.setBounds(214, 73, 16, 14);
        frmTictactoeBySommy.getContentPane().add(OScore);
        frmTictactoeBySommy.setBounds(100, 100, 300, 426);
        frmTictactoeBySommy.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}

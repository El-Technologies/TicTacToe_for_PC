import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class main extends process{

    public JFrame frmTictactoeBySommy;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    main window = new main();
                    window.frmTictactoeBySommy.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the application.
     */
    public main() {
        initialize();
    }

    /**
     * Initialise the contents of the frame.
     */





    public void initialize() {
        frmTictactoeBySommy = new JFrame();
        frmTictactoeBySommy.setTitle("TicTacToe by Sohmtee");
        frmTictactoeBySommy.getContentPane().setBackground(Color.WHITE);
        frmTictactoeBySommy.getContentPane().setLayout(null);

        One = new JButton("");
        One.setFont(new Font("Segoe UI Light", Font.BOLD, 17));
        One.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                N = 1;
                onClickBox();
            }
        });
        One.setBackground(Color.WHITE);
        One.setBounds(46, 111, 60, 60);
        frmTictactoeBySommy.getContentPane().add(One);

        Two = new JButton("");
        Two.setFont(new Font("Segoe UI Light", Font.BOLD, 17));
        Two.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                N = 2;
                onClickBox();
            }
        });
        Two.setBackground(Color.WHITE);
        Two.setBounds(110, 111, 60, 60);
        frmTictactoeBySommy.getContentPane().add(Two);

        Three = new JButton("");
        Three.setFont(new Font("Segoe UI Light", Font.BOLD, 17));
        Three.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                N = 3;
                onClickBox();
            }
        });
        Three.setBackground(Color.WHITE);
        Three.setBounds(174, 111, 60, 60);
        frmTictactoeBySommy.getContentPane().add(Three);

        Four = new JButton("");
        Four.setFont(new Font("Segoe UI Light", Font.BOLD, 17));
        Four.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                N = 4;
                onClickBox();
            }
        });
        Four.setBackground(Color.WHITE);
        Four.setBounds(46, 176, 60, 60);
        frmTictactoeBySommy.getContentPane().add(Four);

        Five = new JButton("");
        Five.setFont(new Font("Segoe UI Light", Font.BOLD, 17));
        Five.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                N = 5;
                onClickBox();
            }
        });
        Five.setBackground(Color.WHITE);
        Five.setBounds(110, 176, 60, 60);
        frmTictactoeBySommy.getContentPane().add(Five);

        Six = new JButton("");
        Six.setFont(new Font("Segoe UI Light", Font.BOLD, 17));
        Six.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                N = 6;
                onClickBox();
            }
        });
        Six.setBackground(Color.WHITE);
        Six.setBounds(174, 176, 60, 60);
        frmTictactoeBySommy.getContentPane().add(Six);

        Seven = new JButton("");
        Seven.setFont(new Font("Segoe UI Light", Font.BOLD, 17));
        Seven.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                N = 7;
                onClickBox();
            }
        });
        Seven.setBackground(Color.WHITE);
        Seven.setBounds(46, 241, 60, 60);
        frmTictactoeBySommy.getContentPane().add(Seven);

        Eight = new JButton("");
        Eight.setFont(new Font("Segoe UI Light", Font.BOLD, 17));
        Eight.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                N = 8;
                onClickBox();
            }
        });
        Eight.setBackground(Color.WHITE);
        Eight.setBounds(110, 241, 60, 60);
        frmTictactoeBySommy.getContentPane().add(Eight);

        Nine = new JButton("");
        Nine.setFont(new Font("Segoe UI Light", Font.BOLD, 17));
        Nine.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                N = 9;
                onClickBox();
            }
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
        resetButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                start();
            }
        });
        resetButton.setForeground(Color.WHITE);
        resetButton.setBackground(Color.ORANGE);
        resetButton.setFont(new Font("Segoe UI Light", Font.BOLD, 17));
        resetButton.setBounds(99, 324, 89, 40);
        frmTictactoeBySommy.getContentPane().add(resetButton);
        frmTictactoeBySommy.setBounds(100, 100, 300, 420);
        frmTictactoeBySommy.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}

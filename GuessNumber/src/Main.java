import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class Main extends JFrame implements ActionListener {
    private JLabel lblTxt;
    private JLabel lbl;
    private JLabel lblGuess;
    private JLabel lblResult;
    private JButton btnup;
    private JButton btndown;
    private JButton btnwin;
    private int random;
    private int guess;

    @Override
    public void actionPerformed(ActionEvent e) {
        Object obj = e.getSource();
        if (obj == btndown) {
            Random generator = new Random();
            random = generator.nextInt(random)+1;
            lbl.setText("" + random);
        } else if (obj == btnup) {
            Random generator = new Random();
            random = new Random().nextInt(guess)  + random;
            lbl.setText("" + random);
        } else {
            if(guess == random) {
                lblResult.setText("YOU ARE THE WİNNER");
            }
            else
                lblResult.setText("Dont Cheat Bro");
        }
    }

    public Main() {
        setLayout(new FlowLayout());
        setTitle("Guess Number");
        lblTxt = new JLabel("Guess 1-10 please");
        btndown = new JButton("Down");
        btnup = new JButton("Up");
        btnwin = new JButton("Win");
        add(lblTxt);
        add(btndown);
        add(btnup);
        add(btnwin);

        Random generator2 = new Random();
        guess = generator2.nextInt(10)+1;
        lblGuess = new JLabel("Your Guess " + guess);
        add(lblGuess);

        Random generator = new Random();
        random = generator.nextInt(10)+1;
        lbl = new JLabel("Number is ..." + random);
        add(lbl);

        lblResult = new JLabel("");
        add(lblResult);

        btndown.addActionListener(this);
        btnup.addActionListener(this);
        btnwin.addActionListener(this);
    }

    public static void main(String [] args) {
        Main gui = new Main();
        gui.setSize(300,300);
        gui.setVisible(true);
        gui.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
}
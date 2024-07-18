import java.util.*;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
class NumberGuessing extends JFrame
{
    int RandomNumber;
    int Attempts;

    JLabel myTitle1;
    JLabel myTitle2;
    JTextField myTextField;
    JButton myButton;
    JLabel myMessageLabel;
    JLabel myAttemptLabel;

    NumberGuessing()
    {
        Random random = new Random();
        RandomNumber = random.nextInt(100)+1;
        Attempts = 0;


        myTitle1 = new JLabel("Guessing Game");
        myTitle1.setFont(new Font("Monospaced",Font.BOLD,23));
        myTitle1.setForeground(Color.MAGENTA);

        myTitle2 = new JLabel("Hint:- Between 1 to 100");
        myTitle2.setFont(new Font("Monospaced",Font.ITALIC,12));
        myTitle2.setForeground(Color.RED);

        myTextField = new JTextField();
        myTextField.setPreferredSize(new Dimension(100, 50));
        myTextField.setEditable(true);
    
        
        myButton = new JButton("Guess");
        myMessageLabel = new JLabel("Guessing... Good Luck");
        myAttemptLabel = new JLabel("Attempts: " + Attempts);
        
        
        myButton.setBackground(Color.CYAN);

      //  setLayout(new BoxLayout(getContentPane(),BoxLayout.Y_AXIS));
        setLayout(null); 
         
        myTitle1.setBounds(110, 20, 200, 40);
        myTitle2.setBounds(117, 57, 200, 20);
        myTextField.setBounds(80, 100, 240, 30);
        myButton.setBounds(150, 160, 100, 30);
        myMessageLabel.setBounds(130, 200, 300, 20);
        myAttemptLabel.setBounds(160, 230, 200, 20);



      
        add(myTitle1);
        add(myTitle2);
        add(myTextField);
        add(myButton);
        add(myMessageLabel);
        add(myAttemptLabel); 

        

        myButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                checkGuess();
            }
        });

        setSize(400,400);
        setBackground(Color.decode("#e5c9fb"));
        setTitle("Guessing Game");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
        getContentPane().setBackground(Color.decode("#fffcef"));

    }

    void checkGuess(){
        String guessNum = myTextField.getText();
        try{
            int guess = Integer.parseInt(guessNum);
            Attempts++;

            if(guess == RandomNumber){
                myMessageLabel.setBackground(Color.GREEN);
                myMessageLabel.setFont(new Font("aerial", Font.BOLD,15));
                myMessageLabel.setBounds(120, 200, 300, 20);
                myMessageLabel.setForeground(Color.GREEN);
                myMessageLabel.setText("Congrats!! Winner!! " );
                myButton.setEnabled(false);
            }
            else if(guess < RandomNumber){
                myMessageLabel.setForeground(Color.RED);
                myMessageLabel.setText("Too Low! Try again.");
            }
            else{
                myMessageLabel.setForeground(Color.RED);
                myMessageLabel.setText("Too High! Try again");
            }

            myAttemptLabel.setText("Attempts: "+Attempts);
            myTextField.setText("");
        }

        catch(NumberFormatException ne)
        {
            JOptionPane.showMessageDialog(this, "Invalid Number");
        }
    }
}

class PRODIGY_SD_02
{
    public static void main(String args[])
    {
        SwingUtilities.invokeLater(new Runnable(){
            @Override
            public void run()
            {
                NumberGuessing ng = new NumberGuessing();
                ng.setVisible(true);
            }
        });
    }
}

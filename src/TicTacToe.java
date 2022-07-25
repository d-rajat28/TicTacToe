import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;


public class TicTacToe implements ActionListener {

    Random random = new Random();
    JFrame frame = new JFrame();
    JPanel t_pannel = new JPanel();
     JPanel pannel = new JPanel();
     JLabel text = new JLabel();
	 JButton but = new JButton();
    JPanel button_panel = new JPanel();
    JButton[] button = new JButton[9];
    JLabel textfield = new JLabel();
    
    JPanel s_panel = new JPanel();
    JPanel p = new JPanel();
    JButton reset = new JButton();
    JButton newg = new JButton();
    JLabel x = new JLabel();
    JLabel xs = new JLabel();
    JLabel o = new JLabel();
    JLabel os = new JLabel();
    JLabel dis = new JLabel();
    public int xno  = 0;
    public int ono  = 0;

    boolean player1_turn;
 

    TicTacToe() {
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //frame.setResizable(false);
        frame.setSize(800, 800);
        frame.getContentPane().setBackground(Color.BLACK);
        frame.setLayout(new BorderLayout());
        
        

        ImageIcon image = new ImageIcon(".//res//logo1.png");
        frame.setIconImage(image.getImage());

        textfield.setBackground(Color.BLACK);
        textfield.setForeground(Color.GREEN);
        textfield.setFont(new Font("Ink Free", Font.BOLD, 75));
        textfield.setHorizontalAlignment(JLabel.CENTER);
        textfield.setOpaque(true);
        textfield.setVisible(true);
        t_pannel.setLayout(new BorderLayout());
        t_pannel.setBounds(0, 0, 800, 100);
        t_pannel.add(textfield);

        button_panel.setLayout(new GridLayout(3, 3));
        button_panel.setBackground(Color.LIGHT_GRAY);
        for (int i = 0; i < 9; i++) {
            button[i] = new JButton();
            button_panel.add(button[i]);
            button[i].setFont(new Font("Jokerman", Font.BOLD, 120));
            button[i].setFocusable(false);
            button[i].addActionListener(this);
        }
        
        
        
        text.setBounds(300, 250, 200, 80);
        text.setForeground(Color.GREEN);
        text.setFont(new Font("Ink Free", Font.BOLD, 30));
        text.setText("Tic-Tac-Toe");
        text.setVisible(true);
        
        but.setBackground(Color.GRAY);
        but.setBounds(300, 350, 150,50);
        but.setForeground(Color.BLACK);
        but.setFont(new Font("Ink Free", Font.BOLD, 15));
        but.setText("Click here to Play");
        but.setOpaque(true);
        but.setFocusable(false);
        but.addActionListener(this);
       
        pannel.setLayout(null);
        pannel.setBackground(Color.BLACK);
        pannel.setVisible(true);
        pannel.add(text);
        pannel.add(but);

        p.setLayout(new BorderLayout());
        p.setSize(100, 600);
        p.setBackground(Color.GRAY);
        p.setVisible(true);

        s_panel.setLayout(new GridLayout(3,2));
        s_panel.setSize(100,500);
        s_panel.setBackground(Color.GRAY);
        s_panel.setVisible(true);

        dis.setForeground(Color.BLACK);
        dis.setBounds(0, 0, 100, 100);
        dis.setFont(new Font("Ink Free", Font.BOLD, 20));
        dis.setText("Score");
        dis.setHorizontalAlignment(JLabel.CENTER);
        dis.setOpaque(true);
        dis.setVisible(true);

        x.setForeground(Color.BLACK);
        //x.setAlignmentX(100);
        x.setSize(40, 10);
        x.setFont(new Font("Ink Free", Font.BOLD, 20));
        x.setText("Player X");
        x.setHorizontalAlignment(JLabel.CENTER);
        x.setOpaque(true);
        x.setVisible(true);

        xs.setForeground(Color.BLACK);
        xs.setSize(40, 10);
        xs.setFont(new Font("Ink Free", Font.BOLD, 20));
        xs.setText(""+Integer. valueOf(xno));
        xs.setHorizontalAlignment(JLabel.CENTER);
        xs.setOpaque(true);
        xs.setVisible(true);

        o.setForeground(Color.BLACK);
        o.setSize(40, 10);
        o.setFont(new Font("Ink Free", Font.BOLD, 20));
        o.setText("Player O");
        o.setHorizontalAlignment(JLabel.CENTER);
        o.setOpaque(true);
        o.setVisible(true);

        os.setForeground(Color.BLACK);
        os.setSize(40, 10);
        os.setFont(new Font("Ink Free", Font.BOLD, 20));
        os.setText(""+Integer. valueOf(ono));
        os.setHorizontalAlignment(JLabel.CENTER);
        os.setOpaque(true);
        os.setVisible(true);

        reset.setBackground(Color.GRAY);
        reset.setForeground(Color.BLACK);
        reset.setSize(40, 10);
        reset.setFont(new Font("Ink Free", Font.BOLD, 15));
        reset.setText("Reset");
        reset.setOpaque(true);
        reset.setFocusable(false);
        reset.addActionListener(this);

        newg.setBackground(Color.GRAY);
        newg.setForeground(Color.BLACK);
        newg.setSize(40, 10);
        newg.setFont(new Font("Ink Free", Font.BOLD, 15));
        newg.setText("New Game");
        newg.setOpaque(true);
        newg.setFocusable(false);
        newg.addActionListener(this);

        
        s_panel.add(x);
        s_panel.add(xs);
        s_panel.add(o);
        s_panel.add(os);
        s_panel.add(reset);
        s_panel.add(newg);
       
        
        p.add(dis,BorderLayout.NORTH);
        p.add(s_panel,BorderLayout.CENTER);

        frame.add(pannel);
     
        frame.setVisible(true);
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == but)
        {
            pannel.setVisible(false);
            t_pannel.setVisible(true);
            button_panel.setVisible(true);
            p.setVisible(true);
           frame.add(button_panel,BorderLayout.CENTER);
            frame.add(t_pannel, BorderLayout.NORTH);
           // s = new score();
            frame.add(p,BorderLayout.EAST);

            firstturn();
        }
        for (int i = 0; i < 9; i++){
            if (e.getSource() == button[i]) {
                if (player1_turn) {
                    if (button[i].getText() == "") {
                        button[i].setForeground(Color.RED);
                        button[i].setText("X");
                        player1_turn = false;
                        textfield.setText("Player O turn");
                        check();
                    }
                } else {
                    button[i].setForeground(Color.BLUE);
                    button[i].setText("O");
                    player1_turn = true;
                    textfield.setText("Player X turn");
                    check();
                }
            }

        } 
        
        if(e.getSource() == reset)
        {
            for(int i = 0; i < 9; i++)
            {
                button[i].setText("");
                button[i].setEnabled(true);
                button[i].setBackground(Color.LIGHT_GRAY);
            }
        }

        if(e.getSource() == newg)
        {
            xno = 0;
            ono = 0;
            for(int i = 0; i < 9; i++)
            {
                button[i].setText("");
                button[i].setEnabled(true);
                button[i].setBackground(Color.LIGHT_GRAY);
            }

        }

    }

    public void firstturn() {

        frame.add(button_panel,BorderLayout.CENTER);

        if (random.nextInt(2) == 0) {
            player1_turn = true;
            textfield.setText("Player X turn");
        } else {
            player1_turn = false;
            textfield.setText("Player O turn");
        }
    }

    public void check() {
        //// check X win conditions

        if (button[0].getText() == "X" && button[1].getText() == "X" && button[2].getText() == "X") {
            xwin(0, 1, 2);
        }
        if (button[3].getText() == "X" && button[4].getText() == "X" && button[5].getText() == "X") {
            xwin(3, 4, 5);
        }
        if (button[6].getText() == "X" && button[7].getText() == "X" && button[8].getText() == "X") {
            xwin(6, 7, 8);
        }
        if (button[0].getText() == "X" && button[3].getText() == "X" && button[6].getText() == "X") {
            xwin(0, 3, 6);
        }
        if (button[1].getText() == "X" && button[4].getText() == "X" && button[7].getText() == "X") {
            xwin(1, 4, 7);
        }
        if (button[2].getText() == "X" && button[5].getText() == "X" && button[8].getText() == "X") {
            xwin(2, 5, 8);
        }
        if (button[0].getText() == "X" && button[4].getText() == "X" && button[8].getText() == "X") {
            xwin(0, 4, 8);
        }
        if (button[2].getText() == "X" && button[4].getText() == "X" && button[6].getText() == "X") {
            xwin(2, 4, 6);
        }

        //// check O win conditions

        if (button[0].getText() == "O" && button[1].getText() == "O" && button[2].getText() == "O") {
            owin(0, 1, 2);
        }
        if (button[3].getText() == "O" && button[4].getText() == "O" && button[5].getText() == "O") {
            owin(3, 4, 5);
        }
        if (button[6].getText() == "O" && button[7].getText() == "O" && button[8].getText() == "O") {
            owin(6, 7, 8);
        }
        if (button[0].getText() == "O" && button[3].getText() == "O" && button[6].getText() == "O") {
            owin(0, 3, 6);
        }
        if (button[1].getText() == "O" && button[4].getText() == "O" && button[7].getText() == "O") {
            owin(1, 4, 7);
        }
        if (button[2].getText() == "O" && button[5].getText() == "O" && button[8].getText() == "O") {
            owin(2, 5, 8);
        }
        if (button[0].getText() == "O" && button[4].getText() == "O" && button[8].getText() == "O") {
            owin(0, 4, 8);
        }
        if (button[2].getText() == "O" && button[4].getText() == "O" && button[6].getText() == "O") {
            owin(2, 4, 6);
        }

    }

    public void xwin(int a, int b, int c) {
        button[a].setBackground(Color.GREEN);
        button[b].setBackground(Color.GREEN);
        button[c].setBackground(Color.GREEN);
        for(int i = 0; i < 9; i++)
        button[i].setEnabled(false);
        textfield.setText("X wins");
        xno++;
        xs.setText(""+Integer. valueOf(xno));

    }

    public void owin(int a, int b, int c) {

        button[a].setBackground(Color.GREEN);
        button[b].setBackground(Color.GREEN);
        button[c].setBackground(Color.GREEN);
        for(int i = 0; i < 9; i++)
        button[i].setEnabled(false);
        textfield.setText("O wins");
        ono++;
        os.setText(""+Integer. valueOf(ono));
    }
}

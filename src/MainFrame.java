import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Random;


public class MainFrame extends JFrame  {
    private int scW = Toolkit.getDefaultToolkit().getScreenSize().width;
    private int scH = Toolkit.getDefaultToolkit().getScreenSize().height;
    private int W = 500;
    private int H = 500;
    static final int SIZE = 15;
    private JPanel JPL;
    private LinkedList<JPanel> snakeBody = new LinkedList();
    private Snake  snake ;
    public JPanel getJPL() {
        return JPL;
    }
    public LinkedList<JPanel> getSnakeBody() {
        return snakeBody;
    }
    public void initSnakePanel(){
        JPanel body1 = new JPanel();
        body1.setBounds(0, 0, SIZE, SIZE);
        body1.setBackground(Color. red);
        snakeBody.add(body1);
        for ( int i = 0; i < 4; i++) {
            JPanel body = new JPanel();
            JPanel last = snakeBody.getLast();
            body.setBounds(last.getX()+ SIZE+1, 0, SIZE, SIZE);
            body.setBackground(Color. red);
            snakeBody.add(body);
            JPL.add(body);
        }
        JPL.add(body1);
    }
    private void myActiongLisenler(){
        this.addKeyListener( new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                int code = e.getKeyCode();
                if(code == 39 && snake == null){
                    snake = new Snake(MainFrame. this);
                    snake.start();
                }
                int nowWay = snake.getWay();
                if((nowWay + code) % 2 != 0)
                    snake.setWay(code);
            }
        });
    }
    public MainFrame(){
        init();
        setTitle( "貪吃蛇");
        initSnakePanel();
        myActiongLisenler();
      //  this.setSize(500, 500);
        this.setLocationRelativeTo( null);
        this.setVisible( true);
        setResizable(false);
    }
    private void init() {
        this.setBounds(scW/2-W/2,scH/2-H/2,W,H);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        JPL = new JPanel();
        JPL.setLayout( null);
        JPL.setBackground(Color. white);
        this.add(JPL);
    }
}
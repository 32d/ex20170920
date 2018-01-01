import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.LinkedList;
import java.util.Random;


public class MainFrame extends JFrame  {
    private int scW = Toolkit.getDefaultToolkit().getScreenSize().width;
    private int scH = Toolkit.getDefaultToolkit().getScreenSize().height;
    private int W = 500;
    private int H = 500;
    private JLabel Jlab = new JLabel();
    private JLabel Jlab2 = new JLabel();
    static final int SIZE = 15;
    private JPanel JPL;
    private JPanel food;
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
            snakeBody.add(body);
            JPL.add(body);
        }
        JPL.add(body1);
    }
    private void KEYLisenler(){
        this.addKeyListener( new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                int code = e.getKeyCode();
                if(code == 10 && snake == null){
                    snake = new Snake(MainFrame. this);
                    snake.start();
                }
                int nowWay = snake.getWay();
                if((nowWay + code) % 2 != 0)
                    snake.setWay(code);
            }
        });
    }
    private void Food(){
        food = new JPanel();
        food.setBackground(Color. black);
        Random rdm = new Random();
        int x = rdm.nextInt( SIZE)*16;
        int y = rdm.nextInt( SIZE)*16;
        food.setBounds(x, y, SIZE, SIZE);
        JPL.add(food);
    }
    public MainFrame(){
        init();
        setTitle( "貪吃蛇");
        initSnakePanel();
        Food();
        KEYLisenler();
        JPL.add(Jlab);
        JPL.add(Jlab2);
        Jlab.setText("按ENTER後來開始遊戲");
        Jlab2.setText("控制方法↑ ↓ ← → ");
        Jlab.setBounds(150,0,500,500);
        Jlab2.setBounds(150,50,500,500);
        Jlab.setFont(new Font("標楷體", Font.BOLD, 16));
        Jlab2.setFont(new Font("標楷體", Font.BOLD, 16));

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
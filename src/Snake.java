import java.awt.*;
import java.util.LinkedList;
import javax.swing.*;

public class Snake extends Thread{
    private MainFrame snake;
    private int way;
    private static  int speed = 100;
    public int getWay() {
        return way;
    }
    public void setWay( int way) {
        this. way = way;
    }
    public Snake(MainFrame snake) {
        this. snake = snake;
    }
    private int scW = Toolkit.getDefaultToolkit().getScreenSize().width;
    private int scH = Toolkit.getDefaultToolkit().getScreenSize().height;
    private int W = 500;
    private int H = 500;
    @Override

    public void run() {

            while (true) {
                move();
                try {

                    Thread.sleep(speed);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
        }
    }



    private void move(){
        LinkedList<JPanel> snakeBody = snake.getSnakeBody();
        JPanel food = snake.getFood();
        JPanel JPL = snake.getJPL();//取舊頭
        JPanel oldHead = snakeBody.getLast();//取舊頭坐標
        int x = oldHead.getX();
        int y = oldHead.getY();



        switch( way){
            case 37:  //往左
                x = x - ( snake. SIZE + 1);
                break;
            case 38:    //往上
                y = y - ( snake. SIZE + 1);
                break;
            case 39:    //往右
                x = x + snake. SIZE + 1;
                break;
            case 40:    //往下
                y = y + snake. SIZE + 1;
                break;
        }


        JPanel newHead = new JPanel();//創建新頭
        newHead.setBounds(x, y, snake. SIZE, snake. SIZE);
        newHead.setBackground(Color. red);





        if(food.getX() == x && food.getY() == y){
            snakeBody.add(newHead);
            JPL.add(newHead);
            JPL.remove(food);
            snake.Food();
            newHead.setBackground(Color.green);
            speed-=1;
        }
        else {
            snakeBody.add(newHead);
            JPL.add(newHead);
            JPL.remove(snakeBody.getFirst());//去尾
            snakeBody.removeFirst();
        }
        snake.repaint();

    }
}
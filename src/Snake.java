import java.awt.*;
import java.util.LinkedList;
import javax.swing.JPanel;

public class Snake extends Thread{
    private MainFrame snake;
    private int way;

    public int getWay() {
        return way;
    }

    public void setWay( int way) {
        this. way = way;
    }

    public Snake(MainFrame snake) {
        this. snake = snake;
    }

    @Override
    public void run() {
        //循環的移動，循環一次走一步，并且延時
        while( true){
            move();
            try {
                Thread. sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    private void move(){
        LinkedList<JPanel> snakeBody = snake.getSnakeBody();

        JPanel JPL = snake.getJPL();
        //獲取到舊頭
        JPanel oldHead = snakeBody.getLast();
        //獲取舊頭的坐標
        int x = oldHead.getX();
        int y = oldHead.getY();
        switch( way){
            case 37:  //往左
                x = x - ( snake. SIZE + 1);
                break;
            case 38:    //往下
                y = y - ( snake. SIZE + 1);
                break;
            case 39:    //往右
                x = x + snake. SIZE + 1;
                break;
            case 40:    //往上
                y = y + snake. SIZE + 1;
                break;
        }
        JPanel newHead = new JPanel();//創建新頭
        newHead.setBounds(x, y, snake. SIZE, snake. SIZE);
        newHead.setBackground(Color. red);
        snakeBody.add(newHead);
        JPL.add(newHead);
        JPL.remove(snakeBody.getFirst());//去尾
        snakeBody.removeFirst();

       if(x==-1){

       }
        snake.repaint();
    }
}
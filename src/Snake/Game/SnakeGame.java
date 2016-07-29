package Snake.Game;

import Snake.Game.Objects.Apple;
import Snake.Game.Objects.Snake;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class SnakeGame extends JPanel implements ActionListener {

    private static final long serialVersionUID = -4201295877166777528L;
    public static final int SCALE = 32;
    public static final int WIDTH = 20;
    public static final int HEIGHT = 20;
    public static final int SPEED = 5;

    Apple apple = new Apple((int) (Math.random()*HEIGHT), (int) (Math.random()*WIDTH));
    Snake snake = new Snake(10, 10, 9, 10);
    Timer timer = new Timer(1000 / SPEED, this);

    public SnakeGame() {
        timer.start();
        addKeyListener(new Keyboard());
        setFocusable(true);
    }

    public void paint(Graphics graphics) {
        graphics.setColor(color(5, 50, 10));
        graphics.fillRect(0, 0, WIDTH * SCALE, HEIGHT * SCALE);
        graphics.setColor(color(255, 216, 0));

        for (int xx = 0; xx <= WIDTH * SCALE; xx += SCALE) {
            graphics.drawLine(xx, 0, xx, HEIGHT * SCALE);
        }
        for (int yy = 0; yy <= HEIGHT * SCALE; yy += SCALE) {
            graphics.drawLine(0, yy, WIDTH * SCALE, yy);
        }

        for (int d = 0; d < snake.lenght; d++) {
            graphics.setColor(color(200, 150, 0));
            graphics.fillRect(snake.snakeX[d] * SCALE + 1, snake.snakeY[d] * SCALE + 1, SCALE - 1, SCALE - 1);

            graphics.setColor(color(255,0,0));
            graphics.fillRect(apple.posX*SCALE+1 ,apple.posY*SCALE+1, SCALE-1,SCALE-1);
        }


    }

    public Color color(int red, int green, int blue) {
        return new Color(red, green, blue);
    }


    public static void main(String[] args) {

        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setSize(WIDTH * SCALE + 7, HEIGHT * SCALE + 30);
        frame.setLocationRelativeTo(null);
        frame.add(new SnakeGame());
        frame.setVisible(true);


    }

    @Override
    public void actionPerformed(ActionEvent e) {
        snake.move();
        if((snake.snakeX[0] == apple.posX)&& (snake.snakeY[0]== apple.posY)){
            apple.setRandomPosition();
            snake.lenght++;
        }
        for (int k = 1; k < snake.lenght; k++) {
            if((snake.snakeX[k] == apple.posX)&& (snake.snakeY[k]== apple.posY)){
                apple.setRandomPosition();

            }
        }
        repaint();
    }

    private class Keyboard extends KeyAdapter{
        public void keyPressed(KeyEvent  kEvnt){

            int key = kEvnt.getKeyCode();

            if(key == KeyEvent.VK_RIGHT) snake.direction = 0;
            if(key == KeyEvent.VK_DOWN) snake.direction = 1;
            if(key == KeyEvent.VK_LEFT) snake.direction = 2;
            if(key == KeyEvent.VK_UP) snake.direction = 3;
        }

    }

}

package Snake.Game.Objects;

import Snake.Game.SnakeGame;

public class Snake {

    SnakeGame main;


    public int direction = 0;
    public int lenght = 2;

    public int snakeX[] = new int[main.WIDTH*main.HEIGHT];
    public int snakeY[] = new int[main.WIDTH*main.HEIGHT];

    public Snake(int x0, int y0, int x1, int y1) {
        snakeX[0] = x0;
        snakeY[0] = y0;
        snakeX[1] = x1;
        snakeY[1] = y1;

    }

    public void move() {

        for (int d = lenght; d > 0; d--) {
            snakeX[d] = snakeX[d - 1];
            snakeY[d] = snakeY[d - 1];
        }
        if (direction == 0) snakeX[0]++;
        if (direction == 1) snakeY[0]++;
        if (direction == 2) snakeX[0]--;
        if (direction == 3) snakeY[0]--;
    }
}
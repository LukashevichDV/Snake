package Snake.Game.Objects;


import Snake.Game.SnakeGame;

public class Apple {

    SnakeGame main;

public int posX;
public int posY;

    public Apple(int posX, int posY) {
        this.posX = posX;
        this.posY = posY;
    }

    public void setRandomPosition(){
        posX = (int) (Math.random()*main.HEIGHT);
        posY = (int) (Math.random()*main.HEIGHT);
    }
}

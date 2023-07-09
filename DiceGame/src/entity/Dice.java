package entity;//import java.security.SecureRandom;
import java.security.SecureRandom;
import java.util.Random;

public class Dice {
    int score;
    int max;
    int min;
    public Dice()
    {
        max = 6;
        min = 1;
    }
    public Dice(int min,int max) {
        this.min = min;
        this.max = max;
    }

    public int getScore() {
        Random random = new SecureRandom();
        score = random.nextInt()%max;
        if(score == 0) return score+max;
        return Math.abs(score);
    }

}

package service;

import java.util.List;

public class LogsPrinter {

    public void noNextChance(int playerId)
    {
        System.out.println("player "+playerId+" doesn't have next chance because of two continuous 1's in the previous two consecutive rolls");
    }
    public void hasExtraChance(int playerId)
    {
        System.out.println("player "+playerId+" has an extra chance for rolling a 6 on the dice");
    }
    public void hasCompletedGame(int playerId,int round) {
        System.out.println("player " + playerId + " has completed the game in "+round+" round");
    }
    public void playingOrderPrinter(List<Integer> playingOrder)
    {
        System.out.println(playingOrder);
    }
}

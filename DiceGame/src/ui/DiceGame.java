package ui;

import entity.Board;
import entity.Dice;
import service.DiceRepoService;
import service.LogsPrinter;
import service.PlayingOrder;
import service.RankingSystem;
import entity.Player;


import java.util.*;

public class DiceGame {
    public static void main(String[] args) {

        Player player = new Player();
        Dice dice = new Dice();
        Board board = new Board();
        RankingSystem rankingSystem = new RankingSystem();
        LogsPrinter logsPrinter = new LogsPrinter();
        DiceRepoService diceRepoService = new DiceRepoService();
        PlayingOrder playingOrderGame = new PlayingOrder();
        Scanner s = new Scanner(System.in);

        System.out.println("Please enter number of players");
        int N = s.nextInt();
        System.out.println("Please enter the total score to win");
        int M = s.nextInt();

        // This list gives us a random order of players to play the game in turns
        diceRepoService.setPlayingOrder(playingOrderGame.getPlayingOrder(N));
        System.out.println("The Playing Order for players is ");
        logsPrinter.playingOrderPrinter(diceRepoService.getPlayingOrder());

        // Map is used to store the list of the players and to search for the players within O(1) time using playerId
        diceRepoService.setAllPlayers(board.intializePlayers(N));

        //This List is used to store the list of players who are currently playing in the game
        diceRepoService.addPlayingPlayer(diceRepoService.getPlayingOrder());


        //this count is used to store the round number of rolling dice
        int count = 0;
        while(diceRepoService.getCompleted().size()!=N)
        {
            count++;
            System.out.println("\nThis is "+count+" round of rolling a dice");
            for(int i=0;i<diceRepoService.getPlayingOrder().size();i++) {
                Player p = diceRepoService.getPlayerById(diceRepoService.getPlayingOrder().get(i));

                if (!p.isHasLostChance()) {
                    System.out.println("Now its your turn player "+ p.getPlayerId() +" please roll the dice");
                    System.out.println("Please press r to roll the dice");
                    char c = s.next().charAt(0);
                    while(c != 'r')
                    {
                        System.out.println("you have entered incorrect character please press only r to roll the dice");
                        c = s.next().charAt(0);
                    }
                    int roll = dice.getScore();
                    System.out.println("The value on the dice is "+ roll);
                    inner:if (roll == 6) {
                        if (p.getPoints()+roll >= M) {
                            break inner;
                        } else {
                            logsPrinter.hasExtraChance(p.getPlayerId());
                            System.out.println("Please press r to roll the dice");
                            c = s.next().charAt(0);
                            while(c != 'r')
                            {
                                System.out.println("you have entered incorrect character please press only r to roll the dice");
                                c = s.next().charAt(0);
                            }
                            int nextRoll = dice.getScore();
                            System.out.println("The value of the extra roll is " + nextRoll);
                            roll = roll + nextRoll;
                        }
                    }
                     else {
                        if (roll == 1 && p.isPreviousRollOne()) {
                            p.setHasLostChance(true);
                            p.setPreviousRollOne(false);
                        } else if (!p.isPreviousRollOne() && roll == 1) {
                            p.setPreviousRollOne(true);
                        }
                        else if(p.isPreviousRollOne() && roll!=1)
                        {
                            p.setPreviousRollOne(false);
                        }
                    }

                    p.setPoints(p.getPoints() +roll);
                    System.out.println("player " + p.getPlayerId() + " your score is "+p.getPoints());
                    if(p.getPoints()>=M)
                    {
                        diceRepoService.addRoundWon(count);
                        logsPrinter.hasCompletedGame(p.getPlayerId(),count);
                        diceRepoService.getPlaying().remove(p);
                        diceRepoService.getCompleted().add(p);
                    }
                    diceRepoService.getAllPlayers().put(p.getPlayerId(), p);
                }
                else {
                    logsPrinter.noNextChance(p.getPlayerId());
                    p.setHasLostChance(false);
                }
            }
            for(int j=0;j<diceRepoService.getCompleted().size();j++)
            {
                diceRepoService.getPlayingOrder().remove(Integer.valueOf(diceRepoService.getCompleted().get(j).getPlayerId()));
            }
            System.out.println("\n The Ranks after "+ count +" round of rolling dice are ");
            rankingSystem.getRankings(diceRepoService.getPlaying(),diceRepoService.getCompleted(),diceRepoService.getRoundWon());    }
    }
}
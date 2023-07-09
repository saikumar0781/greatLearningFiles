package service;

import entity.Player;
import repository.DiceRepo;

import java.util.List;
import java.util.Map;

public class DiceRepoService {
    DiceRepo diceRepo;
    public DiceRepoService() {
        diceRepo = new DiceRepo();
    }
    public void setPlayingOrder(List<Integer> playingOrder)
    {
        diceRepo.setPlayingOrder(playingOrder);
    }
    public void setAllPlayers(Map<Integer,Player> allPlayers)
    {
        diceRepo.setAllPlayers(allPlayers);
    }
    public void addPlayingPlayer(List<Integer> playingGame)
    {
        diceRepo.addPlayingPlayer(playingGame);

    }

    public void addCompletedPlayer(List<Player> completedGame)
    {
        diceRepo.addCompletedPlayer(completedGame);
    }
    public void addRoundWon(int round)
    {
        diceRepo.addRoundWon(round);
    }
    public List<Integer> getPlayingOrder()
    {
        List<Integer> playingOrderTemp = null;
        try {
           playingOrderTemp = diceRepo.getPlayingOrder();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return playingOrderTemp;
    }
    public List<Player> getPlaying()
    {
        List<Player> playingTemp = null;
        try {
            playingTemp = diceRepo.getPlaying();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return playingTemp;
    }
    public List<Player> getCompleted()
    {
        List<Player> completedTemp = null;
        try {
            completedTemp = diceRepo.getCompleted();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return completedTemp;
    }
    public List<Integer> getRoundWon()
    {
        List<Integer> roundWonTemp = null;
        try {
            roundWonTemp = diceRepo.getRoundWon();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return roundWonTemp;
    }
    public Player getPlayerById(int playerId)
    {
        Player p = null;
        try {
            p = diceRepo.getById(playerId);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return p;
    }
    public Map<Integer,Player> getAllPlayers()
    {
        return diceRepo.getAllPlayers();
    }
}

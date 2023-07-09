package repository;

import entity.Player;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DiceRepo {

    //this list refers to the order in which the players will play and it is randomly generated
    List<Integer> playingOrder;

    // this map is used to fetch details of the players within O(1) time complexity
    Map<Integer,Player> allPlayers;

    // this list is used for storing current players playing the game
    List<Player> playing;
    //this list is used for storing players who completed the game
    List<Player> completed;
    //this list is used to store the round number in which each player won the game
    List<Integer> roundWon;

    public DiceRepo()
    {
        playingOrder = new ArrayList<>();
        allPlayers = new HashMap<>();
        playing = new ArrayList<>();
        completed = new ArrayList<>();
        roundWon = new ArrayList<>();
    }

    public void setPlayingOrder(List<Integer> playingOrder) {
            this.playingOrder = playingOrder;
    }
    public void setAllPlayers(Map<Integer,Player> allPlayers) {
        this.allPlayers = allPlayers;
    }
    public void addPlayingPlayer(List<Integer> playingOrder) {
        for(int i=0;i<playingOrder.size();i++)
        {
                playing.add(allPlayers.get(playingOrder.get(i)));
        }
    }
    public void addCompletedPlayer(List<Player> completedGame){
        for(int i=0;i<completedGame.size();i++)
        {
            completed.add(completedGame.get(i));
        }
    }
    public void addRoundWon(Integer round) {
        roundWon.add(round);
    }
    public List<Integer> getPlayingOrder() throws Exception {
        if(playingOrder==null) throw new Exception("The playing order is not generated");
        return this.playingOrder;
    }
    public List<Player> getPlaying() throws Exception {
        if(playing == null) throw new Exception("There are no players playing");
        return this.playing;
    }
    public List<Player> getCompleted() throws Exception {
        if(completed==null) throw new Exception("There are no completed players");
        return this.completed;
    }
    public List<Integer> getRoundWon() throws Exception {
        if(roundWon == null) throw new Exception("No player has won till now");
        return this.roundWon;
    }
    public Player getById(int playerId) throws Exception {
        if(allPlayers.get(playerId)==null) throw new Exception("There is no player with given id");
        return allPlayers.get(playerId);
    }
    public Map<Integer,Player> getAllPlayers()
    {
        return this.allPlayers;
    }


}

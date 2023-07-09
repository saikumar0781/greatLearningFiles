package entity;

import entity.Player;
import service.DiceRepoService;

import java.util.HashMap;
import java.util.Map;

public class Board {
    private Map<Integer,Player> players;

    public Board()
    {
    }

    public Map<Integer, Player> intializePlayers(int N)
    {
        players = new HashMap<>();
        for(int i=0;i<N;i++)
        {
            players.put(i+1,new Player(i+1,"Player"+(int)(i+1),0,0,false,false,false));
        }
        return players;
    }
}

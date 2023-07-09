package service;

import entity.Player;

import java.util.List;
import java.util.PriorityQueue;

public class RankingSystem {

    private PriorityQueue<Pair> rankingQueue = new PriorityQueue<Pair>((a, b)-> b.points - a.points);


    public void getRankings(List<Player> playing, List<Player> wonPlayers, List<Integer> roundGameCompleted)
    {
        for(int i=0;i<playing.size();i++)
            rankingQueue.add(new Pair(playing.get(i).getPlayerId(), playing.get(i).getPoints()));

        for(int i=0;i<wonPlayers.size();i++)
        {
            int rank = i+1;
            System.out.println(wonPlayers.get(i).getPlayerId() + " has completed his game "+"in round "+ roundGameCompleted.get(i)+" with rank " + rank);
        }
        int count = 1;
        int wonsize = wonPlayers.size();
        while(!rankingQueue.isEmpty())
        {
            Pair p = rankingQueue.poll();
            int rank = wonsize+count;
            System.out.println(p.playerId +" has "+ p.points+" points and rank is "+ rank);
            count++;
        }
    }

    static class Pair
    {
        int playerId;
        int points;
        public Pair(int playerId,int points)
        {
            this.playerId = playerId;
            this.points = points;
        }
    }
}


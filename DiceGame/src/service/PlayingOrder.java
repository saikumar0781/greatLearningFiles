package service;

import java.security.SecureRandom;
import java.util.*;

public class PlayingOrder {
    private Set<Integer> playingOrderSet;

    public PlayingOrder() {
        playingOrderSet = new LinkedHashSet<>();
    }

    public List<Integer> getPlayingOrder(int noOfPlayers) {
        int rand = 0;
        Random random = new SecureRandom();
        while(playingOrderSet.size()!=noOfPlayers)
        {
            rand = random.nextInt(noOfPlayers)+1;
            //System.out.println(rand);
            playingOrderSet.add(rand);
        }
        return new ArrayList<>(playingOrderSet);
    }

}

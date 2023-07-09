package entity;
public class Player {
    private int playerId;
    private String playerName;
    private int points;
    private int rank;
    private boolean previousRollOne;
    private boolean gameCompleted;
    private boolean hasLostChance;

    public Player() {
    }

    public Player(int playerId, String playerName, int points, int rank, boolean previousRollOne, boolean gameCompleted, boolean hasLostChance) {
        this.playerId = playerId;
        this.playerName = playerName;
        this.points = points;
        this.rank = rank;
        this.previousRollOne = previousRollOne;
        this.gameCompleted = gameCompleted;
        this.hasLostChance = hasLostChance;
    }

    public int getPlayerId() {
        return playerId;
    }

    public void setPlayerId(int playerId) {
        this.playerId = playerId;
    }

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

    public boolean isPreviousRollOne() {
        return previousRollOne;
    }

    public void setPreviousRollOne(boolean previousRollOne) {
        this.previousRollOne = previousRollOne;
    }

    public boolean isGameCompleted() {
        return gameCompleted;
    }

    public void setGameCompleted(boolean gameCompleted) {
        this.gameCompleted = gameCompleted;
    }

    public boolean isHasLostChance() {
        return hasLostChance;
    }

    public void setHasLostChance(boolean hasLostChance) {
        this.hasLostChance = hasLostChance;
    }

}

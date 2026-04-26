package trivia;

public class Player {
    private String name;
    private int place;
    private int purse;
    private boolean penaltyBox;

    public Player(String name){
        this.name = name;
        this.place = 1;
        this.purse = 0;
        this.penaltyBox = false;
    }

    public boolean isPenaltyBox(){
        return penaltyBox;
    }

    public int getPlace(){
        return this.place;
    }

    public int getPurse(){
        return this.purse;
    }

    public String getName(){
        return this.name;
    }

    public void setPlace(int place) {
        this.place = place;
    }

    public void setPurse(int purse) {
        this.purse = purse;
    }

    public void setPenaltyBox(boolean penaltyBox) {
        this.penaltyBox = penaltyBox;
    }
}

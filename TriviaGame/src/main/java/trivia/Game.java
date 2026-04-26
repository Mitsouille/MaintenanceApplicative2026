package trivia;

import java.util.ArrayDeque;

// REFACTOR ME
public class Game implements IGame {
    ArrayDeque<Player> players = new ArrayDeque<>();

    boolean[] inPenaltyBox = new boolean[4];

    Questions questions;

    Player currentPlayer;
    boolean isGettingOutOfPenaltyBox;

    public Game() {
        this.questions = new Questions();
    }

    public boolean isPlayable() {
        return (howManyPlayers() >= 2);
    }

    public boolean add(String playerName) {
        this.players.add(new Player(playerName));
        currentPlayer = this.players.getFirst();

        System.out.println(playerName + " was added");
        System.out.println("They are players number " + players.size());
        return true;
    }

    public int howManyPlayers() {
        return players.size();
    }

    public void roll(int roll) {
        System.out.println(currentPlayer.getName() + " is the current players");
        System.out.println("They have rolled a " + roll);
        if (currentPlayer.isPenaltyBox()) {
            if (roll % 2 != 0) {
                isGettingOutOfPenaltyBox = true;
                System.out.println(currentPlayer.getName() + " is getting out of the penalty box");
                currentPlayer.setPlace(currentPlayer.getPlace() + roll);
                if (currentPlayer.getPlace() > 12)
                    currentPlayer.setPlace(currentPlayer.getPlace() - 12);

                System.out.println(currentPlayer.getName()
                        + "'s new location is "
                        + currentPlayer.getPlace());
                System.out.println("The category is " + currentCategory());
                askQuestion();
            } else {
                System.out.println(currentPlayer.getName() + " is not getting out of the penalty box");
                isGettingOutOfPenaltyBox = false;
            }

        } else {

            currentPlayer.setPlace(currentPlayer.getPlace() + roll);
            if (currentPlayer.getPlace() > 12)
                currentPlayer.setPlace(currentPlayer.getPlace() - 12);


            System.out.println(currentPlayer.getName()
                    + "'s new location is "
                    + currentPlayer.getPlace());
            System.out.println("The category is " + currentCategory());
            askQuestion();
        }

    }

    private void askQuestion() {
        questions.askQuestion(currentCategory());
    }


    private TypeQuestion currentCategory() {
        if (currentPlayer.getPlace() - 1 == 0) return TypeQuestion.Pop;
        if (currentPlayer.getPlace() - 1 == 4) return TypeQuestion.Pop;
        if (currentPlayer.getPlace() - 1 == 8) return TypeQuestion.Pop;
        if (currentPlayer.getPlace() - 1 == 1) return TypeQuestion.Science;
        if (currentPlayer.getPlace() - 1 == 5) return TypeQuestion.Science;
        if (currentPlayer.getPlace() - 1 == 9) return TypeQuestion.Science;
        if (currentPlayer.getPlace() - 1 == 2) return TypeQuestion.Sports;
        if (currentPlayer.getPlace() - 1 == 6) return TypeQuestion.Sports;
        if (currentPlayer.getPlace() - 1 == 10) return TypeQuestion.Sports;
        return TypeQuestion.Rock;
    }

    public boolean handleCorrectAnswer() {
        if (currentPlayer.isPenaltyBox()) {
            if (isGettingOutOfPenaltyBox) {
                System.out.println("Answer was correct !!!!");
                currentPlayer.setPurse(currentPlayer.getPurse() + 1);
                System.out.println(currentPlayer.getName()
                        + " now has "
                        + currentPlayer.getPurse()
                        + " Gold Coins.");

                boolean winner = didPlayerWin();
                currentPlayer = players.pollFirst();
                players.offerLast(currentPlayer);

                return winner;
            } else {
                currentPlayer = players.pollFirst();
                players.offerLast(currentPlayer);
                return true;
            }


        } else {

            System.out.println("Answer was correct !!!!");
            currentPlayer.setPurse(currentPlayer.getPurse() + 1);
            System.out.println(currentPlayer.getName()
                    + " now has "
                    + currentPlayer.getPurse()
                    + " Gold Coins.");

            boolean winner = didPlayerWin();
            currentPlayer = players.pollFirst();
            players.offerLast(currentPlayer);

            return winner;
        }
    }

    public boolean wrongAnswer() {
        System.out.println("Question was incorrectly answered");
        System.out.println(currentPlayer.getName() + " was sent to the penalty box");
        currentPlayer.setPenaltyBox(true);

        currentPlayer = players.pollFirst();
        players.offerLast(currentPlayer);
        return true;
    }


    private boolean didPlayerWin() {
        return !(currentPlayer.getPurse() == 6);
    }
}

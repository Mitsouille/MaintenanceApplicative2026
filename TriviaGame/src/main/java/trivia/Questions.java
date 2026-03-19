package trivia;

import java.util.LinkedList;

public class Questions {

    LinkedList popQuestions = new LinkedList();
    LinkedList scienceQuestions = new LinkedList();
    LinkedList sportsQuestions = new LinkedList();
    LinkedList rockQuestions = new LinkedList();

    public Questions() {
        for (int i = 0; i < 50; i++) {
            popQuestions.addLast("Pop Question " + i);
            scienceQuestions.addLast(("Science Question " + i));
            sportsQuestions.addLast(("Sports Question " + i));
            rockQuestions.addLast(createRockQuestion(i));
        }
    }

    public String createRockQuestion(int index) {
        return "Rock Question " + index;
    }

    public void askQuestion(TypeQuestion categorie) {
        switch (categorie) {
            case Pop:
                System.out.println(popQuestions.removeFirst());
                break;
            case Science:
                System.out.println(scienceQuestions.removeFirst());
                break;
            case Sports:
                System.out.println(sportsQuestions.removeFirst());
                break;
            case Rock:
                System.out.println(rockQuestions.removeFirst());
                break;
        }
    }
}

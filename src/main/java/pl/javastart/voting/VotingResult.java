package pl.javastart.voting;

import java.util.ArrayList;
import java.util.List;

/**
 * Możesz dodać kolejne metody i pola do klasy. Nie zmieniaj istniejących metod.
 */
public class VotingResult {
    List<Vote> votes;

    public VotingResult() {
        votes = new ArrayList<>();
    }

    public void add(Vote vote) {
        votes.add(vote);
    }

    /**
     * Metoda powinna drukować wyniki głosowania w takiej postaci:
     * Głosów za: 56.53%
     * Głosów przeciw: 35.00%
     * Wstrzymało się: 8.47%
     */
    public void printResults() {
        int votesInFavour = 0;
        int votesAgainst = 0;
        int abstentions = 0;
        for (Vote vote : votes) {
            if (vote.getVote() == null) {
                abstentions++;
            } else if (vote.getVote()) {
                votesInFavour++;
            } else {
                votesAgainst++;
            }
        }
        double ratioVotesInFavour = (double) votesInFavour / votes.size() * 100;
        double ratioVotesAgainst = (double) votesAgainst / votes.size() * 100;
        double ratioAbsentions = (double) abstentions / votes.size() * 100;
        System.out.printf("Głosów za: %.2f%%%n", ratioVotesInFavour);
        System.out.printf("Głosów przeciw: %.2f%%%n", ratioVotesAgainst);
        System.out.printf("Wstrzymało się: %.2f%%%n", ratioAbsentions);
    }

    /**
     * Metoda przyjmuje imię i nazwisko głosującego, np "Zigniew Siobro".
     * Uzupełnij tę metodę, żeby drukowała informację w formie:
     * Zigniew Siobro: ZA
     * Nie zmieniaj sygnatury tej metody!
     */
    public void printVoteForVoter(String voterName) {
        String message = null;
        for (Vote vote : votes) {
            if (vote.getVoter().equalsIgnoreCase(voterName)) {
                if (vote.getVote() == null) {
                    message = "WSTRZYMAŁ SIĘ";
                } else if (vote.getVote()) {
                    message = "ZA";
                } else {
                    message = "PRZECIW";
                }
                System.out.println(vote.getVoter() + ":" + " " + message);
                break;
            }
        }

    }

    public List<Vote> getVoteList() {
        return votes;
    }
}

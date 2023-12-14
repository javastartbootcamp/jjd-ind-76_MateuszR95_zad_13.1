package pl.javastart.voting;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Voting {

    public static void main(String[] args) {
        List<String> voters = new ArrayList<>();

        // możesz dowolnie dodawać / usuwać dane testowe
        voters.add("Jan Kowalski");
        voters.add("Zigniew Siobro");
        voters.add("Zbyszek Stonoga");

        Voting voting = new Voting();

        VotingResult votingResult = voting.executeVoting(voters, new Scanner(System.in));
        votingResult.printResults();
        votingResult.printVoteForVoter("Zigniew Siobro");
        votingResult.printVoteForVoter("Jan Kowalski");
        votingResult.printVoteForVoter("Zbyszek Stonoga");
    }

    /**
     * Uzupełnij metodę metodę, ale nie zmieniaj jej sygnatury! (typu tego, co przyjmuje i zwraca).
     * do wczytywania danych od użytkownika użyj scannera z parametru
     * Metoda powinna pobrać głos dla każdego przekazanego głosującego i zapisać wyniki głosowania do VotingResult
     */
    VotingResult executeVoting(List<String> voters, Scanner scanner) {
        VotingResult votingResult = new VotingResult();
        for (String voter : voters) {
            boolean validVote = false;
            while (!validVote) {
                System.out.println("Witaj: " + voter + ", oddaj głos w sprawie uchwały: " +
                        "z - za, p - przeciw, w - wstrzymanie się");
                String userVote = scanner.nextLine();
                switch (userVote) {
                    case "z" -> {
                        Vote vote = new Vote(voter, true);
                        votingResult.add(vote);
                        validVote = true;
                    }
                    case "p" -> {
                        Vote vote = new Vote(voter, false);
                        votingResult.add(vote);
                        validVote = true;
                    }
                    case "w" -> {
                        Vote vote = new Vote(voter, null);
                        votingResult.add(vote);
                        validVote = true;
                    }
                    default -> System.out.println("Podano nieprawidłową wartość. Oddaj głos ponownie");
                }
            }

        }
        return votingResult;  // to możesz (a nawet powinieneś/powinnaś) zmienić :)
    }

}


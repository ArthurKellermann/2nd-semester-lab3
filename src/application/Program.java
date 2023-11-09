package application;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

import model.entitites.Candidate;
import services.CandidateComparatorService;

public class Program {

	private static CandidateComparatorService cs = new CandidateComparatorService();

	public static void main(String[] args) {
		try {
			menu();
		} catch (RuntimeException e) {
			System.out.println("Error: " + e.getMessage());
		}

	}

	public static void menu() {
		Scanner in = new Scanner(System.in);
		List<Candidate> listCandidates = new ArrayList<Candidate>();

		Candidate c1 = new Candidate("Pedro", "PP", 50, 23090);
		Candidate c2 = new Candidate("Arthur", "PL", 40, 10230);
		Candidate c3 = new Candidate("Lorenzo", "PM", 44, 33120);
		Candidate c4 = new Candidate("Eduardo", "PS", 52, 13000);
		Candidate c5 = new Candidate("Gabriel", "PC", 45, 20000);

		listCandidates.add(c1);
		listCandidates.add(c2);
		listCandidates.add(c3);
		listCandidates.add(c4);
		listCandidates.add(c5);

		System.out.println("Selecione a opção desejada: ");
		System.out.println(
				"1 - Candidatos mais jovens\n" + "2 - Candidatos mais velhos\n" + "3 - Candidatos mais votados\n"
						+ "4 - Candidatos menos votados\n" + "5 - Total de votos recebidos por todos os candidatos\n"
						+ "6 - Média de votação recebida pelos candidatos   ");
		int option = 0;

		do {
			option = in.nextInt();

			System.out.println();

			switch (option) {
			case 1:
				youngestCandidateMenu(listCandidates);
				break;
			case 2:
				oldestCandidateMenu(listCandidates);
				break;
			case 3:
				mostVotedCandidateMenu(listCandidates);
				break;
			case 4:
				leastVotedCandidateMenu(listCandidates);
				break;
			case 5:
				totalVotesReceivedByAllCandidatesMenu(listCandidates);
				break;
			case 6:
				averageVoteReceivedByCandidatesMenu(listCandidates);
				break;
			case 0:
				break;
			}
		} while (option != 0);

		System.out.println("Saindo...");

		in.close();
	}

	public static void youngestCandidateMenu(List<Candidate> listCandidates) {
		PriorityQueue<Candidate> youngestCandidate = cs.youngestCandidate(listCandidates);

		System.out.println("Comparando por candidato mais jovem...");

		while (youngestCandidate.size() != 0) {
			Candidate candidate = youngestCandidate.remove();
			System.out.println(candidate.getName() + ": " + candidate.getAge());
		}

		System.out.println();
	}

	public static void oldestCandidateMenu(List<Candidate> listCandidates) {
		PriorityQueue<Candidate> oldestCandidate = cs.oldestCandidate(listCandidates);

		System.out.println("Comparando por candidato mais velho...");

		while (oldestCandidate.size() != 0) {
			Candidate candidate = oldestCandidate.remove();
			System.out.println(candidate.getName() + ": " + candidate.getAge());
		}

		System.out.println();
	}

	public static void mostVotedCandidateMenu(List<Candidate> listCandidates) {
		PriorityQueue<Candidate> mostVotedCandidate = cs.mostVotedCandidate(listCandidates);

		System.out.println("Comparando por candidato mais votado...");

		while (mostVotedCandidate.size() != 0) {
			Candidate candidate = mostVotedCandidate.remove();
			System.out.println(candidate.getName() + ": " + candidate.getNumberOfVotes());
		}

		System.out.println();
	}

	public static void leastVotedCandidateMenu(List<Candidate> listCandidates) {
		PriorityQueue<Candidate> leastVotedCandidate = cs.leastVotedCandidate(listCandidates);

		System.out.println("Comparando por candidato menos votado...");

		while (leastVotedCandidate.size() != 0) {
			Candidate candidate = leastVotedCandidate.remove();
			System.out.println(candidate.getName() + ": " + candidate.getNumberOfVotes());
		}

		System.out.println();
	}

	public static void totalVotesReceivedByAllCandidatesMenu(List<Candidate> listCandidates) {
		int total = cs.totalVotesReceivedByAllCandidates(listCandidates);

		System.out.println("Total de votos recebidos por todos os candidatos: " + total);

		System.out.println();
	}

	public static void averageVoteReceivedByCandidatesMenu(List<Candidate> listCandidates) {
		double average = cs.averageVoteReceivedByCandidates(listCandidates);

		System.out.println("Média de votação recebida pelos candidatos: " + String.format("%.2f", average));

		System.out.println();
	}

}

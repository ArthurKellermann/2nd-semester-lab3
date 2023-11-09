package services;

import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

import model.comparators.LeastVotedCandidate;
import model.comparators.MostVotedCandidate;
import model.comparators.OldestCandidate;
import model.comparators.YoungestCandidate;
import model.entitites.Candidate;

public class CandidateComparatorService {

	private Comparator<Candidate> youngestCandidate, oldestCandidate, mostVotedCandidate, leastVotedCandidate;

	public CandidateComparatorService() {
		youngestCandidate = new YoungestCandidate();
		oldestCandidate = new OldestCandidate();
		mostVotedCandidate = new MostVotedCandidate();
		leastVotedCandidate = new LeastVotedCandidate();
	}

	private PriorityQueue<Candidate> getCandidatePriorityQueue(List<Candidate> listCandidates,
			Comparator<Candidate> comparator) {
		PriorityQueue<Candidate> pq = new PriorityQueue<Candidate>(listCandidates.size(), comparator);
		pq.addAll(listCandidates);
		return pq;
	}

	public PriorityQueue<Candidate> youngestCandidate(List<Candidate> listCandidates) {
		return getCandidatePriorityQueue(listCandidates, youngestCandidate);
	}

	public PriorityQueue<Candidate> oldestCandidate(List<Candidate> listCandidates) {
		return getCandidatePriorityQueue(listCandidates, oldestCandidate);
	}

	public PriorityQueue<Candidate> mostVotedCandidate(List<Candidate> listCandidates) {
		return getCandidatePriorityQueue(listCandidates, mostVotedCandidate);
	}

	public PriorityQueue<Candidate> leastVotedCandidate(List<Candidate> listCandidates) {
		return getCandidatePriorityQueue(listCandidates, leastVotedCandidate);
	}

	public int totalVotesReceivedByAllCandidates(List<Candidate> listCandidates) {
		int total = 0;

		for (Candidate c : listCandidates) {
			total += c.getNumberOfVotes();
		}

		return total;
	}
	
	public double averageVoteReceivedByCandidates(List<Candidate> listCandidates) {
		double average = totalVotesReceivedByAllCandidates(listCandidates) / listCandidates.size();
		
		return average;
	}
}

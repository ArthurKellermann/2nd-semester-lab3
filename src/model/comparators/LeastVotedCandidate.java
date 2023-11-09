package model.comparators;

import java.util.Comparator;

import model.entities.Candidate;

public class LeastVotedCandidate implements Comparator<Candidate>{
	
	@Override
	public int compare(Candidate candidate1, Candidate candidate2) {
		if (candidate1.getNumberOfVotes() < candidate2.getNumberOfVotes()) {
			return -1;
		}
		if (candidate1.getNumberOfVotes() > candidate2.getNumberOfVotes()) {
			return 1;
		}
		return 0;
	}
}

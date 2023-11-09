package model.comparators;

import java.util.Comparator;

import model.entitites.Candidate;

public class YoungestCandidate implements Comparator<Candidate>{
	
	@Override
	public int compare(Candidate candidate1, Candidate candidate2) {
		if (candidate1.getAge() < candidate2.getAge()) {
			return -1;
		}
		if (candidate1.getAge() > candidate2.getAge()) {
			return 1;
		}
		return 0;
	}
}

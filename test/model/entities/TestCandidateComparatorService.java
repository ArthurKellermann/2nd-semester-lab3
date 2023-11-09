package model.entities;

import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import model.entitites.Candidate;
import services.CandidateComparatorService;

class TestCandidateComparatorService {

	private CandidateComparatorService cs;
	private Candidate c1, c2, c3, c4, c5;
	private List<Candidate> listCandidates;
	
	@BeforeEach
	void setUp() {
		cs = new CandidateComparatorService();
		listCandidates = new ArrayList<Candidate>();
		
		c1 = new Candidate("Pedro", "PP", 50, 23090);
		c2 = new Candidate("Arthur", "PL", 40, 10230);
		c3 = new Candidate("Lorenzo", "PM", 44, 33120);
		c4 = new Candidate("Eduardo", "PS", 52, 13000);
		c5 = new Candidate("Gabriel", "PC", 45, 20000);
		
		listCandidates.add(c1);
		listCandidates.add(c2);
		listCandidates.add(c3);
		listCandidates.add(c4);
		listCandidates.add(c5);
		
	}
	
	@Test
	void testYoungestCandidate() {
		PriorityQueue<Candidate> youngestCandidate = cs.youngestCandidate(listCandidates);
		
		assertEquals(c2, youngestCandidate.peek());
		
	}
	
	@Test
	void testOldestCandidate() {
		PriorityQueue<Candidate> oldestCandidate = cs.oldestCandidate(listCandidates);
		
		assertEquals(c4, oldestCandidate.peek());
		
	}
	
	@Test
	void testMostVotedCandidate() {
		PriorityQueue<Candidate> mostVotedCandidate = cs.mostVotedCandidate(listCandidates);
		
		assertEquals(c3, mostVotedCandidate.peek());
		
	}
	
	@Test
	void testLeastVotedCandidate() {
		PriorityQueue<Candidate> leastVotedCandidate = cs.leastVotedCandidate(listCandidates);
		
		assertEquals(c2, leastVotedCandidate.peek());
		
	}
	
	@Test
	void testTotalVotesReceivedByAllCandidates() {
		int totalVotesReceivedByAllCandidates = cs.totalVotesReceivedByAllCandidates(listCandidates);
		
		assertEquals(99440, totalVotesReceivedByAllCandidates);
		//19888,00
		
	}
	
	@Test
	void testAverageVoteReceivedByCandidatesMenu() {
		double averageVoteReceivedByCandidates = cs.averageVoteReceivedByCandidates(listCandidates);
		
		assertEquals(19888.00, averageVoteReceivedByCandidates, 0.01);
		
	}

}

package com.oracle.questionsAndExercises;

import java.util.ArrayList;
import java.util.List;

class Card {
	private String rank;
	private String suit;
	
	public Card(String rank, String suit) {
		this.rank = rank;
		this.suit = suit;
	}

	public String getRank() {
		return rank;
	}

	public String getSuit() {
		return suit;
	}

	@Override
	public String toString() {
		return "Card [rank=" + rank + ", suit=" + suit + "]";
	}
	
}

// https://docs.oracle.com/javase/tutorial/java/javaOO/QandE/creating-questions.html
//  2. Write a class whose instances represent a full deck of cards. You should also keep this solution.
public class DeckOfCards {
	List<Card> cards;
	
	public DeckOfCards() {
		cards = new ArrayList<>(52);
		initializatDeck();
	}

	private void initializatDeck() {
		String[] ranks = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King", "Ace"};
		String[] suits = {"Spade", "Heart", "Flower", "Diamond"};
		
		for (String rank : ranks) {
			for (String suit : suits) {
				cards.add(new Card(rank, suit));
			}
		}
	}
	
	public void shuffle() {
		// shuffle related logic
	}
}

// 3. Write a small program to test your deck and card classes. The program can be as simple as creating a deck of cards and displaying its cards.
// https://docs.oracle.com/javase/tutorial/java/javaOO/examples/Card.java
// https://docs.oracle.com/javase/tutorial/java/javaOO/examples/Deck.java
// https://docs.oracle.com/javase/tutorial/java/javaOO/examples/DisplayDeck.java




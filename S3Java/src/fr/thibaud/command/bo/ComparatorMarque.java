/**
 * 
 */
package fr.thibaud.command.bo;

import java.util.Comparator;

class ComparatorMarque implements Comparator<Article>{

	@Override
	public int compare(Article o1, Article o2) {
		return o1.getMarque().compareTo(o2.getMarque());
	}

}

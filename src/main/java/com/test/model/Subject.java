package com.test.model;

import java.io.Serializable;
import java.util.Set;

public class Subject implements Serializable{


	/**
	 * 
	 */
	private static final long serialVersionUID = -1343945030230090661L;
	
	public long subjectId;
	public String subtitle;
	public int durationInHours;
	public Set<Book> references;
	
	public Subject(long subjectId, String subtitle, int durationInHours, Set<Book> references){
		this.subjectId = subjectId;
		this.subtitle = subtitle;
		this.durationInHours = durationInHours;
		this.references = references;
	}

	@Override
	public String toString() {
		return "Subject [subjectId=" + subjectId + ", subtitle=" + subtitle + ", durationInHours=" + durationInHours
				+ ", references=" + references + "]";
	}

	public Subject(){
		
	}
	
}

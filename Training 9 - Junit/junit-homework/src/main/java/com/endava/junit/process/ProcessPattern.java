package com.endava.junit.process;

public class ProcessPattern {

	public String generatePosition(String grade, int age) {
		String result = null;
		if (grade != null && age > 0) {
			if ("junior".equals(grade)) {
				result = "Junior Developer";
			} else if ("middle".equals(grade) && age <= 1) {
				result = "Developer 1";
			} else if ("middle".equals(grade) && age > 1) {
				result = "Developer 2";
			} else if ("senior".equals(grade) && age <= 5) {
				result = "Senior 1";
			} else if ("senior".equals(grade) && age > 5) {
				result = "Senior 2";
			} else {
				result = "Unknown Position";
			}
		}
		return result;
	}

}
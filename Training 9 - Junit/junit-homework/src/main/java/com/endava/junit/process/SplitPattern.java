package com.endava.junit.process;

import java.util.ArrayList;
import java.util.List;

public class SplitPattern {

	public List<String> splitByLength(List<String> stringList) {
		List<String> result = new ArrayList<String>();
		for (String s : stringList) {
			String size = getStringLength(s);
			result.add(size);
		}
		return result;
	}

	public String getStringLength(String value) {
		String result = null;
		if (value != null) {
			if (value.length() < 5) {
				result = "small";
			} else if (value.length() >= 5 && value.length() < 15) {
				result = "medium";
			} else {
				result = "long";
			}
		}
		return result;
	}

}

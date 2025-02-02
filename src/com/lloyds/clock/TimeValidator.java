package com.lloyds.clock;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TimeValidator {

	public static boolean isValidTime(String time_str, TimeFormat timeFormat) {

		boolean output = false;

		switch (timeFormat) {
		case HHMM: {
			output = validateHHMM(time_str);
			break;
		}
		case HHMMSS: {
//		    	output= validateHHMMSS()
			break;
		}
		case HHMMSSmm: {
//		    	output= validateHHMMSSmm()
			break;
		}
		default:
            throw new UnsupportedOperationException("Unsupported time format!!");
		}
		return output;
	}

	private static boolean validateHHMM(String time_str) {

		String regex = "^(?:[01]\\d|2[0-3]):[0-5]\\d$";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(time_str);
		return matcher.matches();
	}
}

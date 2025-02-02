package com.lloyds.clock;

import java.time.LocalTime;

public class Util {

	private Util() {

	}

	public static String getLocalTimeString(TimeFormat timeFormat) {

		StringBuilder time_sb = new StringBuilder();
		LocalTime time = LocalTime.now();

		if (timeFormat == TimeFormat.HHMM)
			time_sb.append(String.format("%02d", time.getHour())).append(":")
					.append(String.format("%02d", time.getMinute()));

		return time_sb.toString();
	}

}

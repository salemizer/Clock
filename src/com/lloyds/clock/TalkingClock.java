package com.lloyds.clock;

public class TalkingClock implements Clock {

	private final TimeFormat inputTimeFormat;

	public TalkingClock() {
		// default pattern
		this(TimeFormat.HHMM);
	}

	public TalkingClock(TimeFormat inputTimeFormat) {
		this.inputTimeFormat = inputTimeFormat;
	}

	public String sayTime(String time) {

		StringBuilder time_sb = new StringBuilder();

		if (time == null || time.equals(""))
			time = Util.getLocalTimeString(inputTimeFormat);

		if (!TimeValidator.isValidTime(time, inputTimeFormat))
			return Constants.GENERIC_VALIDATION_ERROR;

		int hours = Integer.parseInt(time.substring(0, time.indexOf(":")));
		int minutes = Integer.parseInt(time.substring(time.indexOf(":") + 1, time.length()));

		if (minutes == 0)
			time_sb.append(TimeWords.HOURS_IN_WORDS[hours]).append(Constants.SPACE).append(Constants.OCLOCK);

		// minutes > 0
		else if (minutes > 0) {

			// minutes < 30
			if (minutes < 30) {
				// minutes == 15
				if (minutes == 15)
					time_sb.append(Constants.QUARTER).append(Constants.SPACE).append(Constants.PAST)
							.append(Constants.SPACE).append(TimeWords.HOURS_IN_WORDS[hours]);
				// minutes < 30 && minutes == 15
				else
					time_sb.append(TimeWords.MINUTES_IN_WORDS[minutes]).append(Constants.SPACE).append(Constants.PAST)
							.append(Constants.SPACE).append(TimeWords.HOURS_IN_WORDS[hours]);
			}

			else if (minutes == 30)
				time_sb.append(Constants.HALF).append(Constants.SPACE).append(Constants.PAST).append(Constants.SPACE)
						.append(TimeWords.HOURS_IN_WORDS[hours]);

			// minutes greater than 30
			else {
				int remaining = 60 - minutes;
				hours = (hours + 1 == 24) ? 0 : hours + 1;
				time_sb.append((remaining == 15) ? Constants.QUARTER : TimeWords.MINUTES_IN_WORDS[remaining])
						.append(Constants.SPACE).append(Constants.TO).append(Constants.SPACE)
						.append(TimeWords.HOURS_IN_WORDS[hours]);
			}
		}

		return time_sb.toString();
	}
}

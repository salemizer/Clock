package com.lloyds.clock;

public class ClockDemo {

	private ClockDemo() {
	}

	public static void main(String[] args) {

		Clock clock = new TalkingClock(TimeFormat.HHMM);
		String time_str = (args.length == 0) ? "" : args[0];

		String t = clock.sayTime(time_str);
		System.out.println(t);
	}
}

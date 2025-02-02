package com.lloyds.clock;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

public class TalkingClockTest {

	private static TimeFormat hhmm;
	private static TimeFormat hhmmss;

	@BeforeAll
	static void init() {
		hhmm = TimeFormat.HHMM;
		hhmmss = TimeFormat.HHMMSS;
	}

	@Test
	void sayTime_MatchTimeFormat() {
		Clock clock = new TalkingClock(hhmm);
		assertEquals("One past One", clock.sayTime("01:01"));
	}

	@Disabled("Yet, hhmm is the only supported format")
	@Test
	void sayTime_Failure_DifferentTimeFormat() {
		Clock clock = new TalkingClock(hhmmss);
		assertEquals("One past One zero one", clock.sayTime("01:01:01"));
	}

	// No time format provided default is HHMM
	@Test
	void sayTime_Failure_DefaultTimeFormat() {
		Clock clock = new TalkingClock();
		assertEquals("One past One", clock.sayTime("01:01"));
	}

	@Test
	void sayTime_currLocalTime() {
		Clock clock = new TalkingClock();
		String expected = clock.sayTime(Util.getLocalTimeString(hhmm));
		assertEquals(expected, clock.sayTime(null));
	}

}

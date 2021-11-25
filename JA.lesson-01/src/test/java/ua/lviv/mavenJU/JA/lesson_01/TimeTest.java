package ua.lviv.mavenJU.JA.lesson_01;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestWatcher;

public class TimeTest {
	private Time time;
	private Time time1;
	private Time time2;

	@Rule
	public TestWatcher testWatcher = new TestWatcher() {
		protected void failed(Throwable e, org.junit.runner.Description description) {
			System.out.println("FAILED--> " + description.getMethodName());
		};

		protected void succeeded(org.junit.runner.Description description) {
			System.out.println("SUCCEED--> " + description.getMethodName());
		};
	};

	@Before
	public void beforeTest() throws IncorectTimeException {
		time1 = new Time(22,15);
		time2 = new Time(0,50);
	}

	@After
	public void afterTest() {
		time = null;
		time1 = null;
		time2 = null;
	}
	@Test
	public void calcualteTimeTest() throws IncorectTimeException {
		Integer realIntTime = Time.timeToMinutes(Time.calcualteTime(time1, time2));
		Integer expTime = 1385;

		Assert.assertEquals(expTime, realIntTime);
	}
	@Test
	public void getHourTest() {
		Assert.assertEquals(22, time1.getHour());
	}
	@Test
	public void getMinTest() {
		Assert.assertEquals(50, time2.getMin());
	}
}

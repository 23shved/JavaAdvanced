package ua.lviv.mavenJU.JA.lesson_01;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestWatcher;

public class ScheduleTest {
	
	private Schedule sc;
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
	public void beforeTest(){
		sc = new Schedule();
	}
	
	@After
	public void afterTest() {
		sc = null;
	}
	
	@Test 
	public void addTestTitle() throws IncorectTimeException {
		sc.addSeance(new Seance(new Movie("Title", new Time(12, 14)), new Time(12,12)));
		String expTitle = "Title";
		String realTitle = sc.getSeanceMovie("Title").getMovie().getTitle();
		Assert.assertEquals(expTitle, realTitle);
	}
	@Test 
	public void addTestHour() throws IncorectTimeException {
		sc.addSeance(new Seance(new Movie("Title", new Time(12, 14)), new Time(12,12)));
		Integer expHour = 12;
		Integer realTime = sc.getSeanceMovie("Title").getMovie().getDuration().getHour();
		Assert.assertEquals(expHour, realTime);
	}
	@Test (timeout = 1000)
	public void runtimeTest() throws IncorectTimeException, InterruptedException {
		sc.addSeance(new Seance(new Movie("Title", new Time(12, 14)), new Time(12,12)));
		Thread.sleep(999);
	}
}

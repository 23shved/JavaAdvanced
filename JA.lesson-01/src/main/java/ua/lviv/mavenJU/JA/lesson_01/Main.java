package ua.lviv.mavenJU.JA.lesson_01;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws IncorectTimeException {
	Time 	time1 = new Time(22,15);
		Time time2 = new Time(0,50);
		
		Integer realIntTime = Time.timeToMinutes(Time.calcualteTime(time1, time2));

		System.out.println(realIntTime);

		Cinema c = new Cinema();
		Scanner sc = new Scanner(System.in);
		
		while(true) {
			Menu();
			switch (sc.nextInt()) {
			case 1: {
				c.addMovie();
				break;
			}
			case 2: {
				c.removeMovie();
				break;
			}
			case 3: {
				c.addSeanceExist();
				break;
			}
			case 31: {
				c.addSeanceNotExist();
				break;
			}
			case 4: {
				c.removeSeance();
				break;
			}
			case 5: {
				c.showAllMovie();
				break;
			}
			case 6: {
				c.showSchedule();
				break;
			}
		}
	}
	}

	static void Menu() {

		System.out.println("1 --- Create movie");
		System.out.println("2 --- Remove movie");
		System.out.println("3 --- Create seance");
		System.out.println("31 -- Create seance if movie is not existing");
		System.out.println("4 --- Remove seance");
		System.out.println("5 --- Show library");
		System.out.println("6 --- Show schedule");
	}
}

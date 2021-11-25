package ua.lviv.mavenJU.JA.lesson_01;

public class IncorectTimeException extends Exception {
	static final String message = "Incorect input";
	
	public IncorectTimeException() {
		super(message);
	}
}

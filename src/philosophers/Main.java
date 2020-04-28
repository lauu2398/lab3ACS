package philosophers;

public class Main {

private static int nbPhilosophers=5;


public static void main(String[] args) {
	Chopstick chopsticks[]= new Chopstick[nbPhilosophers];
	for(int i=0; i< nbPhilosophers; i++) {
		chopsticks[i]=new Chopstick();
	}
	
	for(int i=0; i< nbPhilosophers; i++) {
		Philosopher philosopher=new Philosopher(i, chopsticks[i], chopsticks[(i+1)%5]);
		philosopher.start();
	}
		
	}
}

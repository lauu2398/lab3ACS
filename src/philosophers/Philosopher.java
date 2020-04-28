package philosophers;
import java.util.*;



public class Philosopher extends Thread {
	
	private int id;
	private Chopstick chopstickRight;
	private Chopstick chopstickLeft;
	
	public Philosopher(int id, Chopstick chopstickRight, Chopstick chopstickLeft) {
		this.id=id;
		this.chopstickRight= chopstickRight;
		this.chopstickLeft= chopstickLeft;
	}
	
	void eat() {
		//si eres zurdo coges izq y luego derecho
		//mientras no seas el ultimo filosofo
		if(id!=4) {
			chopstickRight.getChopstick();
			System.out.println("Philosopher"+id+" grabbing chopstick right "+id);
			// llamada bloqueante ver si lo puedo coger
			chopstickLeft.getChopstick();
			System.out.println("Philosopher"+id+" grabbing chopstick left "+ (id+1)%5);
		}else {
			chopstickLeft.getChopstick();
			System.out.println("Philosopher"+id+" grabbing chopstick left "+ (id+1)%5);
			// llamada bloqueante ver si lo puedo coger
			chopstickRight.getChopstick();
			System.out.println("Philosopher"+id+" grabbing chopstick right "+id);
		}
		
		System.out.println("Philosopher"+ id + " oh my god NOODLES!!! ");
	
		chopstickLeft.releaseChopstick();
		System.out.println("Philosopher"+id+" releasing chopstick left "+ (id+1)%5);
		chopstickRight.releaseChopstick();
		System.out.println("Philosopher"+id+" releasing chopstick right "+id);
		//si todos tienen el mismo tenedor-> esperar
		//tiempo comer ale
	}
	
	void think(){
		System.out.println("Philosopher"+ id + " thinking, I'm hungry....:(");
		//tiempo aleatorio
	}
	
	public void run() {
		while(true) {
			think();
			SleepUtilities.nap();
			eat();
			SleepUtilities.nap();
		}
	}
}

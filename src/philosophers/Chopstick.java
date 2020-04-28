package philosophers;

public class Chopstick {

	private boolean taken=false;
	
	//5 instancias
	
	
	 synchronized void getChopstick() {
		 try {
		 	while(taken) {
				wait();
				}
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		taken=true;
		
	}
	
	 synchronized void releaseChopstick() {
		taken=false;
		notify();
	}
}

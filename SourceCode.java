
//Imports all needed for the code.
import java.util.ArrayList;
import java.util.concurrent.Semaphore;

public class Main {
	
	static int laps = 10; // Used to keep track of the total laps needed to complete the race.
	
	// Semaphores for all the resources needed by the cars.
	static Semaphore battery = new Semaphore(0,true);
	static Semaphore refreshment = new Semaphore(0,true);
	static Semaphore tires = new Semaphore(0,true);
	
	// ArrayList to hold all the names of all the cars that finish the race once they have finished and keeps track of when all the racers are done.
	static ArrayList<String> finished = new ArrayList<String>();
	
// Thread for car type A.
static class CarTypeA extends Thread{
		
	
		String Name = "";
		
		// Create the stopVal for the # of laps needed until there is a stop.  (between 3 and 6)
		int stopVal = (int)(Math.random()*(6-3+1)+3);  
		
		// Assigns the specific race car a name from the string that is passed in.
		CarTypeA(String Name){
			this.Name = Name;
		}
		
		@Override
		public void run() {
		
			// For loop to represent the laps that the racer is driving, it finishes once the racer completes all the laps.
			for (int i = 1; i <= laps;i++) {
				
				// Decrements the amount of laps til a stop is needed, so that when it is 0 the racer knows its time for a stop.
				stopVal = stopVal - 1;
				
				// Once the stopVal is equal to 0 this means that it is time for the racer to stop, so the if statement checks for that.
				if (stopVal == 0) {
					
					// Produces an output to alert the user that the racer has made a stop.
					System.out.println(Name + " has stopped at the general refreshments table.");
				
					try {
								// Driver takes time to pick up his own supply of tires
								Thread.sleep(1000);
								// Since this car type has an unlimited amount of tires, it only needs to take battery and refreshments, if none are available the driver waits, when they are available the driver takes some.
								battery.acquire(); 
								refreshment.acquire();
								
								// Driver takes time to apply the resources (fixes tires, consume refreshments, change battery)
								Thread.sleep(2000);
								
								// Output lets user know that the race car has finished and will not be back on the track.
								System.out.println(Name + " has replenished their needs and has returned to the race.");
								
								// Generates a new stopVal for how many laps till the car will need to stop to replenish again. (between 3 and 6)
								stopVal = (int)(Math.random()*(6-3+1)+3); 
		
						
							
						
					} catch (InterruptedException e) {
					
					}
					
				}
				
			
				try {
					
					// Time it takes to complete one drive around the track.
					Thread.sleep(1000);
				} catch (InterruptedException e) {
				}
				
				// Output lets the user know that the race car has completed the current lap and what # lap it is.
				System.out.println(Name + " has completed lap #" + i);
			
		}
			// Once the race car has finished all the laps, the race car's named is added to the finished Arraylist.
			finished.add(Name);
			
			// Output lets the user know the name of the car and in what place the car has finished in the race. 
			System.out.println(Name + " is car number " + finished.size() + " to finish the race.");
			
		}
			

	}

static class CarTypeB extends Thread{ 
	

	String Name = "";
		
		// Create the stopVal for the # of laps needed until there is a stop.  (between 3 and 6)
		int stopVal = (int)(Math.random()*(6-3+1)+3);  
		
		// Assigns the specific race car a name from the string that is passed in.
		CarTypeB(String Name){
			this.Name = Name;
		}
		
		@Override
		public void run() {
		
			// For loop to represent the laps that the racer is driving, it finishes once the racer completes all the laps.
			for (int i = 1; i <= laps;i++) {
				
				// Decrements the amount of laps til a stop is needed, so that when it is 0 the racer knows its time for a stop.
				stopVal = stopVal - 1;
				
				// Once the stopVal is equal to 0 this means that it is time for the racer to stop, so the if statement checks for that.
				if (stopVal == 0) {
					
					// Produces an output to alert the user that the racer has made a stop.
					System.out.println(Name + " has stopped at the general refreshments table.");
				
					try {
								// Driver takes time to pick up his own supply of batteries
								Thread.sleep(1000);
								// Since this car type has an unlimited amount of batteries, it only needs to take tires and refreshments, if none are available the driver waits, when they are available the driver takes some.
								tires.acquire(); 
								refreshment.acquire();
								
								// Driver takes time to apply the resources (fixes tires, consume refreshments, change battery)
								Thread.sleep(2000);
								
								// Output lets user know that the race car has finished and will not be back on the track.
								System.out.println(Name + " has replenished their needs and has returned to the race.");
								
								// Generates a new stopVal for how many laps till the car will need to stop to replenish again. (between 3 and 6)
								stopVal = (int)(Math.random()*(6-3+1)+3); 
			
						
							
						
					} catch (InterruptedException e) {
					
					}
					
				}
				
			
				try {
					
					// Time it takes to complete one drive around the track.
					Thread.sleep(1000);
				} catch (InterruptedException e) {
				}
				
				// Output lets the user know that the race car has completed the current lap and what # lap it is.
				System.out.println(Name + " has completed lap #" + i);
			
		}
			// Once the race car has finished all the laps, the race car's named is added to the finished Arraylist.
			finished.add(Name);
			
			// Output lets the user know the name of the car and in what place the car has finished in the race. 
			System.out.println(Name + " is car number " + finished.size() + " to finish the race.");
			
		}

	}

	static class CarTypeC extends Thread{
		String Name = "";
		
		// Create the stopVal for the # of laps needed until there is a stop.  (between 3 and 6)
		int stopVal = (int)(Math.random()*(6-3+1)+3);  
		
		// Assigns the specific race car a name from the string that is passed in.
		CarTypeC(String Name){
			this.Name = Name;
		}
		
		@Override
		public void run() {
		
			// For loop to represent the laps that the racer is driving, it finishes once the racer completes all the laps.
			for (int i = 1; i <= laps;i++) {
				
				// Decrements the amount of laps til a stop is needed, so that when it is 0 the racer knows its time for a stop.
				stopVal = stopVal - 1;
				
				// Once the stopVal is equal to 0 this means that it is time for the racer to stop, so the if statement checks for that.
				if (stopVal == 0) {
					
					// Produces an output to alert the user that the racer has made a stop.
					System.out.println(Name + " has stopped at the general refreshments table.");
				
					try {
								// Driver takes time to pick up his own supply of refreshments
								Thread.sleep(1000);
								// Since this car type has an unlimited amount of refreshments, it only needs to take battery and tiress, if none are available the driver waits, when they are available the driver takes some.
								battery.acquire(); 
								tires.acquire();
								
								// Driver takes time to apply the resources (fixes tires, consume refreshments, change battery)
								Thread.sleep(2000);
								
								// Output lets user know that the race car has finished and will not be back on the track.
								System.out.println(Name + " has replenished their needs and has returned to the race.");
								
								// Generates a new stopVal for how many laps till the car will need to stop to replenish again. (between 3 and 6)
								stopVal = (int)(Math.random()*(6-3+1)+3); 
			
						
							
						
					} catch (InterruptedException e) {
					
					}
					
				}
				
			
				try {
					
					// Time it takes to complete one drive around the track.
					Thread.sleep(1000);
				} catch (InterruptedException e) {
				}
				
				// Output lets the user know that the race car has completed the current lap and what # lap it is.
				System.out.println(Name + " has completed lap #" + i);
			
		}
			// Once the race car has finished all the laps, the race car's named is added to the finished Arraylist.
			finished.add(Name);
			
			// Output lets the user know the name of the car and in what place the car has finished in the race. 
			System.out.println(Name + " is car number " + finished.size() + " to finish the race.");
			
		}
	}
	
static class SupplyC extends Thread{
		
		@Override
		public void run() {
			
			
			// Tracks to see when all the cars are finished so the supply coordinator doesn't need to release anymore resources. 
				while (finished.size() != 6) {
						
					
					// Checks to see if the table is clear, if it is then the supply coordinator knows to release some resources onto the table.
						if (battery.availablePermits() == 0 && refreshment.availablePermits() == 0 && tires.availablePermits() == 0 ) {
							
							// Sets a random value between 1 and 3 to know which set of resources to put out.
							int supplyVal = (int)(Math.random()*(3-1+1)+1); 
		
							// if else statement to decide which of the  3 different sets of combinations of 2 different resources to release using the random val.
							// includes an output informing the user what the supply coordinator has put out on the table.
							if (supplyVal == 2) {
								battery.release();
								refreshment.release();
								
								System.out.println("Supply Coordinator has placed battery and refreshments out on the table.");
							}
							else if (supplyVal == 1) {
								refreshment.release();
								tires.release();
								
								System.out.println("Supply Coordinator has placed tires and refreshments out on the table.");
							}
							else if (supplyVal == 3) {
								battery.release();
								tires.release();
								
								System.out.println("Supply Coordinator has placed battery and tires out on the table.");
							}
							
							try {
								
								// Supply Coordinator needs time to restock the table.
								Thread.sleep(2000);
								} catch (InterruptedException e) {
									
								}
							
							
							
						}
						
						// In case a driver takes one resource and leaves another, the supply coordinator knows to replace it with something that isn't already on the table. It is randomly generated between the last two options that could be added to the table.
						// It goes through the different cases that could happen.
						else if (battery.availablePermits() == 0 && refreshment.availablePermits() == 0) {
							int count = (int)(Math.random()*(2-1+1)+1); 
							
							if (count == 1) {
								battery.release();
								System.out.println("Supply Coordinator has placed battery on the table.");
							} else {
								refreshment.release();
								System.out.println("Supply Coordinator has placed refreshment on the table.");
							}
							
							try {
								Thread.sleep(2000);
								} catch (InterruptedException e) {
									
								}
						}
						
						else if (battery.availablePermits() == 0 && tires.availablePermits() == 0) {
							int count = (int)(Math.random()*(2-1+1)+1); 
							
							if (count == 1) {
								battery.release();
								System.out.println("Supply Coordinator has placed battery on the table.");
							} else {
								tires.release();
								System.out.println("Supply Coordinator has placed tires on the table.");
							}
							
							try {
								Thread.sleep(2000);
								} catch (InterruptedException e) {
									
								}
						}
						
						else if (tires.availablePermits() == 0 && refreshment.availablePermits() == 0) {
							int count = (int)(Math.random()*(2-1+1)+1); 
							
							if (count == 1) {
								tires.release();
								System.out.println("Supply Coordinator has placed tires on the table.");
							} else {
								refreshment.release();
								System.out.println("Supply Coordinator has placed refreshment on the table.");
							}
							
							try {
								Thread.sleep(2000);
								} catch (InterruptedException e) {
									
								}
						} else {
							// In case none of the resources are used within a given time frame, the supply coordinator takes the resources off the table and puts a new set of two.
							try {
								Thread.sleep(5000);
								
								if (tires.availablePermits() > 0 && refreshment.availablePermits() > 0) {
									tires.acquire();
									refreshment.acquire();
								} else if (battery.availablePermits() > 0 && refreshment.availablePermits() > 0) {
									battery.acquire();
									refreshment.acquire();
								} if (tires.availablePermits() > 0 && battery.availablePermits() > 0) {
									tires.acquire();
									battery.acquire();
								}
								
								} catch (InterruptedException e) {
									
								}
							
							
							
							
							
						}
					}
		}

	}
	
	public static void main(String[] args) {
		
		// Defines and starts the supply coordinator.
		SupplyC SupplyCoordinator = new SupplyC();
		SupplyCoordinator.start();
		
		// Defines and starts all six race cars and provides them each with a name.
		CarTypeA racer1 = new CarTypeA("Racer 1");
		racer1.start();
		
		CarTypeB racer2 = new CarTypeB("Racer 2");
		racer2.start();
		
		CarTypeC racer3 = new CarTypeC("Racer 3");
		racer3.start();
		
		CarTypeA racer4 = new CarTypeA("Racer 4");
		racer4.start();
		
		CarTypeB racer5 = new CarTypeB("Racer 5");
		racer5.start();
		
		CarTypeC racer6 = new CarTypeC("Racer 6");
		racer6.start();

	}

}

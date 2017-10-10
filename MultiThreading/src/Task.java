
class Task implements Runnable {
 private String task;
	public Task(String task){
		this.task=task;
	}
public void run(){
	System.out.println(" Name  "+task+" \n");
}
}

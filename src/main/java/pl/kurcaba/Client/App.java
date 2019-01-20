package pl.kurcaba.Client;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	for(int i = 0;i<100;i++)
    	{
    		try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
	        Thread clientThread = new Thread(new Client());
	        clientThread.run();
    	}
    }
}

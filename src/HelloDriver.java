
public class HelloDriver 
{
	public static void main(String[] args) throws Exception
	{
		int portNumber = 9999;
		String restClassPackage = "app.rest";
		String applicationContext = "applicationContext.xml";

		new JerseyStarter().start(portNumber, restClassPackage, applicationContext);
	}
}

import org.testng.annotations.BeforeMethod;
public class PS {
public void doThis() {
	System.out.println("I am here");
	
}
 @BeforeMethod
public void beforeRun() {
	System.out.println("Run me first");
}

}

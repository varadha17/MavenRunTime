package RunTimeTest;

import Base.BaseTest;
import org.testng.annotations.Test;

import java.io.IOException;

public class runTimeTesting {

    public BaseTest base = new BaseTest();

    @Test
    public void runMavenCommand() throws IOException {
        base.setUp();
        base.setUserCredentialsAtRunTime();
    }
}

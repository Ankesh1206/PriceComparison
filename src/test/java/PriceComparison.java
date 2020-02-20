import ApplicationUtilities.ApplicationLibrary;
import PublicUtilities.Constant;
import PublicUtilities.PublicLibrary;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class PriceComparison {
    private ApplicationLibrary applicationLibrary;
    private PublicLibrary publicLibrary;


    public PriceComparison()
    {
        applicationLibrary=new ApplicationLibrary();
        publicLibrary=new PublicLibrary();
    }


    @BeforeTest
    public void beforeTest()
    {
        publicLibrary.setUp(Constant.chromeBrowser);
        publicLibrary.maximizeBrowser();
    }


    @Test
    public void priceComparisonTest()
    {
        applicationLibrary.priceComparator();
    }


    @AfterTest
    public void afterTest()
    {
        publicLibrary.quitBrowser();
    }
}

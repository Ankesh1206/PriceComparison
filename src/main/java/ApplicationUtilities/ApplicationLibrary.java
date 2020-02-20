package ApplicationUtilities;

import PublicUtilities.Constant;
import PublicUtilities.PublicLibrary;
import javafx.scene.chart.ScatterChart;
import org.openqa.selenium.WebElement;

import java.text.ParseException;
import java.util.NoSuchElementException;

public class ApplicationLibrary {
    public PublicLibrary publicLibrary;

    public ApplicationLibrary()
    {
        publicLibrary=new PublicLibrary();
    }

    /**
     * @return Item Price from flipkart Application
     */
    public String getObjectPriceFromFlipkart()
    {
        WebElement element=null;
        publicLibrary.navigateToUrl(Constant.flipkartUrl);
        publicLibrary.clickElement(ApplicationObjects.loginCloseButton);
        publicLibrary.setText(ApplicationObjects.flipkartSearchBox,Constant.searchItemName);
        publicLibrary.clickElement(ApplicationObjects.flipkartSearchButton);
        try {
            element = PublicLibrary.driver.findElement(ApplicationObjects.flipkartItemPriceSection);
        }
        catch (NoSuchElementException e)
        {
            System.out.println("Item not present in the application");
        }
        return element.getText().substring(1).replaceAll(",","");
    }

    /**
     * Method to compare the items price
     */
    public void priceComparator()
    {
        double flipkartItemPrice = Double.parseDouble(getObjectPriceFromFlipkart());
        double amazonItemPrice = Double.parseDouble(getObjectPriceFromAmazon());
        if (amazonItemPrice > flipkartItemPrice) {
            System.out.println("Item price is lesser in Flipkart(" + flipkartItemPrice + ") than Amazon(" + amazonItemPrice + ")");
        } else if (amazonItemPrice==flipkartItemPrice) {
            System.out.println("Both Application have same price for searched Item =" + amazonItemPrice);
        } else {
            System.out.println("Item price is lesser in Amazon(" + amazonItemPrice + ") than Flipkart(" + flipkartItemPrice + ")");
        }
    }

    /**
     * @return Get the Item price from Amazon Application
     */
    public String getObjectPriceFromAmazon()
    {
        WebElement element=null;
        publicLibrary.navigateToUrl(Constant.amazonUrl);
        publicLibrary.implicitWait(Constant.shortWait);
        element=PublicLibrary.driver.findElement(ApplicationObjects.signinSection);
        publicLibrary.setText(ApplicationObjects.amazonSearchBox,Constant.searchItemName);
        publicLibrary.clickElement(ApplicationObjects.amazonSearchButton);
        try {
            element = PublicLibrary.driver.findElement(ApplicationObjects.amazonItemPriceSection);
        }
        catch (NoSuchElementException e)
        {
            System.out.println("Item not present in the application");
        }
        return element.getText().replaceAll(",","");
    }
}

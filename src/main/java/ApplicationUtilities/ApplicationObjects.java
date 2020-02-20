package ApplicationUtilities;

import org.openqa.selenium.By;

public class ApplicationObjects {
    //flipkart Application Objects
    public static final By loginCloseButton= By.xpath("//button[@class='_2AkmmA _29YdH8']");
    public static final By flipkartSearchBox=By.name("q");
    public static final By flipkartSearchButton=By.xpath("//button[@class='vh79eN']");
    public static final By flipkartItemSection=By.xpath("//div[@class='_1UoZlX']");
    public static final By flipkartItemNameSection=By.xpath("//div[@class='_3wU53n']");
    public static final By flipkartItemPriceSection=By.xpath("//div[@class='_1vC4OE _2rQ-NK']");


    //Amazon Application Objects
    public static final By amazonItemPriceSection=By.xpath("//span[@class='a-price-whole']");
    public static final By amazonSearchBox=By.id("twotabsearchtextbox");
    public static final By amazonSearchButton=By.xpath("(//input[@class='nav-input'])[1]");
    public static final By signinSection=By.id("nav-signin-tooltip");
}

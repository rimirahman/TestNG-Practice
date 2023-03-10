package utils;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.Duration;

public class Utils {
    public static void doScroll(WebDriver driver, int heightPixel){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,"+heightPixel+")");
    }
    public static JSONObject loadJSONFile(String fileLocation) throws IOException, ParseException {
        JSONParser jsonParser = new JSONParser();
        Object obj = jsonParser.parse(new FileReader(fileLocation));
        JSONObject jsonObject = (JSONObject) obj;
        return jsonObject;

    }

    public static void waitForElement(WebDriver driver, WebElement webElement,int timeunit_sce){
        WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(timeunit_sce));
        wait.until(ExpectedConditions.visibilityOf(webElement));
    }

    public static int generateRandomNumber(int min,int max){
       return (int) Math.round(Math.random()*(max-min)+min);

    }

    public static void addJsonArray(String firstName,String lastName,String username,String password) throws IOException, ParseException {
        String fileName="./src/test/resources/NewUsers.json";
        JSONParser jsonParser = new JSONParser();
        Object obj = jsonParser.parse(new FileReader(fileName));
        JSONObject userobj=new JSONObject();
        JSONArray jsonArray = (JSONArray) obj;

        userobj.put("firstName",firstName);
        userobj.put("lastName",lastName);
        userobj.put("username",username);
        userobj.put("password",password);
        jsonArray.add(userobj);

        FileWriter file = new FileWriter(fileName);
        file.write(jsonArray.toJSONString());
        file.flush();
        file.close();
    }

    public static void main(String[] args) throws IOException, ParseException {
//        JSONObject userObject=Utils.loadJSONFile("./src/test/resources/User.json");
//
//        String username= (String) userObject.get("username");
//        String password= (String) userObject.get("password");
//
//        System.out.println(username);
//        System.out.println(password);

        //System.out.println(generateRandomNumber(10,50));

        //addJsonArray("testuser","1234");
    }
}

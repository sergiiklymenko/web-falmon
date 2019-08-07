package PageObjects;

import AbstractClasses.PageBase;
import org.openqa.selenium.By;

public class Login extends PageBase {

    private String loginLoc = "//input[@name='email']";
    private String passwordLoc ="//input[@name='password']";
    private String loginBtnLoc = "//button[@type='submit' and contains(text(), 'Log')]";
    public Login() {
        url = url + "auth/login";
    }

    public Login get() {
       getUrl();
       return isLoaded();
    }

    public Login isLoaded(){
       dh.waitForElementToExist(By.xpath("//div[@class='text-center']"));
       return this;
    }

    public Login setLogin(String login) {
       dh.setText(loginLoc, login);
       return this;
    }

    public Login setPassword(String password){
        dh.setText(passwordLoc, password);
        return this;
    }

    public Login clickLogin(){
        dh.waitForElementToBeClickable(By.xpath(loginBtnLoc));
        dh.click(loginBtnLoc);
        return this;
    }

}

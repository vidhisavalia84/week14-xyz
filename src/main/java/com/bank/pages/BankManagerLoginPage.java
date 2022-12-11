package com.bank.pages;

import com.bank.utility.Utility;
import org.openqa.selenium.By;

public class BankManagerLoginPage extends Utility {
    /* click On "Bank Manager Login" Tab
        click On "Add Customer" Tab
        enter FirstName
        enter LastName
        enter PostCode
        click On "Add Customer" Button
        popup display
        verify message "Customer added successfully"
        click on "ok" button on popup.*/
    By addCustomer = By.xpath("//body/div[3]/div[1]/div[2]/div[1]/div[1]/button[1]");


    public void clickOnAddCustomerButton () {
        clickOnElement(addCustomer);
    }
    By openAccount=By.xpath("//button[@ng-click='openAccount()']");

    public void clickOnOpenAccount() {
        clickOnElement(openAccount);
    }
//Customer added successfully with customer id :6

//public String verifyReceivedTextFromPopup(){
 //       return getTextFormAlert();
//}
//public void clickOkOnPopup(){
  //      acceptAlert();





}

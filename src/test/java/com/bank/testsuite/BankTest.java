package com.bank.testsuite;

import com.bank.pages.*;
import com.bank.testbase.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class BankTest extends BaseTest {
    HomePage homePage = new HomePage();
    BankManagerLoginPage bankManager = new BankManagerLoginPage();
    CustomerLoginPage customerLoginPage = new CustomerLoginPage();
    OpenAccountPage openAccount = new OpenAccountPage();
    AccountPage accountPage = new AccountPage();
    AddCustomerPage addCustomer=new AddCustomerPage();

    @Test
    public void sampleTest() {
        System.out.println("passed");
    }

    @Test//1
    public void bankManagerShouldAddCustomerSuccessfully() throws InterruptedException {
        homePage.clickOnBankManagerLoginButton();

        bankManager.clickOnAddCustomerButton();
        Thread.sleep(2000);
        addCustomer.enterFirstName("Krish");
        addCustomer.enterLastName("Patel");
        addCustomer.enterPostCode("Ha3 8LU");
        addCustomer.clickOnAddCustomerButtonAfterEnterInformation();
        //bankManager.enterFirstName("Krish");
       // bankManager.enterLastName("Patel");
        //bankManager.enterPostCode("Ha3 8LU");
       // bankManager.clickOnAddCustomerButtonAfterEnterInformation();
        Assert.assertEquals(addCustomer.verifyReceivedTextFromPopup(), "Customer added successfully with customer id :6");
         addCustomer.clickOkOnPopup();
    }

    @Test//2
    public void bankManagerShouldOpenAccountSuccessfully() throws InterruptedException {
        homePage.clickOnBankManagerLoginButton();
        bankManager.clickOnAddCustomerButton();
        Thread.sleep(2000);
        addCustomer.enterFirstName("Krish");
        addCustomer.enterLastName("Patel");
        addCustomer.enterPostCode("Ha3 8LU");
        addCustomer.clickOnAddCustomerButtonAfterEnterInformation();
        addCustomer.clickOkOnPopup();
        /****************************************************************/
        homePage.clickOnHomeButton();
        homePage.clickOnBankManagerLoginButton();
        openAccount.clickOnOpenAccount();
        openAccount.clickCustomerFromDropDown();
        openAccount.selectCurrencyPoundFromDropDown();
        openAccount.clickOnProcessButton();
        Assert.assertEquals(openAccount.getSuccessfulTextFromPopup(), "Account created successfully with account Number :1016");
        openAccount.clickOkOnPopup();

    }

    @Test//3
    public void customerShouldLoginAndLogoutSuceessfully() throws InterruptedException {
        homePage.clickOnBankManagerLoginButton();
        bankManager.clickOnAddCustomerButton();
        Thread.sleep(2000);
        addCustomer.enterFirstName("Krish");
        addCustomer.enterLastName("Patel");
        addCustomer.enterPostCode("Ha3 8LU");
        addCustomer.clickOnAddCustomerButtonAfterEnterInformation();
        addCustomer.clickOkOnPopup();
        /**************************************************/
        homePage.clickOnHomeButton();
        homePage.clickOnCustomerLoginButton();
        customerLoginPage.selectYourNameFromDropDown();
        customerLoginPage.clickOnLoginButton();
        Assert.assertEquals(customerLoginPage.verifyLogOutText(), "Logout");
        customerLoginPage.cliclOnLogoutButton();
        Assert.assertEquals(customerLoginPage.verifyYourNameText(), "Your Name :");
    }

    @Test//4
    public void customerShouldDepositMoneySuccessfully() throws InterruptedException {
        homePage.clickOnBankManagerLoginButton();
        bankManager.clickOnAddCustomerButton();
        Thread.sleep(2000);
        addCustomer.enterFirstName("Krish");
        addCustomer.enterLastName("Patel");
        addCustomer.enterPostCode("Ha3 8LU");
        addCustomer.clickOnAddCustomerButtonAfterEnterInformation();
        addCustomer.clickOkOnPopup();
        homePage.clickOnHomeButton();
        /**************************************************/
        homePage.clickOnCustomerLoginButton();
       customerLoginPage.selectHarryPotterFromDropDown();
        //customerPage.selectYourNameFromDropDown();
        customerLoginPage.clickOnLoginButton();
        accountPage.clickOnDepositButton();
        accountPage.enterAmountIntoDepositFeild("100");
        accountPage.clickOnDepositButtonAfterEnterAmount();
        Assert.assertEquals(accountPage.verifyDepositSuccessfulMessage(),"Deposit Successful");
    }
    @Test
    public void customerShouldWithdrawMoneySuccessfully(){


        homePage.clickOnCustomerLoginButton();
       // customerPage.selectYourNameFromDropDown();
        customerLoginPage.selectHarryPotterFromDropDown();
        customerLoginPage.clickOnLoginButton();
        accountPage.clickOnDepositButton();
        accountPage.enterAmountIntoDepositFeild("100");
        accountPage.clickOnDepositButtonAfterEnterAmount();
                homePage.clickOnHomeButton();

        /*****************************************************/
        homePage.clickOnCustomerLoginButton();
        //customerPage.selectYourNameFromDropDown();
        customerLoginPage.selectHarryPotterFromDropDown();
        customerLoginPage.clickOnLoginButton();
        accountPage.clickOnWithdrawlButton();
        accountPage.enterAmountYouWishToWithdrawl("10");
        accountPage.clickOnWithdrawlButtonAfterEnterAmount();
        Assert.assertEquals(accountPage.verifyTransactionSuccessfulMessage(),"Transaction successful","transaction unsuccessful");


    }
}

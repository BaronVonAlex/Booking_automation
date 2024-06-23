package ge.tbc.tbcacademy.steps.booking;

import ge.tbc.tbcacademy.pages.BookingRegisterPage;
import io.qameta.allure.Step;

public class BookingRegistrationSteps {
    BookingRegisterPage bookingRegisterPage = new BookingRegisterPage();

    @Step("Return Text from Booker.com Header Button.")
    public String getPageHeaderText() {
        return bookingRegisterPage.registerPageHeader.getText();
    }

    @Step("Click on Submit Button.")
    public BookingRegistrationSteps clickOnSubmitBtn() {
        bookingRegisterPage.submitBtn.click();
        return this;
    }

    @Step("Input text on Mail input field.")
    public BookingRegistrationSteps inputMailAddress(String mail) {
        bookingRegisterPage.emailInputField.sendKeys(mail);
        return this;
    }

    @Step("Return Error Message from Incorrectly put Mail Address")
    public String getIncorrectMailMsg(){
        return bookingRegisterPage.gmailErrorMessage.getText();
    }

    @Step("Input Password on Main Password Field.")
    public BookingRegistrationSteps inputPassword(String password) {
        bookingRegisterPage.passwordInputField.sendKeys(password);
        return this;
    }

    @Step("Input Password on Confirmation Password Field.")
    public BookingRegistrationSteps inputConfirmationPassword(String password) {
        bookingRegisterPage.confirmationPasswordInputField.sendKeys(password);
        return this;
    }

    @Step("Return Error Message from Incorrectly put Password.")
    public String getPasswordErrMsgTxt() {
        return bookingRegisterPage.passwordErrorMessage.getText();
    }

    @Step("Return Error Message from Incorrectly put Password and Confirmation Password.")
    public String getUnmatchingPasswordErrMsgTxt() {
        return bookingRegisterPage.confirmPasswordErrorMessage.getText();
    }
}

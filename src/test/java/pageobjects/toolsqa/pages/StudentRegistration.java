package pageobjects.toolsqa.pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import java.io.File;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;
import static pageobjects.toolsqa.fragments.RowFragment.checkRowValue;


public class StudentRegistration {
    private final SelenideElement firstNameInput = $("[id=firstName]");
    private final SelenideElement lastNameInput = $("[id=lastName]");
    private final SelenideElement userEmailInput = $("[id=userEmail]");
    private final SelenideElement genderMaleRadioBtn = $("[id=gender-radio-1]");
    private final SelenideElement genderFemaleRadioBtn = $("[id=gender-radio-2]");
    private final SelenideElement genderOtherRadioBtn = $("[id=gender-radio-3]");
    private final SelenideElement userNumberInput = $("[id=userNumber]");
    private final SelenideElement dateOfBirthCalendar = $("[id=dateOfBirthInput]");
    private final SelenideElement monthDropdown = $(By.className("react-datepicker__month-select"));
    private final SelenideElement yearDropdown = $(By.className("react-datepicker__year-select"));
    private final SelenideElement dayInput = $x("//div[contains(@class, 'react-datepicker__day--')]");
    private final SelenideElement subjectsDropdown = $("[id=subjectsInput]");
    private final SelenideElement hobbiesSportsCheckbox = $("label[for='hobbies-checkbox-1']");
    private final SelenideElement hobbiesReadingCheckbox = $("label[for='hobbies-checkbox-2']");
    private final SelenideElement hobbiesMusicCheckbox = $("label[for='hobbies-checkbox-3']");
    private final SelenideElement uploadPictureBtn = $("[id=uploadPicture]");
    private final SelenideElement currentAddressInput = $("[id=currentAddress]");
    private final SelenideElement stateDropdown = $("[id=state]");
    private final SelenideElement cityDropdown = $("[id=city]");
    private final SelenideElement submitBtn = $("[id=submit]");
    private final SelenideElement closeLargeModalBtn = $("[id=closeLargeModal]");

    public StudentRegistration typeFirstName(String firstname) {
        firstNameInput.val(firstname);
        return this;
    }

    public StudentRegistration typeLastName(String lastname) {
        lastNameInput.val(lastname);
        return this;
    }

    public StudentRegistration typeEmail(String email) {
        userEmailInput.val(email);
        return this;
    }

    public StudentRegistration selectGender(String gender) {
        if (gender.equals("Male")) this.genderMaleRadioBtn.doubleClick();
        if (gender.equals("Female")) this.genderFemaleRadioBtn.doubleClick();
        if (gender.equals("Other")) this.genderOtherRadioBtn.doubleClick();
        return this;
    }

    public StudentRegistration typeMobile(String number) {
        userNumberInput.val(number);
        return this;
    }

    public StudentRegistration addDateOfBirth(String month, String year) {
        dateOfBirthCalendar.click();
        monthDropdown.selectOption(month);
        yearDropdown.selectOptionByValue(year);
        // set specific date later on
        dayInput.click();
        return this;
    }

    public StudentRegistration typeSubjects(String subject) {
        subjectsDropdown.val(subject).pressEnter();
        return this;
    }

    public StudentRegistration selectHobbies() {
        hobbiesSportsCheckbox.click();
        hobbiesMusicCheckbox.click();
        hobbiesReadingCheckbox.click();
        return this;
    }

    public StudentRegistration uploadPicture(String file) {
        uploadPictureBtn.uploadFile(new File(file));
        return this;
    }

    public StudentRegistration typeAddress(String address) {
        currentAddressInput.val(address);
        return this;
    }

    public StudentRegistration selectState(String state) {
        stateDropdown.scrollIntoView(true).click();
        stateDropdown.$x(".//input").val(state).shouldBe(visible).pressEnter();
        return this;
    }

    public StudentRegistration selectCity(String city) {
        cityDropdown.click();
        cityDropdown.$x(".//input").val(city).shouldBe(visible).pressEnter();
        return this;
    }

    public void submitForm() {
        submitBtn.shouldBe(visible).click();
    }

    public void closeSubmitModal() {
        closeLargeModalBtn.scrollIntoView(true).shouldBe(visible).click();
    }

    public void verifyAllFilledCorrect(String firstName, String lastName, String email, String gender, String mobile,
                                       String day, String month, String year, String subject,
                                       String hobbies, String fileName, String address, String state, String city) {
        checkRowValue("Student Name", firstName + " " + lastName);
        checkRowValue("Student Email", email);
        checkRowValue("Gender", gender);
        checkRowValue("Mobile", mobile);
        checkRowValue("Date of Birth", day + " " + month + "," + year);
        checkRowValue("Subjects", subject);
        checkRowValue("Hobbies", hobbies);
        checkRowValue("Picture", fileName);
        checkRowValue("Address", address);
        checkRowValue("State and City", state + " " + city);
    }


}

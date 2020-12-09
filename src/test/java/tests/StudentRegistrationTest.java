package tests;

import com.github.javafaker.Faker;
import com.github.javafaker.service.FakeValuesService;
import com.github.javafaker.service.RandomService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pageobjects.toolsqa.pages.StudentRegistration;

import java.util.Locale;

import static com.codeborne.selenide.Selenide.open;

public class StudentRegistrationTest {

    @Test
    @DisplayName("Submit and verify form data")
    void shouldSubmitForm() {

        Faker faker = new Faker();
        FakeValuesService fakeValuesService = new FakeValuesService(
                new Locale("en-GB"), new RandomService());


        String firstName = faker.name().firstName();
        String lastName = faker.name().lastName();
        String email = faker.internet().emailAddress();
        String gender = "Male";
        String month = "September";
        String year = "1991";
        String day = "01";
        String fileName = "redoc.png";
        String subject = "Computer Science";
        String hobbies = "Sports, Music, Reading";
        String mobile = "1234567890";
        String address = "Washington D.C.";
        String state = "NCR";
        String city = "Delhi";

        open("https://demoqa.com/automation-practice-form");

        StudentRegistration form = new StudentRegistration();
        form.typeFirstName(firstName)
                .typeLastName(lastName)
                .typeEmail(email)
                .selectGender(gender)
                .typeMobile(mobile)
                .addDateOfBirth(month, year)
                .typeSubjects(subject)
                .selectHobbies()
                .uploadPicture("src/test/resources/" + fileName)
                .typeAddress(address)
                .selectState(state)
                .selectCity(city)
                .submitForm();

        form.verifyAllFilledCorrect(firstName, lastName, email, gender, mobile, day, month, year, subject,
                hobbies, fileName, address, state, city);
    }
}

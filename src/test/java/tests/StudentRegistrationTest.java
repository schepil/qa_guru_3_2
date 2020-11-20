package tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pageobjects.toolsqa.pages.StudentRegistration;

import static com.codeborne.selenide.Selenide.open;

public class StudentRegistrationTest {

    @Test
    @DisplayName("Submit and verify form data")
    void shouldSubmitForm() {
        String firstName = "Fox",
                lastName = "Mulder",
                email = "fox.mulder@fbi.com",
                gender = "Male",
                month = "September",
                year = "1991",
                day = "01",
                file = "Toolsqa.jpg",
                subject = "Computer Science",
                hobbies = "Sports, Music, Reading",
                mobile = "1234567890",
                address = "Washington D.C.",
                state = "NCR",
                city = "Delhi";


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
                .uploadPicture(file)
                .typeAddress(address)
                .selectState(state)
                .selectCity(city)
                .submitForm();

        form.verifyAllFilledCorrect(firstName,lastName, email, gender, mobile, day, month, year, subject,
                hobbies, file, address, state, city);

        form.closeSubmitModal();

        System.out.print("");
    }
}

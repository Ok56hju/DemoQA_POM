package com.demoqa.tests;

import com.demoqa.pages.HomePage;
import com.demoqa.pages.PracticeFormPage;
import com.demoqa.pages.SidePanel;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class PracticeFormTest extends TestBase{
    @BeforeMethod
    public void precondition(){
        new HomePage(driver).getForms();
        new SidePanel(driver).selectPracticeForm();
    }

    @Test
    public void createStudentAccount(){
        new PracticeFormPage(driver).hideIfarmes();
        //enter personal data
        new PracticeFormPage(driver).enterPersonalData("Tom","Tomas","ty5@gm.com","1234567893")
        //select gender(radio button)
                .selectGender("Male")
        //enter birthday
                .enterBirthDay("16 August 1987")
        //enter subjects
                .enterSubjects(new String[]{"Maths","Chemistry"})
        //select hobby(check box)
                .selectHobby(new String[]{"Sports","Reading"})
                .uploadFile("C:/Tools/friend5.jpg")
        //select state
                .selectState("NCR")
        //select city
                .selectCity("Delhi")
        //click on submit button
                .clickOnSubmit()
        //assert student form is appears
                .verifySuccessTitle("Thanks for submitting the form")

        ;

    }

}

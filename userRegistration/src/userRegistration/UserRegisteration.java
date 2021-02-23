package com.userregisteration;

import com.userregisteration.InvalidException.java.InvalidInputException;
import com.userregisteration.ParameterisedEntry.ParameterisedEntry;
import org.junit.jupiter.api.Test;

import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertSame;

public class UserRegisterationTest {

    @Test
    void welcomeMessageTest() {
        UserRegistration userRegistration=new UserRegistration();
        String welcomeMessageResult=userRegistration.welcomeMessage("Welcome to user registration");
        assertSame("Welcome to user registration",welcomeMessageResult);
    }

    @Test
    void userFirstNameTest() {
        boolean firstNameResult=UserRegistration.firstNameValidation("Prasanna");
        assertEquals(true, firstNameResult);
    }

    @Test
    void userLastNameTest() {
        boolean lastNameResult=UserRegistration.lastNameValidation("Prasanna Nanda");
        assertEquals(true, lastNameResult);
    }

    @Test
    void userMailTest() {
        boolean emailResult=UserRegistration.emailValidation("abc.xyz@bl.co.in");
        assertEquals(true, emailResult);
    }

    @Test
    void userMobileFormatTest() {
        boolean mobileResult=UserRegistration.mobileFormatValidation("91 9999999999");
        assertEquals(true, mobileResult);
    }

    @Test
    void userMinEightCharacterTest() {
        boolean minCharResult=UserRegistration.minimunCharectersValidation("dESKtop89");
        assertEquals(true, minCharResult);
    }

    @Test
    void userMinUpperCase() {
        boolean minOneUpperCaseResult=UserRegistration.minimunOneUpperCaseValidation("deskTop89");
        assertEquals(true, minOneUpperCaseResult);
    }

    @Test
    void userMinOneNumericCase() {
        boolean minOneNumericCaseResult=UserRegistration.minimunOneNumericCaseValidation("Desktop12789");
        assertEquals(true, minOneNumericCaseResult);
    }

    @Test
    void minOneSpecialCase() {
        boolean minOneSpecialCaseResult=UserRegistration.minimunOneSpecialCaseValidation("Desktop@#12789");
        assertEquals(true, minOneSpecialCaseResult);
    }

    @Test
    void userEntryValidation() {
        UserRegistration userRegistration=new UserRegistration();
        Scanner scanner=new Scanner(System.in);
        System.out.println("Enter first name:");
        String firstName=scanner.nextLine();

        Scanner scanner1=new Scanner(System.in);
        System.out.println("Enter Last name:");
        String lastName=scanner1.nextLine();

        Scanner scanner2=new Scanner(System.in);
        System.out.println("Enter Email");
        String emailId=scanner2.nextLine();

        Scanner scanner3=new Scanner(System.in);
        System.out.println("Enter Mobile Number:");
        String mobileNumber=scanner3.nextLine();

        Scanner scanner4=new Scanner(System.in);
        System.out.println("Enter Password:");
        String password=scanner4.nextLine();

        String userValidation=userRegistration.userEntryValidation(firstName,lastName,emailId,mobileNumber,password);
        assertEquals("happy", userValidation);
    }

    @Test
    void nameTest() {
        try {
            ParameterisedEntry name = new ParameterisedEntry();
            boolean output = name.name1("Bells");
            assertTrue(output);
        } catch (NullPointerException e) {
            e.printStackTrace();
        }
    }

    @Test
    void emailIdTest() throws InvalidInputException {
        try
        {
            ParameterisedEntry newEmail = new ParameterisedEntry();
            boolean output = newEmail.email1("abc1234@gmail.com");
            assertTrue(output);
        }
        catch (NullPointerException e)
        {
            e.printStackTrace();
        }
    }

    @Test
    void mobileTest() throws InvalidInputException {
        try{
        ParameterisedEntry phoneNumber = new ParameterisedEntry();
        boolean output = phoneNumber.mobileNumber1("91 1204356789");
        assertTrue(output);
    }
    catch (NullPointerException e)
    {
        e.printStackTrace();
    }
    }

    @Test
    void passwordTest() {
        try
        {
            ParameterisedEntry passWord = new ParameterisedEntry();
            boolean output = passWord.password1("Thomas#2@87B");
            assertTrue(output);
        }
        catch (NullPointerException e)
        {
            e.printStackTrace();
        }
    }
}

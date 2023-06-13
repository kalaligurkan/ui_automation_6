package scripts;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.Project3Page;
import utils.DropdownHandler;
import utils.Waiter;

import javax.swing.*;

public class _03_ProjectTest extends Base {
    @BeforeMethod
    public void setPage() {
        driver.get(" https://techglobal-training.com/frontend/project-3");
        project3Page = new Project3Page();
    }

    /**
     * Navigate to https://techglobal-training.com/frontend/project-3
     * Validate that the “One way” radio button is displayed enabled and selected by default
     * Validate that the “Round trip” radio button is displayed enabled and not selected by default
     * Validate that the “Cabin Class” label and dropdown are displayed
     * Validate that the “From” label and dropdown are displayed
     * Validate that the “To” label and dropdown are displayed
     * Validate that the “Depart” label and date picker is displayed
     * Validate that the “Return” label and date picker is displayed and disabled
     * Validate that the “Number of passengers” label and dropdown are displayed and 1 is the default
     * Validate that the “Passenger 1” category label and dropdown are displayed and “Adult (16-64)” is the default
     * Validate that the “BOOK” button is displayed and enabled
     */
    @Test(priority = 1, description = "Test Case 01 - Validate the default Book your trip form")
    public void validateTheDefaultBookYourTripForm() {
        Assert.assertTrue(project3Page.oneWayButton.isEnabled());
        Assert.assertTrue(project3Page.oneWayButton.isDisplayed());
        Assert.assertTrue(project3Page.oneWayButton.isSelected());
        Assert.assertTrue(project3Page.roundTripButton.isEnabled());
        Assert.assertTrue(project3Page.roundTripButton.isDisplayed());
        Assert.assertFalse(project3Page.roundTripButton.isSelected());
        Assert.assertTrue(project3Page.cabinClassDropdown.isDisplayed());
        Assert.assertTrue(project3Page.cabinClassLabel.isDisplayed());
        Assert.assertTrue(project3Page.from.isDisplayed());
        Assert.assertTrue(project3Page.fromDropdown.isDisplayed());
        Assert.assertTrue(project3Page.to.isDisplayed());
        Assert.assertTrue(project3Page.toDropdown.isDisplayed());
        Assert.assertTrue(project3Page.departLabel.isDisplayed());
        Assert.assertTrue(project3Page.departDatePicker.isDisplayed());
        Assert.assertTrue(project3Page.returnLabel.isDisplayed());

        Assert.assertTrue(project3Page.returnDatePickerDisabled.isDisplayed());
        Assert.assertTrue(project3Page.returnDatePickerDisabled.isEnabled());  // CHECK

        Assert.assertTrue(project3Page.numberOfPassengersLabel.isDisplayed());
        Assert.assertTrue(project3Page.passengerNumberDropdown.isDisplayed());
        Assert.assertTrue(project3Page.passengerNumberDropdownDefault.isSelected());
        Assert.assertTrue(project3Page.passenger1.isDisplayed());
        Assert.assertTrue(project3Page.passenger1Dropdown.isDisplayed());
        Assert.assertTrue(project3Page.passenger1DropdownDefault.isSelected());
        Assert.assertTrue(project3Page.bookButton.isDisplayed());
        Assert.assertTrue(project3Page.bookButton.isEnabled());

    }

    /**
     * Navigate to https://techglobal-training.com/frontend/project-3
     * Click on the “Round trip” radio button and validate it is selected
     * Validate that the “One way” radio button is not selected
     * Validate that the “Cabin Class” label and dropdown are displayed
     * Validate that the “From” label and dropdown are displayed
     * Validate that the “To” label and dropdown are displayed
     * Validate that the “Depart” label and date picker is displayed
     * Validate that the “Return” label and date picker is displayed
     * Validate that the “Number of passengers” label and dropdown are displayed and 1 is the default
     * Validate that the “Passenger 1” label and dropdown are displayed and “Adult (16-64)” is the default
     * Validate that the “BOOK” button is displayed and enabled
     */
    @Test(priority = 2, description = "Test Case 02 - Validate the Book your trip form when Round trip is selected")
    public void validateTheBookTripWithRound() {
        project3Page.roundTripButton.click();
        Assert.assertTrue(project3Page.roundTripButton.isSelected());

        Assert.assertFalse(project3Page.oneWayButton.isSelected());

        Assert.assertTrue(project3Page.cabinClassLabel.isDisplayed());
        Assert.assertTrue(project3Page.cabinClassDropdown.isDisplayed());

        Assert.assertTrue(project3Page.from.isDisplayed());
        Assert.assertTrue(project3Page.fromDropdown.isDisplayed());

        Assert.assertTrue(project3Page.to.isDisplayed());
        Assert.assertTrue(project3Page.toDropdown.isDisplayed());

        Assert.assertTrue(project3Page.departLabel.isDisplayed());
        Assert.assertTrue(project3Page.departDatePicker.isDisplayed());

        Assert.assertTrue(project3Page.returnLabel.isDisplayed());
        Assert.assertTrue(project3Page.returnDatePickerEnable.isDisplayed());

        Assert.assertTrue(project3Page.numberOfPassengersLabel.isDisplayed());
        Assert.assertTrue(project3Page.passengerNumberDropdown.isDisplayed());
        Assert.assertTrue(project3Page.passengerNumberDropdownDefault.isSelected());

        Assert.assertTrue(project3Page.passNumber1.isDisplayed());
        Assert.assertTrue(project3Page.passenger1Dropdown.isDisplayed());
        Assert.assertTrue(project3Page.passenger1DropdownDefault.isSelected());

        Assert.assertTrue(project3Page.bookButton.isDisplayed());
        Assert.assertTrue(project3Page.bookButton.isEnabled());


    }

    /**
     * Navigate to https://techglobal-training.com/frontend/project-3
     * Select the “One way” radio button
     * Select “Business” for the “Cabin Class” dropdown
     * Select “Illinois” for the “From” dropdown
     * Select “Florida” for the “To” dropdown
     * Select the next week for the ”Depart”
     * Select “1” for the “Number of passengers” dropdown
     * Select “Senior (65+)” for the Passenger 1 dropdown
     * Click on the “BOOK” button
     * Validate the booking information displayed below
     * DEPART
     * IL to FL
     * {dynamic date}
     * Number of passengers: 1
     * Passenger 1: Senior (65+)
     * Cabin Class: Business
     */
    @Test(priority = 3, description = "Test Case 03 - Validate the booking for 1 passenger and one way")
    public void validateTheBookingForOnePassenger() {
        DropdownHandler.selectByVisibleText(project3Page.cabinClass, "Business");
        DropdownHandler.selectByVisibleText(project3Page.fromDropdown, "Illinois");
        DropdownHandler.selectByVisibleText(project3Page.toDropdown, "Florida");
        project3Page.departDatePickerMonth.sendKeys("6");
        project3Page.departDatePickerDay.sendKeys("19");
        project3Page.departDatePickerYear.sendKeys("2023");
        project3Page.passNumber1.click();
        project3Page.senior.click();
        Waiter.pause(3);
        project3Page.bookButton.click();
        Assert.assertTrue(project3Page.departMessage.isDisplayed());
        Assert.assertTrue(project3Page.from_to.isDisplayed());

        String[] expectedText = {"Mon Jun 19 2023",
                "Number of Passengers: 1",
                "Passenger 1: Senior (65+)",
                "Cabin class: Business"};
        for(int i = 0; i < project3Page.dataInfo.size(); i++){
            Assert.assertTrue(project3Page.dataInfo.get(i).isDisplayed());
            Assert.assertEquals(project3Page.dataInfo.get(i).getText(),expectedText[i]);
        }



    }

    /**
     * Navigate to https://techglobal-training.com/frontend/project-3
     * Select the “Round trip” radio button
     * Select “First” for the “Cabin Class” dropdown
     * Select “California” for the “From” dropdown
     * Select “Illinois” for the “To” dropdown
     * Select the next week for the ”Depart”
     * Select the next month for the “Return”
     * Select “1” for the “Number of passengers” dropdown
     * Select “Adult (16-64)” for the Passenger 1 dropdown
     * Click on the “BOOK” button
     * Validate the booking information displayed below
     * DEPART
     * CA to IL
     * {dynamic date}
     * Number of passengers: 1
     * Passenger 1: Adult (16-64)
     * Cabin Class: First
     * <p>
     * <p>
     * RETURN
     * IL to CA
     * {dynamic date}
     */
    @Test(priority = 4, description = "Test Case 04 - Validate the booking for 1 passenger and round trip")
    public void validateTheOnePassengerAndRoundTrip() {
        project3Page.roundTripButton.click();
        DropdownHandler.selectByVisibleText(project3Page.cabinClass, "First");
        DropdownHandler.selectByVisibleText(project3Page.fromDropdown, "California");
        DropdownHandler.selectByVisibleText(project3Page.toDropdown, "Illinois");
        project3Page.departDatePickerMonth.sendKeys("6");
        project3Page.departDatePickerDay.sendKeys("19");
        project3Page.departDatePickerYear.sendKeys("2023");

        project3Page.returnDatePickerMonth.sendKeys("7");
        project3Page.returnDatePickerDay.sendKeys("12");
        project3Page.returnDatePickerYear.sendKeys("2023");

        project3Page.passNumber1.click();
        project3Page.passenger1DropdownDefault.click();
        project3Page.bookButton.click();

        Assert.assertTrue(project3Page.departMessage.isDisplayed());
        Assert.assertEquals(project3Page.departMessage.getText(),"DEPART");
        Assert.assertTrue(project3Page.departToReturn.isDisplayed());
        Assert.assertEquals(project3Page.departToReturn.getText(), "CA to IL");


        Assert.assertTrue(project3Page.returnMessage.isDisplayed());
        Assert.assertEquals(project3Page.returnMessage.getText(),"RETURN");
        Assert.assertTrue(project3Page.returnToDepart.isDisplayed());
        Assert.assertEquals(project3Page.returnToDepart.getText(), "IL to CA");

        String[] expectedText = {
                "Number of Passengers: 1",
                "Passenger 1: Adult (16-64)",
                "Cabin class: First"};
        for(int i = 0; i < project3Page.departMessageText.size(); i++){
            Assert.assertTrue(project3Page.departMessageText.get(i).isDisplayed());
            Assert.assertEquals(project3Page.departMessageText.get(i).getText(),expectedText[i]);
        }

    }

    /**
     * Navigate to https://techglobal-training.com/frontend/project-3
     * Select the “One way” radio button
     * Select “Premium Economy” for the “Cabin Class” dropdown
     * Select “New York” for the “From” dropdown
     * Select “Texas” for the “To” dropdown
     * Select the next day for the ”Depart”
     * Select “2” for the “Number of passengers” dropdown
     * Select “Adult (16-64)” for the Passenger 1 dropdown
     * Select “Child (2-11)” for the Passenger 2 dropdown
     * Click on the “BOOK” button
     * Validate the booking information displayed below
     * DEPART
     * NY to TX
     * {dynamic date}
     * Number of passengers: 2
     * Passenger 1: Adult (16-64)
     * Passenger 2: Child (2-11)
     * Cabin Class: Premium Economy
     */
    @Test(priority = 5, description = "Test Case 05 - Validate the booking for 2 passengers and one way")
    public void validateTheTwoPassengerAndOneWay() {
        DropdownHandler.selectByVisibleText(project3Page.cabinClass, "Premium Economy");
        DropdownHandler.selectByVisibleText(project3Page.fromDropdown, "New York");
        DropdownHandler.selectByVisibleText(project3Page.toDropdown, "Texas");

        project3Page.departDatePickerMonth.sendKeys("6");
        project3Page.departDatePickerDay.sendKeys("13");
        project3Page.departDatePickerYear.sendKeys("2023");

        project3Page.passNumber2.click();
        project3Page.passenger1DropdownDefault.click();
        project3Page.passenger2Dropdown.click();

        project3Page.bookButton.click();

        String[] expectedText = {
                "Number of Passengers: 2",
                "Passenger 1: Adult (16-64)",
                "Passenger 2: Child (2-11)",
                "Cabin class: Premium Economy"};
        for(int i = 0; i < project3Page.departMessageText.size(); i++){
            Assert.assertTrue(project3Page.departMessageText.get(i).isDisplayed());
            Assert.assertEquals(project3Page.departMessageText.get(i).getText(),expectedText[i]);
        }


    }
}

package pages;
/*
 * 1.НА PROJECT PAGE НАЖАТЬ НА ИКОНКУ
 * 2.ДОЖДАТЬСЯ ПОКА ОТКРОЕТСЯ OVERVIEW PAGE
 * 3.КЛИКНУТЬ Test Suites & Cases
 * 4.ДОЖДАТЬСЯ ПОКА ОТКРОЕТСЯ Test Suites & Cases
 * 5.КЛИКНУТЬ ADD SUITE
 * 6.ДОЖДАТЬСЯ ПОКА ОТКРОЕТСЯ Add Test Suite
 * 7.ЗАПОЛНИТЬ ФОРМУ И КЛИКНУТЬ ADD TEST SUITE
 * 8.ПРОВЕРИТЬ ПО MESSAGE "Successfully added the new test suite" (done)
 * 9. КЛИКНУТЬ ПО SUITE
 * 10.КЛИКНУТЬ ADD TEST CASE
 * 10.ЗАПОЛНИТЬ ФОРМУ
 * 11.ВЫБРАТЬ МЕЖДУ КНОПКАМИ TEST CASE И ADD & NEXT
 *   A)ВАЛИДАЦИЯ
 *   Б)ДОЖДАТЬСЯ "Add Test Case" -> ЗАПОЛНИТЬ ФОРМУ
 *
 * */

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class TestCaseAndSuitePage extends BasePage {
    public static final By SUCCESS_SUITE_MESSAGE_XPATH = By.xpath("//*[@class='message message-success'][contains(text()," +
            "'Successfully updated the test suite.')]");
    public static final By ADD_TEST_CASE_BUTTON_ID = By.id("sidebar-cases-add");
    public static final By TEST_CASE_BUTTON=By.id("navigation-suites");

    public TestCaseAndSuitePage(WebDriver driver) {
        super(driver);
    }

    public void openTestCasePage() {
        driver.findElement(TEST_CASE_BUTTON).click();
    }

    public void clickAddTestCase() {
        driver.findElement(ADD_TEST_CASE_BUTTON_ID).click();
    }

    public void successSuiteMessage() {
        driver.findElement(SUCCESS_SUITE_MESSAGE_XPATH).isDisplayed();
    }
}
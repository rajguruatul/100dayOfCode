package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.time.LocalDate;
import java.time.Month;
import java.time.chrono.ChronoLocalDate;
import java.time.temporal.ChronoUnit;

import static java.lang.String.format;

public class DatePickerPage {
    private WebDriver d;

    private By openCalendar = By.id("datepicker");
    private By calendar = By.id("ui-datepicker-div");
    private By currentYear = By.xpath("//span[@class='ui-datepicker-year']");
    private By currentMonth = By.xpath("//span[@class='ui-datepicker-month']");
    private By prevArrow = By.xpath("//span[@class='ui-icon ui-icon-circle-triangle-w']");
    private By nextArrow = By.xpath("//span[@class='ui-icon ui-icon-circle-triangle-e']");

    private String selectDate_FORMAt = "//a[@class='ui-state-default'][text()='%d']";
    private String currentYearString;
    private String currentMonthString;

    public DatePickerPage(WebDriver d) {
        this.d = d;
    }

    public void chooseDate(LocalDate date) {
        openCalender();
        chooseMonth(date);
        chooseDay(date.getDayOfMonth());
    }

    public void chooseDay(int dayOfMonth) {
        By locator = By.xpath(format(selectDate_FORMAt, dayOfMonth));
        d.findElement(locator).click();

        System.out.println("Selected date:" + d.findElement(By.xpath("//input[@id='datepicker']")).getText());


    }

    public void openCalender() {
        if (!isCalendarOpen())
            d.findElement(openCalendar).click();
    }

    private boolean isCalendarOpen() {
        return (d.findElement(calendar).isDisplayed());
    }


    public void chooseMonth(LocalDate date) {
        LocalDate currentDate = getCurrentDate();
        long monthsAway = ChronoUnit.MONTHS.between(currentDate, date.withDayOfMonth(1));

        By arrow = monthsAway < 0 ? prevArrow : nextArrow;
        System.out.println("Months away : " + monthsAway);

        for (int i = 0; i < Math.abs(monthsAway); i++) {
            d.findElement(arrow).click();
        }

    }

    public LocalDate getCurrentDate() {
        currentMonthString = d.findElement(currentMonth).getText();
        currentYearString = d.findElement(currentYear).getText();
        return LocalDate.of(Integer.parseInt(currentYearString), Month.valueOf(currentMonthString.toUpperCase()), 1);
    }

}

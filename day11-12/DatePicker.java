package DatePicker;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.BaseClass;
import pages.DatePickerPage;

import java.time.LocalDate;

public class DatePicker extends BaseClass
{
    //public static String URL="https://demoqa.com/datepicker/";
        @Test
        public void setPastDate()  {
            LocalDate dateToSelect = LocalDate.of(2019,3,3);
            new DatePickerPage(d).chooseDate(dateToSelect);
        }

    @Test
    public void setFutureDate() {
        LocalDate dateToSelect = LocalDate.of(2022,12,12);
        new DatePickerPage(d).chooseDate(dateToSelect);
    }


    @Test
    public void setCurrentMonth()  {
        LocalDate dateToSelect = LocalDate.now().withDayOfMonth(15);
        new DatePickerPage(d).chooseDate(dateToSelect);

    }

    }

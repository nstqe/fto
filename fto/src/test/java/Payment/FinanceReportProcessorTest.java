package Payment;

import org.junit.Test;

import java.util.Date;
import java.util.List;

import static org.junit.Assert.*;

public class FinanceReportProcessorTest {

    @Test
    public void nameBeginsWithLetter() {
        List<Payment> payments1 = List.of(
                new Payment("Щепковна Дария", 4, 10, 2023, 12300),
                new Payment("Крашев Нкей", 7, 10, 2023, 4500),
                new Payment("Кейпоперша Адия Крутяшкина", 3, 4, 2023, 2343),
                new Payment("Мурмаевна Елизовета Няшковна", 25, 1, 2024, 1850)
        );
        List<Payment> payments = List.of(
                new Payment("Кейпоперша Адия Крутая", 3, 4, 2023, 2343)
        );
        FinanceReport report1 = new  FinanceReport("Вайперов Найнмайс Кайэнджелович", new Date(), payments);
        FinanceReport report2 = new  FinanceReport("Вайперов Найнмайс Кайэнджелович", new Date(), payments1);
        assertEquals(report1, FinanceReportProcessor.nameBeginsWithLetter(report2, payments1, 'П'));
    }
    @Test
    public void nameBeginsWithLetter1() {
        List<Payment> payments1 = List.of(
                new Payment("Щепковна Дария", 4, 10, 2023, 12300),
                new Payment("Крашев Нкей", 7, 10, 2023, 4500),
                new Payment("Кейпоперша Адия Крутяшкина", 3, 4, 2023, 2343),
                new Payment("Мурмаевна Елизовета Няшковна", 25, 1, 2024, 1850)
        );
        List<Payment> payments = List.of(
        );
        FinanceReport report1 = new  FinanceReport("Вайперов Найнмайс Кайэнджелович", new Date(), payments);
        FinanceReport report2 = new  FinanceReport("Вайперов Найнмайс Кайэнджелович", new Date(), payments1);
        assertEquals(report1, FinanceReportProcessor.nameBeginsWithLetter(report2, payments1, ' '));
    }
    @Test
    public void valuePayments() {
        List<Payment> payments = List.of(
                new Payment("Щепковна Дария", 4, 10, 2023, 12300),
                new Payment("Крашев Нкей", 7, 10, 2023, 4500),
                new Payment("Кейпоперша Адия Крутяшкина", 3, 4, 2023, 2343),
                new Payment("Мурмаевна Елизовета Няшковна", 25, 1, 2024, 1850)
        );
        Date date = new Date();
        FinanceReport fr1 = new FinanceReport("Вайперов Найнмайс Кайэнджелович", date, payments);
        List<Payment> expectedPayments = List.of(
                new Payment("Крашев Нкей", 7, 10, 2023, 4500),
                new Payment("Мурмаевна Елизовета Няшковна", 25, 1, 2024, 1850)
        );
        FinanceReport expected = new FinanceReport("Вайперов Найнмайс Кайэнджелович", date, expectedPayments);
        FinanceReport filtered = FinanceReportProcessor.valuePayments(fr1, payments, 5000);
        assertEquals(expected, filtered);
    }
    @Test
    public void valuePayments1() {
        List<Payment> payments = List.of(
                new Payment("Щепковна Дария", 4, 10, 2023, 12300),
                new Payment("Крашев Нкей", 7, 10, 2023, 4500),
                new Payment("Кейпоперша Адия Крутяшкина", 3, 4, 2023, 2343),
                new Payment("Мурмаевна Елизовета Няшковна", 25, 1, 2024, 1850)
        );
        Date date = new Date();
        FinanceReport fr1 = new FinanceReport("Вайперов Найнмайс Кайэнджелович", date, payments);
        List<Payment> expectedPayments = List.of(
        );
        FinanceReport expected = new FinanceReport("Вайперов Найнмайс Кайэнджелович", date, expectedPayments);
        FinanceReport filtered = FinanceReportProcessor.valuePayments(fr1, payments, ' ');
        assertEquals(expected, filtered);
    }
    @Test
    public void valuePayments2() {
        List<Payment> payments = List.of(
                new Payment("Щепковна Дария", 4, 10, 2023, 12300),
                new Payment("Крашев Нкей", 7, 10, 2023, 4500),
                new Payment("Кейпоперша Адия Крутяшкина", 3, 4, 2023, 2343),
                new Payment("Мурмаевна Елизовета Няшковна", 25, 1, 2024, 1850)
        );
        Date date = new Date();
        FinanceReport report = new FinanceReport("Вайперов Найнмайс Кайэнджелович", date, payments);
        assertThrows(IllegalArgumentException.class, () -> {
            FinanceReportProcessor.valuePayments(report, payments, -10);
        });
    }
}

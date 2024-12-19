package Payment;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.*;

public class FinanceReportTest {

    @Test
    public void getIndexOfPayments() {
        List<Payment> payments = List.of(
                new Payment("Щепковна Дария", 4, 10, 2023, 12300),
                new Payment("Крашев Нкей", 7, 10, 2023, 4500),
                new Payment("Кейпоперша Адия Крутяшкина", 3, 4, 2023, 2343),
                new Payment("Мурмаевна Елизовета Няшковна", 25, 1, 2024, 1850)
        );
        FinanceReport report = new FinanceReport("Test Author", new Date(), payments);
        Payment expectedPayment = report.getIndexOfPayments(2);
        assertEquals(expectedPayment, report.getIndexOfPayments(2));
    }

    @Test
    public void getIndexOfPaymentException() {
        List<Payment> payments = List.of(
                new Payment("Щепковна Дария", 4, 10, 2023, 12300),
                new Payment("Крашев Нкей", 7, 10, 2023, 4500),
                new Payment("Кейпоперша Адия Крутяшкина", 3, 4, 2023, 2343),
                new Payment("Мурмаевна Елизовета Няшковна", 25, 1, 2024, 1850)
        );
        FinanceReport report = new FinanceReport("Test Author", new Date(), payments);
        assertThrows(IndexOutOfBoundsException.class, () -> {
            report.getIndexOfPayments(-2);
        });
    }

    @Test
    public void getIndexOfPaymentException1() {
        List<Payment> payments = List.of(
                new Payment("Щепковна Дария", 4, 10, 2023, 12300),
                new Payment("Крашев Нкей", 7, 10, 2023, 4500),
                new Payment("Кейпоперша Адия Крутяшкина", 3, 4, 2023, 2343),
                new Payment("Мурмаевна Елизовета Няшковна", 25, 1, 2024, 1850)
        );
        FinanceReport report = new FinanceReport("Test Author", new Date(), payments);
        assertThrows(IndexOutOfBoundsException.class, () -> {
            report.getIndexOfPayments(5);
        });
    }

    @Test
    public void setPaymentIndex() {
        List<Payment> payments = new ArrayList<>(List.of(
                new Payment("Test 1", 1, 1, 2024, 1000)
        ));
        Payment newPayment = new Payment("Щепковна Дария", 4, 10, 2023, 12300);
        FinanceReport report = new FinanceReport("Test Author", new Date(), payments);
        report.setPaymentIndex(0, newPayment);
        assertEquals(newPayment, report.getIndexOfPayments(0));
    }

    @Test
    public void setIndexOfPaymentsException() {
        List<Payment> payments = new ArrayList<>(List.of(
                new Payment("Test 1", 1, 1, 2024, 1000)
        ));
        Payment newPayment = new Payment("Щепковна Дария", 4, 10, 2023, 12300);
        FinanceReport report = new FinanceReport("Test Author", new Date(), payments);
        assertThrows(IndexOutOfBoundsException.class, () -> {
            report.setPaymentIndex(-1, newPayment); // Отрицательный индекс
        });
        assertThrows(IndexOutOfBoundsException.class, () -> {
            report.setPaymentIndex(1, newPayment); // Индекс выходит за пределы списка
        });
    }


    @Test
    public void setIndexOfPaymentsException1() {
        List<Payment> payments = new ArrayList<>(List.of(
                new Payment("Test 1", 1, 1, 2024, 1000)
        ));
        Payment newPayment = new Payment("Щепковна Дария", 4, 10, 2023, 12300);
        FinanceReport report = new FinanceReport("Test Author", new Date(), payments);
        assertThrows(IndexOutOfBoundsException.class, () -> {
            report.setPaymentIndex(3, newPayment);
        });
    }
}
package Payment;

import java.util.ArrayList;
import java.util.List;

import static java.lang.Character.toLowerCase;

public class FinanceReportProcessor {
    public static FinanceReport nameBeginsWithLetter(FinanceReport fr, List<Payment> payments, char letter) {
        if (fr == null || payments == null) {
            throw new IllegalArgumentException("FinanceReport и список платежей не могут быть null.");
        }
        List<Payment> filteredPayments = new ArrayList<>();
        for (Payment p : payments) {
            if (p.getFio().trim().toLowerCase().charAt(0) == toLowerCase(letter)) {
                filteredPayments.add(p);
            }
        }
        return new FinanceReport(fr.getAuthor(), fr.getReportDate(), filteredPayments);
    }
    public static FinanceReport valuePayments(FinanceReport fr, List<Payment> payments, int value) {
        if (value <= 0) {
            throw new IllegalArgumentException("Значение value должно быть больше 0");
        }
        List<Payment> filteredPayments = new ArrayList<>();
        for (Payment p : payments) {
            if (p.getAmount() < value) {
                filteredPayments.add(p);
            }
        }
        return new FinanceReport(fr.getAuthor(), fr.getReportDate(), filteredPayments);
    }

}

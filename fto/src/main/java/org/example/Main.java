package org.example;
import Payment.*;
import Payment.Payment;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static Payment.FinanceReportProcessor.*;

public class Main {
    public static void main(String[] args) throws ParseException {
        List<Payment> payments = new ArrayList<>();
        payments.add(new Payment("Евреев Степка", 20, 10, 2023, 123400));
        payments.add(new Payment("Хрюшковна Настюшка", 27, 10, 2023, 4500));

        DateTimeFormatter forma = DateTimeFormatter.ofPattern("dd.MM.yyyy");  // Форматируем дату LocalDate в строку с заданным форматом "dd.MM.yyyy"
        LocalDate date = LocalDate.of(2023, 10, 26);
        String formaDate = date.format(forma);

        SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");// Создаем объект SimpleDateFormat для преобразования строки в объект Date.
        Date reportDate = sdf.parse(formaDate);

        FinanceReport report = new FinanceReport("Елезовета Кожуркина", reportDate, payments);
        System.out.println(report);


        Payment payment0 = report.getIndexOfPayments(0);
        if (payment0 != null) {
            System.out.println("Платеж: " + payment0.getFio() + ", сумма: " + payment0.getAmount());
        } else {
            System.out.println("Платеж с таким индексом не найден.");
        }

        Date reportDate1 = new Date();

        FinanceReport report1 = new FinanceReport("Адияшкинс Ануаровна Инкеевна", reportDate1, payments);

        System.out.println("Количество платежей: " + report1.getPayment());

        FinanceReport nameBeginsWithLetter = nameBeginsWithLetter(report1, payments, 'Е');
        System.out.println("\nПервая буква Фамилии 'Е':\n" + nameBeginsWithLetter);

        FinanceReport smallerPayments = valuePayments(report1, payments, 15000);
        System.out.println("\nПлатежи, у которых сумма меньше 15000:\n" + smallerPayments);
    }
}

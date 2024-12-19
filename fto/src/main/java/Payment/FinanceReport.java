package Payment;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

public class FinanceReport {
    private String author;
    private Date reportDate;
    private List<Payment> payments;

    public FinanceReport(String author, Date reportDate, List<Payment> payments) {
        this.author = author;
        this.reportDate = reportDate;
        this.payments = payments;
    }
    // Конструктор копирования
    public FinanceReport(FinanceReport other) {
        this.author = other.author;
        this.reportDate = new Date(other.reportDate.getTime());
        this.payments = new ArrayList<>(other.payments);
    }
    public String getAuthor() {
        return author;
    }
    public Date getReportDate() {
        if (reportDate == null) {
            throw new IllegalStateException("Дата отчета не установлена");
        }
        return reportDate;
    }
    public List<Payment> getPayments() {
        return payments;
    }
    public void setAuthor(String author) {
        if (author == null || author.isEmpty()) {
            throw new IllegalArgumentException("Автор не может быть пустым");
        }
        this.author = author;
    }

    public void setPayments(List<Payment> payments) {
        if (payments == null || payments.isEmpty()) {
            throw new IllegalArgumentException("Список платежей не может быть null или пустым");
        }
        this.payments = payments;
    }
    public void setReportDate(Date reportDate) {
        if (reportDate == null) {
            throw new IllegalArgumentException("Дата не может быть null");
        }
        this.reportDate = reportDate;
    }
    // получение количества платежей
    public int getPayment() {
        if (payments == null) {
            return 0;
        } else {
            return payments.size();
        }
    }
    // Метод для доступа к i-му платежу (на чтение)
    public Payment getIndexOfPayments(int i)  {
        if (i >= 0 && i< payments.size()){
            return payments.get(i);
        } else {
            throw new IndexOutOfBoundsException("Индекс платежа выходит за границы списка");
        }
    }
    // Метод для доступа к i-му платежу (на запись)
    public void setPaymentIndex(int i, Payment payment) {
        if (i < 0 || i >= payments.size()) { // Исправленная проверка
            throw new IndexOutOfBoundsException("Индекс платежа должен быть в диапазоне от 0 до " + (payments.size() - 1));
        }
        payments.set(i, payment); // Корректное обновление платежа
    }

    @Override
    public String toString() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("[Автор: %s, дата: %s , Платежи: [", getAuthor(), sdf.format(reportDate)));
        for (Payment p : payments) {
            sb.append(String.format("Плательщик: %s, дата: %d.%d.%d сумма: %d руб. %d коп.\n", p.getFio(),p.getDay(), p.getMonth(), p.getYear(), p.getAmount() / 100, p.getAmount()));
        }
        sb.append("]]");
        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FinanceReport report = (FinanceReport) o;
        return Objects.equals(author, report.author) && Objects.equals(reportDate, report.reportDate) && Objects.equals(payments, report.payments);
    }

    @Override
    public int hashCode() {
        return Objects.hash(author, reportDate, payments);
    }
}
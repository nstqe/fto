package Payment;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class PaymentTest {
    @Test
    public void equals() {
        Payment payment = new Payment("Дмитриев Сергей", 1, 11, 2023, 100);
        assertEquals(payment, payment);
    }
    @Test
    public void equals1() {
        Payment p1 = new Payment("Дмитриев Сергей", 11, 11, 2023, 300);
        Payment p2 = new Payment("Дмитриев Сергей", 11, 11, 2023, 300);
        assertEquals(p1, p2);
        assertEquals(p2, p1);
    }
    @Test
    public void equals2() {
        Payment p1 = new Payment("Дмитриев Сергей", 11, 11, 2023, 300);
        Payment p2 = new Payment("Иванов Иван", 15, 5, 2024, 200);
        assertNotEquals(p1, p2);
    }
    @Test
    public void equals3() {
        Payment p1 = new Payment("Дмитриев Сергей", 11, 11, 2023, 300);
        assertNotEquals(p1, null);
    }
    @Test
    public void equalsDifferentFields() {
        Payment p1 = new Payment("Дмитриев Сергей", 11, 11, 2023, 300);

        Payment p2 = new Payment("Ицков Дмитрий", 11, 11, 2023, 300);
        assertNotEquals(p1, p2);

        p2 = new Payment("Дмитриев Сергей", 2, 11, 2023, 100);
        assertNotEquals(p1, p2);

        p2 = new Payment("Дмитриев Сергей", 12, 12, 2023, 100);
        assertNotEquals(p1, p2);

        p2 = new Payment("Дмитриев Сергей", 1, 11, 2024, 100);
        assertNotEquals(p1, p2);

        p2 = new Payment("Дмитриев Сергей", 11, 11, 2023, 301);
        assertNotEquals(p1, p2);
        p2 = new Payment("Дмитриев Сергей", 11, 11, 2023, 90);
        assertNotEquals(p1, p2);
    }

    @Test
    public void hashCode1() {
        Payment p1 = new Payment("Дмитриев Сергей", 11, 11, 2023, 300);
        Payment p2 = new Payment("Дмитриев Сергей", 11, 11, 2023, 300);
        assertEquals(p1.hashCode(), p2.hashCode());
    }
    @Test
    public void hashCodeDifferentObjects() {
        Payment p1 = new Payment("Дмитриев Сергей", 11, 11, 2023, 300);
        Payment p2 = new Payment("Ицков Дмитрий", 15, 5, 2024, 200);
        assertNotEquals(p1.hashCode(), p2.hashCode());
    }
    @Test
    public void hashCodeNullFio() {
        Payment p1 = new Payment(null, 11, 11, 2023, 300);
        Payment p2 = new Payment(null, 11, 11, 2023, 300);
        assertEquals(p1.hashCode(), p2.hashCode());
    }
}
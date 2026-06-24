import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

public class TrafficTicketTest {

    private TrafficTicket ticketIvanov;
    private TrafficTicket ticketOverspeed15;
    private TrafficTicket ticketOverspeed25;

    private int countBeforeTest;

    @BeforeAll
    static void initAll() {
        TrafficTicket.totalFinesIssued = 0;
        System.out.println("🔧 Запуск всех тестов для TrafficTicket. Инициализация общих ресурсов...");
    }

    @BeforeEach
    void setUp() {
        countBeforeTest = TrafficTicket.totalFinesIssued;

        ticketIvanov = new TrafficTicket("Иванов", 80, 60);
        ticketOverspeed15 = new TrafficTicket("Петров", 75, 60);
        ticketOverspeed25 = new TrafficTicket("Сидоров", 85, 60);

        System.out.println("  ✅ Созданы новые штрафы для теста. Текущий счетчик: " + TrafficTicket.totalFinesIssued);
    }

    @AfterEach
    void tearDown() {
        int currentCount = TrafficTicket.totalFinesIssued;
        assertTrue(currentCount > countBeforeTest, "Счетчик должен увеличиваться при создании объектов");
        System.out.println("  🧹 Тест завершен. Проверка счетчика пройдена.");
    }

    @AfterAll
    static void tearDownAll() {
        System.out.println("🏁 Все тесты TrafficTicket завершены. Общее количество выписанных штрафов: " + TrafficTicket.totalFinesIssued);
    }

    @Test
    @DisplayName("Задание 1: Проверка, что новый штраф не оплачен")
    void testTicketIsNotPaid() {
        assertFalse(ticketIvanov.isPaid(), "Штраф по умолчанию не должен быть оплачен!");
        System.out.println("    ⚔️ Выполняется testTicketIsNotPaid");
    }

    @Test
    @DisplayName("Задание 2.1: Проверка штрафа за превышение на 15 км/ч")
    void testCalculateFineOverspeed15() {
        assertEquals(500, ticketOverspeed15.calculateFine(), "За превышение на 15 км/ч штраф должен составить 500");
        System.out.println("    ⚔️ Выполняется testCalculateFineOverspeed15");
    }

    @Test
    @DisplayName("Задание 2.2: Проверка штрафа за превышение на 25 км/ч")
    void testCalculateFineOverspeed25() {
        assertEquals(1500, ticketOverspeed25.calculateFine(), "За превышение на 25 км/ч штраф должен составить 1500");
        System.out.println("    ⚔️ Выполняется testCalculateFineOverspeed25");
    }
}
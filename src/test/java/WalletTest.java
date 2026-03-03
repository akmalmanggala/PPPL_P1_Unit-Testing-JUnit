import org.example.Owner;
import org.example.Wallet;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@TestInstance(TestInstance.Lifecycle.PER_METHOD)
public class WalletTest {

    private static Wallet wallet;

    @BeforeAll
    public static void initClass() {
        wallet = new Wallet();
    }

    @AfterAll
    public static void cleanClass() {
        wallet = null;
    }

    @BeforeEach
    public void initMethod() {
        wallet.addCard("ATM BCA");

        wallet.addCash(50000);
        wallet.addCash(20000);

    }

    @AfterEach
    public void cleanMethod() {
        wallet.setOwner(null);
        wallet.clearCards();
        wallet.clearCash();
    }

    @Test
    @Order(1)
    public void testAddCard() {
        assertTrue(wallet.hasCard("ATM BCA"));
        assertEquals(1, wallet.getCardCount());
    }

    @Test
    @Order(2)
    public void testRemoveCard() {
        boolean result = wallet.removeCard("ATM BCA");
        assertTrue(result);
        assertEquals(0, wallet.getCardCount());
    }

    @Test
    @Order(3)
    public void testAddCash() {
        assertEquals(70000, wallet.getTotalCash());
    }

    @Test
    @Order(4)
    public void testRemoveCash() {
        wallet.removeCash(10000);
        assertEquals(60000, wallet.getTotalCash());
    }

    @Test
    @Order(5)
    public void testGetTotalCash() {
        int currentBalance = wallet.getTotalCash();
        wallet.addCash(10000);

        assertEquals(currentBalance + 10000, wallet.getTotalCash());
        System.out.println("    Run: testGetTotalCash");
    }

    @ParameterizedTest(name = ("Eksekusi ke-{index}, nilai: {arguments}"))
    @ValueSource(ints = {10000, 40000})
    void tesTambahPositif(int param){
        Wallet wallet = new Wallet();
        assertTrue(wallet.addCash(param));
    }

    @ParameterizedTest(name = ("Eksekusi ke-{index}, nilai: {arguments}"))
    @ValueSource(ints = {-50000, -20000})
    void tesTambahNegatif(int param){
        Wallet wallet = new Wallet();
        assertFalse(wallet.addCash(param));
    }

    @ParameterizedTest
    @CsvSource({"10000,0,10000", "20000,5000,15000", "50000,25000,25000", "100000,100000,0"})
    void tesWithdrawValid(int deposit, int withdraw, int expect){
        Wallet wallet = new Wallet();
        wallet.addCash(deposit);

        if (withdraw > 0){
            wallet.removeCash(withdraw);
        }

        assertEquals(expect,wallet.getTotalCash());
    }

    @ParameterizedTest
    @CsvSource({"10000, 15000, InsufficientFundsException", "10000, 0, IllegalArgumentException", "10000, -1000, IllegalArgumentException", "0, 1000, InsufficientFundsException"})
    void tesWithdrawInvalid(int initialDeposit, int withdraw, String expectedException){
        Wallet wallet = new Wallet();
        if (initialDeposit > 0){
            wallet.addCash(initialDeposit);
        }

        Exception exception = assertThrows(Exception.class, () -> {
            wallet.removeCash(withdraw);
        });

        assertTrue(exception.toString().contains(expectedException));
    }

    private static Stream<Arguments> provideOwner(){
        return Stream.of(
                Arguments.of(new Owner("1", "Akmal", "akmal@gmail.com"))
        );
    }

    @ParameterizedTest
    @MethodSource("provideOwner")
    void testSetOwnerObject(Owner owner){
        Wallet wallet = new Wallet();
        wallet.setOwner(owner);
        assertEquals(owner, wallet.getOwner());
    }
}
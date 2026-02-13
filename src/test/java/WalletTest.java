import org.example.Wallet;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class WalletTest {
    @Test
    public void testSetOwner(){
        Wallet wallet = new Wallet();
        wallet.setOwner("akmal");

        Assertions.assertNotNull(wallet.getOwner());
        Assertions.assertEquals("akmal",wallet.getOwner());
    }

    @Test
    public void testAddCard(){
        Wallet wallet = new Wallet();
        wallet.addCard("ATM BCA");

        Assertions.assertTrue(wallet.hasCard("ATM BCA"));
        Assertions.assertEquals(1, wallet.getCardCount());

    }

    @Test
    public void testRemoveCard(){
        Wallet wallet = new Wallet();
        wallet.addCard("SIM");

        boolean result = wallet.removeCard("SIM");

        Assertions.assertTrue(result);
        Assertions.assertEquals(0, wallet.getCardCount());
    }

    @Test
    public void testAddCash(){
        Wallet wallet = new Wallet();
        wallet.addCash(50000);
        wallet.addCash(20000);

        Assertions.assertEquals(70000, wallet.getTotalCash());
    }

    @Test
    public void testRemoveCash(){
        Wallet wallet = new Wallet();
        wallet.addCash(20000);

        boolean result = wallet.removeCash(10000);

        Assertions.assertTrue(result);
        Assertions.assertEquals(10000,wallet.getTotalCash());
    }

    @Test
    public void testGetTotalCash(){
        Wallet wallet = new Wallet();
        wallet.addCash(10000);
        wallet.addCash(20000);
        wallet.addCash(50000);

        Assertions.assertEquals(80000, wallet.getTotalCash());
    }
}

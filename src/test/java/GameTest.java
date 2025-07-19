import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.netology.Game;
import ru.netology.NotRegisteredException;
import ru.netology.Player;

public class GameTest {
    Game game = new Game();

    @Test
    public void testWinFirstPlayer() {
        Player player1 = new Player(1, "Peta", 67);
        Player player2 = new Player(2, "Anton", 54);
        game.register(player1);
        game.register(player2);
        int expected = 1;
        int actual = game.round("Peta", "Anton");
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testWinSecondPlayer() {
        Player player1 = new Player(1, "Peta", 67);
        Player player2 = new Player(2, "Anton", 70);
        game.register(player1);
        game.register(player2);
        int expected = 2;
        int actual = game.round("Peta", "Anton");
        Assertions.assertEquals(expected, actual);

    }

    @Test
    public void testAllNotWinPlayer() {
        Player player1 = new Player(1, "Peta", 40);
        Player player2 = new Player(2, "Anton", 40);
        game.register(player1);
        game.register(player2);
        int expected = 0;
        int actual = game.round("Peta", "Anton");
        Assertions.assertEquals(expected, actual);

    }

    @Test
    public void testWhenFirstPlayerNotExist() {
        Player player1 = new Player(1, "Peta", 67);
        Player player2 = new Player(2, "Anton", 54);
        game.register(player1);
        game.register(player2);
        Assertions.assertThrows(NotRegisteredException.class, () -> {
            game.round("Ola", "Anton");

        });
    }

    @Test
    public void testWhenSecondPlayerNotExist() {
        Player player1 = new Player(1, "Peta", 67);
        Player player2 = new Player(2, "Anton", 54);
        game.register(player1);
        game.register(player2);
        Assertions.assertThrows(NotRegisteredException.class, () -> {
            game.round("Peta", "Kati");
        });
    }
    @Test
    public void testWhenAllPlayersNotExist() {
        Assertions.assertThrows(NotRegisteredException.class, () -> {
            game.round("Ola", "Anton");

        });
    }

}

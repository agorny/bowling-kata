import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class GameTest {

    private Game game;

    @Before
    public void setUp() throws Exception {
        game = new Game();
    }

    @Test
    public void gutterGame() throws Exception {
        rollMany(20, 0);
        assertThat(game.score(), is(equalTo(0)));
    }

    @Test
    public void allOnes() throws Exception {
        rollMany(20, 1);
        assertThat(game.score(), is(equalTo(20)));
    }

    @Test
    public void oneSpare() throws Exception {
        rollSpare();
        game.roll(1);
        rollMany(17, 0);
        assertThat(game.score(), is(equalTo(12)));
    }

    @Test
    public void oneStrike() throws Exception {
        rollStrike();
        game.roll(2);
        game.roll(2);
        game.roll(1);
        rollMany(16, 0);
        assertThat(game.score(), is(equalTo(19)));
    }

    @Test
    public void perfectGame() throws Exception {
        rollMany(12,10);
        assertThat(game.score(), is(equalTo(300)));
    }

    private void rollStrike() {
        game.roll(10);
    }

    private void rollSpare() {
        game.roll(5);
        game.roll(5);
    }

    private void rollMany(int n, int pins) {
        for (int i = 0; i < n; i++) {
            game.roll(pins);
        }
    }
}

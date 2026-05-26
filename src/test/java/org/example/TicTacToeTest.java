package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TicTacToeTest {

    private TicTacToe game;

    @BeforeEach
    public void setUp() {
        game = new TicTacToe();
    }

    @Test
    public void testSwitchCurrentPlayerPositive() {
        Player initialPlayer = game.getCurrentPlayer();
        game.switchCurrentPlayer();
        assertNotEquals(initialPlayer, game.getCurrentPlayer());
    }

    @Test
    public void testSwitchCurrentPlayerNegative() {
        Player initialPlayer = game.getCurrentPlayer();
        game.switchCurrentPlayer();
        game.switchCurrentPlayer();
        assertEquals(initialPlayer, game.getCurrentPlayer());
    }

    @Test
    public void testHasWinnerPositive() {
        game.getBoard().place(0, 0, game.getCurrentPlayer().getMarker());
        game.getBoard().place(0, 1, game.getCurrentPlayer().getMarker());
        game.getBoard().place(0, 2, game.getCurrentPlayer().getMarker());
        assertTrue(game.hasWinner());
    }

    @Test
    public void testHasWinnerNegative() {
        game.getBoard().place(0, 0, game.getCurrentPlayer().getMarker());
        game.getBoard().place(0, 1, game.getCurrentPlayer().getMarker());
        game.getBoard().place(1, 2, game.getCurrentPlayer().getMarker());
        assertFalse(game.hasWinner());
    }
}

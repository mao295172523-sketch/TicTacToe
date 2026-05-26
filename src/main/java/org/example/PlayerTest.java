package org.example;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class PlayerTest {
    @Test
    public void testGetMarkerPositive() {
        Player player = new Player('X');
        assertEquals('X', player.getMarker());
    }

    @Test
    public void testGetMarkerNegative() {
        Player player = new Player('O');
        assertNotEquals('X', player.getMarker());
    }
}

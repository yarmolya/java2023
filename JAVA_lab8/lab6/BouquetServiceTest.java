package JAVA_lab8.lab6;
import static org.junit.Assert.*;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.List;

public class BouquetServiceTest {
    Bouquet bouquet = new Bouquet();
    BouquetService bouquetService = bouquet.getBouquetService();
    @Test
    public void testAddFlower() throws RuntimeException {
        Flower rose = new Rose();
        bouquet.add(rose);
        assertEquals(1, bouquetService.flowerList.size());
        assertEquals(rose, bouquetService.flowerList.get(0));
    }

    @Test
    public void testAddFlowerList() throws RuntimeException {
        Flower rose = new Rose();
        Flower tulip = new Tulip();
        bouquet.add(Arrays.asList(rose, tulip));
        assertEquals(2, bouquetService.flowerList.size());
        assertEquals(rose, bouquetService.flowerList.get(0));
        assertEquals(tulip, bouquetService.flowerList.get(1));
        assertTrue(bouquetService.flowerList.contains(rose));
        assertTrue(bouquetService.flowerList.contains(tulip));
    }

    @Test
    public void testAddNullFlower() {
        assertThrows(NullPointerException.class, () -> bouquetService.add((Flower) null));
    }

    @Test
    public void testAddNullFlowerList() {
        assertThrows(NullPointerException.class, () -> bouquetService.add((List<Flower>) null));
    }


}

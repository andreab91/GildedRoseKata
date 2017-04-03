package test.java.com.gildedrose;

import static org.junit.Assert.assertEquals;

import main.java.com.gildedrose.GildedRose;
import main.java.com.gildedrose.Item;
import org.junit.Test;


public class GildedRoseTest {

    @Test
    public void foo() {
        Item[] items = new Item[] { new Item("foo", 1, 1) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals("foo", app.items[0].name);
    }
}

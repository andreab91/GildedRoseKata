package com.gildedrose;

import static org.junit.Assert.*;

import org.junit.Test;

public class GildedRoseTest {

    @Test
    public void foo() {
        Item[] items = new Item[] { new Item("fixme", 0, 0) };
        GildedRose app = new GildedRose(items);

        app.updateQuality();

        assertEquals("fixme", app.items[0].name);
    }

    @Test
    public void quality_degrades_twice_as_fast_when_sell_date_passed() throws Exception {
        Item[] items = new Item[] { new Item("A standard item", -1, 2) };
        GildedRose app = new GildedRose(items);

        app.updateQuality();

        assertEquals(-2, app.items[0].sellIn);
        assertEquals(0, app.items[0].quality);
    }
}

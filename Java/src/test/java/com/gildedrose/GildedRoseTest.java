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

    @Test
    public void quality_of_an_item_is_never_negative() throws Exception {
        Item[] items = new Item[] { new Item("Any item", 5, 0) };
        GildedRose app = new GildedRose(items);

        app.updateQuality();

        assertEquals(4, app.items[0].sellIn);
        assertEquals(0, app.items[0].quality);
    }

    @Test
    public void aged_brie_increase_in_quality_with_time() throws Exception {
        Item[] items = new Item[] { new Item("Aged Brie", 5, 0) };
        GildedRose app = new GildedRose(items);

        app.updateQuality();

        assertEquals(4, app.items[0].sellIn);
        assertEquals(1, app.items[0].quality);
    }

    @Test
    public void quality_is_never_greater_than_50() throws Exception {
        Item[] items = new Item[] { new Item("Aged Brie", 5, 50) };
        GildedRose app = new GildedRose(items);

        app.updateQuality();

        assertEquals(4, app.items[0].sellIn);
        assertEquals(50, app.items[0].quality);
    }

    @Test
    public void sulfuras_sell_in_date_never_decrease() throws Exception {
        Item[] items = new Item[] { new Item("Sulfuras, Hand of Ragnaros", 10, 1) };
        GildedRose app = new GildedRose(items);

        app.updateQuality();

        assertEquals(10, app.items[0].sellIn);
    }

    @Test
    public void sulfuras_quality_never_degrades() throws Exception {
        Item[] items = new Item[] { new Item("Sulfuras, Hand of Ragnaros", 10, 1) };
        GildedRose app = new GildedRose(items);

        app.updateQuality();

        assertEquals(1, app.items[0].quality);
    }

    @Test
    public void backstage_passes_increase_in_quality() throws Exception {
        Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", 20, 1) };
        GildedRose app = new GildedRose(items);

        app.updateQuality();

        assertEquals(2, app.items[0].quality);
    }

    @Test
    public void backstage_passes_increase_in_quality_by_2_when_10_days_left() throws Exception {
        Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", 10, 1) };
        GildedRose app = new GildedRose(items);

        app.updateQuality();

        assertEquals(3, app.items[0].quality);
    }

    @Test
    public void backstage_passes_increase_in_quality_by_2_when_5_days_left() throws Exception {
        Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", 5, 1) };
        GildedRose app = new GildedRose(items);

        app.updateQuality();

        assertEquals(4, app.items[0].quality);
    }

    @Test
    public void backstage_passes_quality_drops_to_0_after_due_date() throws Exception {
        Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", 0, 10) };
        GildedRose app = new GildedRose(items);

        app.updateQuality();

        assertEquals(0, app.items[0].quality);
    }

    @Test
    public void conjured_item_degrades_in_quality_by_2_before_sell_in_date() throws Exception {
        Item[] items = new Item[] { new Item("Conjured Mana Cake", 6, 10) };
        GildedRose app = new GildedRose(items);

        app.updateQuality();

        assertEquals(8, app.items[0].quality);
    }

    @Test
    public void conjured_item_degrades_in_quality_by_4_after_sell_in_date() throws Exception {
        Item[] items = new Item[] { new Item("Conjured Mana Cake", 0, 10) };
        GildedRose app = new GildedRose(items);

        app.updateQuality();

        assertEquals(6, app.items[0].quality);
    }
}

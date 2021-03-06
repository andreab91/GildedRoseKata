package test.java.com.gildedrose;

import static org.junit.Assert.assertEquals;

import main.java.com.gildedrose.GildedRose;
import main.java.com.gildedrose.Item;
import org.junit.Test;


public class GildedRoseTest {

    @Test
    public void testConjuredQualityDecreaseTwiceAsNormal() throws Exception {
        Item[] items = new Item[] { new Item("Conjured", 1, 2) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(0, app.items[0].quality);
    }

    @Test
    public void testConjuredQualityDecreaseTwiceAsNormalAfterSellDate() throws Exception {
        Item[] items = new Item[] { new Item("Conjured", 0, 4) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(0, app.items[0].quality);
    }

    @Test
    public void testItemQualityAlwaysPositive() throws Exception {
        Item[] items = new Item[] { new Item("foo", 1, 0) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(0, app.items[0].quality);
    }

    @Test
    public void testItemQualityNeverAbove50() throws Exception {
        Item[] items = new Item[] { new Item("Aged Brie", 1, 50) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(50, app.items[0].quality);
    }

    @Test
    public void testStandardItemDecreaseByOneAfterOneDay() throws Exception {
        Item[] items = new Item[] {
                new Item("+5 Dexterity Vest", 1, 1),
                new Item("Elixir of the Mongoose", 1, 1),
                new Item("foo", 1, 1),
        };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(0, app.items[0].quality);
        assertEquals(0, app.items[1].quality);
        assertEquals(0, app.items[2].quality);
    }

    @Test
    public void testStandardItemDecreaseByTwoAfterSellDate() throws Exception {
        Item[] items = new Item[] { new Item("foo", 0, 2) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(0, app.items[0].quality);
    }

    @Test
    public void testAgedBrieIncreaseByOneAfterOneDay() throws Exception {
        Item[] items = new Item[] { new Item("Aged Brie", 1, 0) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(1, app.items[0].quality);
    }

    @Test
    public void testSulfurasQualityNeverChanges() throws Exception {
        Item[] items = new Item[] { new Item("Sulfuras, Hand of Ragnaros", 1, 80) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(80, app.items[0].quality);
    }

    @Test
    public void testBackstagePassesIncreaseByOneIfMoreThan10DaysLeft() throws Exception {
        Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", 11, 0) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(1, app.items[0].quality);
    }

    @Test
    public void testBackstagePassesIncreaseByTwoIfLessThan10DaysLeft() throws Exception {
        Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", 10, 0) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(2, app.items[0].quality);
    }

    @Test
    public void testBackstagePassesIncreaseByThreeIfLessThan5DaysLeft() throws Exception {
        Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", 5, 0) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(3, app.items[0].quality);
    }

    @Test
    public void testBackstagePassesGoToZeroAfterConcert() throws Exception {
        Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", 0, 10) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(0, app.items[0].quality);
    }
}

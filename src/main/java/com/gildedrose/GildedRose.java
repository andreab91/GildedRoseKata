package main.java.com.gildedrose;

public class GildedRose {
    public Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (int i = 0; i < items.length; i++) {
            QualityUpdater qualityUpdater = QualityUpdaterFactory.create(items[i]);
            qualityUpdater.updateQualityOf(items[i]);

            updateSellDate(items[i]);

            if (items[i].sellIn < 0) {
                if (!items[i].name.equals("Aged Brie")) {
                    if (!items[i].name.equals("Backstage passes to a TAFKAL80ETC concert")) {
                        if (items[i].quality > 0) {
                            qualityUpdater.updateQualityOf(items[i]);
                        }
                    } else {
                        items[i].quality = 0;
                    }
                } else {
                    if (items[i].quality < 50) {
                        increaseQualityByOne(i);
                    }
                }
            }
        }
    }

    private void increaseQualityByOne(int i) {
        items[i].quality = items[i].quality + 1;
    }

    private void updateSellDate(Item item) {
        if (!item.name.equals("Sulfuras, Hand of Ragnaros")) {
            item.sellIn = item.sellIn - 1;
        }
    }

    private void updateBackstagePassQuality(Item item) {
        if (item.sellIn < 11) {
            if (item.quality < 50) {
                item.quality = item.quality + 1;
            }
        }
        if (item.sellIn < 6) {
            if (item.quality < 50) {
                item.quality = item.quality + 1;
            }
        }
    }
}

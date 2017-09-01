package com.gildedrose;

public class AgedBrieUpdateStrategy implements UpdateStrategy {
    @Override
    public boolean canHandle(Item item) {
        return item.name.equals("Aged Brie");
    }

    @Override
    public void updateQuality(Item item) {
        item.sellIn = item.sellIn - 1;

        if (item.quality < 50) {
            item.quality = item.quality + 1;

            if (item.sellIn < 0) {
                item.quality = item.quality + 1;
            }
        }
    }
}

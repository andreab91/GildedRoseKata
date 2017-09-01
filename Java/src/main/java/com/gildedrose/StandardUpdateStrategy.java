package com.gildedrose;

public class StandardUpdateStrategy implements UpdateStrategy {
    @Override
    public boolean canHandle(Item item) {
        return true;
    }

    @Override
    public void updateQuality(Item item) {
        item.sellIn = item.sellIn - 1;

        if (item.quality > 0) {
            item.quality = item.quality - 1;
        }

        if (item.sellIn < 0) {
            if (item.quality > 0) {
                item.quality = item.quality - 1;
            }
        }
    }
}

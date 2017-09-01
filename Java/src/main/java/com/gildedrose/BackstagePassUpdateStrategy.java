package com.gildedrose;

public class BackstagePassUpdateStrategy implements UpdateStrategy {
    @Override
    public boolean canHandle(Item item) {
        return item.name.equals("Backstage passes to a TAFKAL80ETC concert");
    }

    @Override
    public void updateQuality(Item item) {
        item.sellIn = item.sellIn - 1;

        if (item.quality < 50) {
            item.quality = item.quality + 1;

            if (item.sellIn < 10) {
                item.quality = item.quality + 1;
            }

            if (item.sellIn < 5) {
                item.quality = item.quality + 1;
            }
        }

        if (item.sellIn < 0) {
            item.quality = 0;
        }
    }
}

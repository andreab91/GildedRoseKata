package com.gildedrose;

public class ConjuredUpdateStrategy implements UpdateStrategy {
    @Override
    public boolean canHandle(Item item) {
        return item.name.equals("Conjured Mana Cake");
    }

    @Override
    public void updateQuality(Item item) {
        item.sellIn = item.sellIn - 1;

        if (item.sellIn >= 0) {
            item.quality = item.quality - 2;
        } else {
            item.quality = item.quality - 4;
        }
    }
}

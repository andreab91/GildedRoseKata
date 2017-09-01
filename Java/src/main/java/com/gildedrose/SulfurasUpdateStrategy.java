package com.gildedrose;

public class SulfurasUpdateStrategy implements UpdateStrategy {
    @Override
    public boolean canHandle(Item item) {
        return item.name.equals("Sulfuras, Hand of Ragnaros");
    }

    @Override
    public void updateQuality(Item item) {

    }
}

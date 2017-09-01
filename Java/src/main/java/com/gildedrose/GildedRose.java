package com.gildedrose;

import java.util.Arrays;
import java.util.List;

class GildedRose {
    Item[] items;

    List<UpdateStrategy> strategies = Arrays.asList(
        new SulfurasUpdateStrategy(),
        new ConjuredUpdateStrategy(),
        new BackstagePassUpdateStrategy(),
        new AgedBrieUpdateStrategy(),
        new StandardUpdateStrategy()
    );

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (Item item : items) {
            UpdateStrategy updateStrategy = strategies.stream().filter(s -> s.canHandle(item)).findFirst().get();
            updateStrategy.updateQuality(item);
        }
    }
}
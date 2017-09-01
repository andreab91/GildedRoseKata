package com.gildedrose;

public interface UpdateStrategy {

    boolean canHandle(Item item);

    void updateQuality(Item item);
}

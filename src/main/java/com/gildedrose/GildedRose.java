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
        }
    }
}

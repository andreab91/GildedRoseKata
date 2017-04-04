package main.java.com.gildedrose;

public class GildedRose {
    public Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (Item item : items) {
            QualityUpdater qualityUpdater = QualityUpdaterFactory.create(item);
            qualityUpdater.updateQualityOf(item);
        }
    }
}

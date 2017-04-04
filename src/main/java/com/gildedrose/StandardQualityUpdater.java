package main.java.com.gildedrose;

/**
 * Created by andrea on 03/04/17.
 */
public class StandardQualityUpdater implements QualityUpdater {
    @Override
    public void updateQualityOf(Item item) {
        decreaseQuality(item);

        item.sellIn = item.sellIn - 1;

        if (item.sellIn < 0) {
            decreaseQuality(item);
        }
    }

    private void decreaseQuality(Item item) {
        if (item.quality > MIN_QUALITY) {
            item.quality = item.quality - STANDARD_QUALITY_DECREASE;
        }
    }
}

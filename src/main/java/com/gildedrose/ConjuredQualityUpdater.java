package main.java.com.gildedrose;

/**
 * Created by andrea on 04/04/17.
 */
public class ConjuredQualityUpdater implements QualityUpdater {
    @Override
    public void updateQualityOf(Item item) {
        if (item.quality > 0) {
            item.quality = item.quality - 2;
        }

        item.sellIn--;

        if (item.sellIn < 0) {
            decreaseQuality(item);
        }
    }

    private void decreaseQuality(Item item) {
        if (item.quality > 0) {
            item.quality = item.quality - 2;
        }
    }
}

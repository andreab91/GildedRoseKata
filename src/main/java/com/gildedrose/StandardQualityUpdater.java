package main.java.com.gildedrose;

/**
 * Created by andrea on 03/04/17.
 */
public class StandardQualityUpdater implements QualityUpdater {
    @Override
    public void updateQualityOf(Item item) {
        decreaseQuality(item);

        item.sellIn--;

        if (item.sellIn < 0) {
            decreaseQuality(item);
        }
    }

    private void decreaseQuality(Item item) {
        if (item.quality > 0) {
            item.quality = item.quality - 1;
        }
    }
}

package main.java.com.gildedrose;

/**
 * Created by andrea on 03/04/17.
 */
public class AgedBrieQualityUpdater implements QualityUpdater {
    @Override
    public void updateQualityOf(Item item) {
        increaseQuality(item);

        item.sellIn--;

        if(item.sellIn < 0) {
            increaseQuality(item);
        }
    }

    private void increaseQuality(Item item) {
        if(item.quality < 50) {
            item.quality = item.quality + 1;
        }
    }
}
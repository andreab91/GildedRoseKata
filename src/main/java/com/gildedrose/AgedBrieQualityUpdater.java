package main.java.com.gildedrose;

/**
 * Created by andrea on 03/04/17.
 */
public class AgedBrieQualityUpdater implements QualityUpdater {

    @Override
    public void updateQualityOf(Item item) {
        increaseQuality(item);

        item.sellIn = item.sellIn - 1;

        if(item.sellIn < 0) {
            increaseQuality(item);
        }
    }

    private void increaseQuality(Item item) {
        if(item.quality < MAX_QUALITY) {
            item.quality = item.quality + STANDARD_QUALITY_INCREASE;
        }
    }
}

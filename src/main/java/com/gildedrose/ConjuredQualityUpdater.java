package main.java.com.gildedrose;

/**
 * Created by andrea on 04/04/17.
 */
public class ConjuredQualityUpdater implements QualityUpdater {
    public static final int CONJURED_QUALITY_DECREASE = STANDARD_QUALITY_DECREASE * 2;

    @Override
    public void updateQualityOf(Item item) {
        decreaseQuality(item);

        item.sellIn = item.sellIn - 1;

        if (item.sellIn < 0) {
            decreaseQuality(item);
        }
    }

    private void decreaseQuality(Item item) {
        if (item.quality - CONJURED_QUALITY_DECREASE >= MIN_QUALITY) {
            item.quality = item.quality - CONJURED_QUALITY_DECREASE;
        }
    }
}

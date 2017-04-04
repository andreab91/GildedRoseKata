package main.java.com.gildedrose;

/**
 * Created by andrea on 03/04/17.
 */
public class BackstagePassQualityUpdater implements QualityUpdater {

    private static final int BACKSTAGE_PASS_MIN_QUALITY = MIN_QUALITY;

    @Override
    public void updateQualityOf(Item item) {
        increaseQuality(item);

        if (tenOrLessDaysLeft(item)) {
            increaseQuality(item);
        }
        if (fiveOrLessDaysLeft(item)) {
            increaseQuality(item);
        }

        item.sellIn = item.sellIn - 1;

        if (item.sellIn < 0) {
            item.quality = BACKSTAGE_PASS_MIN_QUALITY;
        }
    }

    private boolean fiveOrLessDaysLeft(Item item) {
        return item.sellIn < 6;
    }

    private boolean tenOrLessDaysLeft(Item item) {
        return item.sellIn < 11;
    }

    private void increaseQuality(Item item) {
        if (item.quality < MAX_QUALITY) {
            item.quality = item.quality + STANDARD_QUALITY_INCREASE;
        }
    }
}

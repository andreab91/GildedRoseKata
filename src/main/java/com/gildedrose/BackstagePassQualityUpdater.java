package main.java.com.gildedrose;

/**
 * Created by andrea on 03/04/17.
 */
public class BackstagePassQualityUpdater implements QualityUpdater {
    @Override
    public void updateQualityOf(Item item) {
        increaseQuality(item);

        if (tenOrLessDaysLeft(item)) {
            increaseQuality(item);
        }
        if (fiveOrLessDaysLeft(item)) {
            increaseQuality(item);
        }

        item.sellIn--;

        if (item.sellIn < 0) {
            item.quality = 0;
        }
    }

    private boolean fiveOrLessDaysLeft(Item item) {
        return item.sellIn < 6;
    }

    private boolean tenOrLessDaysLeft(Item item) {
        return item.sellIn < 11;
    }

    private void increaseQuality(Item item) {
        if (item.quality < 50) {
            item.quality = item.quality + 1;
        }
    }
}

package main.java.com.gildedrose;

/**
 * Created by andrea on 03/04/17.
 */
public class BackstagePassQualityUpdater implements QualityUpdater {
    @Override
    public void updateQualityOf(Item item) {
        if (item.quality < 50) {
            item.quality = item.quality + 1;
        }
        if (item.sellIn < 11) {
            if (item.quality < 50) {
                item.quality = item.quality + 1;
            }
        }
        if (item.sellIn < 6) {
            if (item.quality < 50) {
                item.quality = item.quality + 1;
            }
        }

        item.sellIn--;

        if (item.sellIn < 0) {
            item.quality = 0;
        }
    }
}

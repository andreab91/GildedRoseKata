package main.java.com.gildedrose;

/**
 * Created by andrea on 03/04/17.
 */
public class StandardQualityUpdater implements QualityUpdater {
    @Override
    public void updateQualityOf(Item item) {
        if(item.quality > 0) {
            item.quality = item.quality - 1;
        }

        item.sellIn--;

        if(item.sellIn < 0) {
            item.quality = item.quality - 1;
        }
    }
}

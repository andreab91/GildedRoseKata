package main.java.com.gildedrose;

/**
 * Created by andrea on 03/04/17.
 */
class QualityUpdaterFactory {
    public static QualityUpdater create(Item item) {
        if(item.name.contains("Aged Brie")) {
            return new AgedBrieQualityUpdater();
        }
        else if(item.name.contains("Sulfuras")) {
            return new SulfurasQualityUpdater();
        }
        else if(item.name.contains("Backstage passes")) {
            return new BackstagePassQualityUpdater();
        }
        else if(item.name.contains("Conjured")) {
            return new ConjuredQualityUpdater();
        }
        else {
            return new StandardQualityUpdater();
        }
    }
}

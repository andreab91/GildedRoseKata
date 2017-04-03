package main.java.com.gildedrose;

/**
 * Created by andrea on 03/04/17.
 */
public class QualityUpdaterFactory {
    public static QualityUpdater create(Item item) {
        if(item.name.contains("Aged Brie")) {
            return null;
        }
        else if(item.name.contains("Sulfuras")) {
            return null;
        }
        else if(item.name.contains("Backstage passes")) {
            return null;
        }
        else {
            return new StandardQualityUpdater();
        }
    }
}

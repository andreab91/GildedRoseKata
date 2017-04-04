package main.java.com.gildedrose;

/**
 * Created by andrea on 03/04/17.
 */
public interface QualityUpdater {
    int MIN_QUALITY = 0;
    int MAX_QUALITY = 50;
    int STANDARD_QUALITY_INCREASE = 1;
    int STANDARD_QUALITY_DECREASE = 1;

    void updateQualityOf(Item item);
}

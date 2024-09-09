package com.gildedrose;

public class ConjuredUpdater extends ItemUpdater {
    @Override
    public void update(Item item) {
        degradeQuality(item);
        degradeQuality(item);

        decreaseSellIn(item);

        if (isPassedSellIn(item)) {
            degradeQuality(item);
            degradeQuality(item);
        }
    }
}

package com.gildedrose;

public class NormalUpdater extends ItemUpdater {
    @Override
    public void update(Item item) {
        degradeQuality(item);

        decreaseSellIn(item);

        if (isPassedSellIn(item)) {
            degradeQuality(item);
        }
    }
}

package com.gildedrose;

public class BrieUpdater extends ItemUpdater {
    @Override
    public void update(Item item) {
        upgradeQuality(item);

        decreaseSellIn(item);

        if (isPassedSellIn(item)) {
            upgradeQuality(item);
        }
    }
}

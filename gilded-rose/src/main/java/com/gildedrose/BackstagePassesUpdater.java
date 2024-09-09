package com.gildedrose;

public class BackstagePassesUpdater extends ItemUpdater {
    @Override
    public void update(Item item) {
        upgradeQuality(item);

        if (item.sellIn < 11) {
            upgradeQuality(item);
        }

        if (item.sellIn < 6) {
            upgradeQuality(item);
        }

        decreaseSellIn(item);

        if (isPassedSellIn(item)) {
            item.quality = 0;
        }
    }
}

package com.gildedrose;

class ItemUpdater {

    private Item item;

    private void upgradeQuality(Item item) {
        if (item.quality < 50) {
            item.quality = item.quality + 1;
        }
    }

    private void degradeQuality(Item item) {
        if (item.quality > 0) {
            item.quality = item.quality - 1;
        }
    }

    private void decreaseSellIn(Item item) {
        item.sellIn = item.sellIn - 1;
    }

    private boolean isPassedSellIn(Item item) {
        return item.sellIn < 0;
    }

    public ItemUpdater() {
    }

    public void update(Item item) {
        switch (item.name) {
            case "Aged Brie":
                updateBrie(item);
                break;
            case "Backstage passes to a TAFKAL80ETC concert":
                updateBackstagePasses(item);
                break;
            case "Sulfuras, Hand of Ragnaros":

                break;
            case "Conjured Mana Cake":
                updateConjuredItem(item);
                break;
            default:
                updateNormalItem(item);
                break;
        }
    }

    private void updateNormalItem(Item item) {
        degradeQuality(item);

        decreaseSellIn(item);

        if (isPassedSellIn(item)) {
            degradeQuality(item);
        }
    }

    private void updateConjuredItem(Item item) {
        degradeQuality(item);
        degradeQuality(item);

        decreaseSellIn(item);

        if (isPassedSellIn(item)) {
            degradeQuality(item);
            degradeQuality(item);
        }
    }

    private void updateBackstagePasses(Item item) {
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

    private void updateBrie(Item item) {
        upgradeQuality(item);

        decreaseSellIn(item);

        if (isPassedSellIn(item)) {
            upgradeQuality(item);
        }
    }
}

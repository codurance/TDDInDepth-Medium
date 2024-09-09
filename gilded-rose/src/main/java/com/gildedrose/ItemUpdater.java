package com.gildedrose;

abstract class ItemUpdater {

    private Item item;

    public static ItemUpdater forItem(Item item) {
        switch (item.name) {
            case "Aged Brie":
                return new BrieUpdater();
            case "Backstage passes to a TAFKAL80ETC concert":
                return new BackstagePassesUpdater();
            case "Sulfuras, Hand of Ragnaros":
                return new LegendaryUpdater();
            case "Conjured Mana Cake":
                return new ConjuredUpdater();
            default:
                return new NormalUpdater();
        }
    }

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

    abstract void update(Item item);

    protected void updateNormalItem(Item item) {
        degradeQuality(item);

        decreaseSellIn(item);

        if (isPassedSellIn(item)) {
            degradeQuality(item);
        }
    }

    protected void updateConjuredItem(Item item) {
        degradeQuality(item);
        degradeQuality(item);

        decreaseSellIn(item);

        if (isPassedSellIn(item)) {
            degradeQuality(item);
            degradeQuality(item);
        }
    }

    protected void updateBackstagePasses(Item item) {
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

    protected void updateBrie(Item item) {
        upgradeQuality(item);

        decreaseSellIn(item);

        if (isPassedSellIn(item)) {
            upgradeQuality(item);
        }
    }
}

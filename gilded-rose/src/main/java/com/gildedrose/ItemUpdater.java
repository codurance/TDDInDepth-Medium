package com.gildedrose;

abstract class ItemUpdater {

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

    protected void upgradeQuality(Item item) {
        if (item.quality < 50) {
            item.quality = item.quality + 1;
        }
    }

    protected void degradeQuality(Item item) {
        if (item.quality > 0) {
            item.quality = item.quality - 1;
        }
    }

    protected void decreaseSellIn(Item item) {
        item.sellIn = item.sellIn - 1;
    }

    protected boolean isPassedSellIn(Item item) {
        return item.sellIn < 0;
    }

    abstract void update(Item item);

}

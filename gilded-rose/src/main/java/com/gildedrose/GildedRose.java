package com.gildedrose;

class GildedRose {
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (int i = 0; i < items.length; i++) {
            Item item = items[i];
            if (item.name.equals("Aged Brie")) {
                upgradeQuality(item);

                decreaseSellIn(item);

                if (isPassedSellIn(item)) {
                    upgradeQuality(item);
                }
            } else if (item.name.equals("Backstage passes to a TAFKAL80ETC concert")) {
                upgradeQuality(item);

                if (item.sellIn < 11) {
                    upgradeQuality(item);
                }

                if (item.sellIn < 6) {
                    upgradeQuality(item);
                }

                decreaseSellIn(item);

                if (isPassedSellIn(item)) {
                    item.quality = item.quality - item.quality;
                }
            } else if (item.name.equals("Sulfuras, Hand of Ragnaros")) {

            } else {
                degradeQuality(item);

                decreaseSellIn(item);

                if (isPassedSellIn(item)) {
                    degradeQuality(item);
                }

            }
        }
    }

    private static void upgradeQuality(Item item) {
        if (item.quality < 50) {
            item.quality = item.quality + 1;
        }
    }

    private static void decreaseSellIn(Item item) {
        item.sellIn = item.sellIn - 1;
    }

    private static void degradeQuality(Item item) {
        if (item.quality > 0) {
            item.quality = item.quality - 1;
        }
    }

    private static boolean isPassedSellIn(Item item) {
        return item.sellIn < 0;
    }
}

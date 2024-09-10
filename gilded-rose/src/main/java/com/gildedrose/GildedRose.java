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
                if (item.quality < 50) {
                    item.quality = item.quality + 1;

                }

                item.sellIn = item.sellIn - 1;

                if (isPassedSellIn(item)) {
                    if (item.quality < 50) {
                        item.quality = item.quality + 1;
                    }
                }
            } else if (item.name.equals("Backstage passes to a TAFKAL80ETC concert")) {
                if (item.quality < 50) {
                    item.quality = item.quality + 1;

                    if (item.sellIn < 11) {
                        if (item.quality < 50) {
                            item.quality = item.quality + 1;
                        }
                    }

                    if (item.sellIn < 6) {
                        if (item.quality < 50) {
                            item.quality = item.quality + 1;
                        }
                    }
                }

                item.sellIn = item.sellIn - 1;

                if (isPassedSellIn(item)) {
                    item.quality = item.quality - item.quality;
                }
            } else if (item.name.equals("Sulfuras, Hand of Ragnaros")) {

            } else {
                if (item.quality > 0) {
                    item.quality = item.quality - 1;
                }

                item.sellIn = item.sellIn - 1;

                if (isPassedSellIn(item)) {
                    if (item.quality > 0) {
                        item.quality = item.quality - 1;
                    }
                }

            }
        }
    }

    private static boolean isPassedSellIn(Item item) {
        return item.sellIn < 0;
    }
}

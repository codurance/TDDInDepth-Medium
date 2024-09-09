package com.gildedrose;

class GildedRose {
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (int i = 0; i < items.length; i++) {
            Item item = items[i];
            new ItemUpdater(item).invoke();
        }
    }

    private class ItemUpdater {

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

        public ItemUpdater(Item item) {
            this.item = item;
        }

        public void invoke() {
            update(item);
        }

        private void update(Item item) {
            switch (item.name) {
                case "Aged Brie":
                    upgradeQuality(item);

                    decreaseSellIn(item);

                    if (isPassedSellIn(item)) {
                        upgradeQuality(item);
                    }
                    break;
                case "Backstage passes to a TAFKAL80ETC concert":
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
                    break;
                case "Sulfuras, Hand of Ragnaros":

                    break;
                default:
                    degradeQuality(item);

                    decreaseSellIn(item);

                    if (isPassedSellIn(item)) {
                        degradeQuality(item);
                    }

                    break;
            }
        }
    }
}

package com.codurance.legacy.gildedrose;

import org.approvaltests.Approvals;
import org.approvaltests.reporters.DiffReporter;
import org.approvaltests.reporters.UseReporter;
import org.junit.jupiter.api.Test;

@UseReporter(DiffReporter.class)
public class GildedRoseApprovalTest {

    @Test
    public void shouldDecreaseTheItemQualityWhenQualityIsUpdated() {

        Item[] items = new Item[] { new Item("foo", 0, 0) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();

        Approvals.verifyAll("Items", items);
    }

}

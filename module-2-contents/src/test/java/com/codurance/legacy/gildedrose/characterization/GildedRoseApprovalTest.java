package com.codurance.legacy.gildedrose.characterization;

import org.approvaltests.Approvals;
import org.approvaltests.reporters.DiffReporter;
import org.approvaltests.reporters.UseReporter;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

@UseReporter(DiffReporter.class)
public class GildedRoseApprovalTest {

    @Test
    public void shouldDecreaseTheItemQualityWhenQualityIsUpdated() {

        Item[] items = new Item[] { new Item("foo", 0, 0) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();

        Approvals.verifyAll("Items", items);
    }

    @Test
    public void shouldIncreaseQualityForAgedBrie() {
        Item agedBrie = new Item("Aged Brie", 5, 10);
        Item[] items = new Item[]{agedBrie};
        GildedRose app = new GildedRose(items);

        app.updateQuality();

        Assertions.assertEquals(11, agedBrie.quality);
        Assertions.assertEquals(4, agedBrie.sellIn);
    }

    @Test
    public void shouldDecreaseTheItemQualityWhenQualityIsUpdatedDuringThirtyDays() {

        ByteArrayOutputStream fakeoutput = new ByteArrayOutputStream();
        System.setOut(new PrintStream(fakeoutput));
        System.setIn(new ByteArrayInputStream("a\n".getBytes()));

        Program.main();
        String output = fakeoutput.toString();

        Approvals.verify(output);
    }
}

package com.gildedrose;

import org.approvaltests.Approvals;
import org.junit.jupiter.api.Test;

public class TexttestFixtureApprovalTest {

    @Test
    public void approvalTest(){
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("OMGHAI").append("\n");

        Item[] items = new Item[] {
                new Item("+5 Dexterity Vest", 10, 20), //
                new Item("Aged Brie", 2, 0), //
                new Item("Elixir of the Mongoose", 5, 7), //
                new Item("Sulfuras, Hand of Ragnaros", 0, 80), //
                new Item("Sulfuras, Hand of Ragnaros", -1, 80),
                new Item("Backstage passes to a TAFKAL80ETC concert", 15, 20),
                new Item("Backstage passes to a TAFKAL80ETC concert", 10, 49),
                new Item("Backstage passes to a TAFKAL80ETC concert", 5, 49),
                // this conjured item does not work properly yet
                new Item("Conjured Mana Cake", 3, 6) };

        GildedRose app = new GildedRose(items);

        int days = 5;

        for (int i = 1; i <= days; i++) {
            stringBuilder.append("-------- day ")
                    .append(i)
                    .append(" --------")
                    .append("\n");

            stringBuilder.append("name, sellIn, quality")
                    .append("\n");
            for (Item item : items) {
                stringBuilder.append(item)
                        .append("\n");
            }

            stringBuilder.append("\n");

            app.updateQuality();
        }

        Approvals.verify(stringBuilder.toString());
    }
}

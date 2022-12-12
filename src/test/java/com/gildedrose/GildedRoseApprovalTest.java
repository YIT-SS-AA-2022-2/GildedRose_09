package com.gildedrose;

import org.approvaltests.Approvals;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GildedRoseApprovalTest {

    @Test
    public void gildedRoseApprovalTest() throws Exception{
        Item[] items = new Item[]{
                new Item("Aged Brie", 20, 0), //
                new Item("Sulfuras", 0, 80), //
                new Item("Sulfuras", -1, 80),
                new Item("Backstage passes", 15, 20),
                new Item("Backstage passes", 10, 20),
                new Item("Backstage passes", 5, 20)
        };
        GildedRose app = new GildedRose(items);
        StringBuilder results = new StringBuilder();
        for(int day = 1; day <= 100; day++){
            String dayAndItems = Arrays.asList(items).stream().map(n->String.valueOf(n)).collect(Collectors.joining("\t"));
            results.append(dayAndItems);
            results.append("\n");
            app.updateQuality();
        }
        Approvals.verify(results.toString());
        assertEquals(41742866, results.toString().hashCode());
    }
}

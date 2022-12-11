package com.gildedrose;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class GildedRoseTest {

    @Test
    public void foo() {
        Item[] items = new Item[] { new Item("foo", 0, 0) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals("foo", app.items[0].name);
    }

    @Test
    public void DecreaseQualityWithEachDay(){
        Item[] items = new Item[] { new Item("foo", 1, 10) };
        GildedRose app = new GildedRose(items);

        /*
            유통 기한이 남아있을 경우
         */
        app.updateQuality();
        assertEquals(9,items[0].quality);

         /*
            유통 기한이 남아있지 않을 경우
         */
        app.updateQuality();
        assertEquals(7,items[0].quality);
    }

    @Test
    public void updateQualityAgedBrie(){
        Item[] items = new Item[] { new Item("Aged Brie", 1, 10) };
        GildedRose app = new GildedRose(items);

        /*
            유톹 기한이 지나기 전
         */
        app.updateQuality();
        assertEquals(11,items[0].quality);

        /*
            유통기한이 지난 후
         */
        app.updateQuality();
        assertEquals(13,items[0].quality);
    }

    @Test
    public void updateQualityBackstagePasses(){
        Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", 11, 10) };
        GildedRose app = new GildedRose(items);

        /*
            유통기한이 11일 이상인 경우
         */
        app.updateQuality();
        assertEquals(11,items[0].quality);

        /*
            유통기한이 10일 이하인 경우
         */
        app.updateQuality();
        assertEquals(13,items[0].quality);

        /*
            유통기한이 5일 이하인 경우
         */
        items[0].sellIn = 1;
        app.updateQuality();
        assertEquals(16,items[0].quality);

        /*
            유통기한이 지난 후
         */
        app.updateQuality();
        assertEquals(0,items[0].quality);
    }

    @Test
    public void updateQualitySulfuras(){
        Item[] items = new Item[] { new Item("Sulfuras, Hand of Ragnaros", 1, 10) };
        GildedRose app = new GildedRose(items);

        /*
            유통기한이 지나기 전
         */
        app.updateQuality();
        assertEquals(10,items[0].quality);

        /*
            유통기한이 지난 후
         */
        app.updateQuality();
        assertEquals(10,items[0].quality);
    }

}

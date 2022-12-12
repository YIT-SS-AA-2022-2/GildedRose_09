package com.gildedrose;

import org.junit.jupiter.api.DisplayName;
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
    @DisplayName("일반 아이템 테스트")
    public void DecreaseQualityWithEachDay() {
        Item[] items = new Item[] { new Item("foo", 1, 10) };
        GildedRose app = new GildedRose(items);

        //유통 기한 있을 때
        app.updateQuality();
        assertEquals(9, items[0].quality);

        //유통 기한 지났을 때
        app.updateQuality();
        assertEquals(7, items[0].quality);
    }

    @Test
    @DisplayName("AgedBrie 테스트")
    public void updateQualityAgedBrie(){
        Item[] items = new Item[] { new Item("Aged Brie", 1, 10) };
        GildedRose app = new GildedRose(items);

        // 유효기간 지나기 전
        app.updateQuality();
        assertEquals(11,items[0].quality);

        //유통기한이 지나고 나서
        app.updateQuality();
        assertEquals(13,items[0].quality);
    }

    @Test
    @DisplayName("BackstagePasses 테스트")
    public void updateQualityBackstagePasses(){
        Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", 11, 10) };
        GildedRose app = new GildedRose(items);

        //유통기한 > 11
        app.updateQuality();
        assertEquals(11,items[0].quality);

        //유통기한 <= 10
        app.updateQuality();
        assertEquals(13,items[0].quality);

        //유통기한  <= 5
        items[0].sellIn = 1;
        app.updateQuality();
        assertEquals(16,items[0].quality);

        //유통기한이 지난 후
        app.updateQuality();
        assertEquals(0,items[0].quality);
    }

    @Test
    @DisplayName("Sulfuras 테스트")
    public void updateQualitySulfuras() {
        Item[] items = new Item[]{new Item("Sulfuras, Hand of Ragnaros", 1, 10)};
        GildedRose app = new GildedRose(items);

        //유통기한이 지나기 전
        app.updateQuality();
        assertEquals(10, items[0].quality);

        //유통기한이 지난 후
        app.updateQuality();
        assertEquals(10, items[0].quality);
    }
}

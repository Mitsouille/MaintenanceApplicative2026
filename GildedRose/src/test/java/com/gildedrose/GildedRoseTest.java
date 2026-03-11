package com.gildedrose;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GildedRoseTest {

    @Test
    void test_ItemQualiUnder50(){
        Item[] items = new Item[] {new Item("Test", 50 ,45),
        new Item("Backstage passes to a TAFKAL80ETC concert", 45, 45),
        new Item("Sulfuras, Hand of Ragnaros", 45, 45),
        new Item("Aged Brie", 45, 45)
        };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals("Test", app.items[0].name);
        assertEquals(44, app.items[0].quality);
        assertEquals(49, app.items[0].sellIn);
        assertEquals("Backstage passes to a TAFKAL80ETC concert", app.items[1].name);
        assertEquals(46, app.items[1].quality);
        assertEquals(44, app.items[1].sellIn);
        assertEquals("Sulfuras, Hand of Ragnaros", app.items[2].name);
        assertEquals(45, app.items[2].quality);
        assertEquals(45, app.items[2].sellIn);
        assertEquals("Aged Brie", app.items[3].name);
        assertEquals(46, app.items[3].quality);
        assertEquals(44, app.items[3].sellIn);
    }

    @Test
    void test_ItemQualiOver50(){
        Item[] items = new Item[] {new Item("Test", 50 ,55),
                new Item("Backstage passes to a TAFKAL80ETC concert", 45, 105),
                new Item("Sulfuras, Hand of Ragnaros", 45, 75),
                new Item("Aged Brie", 45, 62)
        };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals("Test", app.items[0].name);
        assertEquals(54, app.items[0].quality);
        assertEquals(49, app.items[0].sellIn);
        assertEquals("Backstage passes to a TAFKAL80ETC concert", app.items[1].name);
        assertEquals(105, app.items[1].quality);
        assertEquals(44, app.items[1].sellIn);
        assertEquals("Sulfuras, Hand of Ragnaros", app.items[2].name);
        assertEquals(75, app.items[2].quality);
        assertEquals(45, app.items[2].sellIn);
        assertEquals("Aged Brie", app.items[3].name);
        assertEquals(62, app.items[3].quality);
        assertEquals(44, app.items[3].sellIn);
    }

    @Test
    void test_ItemSellInUnder11(){
        Item[] items = new Item[] {new Item("Test", 11 ,11),
                new Item("Backstage passes to a TAFKAL80ETC concert", 4, 10),
                new Item("Sulfuras, Hand of Ragnaros", 6, 6),
                new Item("Aged Brie", -5, 5),
                new Item("Second Test Item", -520, 15),
                new Item("Backstage passes to a TAFKAL80ETC concert", -5, 10)
        };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals("Test", app.items[0].name);
        assertEquals(10, app.items[0].quality);
        assertEquals(10, app.items[0].sellIn);
        assertEquals("Backstage passes to a TAFKAL80ETC concert", app.items[1].name);
        assertEquals(13, app.items[1].quality);
        assertEquals(3, app.items[1].sellIn);
        assertEquals("Sulfuras, Hand of Ragnaros", app.items[2].name);
        assertEquals(6, app.items[2].quality);
        assertEquals(6, app.items[2].sellIn);
        assertEquals("Aged Brie", app.items[3].name);
        assertEquals(7, app.items[3].quality);
        assertEquals(-6, app.items[3].sellIn);
        assertEquals("Second Test Item", app.items[4].name);
        assertEquals(13, app.items[4].quality);
        assertEquals(-521, app.items[4].sellIn);
        assertEquals("Backstage passes to a TAFKAL80ETC concert", app.items[5].name);
        assertEquals(0, app.items[5].quality);
        assertEquals(-6, app.items[5].sellIn);
    }


}

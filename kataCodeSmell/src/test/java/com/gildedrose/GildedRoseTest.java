package com.gildedrose;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class GildedRoseTest {

  Item[] items = new Item[]{ new Item("Sulfuras, Hand of Ragnaros", 1, 1) };

    @Test
    public void foo() {
        Item[] items = new Item[] { new Item("fixme", 0, 0) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals("fixme", app.items[0].name);
        assertEquals(-1, app.items[0].sellIn);
        assertEquals(0, app.items[0].quality);
    }

    @Test
    public void decrementarItemSulfuras(){
      GildedRose app = new GildedRose(this.items);
      Item item = app.decrementarSellInSulfuras(app.items[0]);
      assertEquals(0, item.sellIn);
      assertEquals("Sulfuras, Hand of Ragnaros", item.name);
    }
    
    @Test
    public void ConjuredTest()
    {
        Item[] items = new Item[] { new Item("Conjured Mana Cake", 10, 20) };
        GildedRose app = new GildedRose(items);
        int sellin = 10, quality = 20;
        for (int i = 0; i < 5; i++)
        {
            assertEquals(sellin, app.items[0].sellIn);
            assertEquals(quality, app.items[0].quality);
            app.updateQuality();
            sellin--;
            quality -= 2;
            //System.out.println(app.items[0].sellIn + " " + sellin + "----" + app.items[0].quality + " " + quality);
        }
    }
    
    @Test
    public void Backstage_Test()
    {
        Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", -1, 20) };
        GildedRose app = new GildedRose(items);
        int sellin = -1, quality = 20;
        for (int i = 0; i < 5; i++)
        {
            assertEquals(sellin, app.items[0].sellIn);
            if (i != 0)
                quality = 0;
            assertEquals(quality, app.items[0].quality);
            app.updateQuality();
            sellin--;
            //System.out.println(app.items[0].sellIn + " " + sellin + "----" + app.items[0].quality + " " + quality);
        }
    }
    
    @Test
    public void aged_Test()
    {
        Item[] items = new Item[] { new Item("Aged Brie", 6, 10) };
        GildedRose app = new GildedRose(items);
        int sellin = 6, quality = 10;
        for (int i = 0; i < 5; i++)
        {
            assertEquals(sellin, app.items[0].sellIn);
            assertEquals(quality, app.items[0].quality);
            app.updateQuality();
            sellin--;
            quality++;
           // System.out.println(app.items[0].sellIn + " " + sellin + "----" + app.items[0].quality + " " + quality);
        }
    }
    
    @Test
    public void sulfuras_Test()
    {
        Item[] items = new Item[] { new Item("Sulfuras, Hand of Ragnaros", 6, 10) };
        GildedRose app = new GildedRose(items);
        for (int i = 0; i < 5; i++)
        {
            assertEquals(6, app.items[0].sellIn);
            assertEquals(10, app.items[0].quality);
            app.updateQuality();
        }
    }
}

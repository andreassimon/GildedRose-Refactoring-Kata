package com.gildedrose;

import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.Matchers.*;

class GildedRoseTest {

    @Test
    void dexterity_vest() {
        Item[] items = new Item[] {
            new Item("+5 Dexterity Vest", 30, 1)
        };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertThat(app.items[0].quality, is(0));
    }

    @Test
    void aged_brie() {
        Item[] items = new Item[] {
                new Item("Aged Brie", 30, 1)
        };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertThat(app.items[0].quality, is(2));
    }

    @Test
    void aged_brie_after_date() {
        Item[] items = new Item[] {
                new Item("Aged Brie", -1, 1)
        };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertThat(app.items[0].quality, is(3));
    }

    @Test
    void backstage_passes() {
        Item[] items = new Item[] {
            new Item("Backstage passes to a TAFKAL80ETC concert", 30, 1)
        };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertThat(app.items[0].quality, is(2));
    }

    @Test
    void backstage_passes_within_10_days() {
        Item[] items = new Item[] {
            new Item("Backstage passes to a TAFKAL80ETC concert", 10, 1)
        };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertThat(app.items[0].quality, is(3));
    }

    @Test
    void backstage_passes_within_5_days() {
        Item[] items = new Item[] {
                new Item("Backstage passes to a TAFKAL80ETC concert", 5, 1)
        };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertThat(app.items[0].quality, is(4));
    }

    @Test
    void backstage_passes_after_concert() {
        Item[] items = new Item[] {
                new Item("Backstage passes to a TAFKAL80ETC concert", -1, 1)
        };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertThat(app.items[0].quality, is(0));
    }

    @Test
    void sulfuras() {
        Item[] items = new Item[] {
                new Item("Sulfuras, Hand of Ragnaros", 0, 80)
        };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertThat(app.items[0].quality, is(80));
    }

    @Test
    void sulfuras_2() {
        Item[] items = new Item[] {
                new Item("Sulfuras, Hand of Ragnaros", -1, 80)
        };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertThat(app.items[0].quality, is(80));
    }

    @Test
    void other() {
        Item[] items = new Item[] {
                new Item("Elixir of the Mongoose", -1, 10)
        };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertThat(app.items[0].quality, is(8));
    }
}

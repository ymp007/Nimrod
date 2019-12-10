package com.example.newproject.dummy;

import com.example.newproject.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Helper class for providing sample content for user interfaces created by
 * Android template wizards.
 * <p>
 * TODO: Replace all uses of this class before publishing your app.
 */
public class CategoryList {

    /**
     * An array of sample (dummy) items.
     */
    public static final List<Category> ITEMS = new ArrayList<Category>();

    /**
     * A map of sample (dummy) items, by ID.
     */

    private static final int COUNT = 25;

    static {
        // Add some sample items.
            ITEMS.add(new Category("Photography", R.drawable.photography));
            ITEMS.add(new Category("Audio Engineering",R.drawable.audio));
            ITEMS.add(new Category("Singers",R.drawable.singer));
            ITEMS.add(new Category("General labour",R.drawable.genral));
            ITEMS.add(new Category("Machine Operators",R.drawable.genral));
            ITEMS.add(new Category("Website Developer",R.drawable.webdeveloper));
            ITEMS.add(new Category("Mobile Developers",R.drawable.softwaredeveloper));
            ITEMS.add(new Category("Delivery Boys",R.drawable.delivery));
            ITEMS.add(new Category("Movers/Cleaners",R.drawable.movers));
    }

     public static class Category {
        public final String categoryName;
        public final int categoryImage;

        public Category(String categoryName,int categoryImage) {
            this.categoryName = categoryName;
            this.categoryImage = categoryImage;
        }

        @Override
        public String toString() {
            return "Category{" +
                    "categoryName='" + categoryName + '\'' +
                    '}';
        }
    }
}

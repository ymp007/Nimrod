package com.example.newproject.dummy;

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
public class JobList {

    /**
     * An array of sample (dummy) items.
     */
    public static final List<Jobs> ITEMS = new ArrayList<Jobs>();


    private static final int COUNT = 25;

    static {
        // Add some sample items.
        for (int i = 1; i <= COUNT; i++) {
            addItem(createDummyItem(i));
        }
    }

    private static void addItem(Jobs item) {
        ITEMS.add(item);
    }

    private static Jobs createDummyItem(int position) {
        return new Jobs("Candidate"+position,"Profession " + position, String.valueOf(position*25/10));
    }

    public static class Jobs {
        public final String profileName;
        public final String desgnation;
        public final String ratings;

        public Jobs(String profileName, String desgnation, String ratings) {
            this.profileName = profileName;
            this.desgnation = desgnation;
            this.ratings = ratings;
        }

        @Override
        public String toString() {
            return "Jobs{" +
                    "profileName='" + profileName + '\'' +
                    ", desgnation='" + desgnation + '\'' +
                    ", ratings='" + ratings + '\'' +
                    '}';
        }
    }
}

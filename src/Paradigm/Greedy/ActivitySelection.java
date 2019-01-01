package Paradigm.Greedy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

// You are given n activities with their start and finish times.
// Select the maximum number of activities that can be performed
// by a single person, assuming that a person can only work on a
// single activity at a time.
// Example 1 : Consider the following 3 activities sorted by
// by finish time.
//     start[]  =  {10, 12, 20};
//     finish[] =  {20, 25, 30};
// A person can perform at most two activities. The
// maximum set of activities that can be executed
// is {0, 2} [ These are indexes in start[] and
// finish[] ]
//
// Example 2 : Consider the following 6 activities
// sorted by by finish time.
//     start[]  =  {1, 3, 0, 5, 8, 5};
//     finish[] =  {2, 4, 6, 7, 9, 9};
// A person can perform at most four activities. The
// maximum set of activities that can be executed
// is {0, 1, 3, 4} [ These are indexes in start[] and
// finish[] ]
public class ActivitySelection {
    static class Activity {
        int start, finish;
        Activity(int start, int finish) {
            this.start = start;
            this.finish = finish;
        }
    }

    static class ActivityComparator implements Comparator<Activity> {
        public int compare(Activity a1, Activity a2) {
            return a1.finish - a2.finish;
        }
    }

    // Time : O(NlogN) because we need to sort the activities
    static List<List<Integer>> maxActivities(List<Activity> arr) {
        int n = arr.size();
        Collections.sort(arr, new ActivityComparator());
        // Can also use Arrays.sort(arr, new ActivityComparator());
        // when parameter is Activity[] arr
        List<List<Integer>> res = new ArrayList<>();

        int i = 0;
        List<Integer> chosen = new ArrayList<>();
        chosen.add(arr.get(i).start);
        chosen.add(arr.get(i).finish);
        res.add(chosen);

        for (int j = 1; j < n; j++) {
            if (arr.get(j).start >= arr.get(i).finish) {
                List<Integer> pair = new ArrayList<>();
                pair.add(arr.get(j).start);
                pair.add(arr.get(j).finish);
                res.add(pair);
                i = j;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        List<Activity> arr = new ArrayList<>();

        arr.add(new Activity(5, 9));
        arr.add(new Activity(1, 2));
        arr.add(new Activity(3, 4));
        arr.add(new Activity(0, 6));
        arr.add(new Activity(5, 7));
        arr.add(new Activity(8, 9));

        System.out.println("Max number of activities that can be performed : ");
        System.out.println(maxActivities(arr));
    }
}

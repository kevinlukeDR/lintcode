package BinarySearch;

import java.util.ArrayList;
import java.util.List;

public class CounterOfSmallerNum {

//    248. Count of Smaller Number
//    Give you an integer array (index from 0 to n-1, where n is the size of this array, value from 0 to 10000) and an query list. For each query, give you an integer, return the number of element in the array that are smaller than the given integer.
//
//    Example
//    For array [1,2,7,8,5], and queries [1,8,5], return [0,4,2]


    //TODO: Attention 0 -10000
    private class SegmentTreeNode {
        int start, end, count;
        SegmentTreeNode left, right;
        SegmentTreeNode(int start, int end, int count) {
            this.start = start;
            this.end = end;
            this.count = count;
            this.left = this.right = null;
        }
    }
    private SegmentTreeNode build(int start, int end) {
        if (start == end) {
            return new SegmentTreeNode(start, end, 0);
        }
        SegmentTreeNode root = new SegmentTreeNode(start, end, 0);
        int mid = start + (end - start) / 2;
        root.left = build(start, mid);
        root.right = build(mid + 1, end);
        root.count = root.left.count + root.right.count;
        return root;
    }
    private void modify(SegmentTreeNode root, int index) {
        if (root == null) {
            return;
        }
        if (root.start <= index && root.end >= index) {
            root.count++;
        }
        int mid = root.start + (root.end - root.start) / 2;
        if (index <= mid) {
            modify(root.left, index);
        } else {
            modify(root.right, index);
        }
    }
    private int query(SegmentTreeNode root, int start, int end) {
        if (root.start == start && root.end == end) {
            return root.count;
        }
        int leftCount = 0, rightCount = 0;
        int mid = root.start + (root.end - root.start) / 2;
        if (start <= mid) {
            if (end <= mid) {
                leftCount = query(root.left, start, end);
            } else {
                leftCount = query(root.left, start, mid);
                rightCount = query(root.right, mid + 1, end);
            }
        } else {
            rightCount = query(root.right, start, end);
        }
        return leftCount + rightCount;
    }
    public List<Integer> countOfSmallerNumber(int[] A, int[] queries) {
        // write your code here
        List<Integer> res = new ArrayList<>();
        SegmentTreeNode root = build(0, 10000);
        for (int num : A) {
            modify(root, num);
        }
        for (int query : queries) {
            res.add(query(root, 0, query - 1));
        }
        return res;
    }
}

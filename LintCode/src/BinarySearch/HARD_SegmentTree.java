package BinarySearch;

public class HARD_SegmentTree {


//    205. Interval Minimum Number
//    Given an integer array (index from 0 to n-1, where n is the size of this array), and an query list. Each query has two integers [start, end]. For each query, calculate the minimum number between index start and end in the given array, return the result list.
//
//            Example
//    For array [1,2,7,8,5], and queries [(1,2),(0,4),(2,4)], return [2,1,5]
//
//    Challenge
//    O(logN) time for each query



    // TODO: Details: http://wulc.me/2016/08/05/Segment%20Tree%20%E7%AE%80%E4%BB%8B/
    private class SegmentTreeNode {
        SegmentTreeNode left, right;
        int start, end, min;
        SegmentTreeNode (int start, int end, int min) {
            this.start = start;
            this.end = end;
            this.min = min;
            this.left = this.right = null;
        }
    }
    private SegmentTreeNode build(int[] A, int start, int end) {
        if (start == end) {
            return new SegmentTreeNode(start, end, A[start]);
        }
        SegmentTreeNode root = new SegmentTreeNode(start, end, Integer.MAX_VALUE);
        int mid = start + (end - start) / 2;
        root.left = build(A, start, mid);
        root.right = build(A, mid + 1, end);
        root.min = Math.min(root.left.min, root.right.min);
        return root;
    }
    private int query(SegmentTreeNode root, int start, int end) {
        // TODO: Notice these two statements
        if (start > end || root == null) {
            return 0;
        }
        if (root.start >= start && root.end <= end) {
            return root.min;
        }
        int mid = root.start + (root.end - root.start) / 2;
        int leftMin = Integer.MAX_VALUE, rightMin = Integer.MAX_VALUE;
        if (start <= mid) {
            if (end <= mid) {
                leftMin = query(root.left, start, end);
            } else {
                leftMin = query(root.left, start, mid);
                rightMin = query(root.right, mid + 1, end);
            }
        } else {
            rightMin = query(root.right, start, end);
        }
        return Math.min(leftMin, rightMin);
    }
}

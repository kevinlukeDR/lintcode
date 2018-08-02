package BinarySearch;

public class HARD_SegmentTreeSum {
    /* you may need to use some attributes here */

    /*
     * @param A: An integer array
     */
    private int[] A;
    private SegmentTreeNode root;

    public HARD_SegmentTreeSum(int[] A) {
        // do intialization if necessary
        this.A = A;
        // TODO: NullPointException Check
        if (A == null || A.length == 0) {
            root = null;
        } else {
            root = build(A, 0, A.length - 1);
        }
    }

    private class SegmentTreeNode {
        int start, end;
        long sum;
        SegmentTreeNode left, right;
        SegmentTreeNode (int start, int end, long sum) {
            this.start = start;
            this.end = end;
            this.sum = sum;
            this.left = this.right = null;
        }
    }

    private SegmentTreeNode build(int[] A, int start, int end) {
        if (start == end) {
            return new SegmentTreeNode(start, end, A[start]);
        }
        int mid = start + (end - start) / 2;
        SegmentTreeNode root = new SegmentTreeNode(start, end, 0L);
        root.left = build(A, start, mid);
        root.right = build(A, mid + 1, end);
        root.sum = root.left.sum + root.right.sum;
        return root;
    }

    public long query(int start, int end) {
        return query(root, start, end);
    }

    private long query(SegmentTreeNode root, int start, int end) {
        if (root.start == start && root.end == end) {
            return root.sum;
        }
        long leftSum = 0L, rightSum = 0L;
        int mid = root.start + (root.end - root.start) / 2;
        if (start <= mid) {
            if (end <= mid) {
                leftSum = query(root.left, start, end);
            } else {
                leftSum = query(root.left, start, mid);
                rightSum = query(root.right, mid + 1, end);
            }
        } else {
            rightSum = query(root.right, start, end);
        }
        return leftSum + rightSum;
    }

    public void modify(int index, int value) {
        // write your code here
        modify(root, index, value - A[index]);
        // TODO: Never forget this
        A[index] = value;
    }
    private void modify(SegmentTreeNode root, int index, long diff) {
        if (root == null) {
            return;
        }
        if (root.start <= index && root.end >= index) {
            root.sum += diff;
        }
        int mid = root.start + (root.end - root.start) / 2;
        if (index <= mid) {
            modify(root.left, index, diff);
        } else {
            modify(root.right, index, diff);
        }
    }
}

package com.algorithms.storehouse.tree.commonanchestor

/*
 Find the first common ancestor of two nodes in a binary tree.
 Avoid storing additional nodes in a data structure.
 NOTE: This is not necessarily a binary search tree.

Example:

    int[] array = {5, 3, 6, 1, 9, 11};
    TreeNode root = new TreeNode(20);
    for (int a : array) {
      root.insertInOrder(a);
    }
    TreeNode n1 = root.find(1);
    TreeNode n9 = root.find(9);
    TreeNode ancestor = CommonAncestor.commonAncestor(root, n1, n9);
    System.out.println(ancestor.data);

//5
 */
class CommonAncestor {

    fun findQuadratic(root: TreeNode, node1: TreeNode, node2: TreeNode): TreeNode {
        var n1 = node1
        var n2 = node2
        while (n1.parent != null) {
            n1 = n1.parent!!
            while (n2.parent != null) {
                n2 = n2.parent!!
                if (n2 == n1) return n2
            }
            n2 = node2
        }
        throw RuntimeException("No common ancestor")
    }


    fun findLinear(root: TreeNode, node1: TreeNode, node2: TreeNode): TreeNode {
        val visited = HashSet<TreeNode>()
        var n1 = node1
        var n2 = node2
        while (n1.parent != null) {
            visited.add(n1)
            n1 = n1.parent!!
        }
        while (n2.parent != null) {
            if (visited.contains(n2)) return n2
            n2 = n2.parent!!
        }
        throw RuntimeException("No common ancestor")
    }
}
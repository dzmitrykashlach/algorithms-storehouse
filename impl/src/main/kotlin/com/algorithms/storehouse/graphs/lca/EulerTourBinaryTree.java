package com.algorithms.storehouse.graphs.lca;
// https://www.geeksforgeeks.org/euler-tour-tree/

import lombok.NonNull;

import java.util.ArrayList;
import java.util.List;

public class EulerTourBinaryTree {

    public static List<Integer> build(@NonNull Node node, List<Integer> eulerTour) {
        eulerTour.add(node.data);
        if (node.left != null) {
            build(node.left, eulerTour);
            eulerTour.add(node.data);
        }
        if (node.right != null) {
            build(node.right, eulerTour);
            if (eulerTour.get(0) != node.data) {
                eulerTour.add(node.data);
            }
        }
        return eulerTour;
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        List<Integer> eulerTour = new ArrayList<>(29);
        root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);

        root.left.left.left = new Node(8);
        root.left.left.right = new Node(9);
        root.left.right.left = new Node(10);
        root.left.right.right = new Node(11);
        root.right.left.left = new Node(12);
        root.right.left.right = new Node(13);
        root.right.right.left = new Node(14);
        root.right.right.right = new Node(15);
        build(root, eulerTour);
        eulerTour.size();
    }
}

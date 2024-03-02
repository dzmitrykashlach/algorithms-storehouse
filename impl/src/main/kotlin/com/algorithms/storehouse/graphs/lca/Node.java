package com.algorithms.storehouse.graphs.lca;

import lombok.NonNull;

class Node {
    int data;
    Node left, right;

    Node(@NonNull Integer value)
    {
        data = value;
        left = right = null;
    }


}
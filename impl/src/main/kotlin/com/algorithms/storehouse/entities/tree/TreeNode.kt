package com.algorithms.storehouse.entities.tree


class TreeNode(var data: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
    var parent: TreeNode? = null
    private var size = 0

    init {
        size = 1
    }

    private fun setLeftChild(left: TreeNode?) {
        this.left = left
        if (left != null) {
            left.parent = this
        }
    }

    private fun setRightChild(right: TreeNode?) {
        this.right = right
        if (right != null) {
            right.parent = this
        }
    }

    fun insertInOrder(d: Int) {
        if (d <= data) {
            if (left == null) {
                setLeftChild(TreeNode(d))
            } else {
                left!!.insertInOrder(d)
            }
        } else {
            if (right == null) {
                setRightChild(TreeNode(d))
            } else {
                right!!.insertInOrder(d)
            }
        }
        size++
    }

    fun size(): Int {
        return size
    }

    val isBST: Boolean
        get() {
            if (left != null) {
                if (data < left!!.data || !left!!.isBST) {
                    return false
                }
            }
            if (right != null) {
                if (data >= right!!.data || !right!!.isBST) {
                    return false
                }
            }
            return true
        }

    fun height(): Int {
        val leftHeight = if (left != null) left!!.height() else 0
        val rightHeight = if (right != null) right!!.height() else 0
        return 1 + Math.max(leftHeight, rightHeight)
    }

    fun find(d: Int): TreeNode? {
        if (d == data) {
            return this
        } else if (d <= data) {
            return if (left != null) left!!.find(d) else null
        } else if (d > data) {
            return if (right != null) right!!.find(d) else null
        }
        return null
    }

    companion object {
        fun createMinimalBST(arr: IntArray, start: Int, end: Int): TreeNode? {
            if (end < start) {
                return null
            }
            val mid = (start + end) / 2
            val n = TreeNode(arr[mid])
            n.setLeftChild(createMinimalBST(arr, start, mid - 1))
            n.setRightChild(createMinimalBST(arr, mid + 1, end))
            return n
        }

        fun createMinimalBST(array: IntArray): TreeNode? {
            return createMinimalBST(array, 0, array.size - 1)
        }
    }
}
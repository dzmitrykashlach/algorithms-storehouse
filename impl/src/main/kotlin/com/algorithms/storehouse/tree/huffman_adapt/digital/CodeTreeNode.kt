package com.algorithms.storehouse.tree.huffman_adapt.digital

/**
 * Класс для представления узла кодового дерева
 */
class CodeTreeNode : Comparable<CodeTreeNode> {
    @JvmField
    var content: Int?
    @JvmField
    var weight: Int
    @JvmField
    var left: CodeTreeNode? = null
    @JvmField
    var right: CodeTreeNode? = null
    @JvmField
    var parent: CodeTreeNode? = null

    constructor(content: Int?, weight: Int) {
        this.content = content
        this.weight = weight
    }

    constructor(content: Int?, weight: Int, left: CodeTreeNode?, right: CodeTreeNode?, parent: CodeTreeNode?) {
        this.content = content
        this.weight = weight
        this.left = left
        this.right = right
        this.parent = parent
    }

    override fun compareTo(other: CodeTreeNode): Int {
        return other.weight - weight
    }

    fun updateWeights(): Int {
        return if (content != null) {
            weight
        } else {
            var w = 0
            if (right != null) {
                w += right!!.updateWeights()
            }
            if (left != null) {
                w += left!!.updateWeights()
            }
            weight = w
            weight
        }
    }
}
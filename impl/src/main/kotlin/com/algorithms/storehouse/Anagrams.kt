package com.algorithms.storehouse

class Anagrams(private val s1: String, private val s2: String) {
    fun check(): Boolean {
        if (s1.length == s2.length) {
            for (c in s1.toCharArray()) {
                if (s2.indexOf(c) == -1) {
                    return false
                }
            }
            return true
        }
        return false
    }

}
package com.algorithms.storehouse.streaming

class LimitedHashMap<K, V>(private val limit: Int) : HashMap<K, V>() {
    fun putKey(key: K, value: V): Boolean {
        return if (super.size >= limit && !super.containsKey(key)) {
            false
        } else {
            super.put(key, value)
            true
        }
    }
}
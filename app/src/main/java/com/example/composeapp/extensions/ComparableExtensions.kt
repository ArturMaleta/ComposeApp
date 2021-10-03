package com.example.composeapp.extensions


fun <T : Comparable<T>> MutableList<T>.mergeSort(): MutableList<T> {
    if (size <= 1) {
        return this
    }

    val pivot = size / 2
    val left = subList(0, pivot)
    val right = subList(pivot, size)

    fun merge(left: MutableList<T>, right: MutableList<T>): MutableList<T> {
        var indexLeft = 0
        var indexRight = 0
        val merged = mutableListOf<T>()

        while (indexLeft < left.count() && indexRight < right.count()) {
            if (left[indexLeft] <= right[indexRight]) {
                merged.add(left[indexLeft])
                indexLeft++
            } else {
                merged.add(right[indexRight])
                indexRight++
            }
        }

        while (indexLeft < left.size) {
            merged.add(left[indexLeft])
            indexLeft++
        }

        while (indexRight < right.size) {
            merged.add(right[indexRight])
            indexRight++
        }

        return merged
    }

    return merge(left.mergeSort(), right.mergeSort())
}


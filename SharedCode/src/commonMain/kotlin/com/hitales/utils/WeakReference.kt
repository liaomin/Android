package com.hitales.utils

expect class WeakReference<T :Any>{
    constructor(referred: T)
    fun clear()
    fun get(): T?
}
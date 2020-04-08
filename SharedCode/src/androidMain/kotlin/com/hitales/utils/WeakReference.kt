package com.hitales.utils

actual class WeakReference<T :Any> {

    private val mWeakReference:java.lang.ref.WeakReference<T>

    actual constructor(referred: T) {
        mWeakReference = java.lang.ref.WeakReference(referred)
    }

    actual fun clear() {
        mWeakReference.clear()
    }

    actual fun get(): T? {
        return mWeakReference.get()
    }

    actual fun use(block: (item: T) -> Unit) {
        val ref = mWeakReference.get()
        if(ref != null){
            block(ref)
        }
    }
}

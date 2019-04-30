package com.hitales.ui

import com.hitales.utils.EdgeInsets
import com.hitales.utils.Frame
import com.hitales.utils.NotificationCenter
import kotlinx.cinterop.*
import platform.CoreGraphics.CGRectMake
import platform.UIKit.*

val notificationCenter = NotificationCenter.getInstance()

inline fun Int.toUIColor():UIColor{
    val a = (this ushr 24 and 0x000000FF) / 255.0
    val r =  this ushr 16 and 0x000000FF
    val g =  this ushr 8 and 0x000000FF
    val b = this and 0x000000FF
    return UIColor.colorWithRed(r.toDouble(),g.toDouble(),b.toDouble(),a)
}

inline fun UIColor.toInt():Int{
    return memScoped {
        val r= cValuesOf(0.0).getPointer(this)
        val g= cValuesOf(0.0).getPointer(this)
        val b= cValuesOf(0.0).getPointer(this)
        val a= cValuesOf(0.0).getPointer(this)
        getRed(r,g,b,a)
        return ((a[0]*255).toInt() shl 24) or (r[0].toInt() shl 16) or (g[0].toInt() shl 8) or b[0].toInt()
    }
}

actual open class View {

    protected val mWidget: UIView = createWidget()

    init {
        setBackgroundColor(0)
    }

    actual var padding: EdgeInsets = EdgeInsets.zero()
    actual var margin:EdgeInsets = EdgeInsets.zero()

    actual open var frame:Frame
        set(value) {
            field = value
            setWidgetFrame(value)
        }

    actual var border:EdgeInsets? =  null

    actual var borderWith:Float = 0f

    actual var superView:LayoutView? = null

    actual open var id:Int
        get() = getWidget().tag.toInt()
        set(value) {
            getWidget().tag = value.toLong()
        }

    actual open var tag:Any? = null

    actual constructor(frame: Frame){
        this.frame = frame
    }

    open fun getWidget(): UIView {
        return mWidget
    }

    open fun createWidget(): UIView {
       return UIView()
    }

    open fun getIOSWidget(): UIView {
        return mWidget
    }

    actual open fun setBackgroundColor(color: Int) {
        getWidget().backgroundColor = color.toUIColor()
    }

    override fun toString(): String {
        return "${this::class}: frame :$frame"
    }

    actual open fun removeFromSuperView(){
        superView?.removeView(this)
    }

    actual open fun onAttachedToWindow() {

    }

    actual open fun onDetachedFromWindow() {

    }

    actual open fun onAttachedToView(layoutView: LayoutView) {
        println()
    }

    actual open fun onDetachedFromView(layoutView: LayoutView) {

    }

    open fun setWidgetFrame(value:Frame){
        getWidget().setFrame(CGRectMake(value.x.toDouble(),value.y.toDouble(),value.width.toDouble(),value.height.toDouble()))
    }
}
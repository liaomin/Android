package com.hitales.ui.ios

import com.hitales.ui.ScrollView
import com.hitales.ui.ViewGroup
import com.hitales.utils.WeakReference
import kotlinx.cinterop.ObjCAction
import platform.CoreGraphics.CGRectMake
import platform.CoreGraphics.CGSizeMake
import platform.QuartzCore.CALayer
import platform.UIKit.UIScrollView
import platform.UIKit.UIWindow
import kotlin.math.max

class IOSScrollView(protected val mView: WeakReference<ViewGroup>) : UIScrollView(CGRectMake(0.0,0.0,0.0,0.0)) {

    @ObjCAction
    fun willMoveToWindow(window: UIWindow?){
        val view = mView.get()
        if(window == null){
            view?.onDetachedFromWindow()
            this.layer.contents = null
        }else{
            view?.onAttachedToWindow()
            this.layer.setNeedsDisplay()
        }
    }

    override fun displayLayer(layer: CALayer) {
        val view = mView.get()
        if(view != null){
            view.mBackground?.onDraw(layer,view.mBackgroundColor)
        }
    }

}
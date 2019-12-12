package com.hitales.ui.ios

import com.hitales.ui.TextInput
import com.hitales.utils.WeakReference
import kotlinx.cinterop.ObjCAction
import platform.CoreGraphics.CGContextRef
import platform.CoreGraphics.CGRectMake
import platform.QuartzCore.CALayer
import platform.UIKit.UITextView
import platform.UIKit.UIWindow

class IOSInputView(val mView: WeakReference<TextInput>) : UITextView(CGRectMake(0.0,0.0,0.0,0.0),null) {

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

    override fun drawLayer(layer: CALayer, inContext: CGContextRef?) {
        val view = mView.get()
        if(view != null){
            view.mBackground?.onDraw(layer,view.mBackgroundColor)
        }
        super.drawLayer(layer, inContext)
    }

}
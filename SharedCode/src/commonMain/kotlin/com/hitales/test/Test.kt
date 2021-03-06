package com.hitales.test

import com.hitales.ui.*
import com.hitales.utils.Frame
import com.hitales.utils.assertUI

class TestController : BasicController() {

    var v: TextView?  = null

    override fun onCreate() {
        super.onCreate()
        assertUI()
        var index = 0
        val buttonWidth = Platform.windowWidth - 20
        val buttonHeight = 50f
        val rootView = ScrollView(Frame(0f,0f, Platform.windowWidth ,Platform.windowHeight))
        view = rootView
        rootView.setBackgroundColor(Colors.WHITE)
        var v  = Button("view shadow测试", Frame(10f,10f, buttonWidth , buttonHeight))
        rootView.addSubView(v)
        v.setBackgroundColor(Colors.BLUE)
        v.setBackgroundColor(Colors.RED,ViewState.PRESSED)
        v.setOnPressListener {
            this.push(TestViewController())
        }

        v.setOnLongPressListener {

        }

//        index++
//        v  = Button("view 背景测试", Frame(10f,(buttonHeight+10)*index+10f, buttonWidth , buttonHeight))
//        rootView.addSubView(v)
//        v.setBackgroundColor(Colors.BLUE)
//        v.setBackgroundColor(Colors.RED,ViewState.PRESSED)
//        v.setOnPressListener {
//            this.push(BackgroundTestControllerTest())
//        }

        index++
        v  = Button("view border测试", Frame(10f,(buttonHeight+10)*index+10f, buttonWidth , buttonHeight))
        rootView.addSubView(v)
        v.setBackgroundColor(Colors.BLUE)
        v.setBackgroundColor(Colors.RED,ViewState.PRESSED)
        v.setOnPressListener {
            this.push(BorderWidthTestControllerTest())
        }

        index++
        v  = Button("text view 测试", Frame(10f,(buttonHeight+10)*index+10f, buttonWidth , buttonHeight))
        rootView.addSubView(v)
        v.setBackgroundColor(Colors.BLUE)
        v.setBackgroundColor(Colors.RED,ViewState.PRESSED)
        v.setOnPressListener {
            this.push(TestTextControllerTest())
        }

        index++
        v  = Button("button 测试", Frame(10f,(buttonHeight+10)*index+10f, buttonWidth , buttonHeight))
        rootView.addSubView(v)
        v.setBackgroundColor(Colors.BLUE)
        v.setBackgroundColor(Colors.RED,ViewState.PRESSED)
        v.setOnPressListener {
            this.push(TestButtonController())
        }

        index++
        v  = Button("input 测试", Frame(10f,(buttonHeight+10)*index+10f, buttonWidth , buttonHeight))
        rootView.addSubView(v)
        v.setBackgroundColor(Colors.BLUE)
        v.setBackgroundColor(Colors.RED,ViewState.PRESSED)
        v.setOnPressListener {
            this.push(TestInputController())
        }

        index++
        v  = Button("imageView 测试", Frame(10f,(buttonHeight+10)*index+10f, buttonWidth , buttonHeight))
        rootView.addSubView(v)
        v.setBackgroundColor(Colors.BLUE)
        v.setBackgroundColor(Colors.RED,ViewState.PRESSED)
        v.setOnPressListener {
            this.push(TestImageController())
        }


        index++
        v  = Button("animation 测试", Frame(10f,(buttonHeight+10)*index+10f, buttonWidth , buttonHeight))
        rootView.addSubView(v)
        v.setBackgroundColor(Colors.BLUE)
        v.setBackgroundColor(Colors.RED,ViewState.PRESSED)
        v.setOnPressListener {
            this.push(TestAnimationController())
        }

        index++
        v  = Button("CollectionView 测试", Frame(10f,(buttonHeight+10)*index+10f, buttonWidth , buttonHeight))
        rootView.addSubView(v)
        v.setBackgroundColor(Colors.BLUE)
        v.setBackgroundColor(Colors.RED,ViewState.PRESSED)
        v.setOnPressListener {
            this.push(TestCollectionViewController())
        }

        index++
        val v4  = Button("测试4", Frame(0f,4000f,100f,100f))
        rootView.addSubView(v4)
        v4.setBackgroundColor(Colors.BLACK)
        v.setBackgroundColor(Colors.RED,ViewState.PRESSED)
        v4.setOnPressListener  {
            println("press $it")
        }
        v4.setOnLongPressListener {
            println("long press $it")
        }


//        rootView.contentSize = Size(Platform.windowWidth,4100f)

    }
//
//    fun ob(key:Any,value: Any?){
//        val frame = v!!.frame
//        frame.x += 1
////        v?.frame = frame
//    }

}
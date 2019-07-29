package com.ludaxord.projectsup.library.button.button

import android.content.Context
import android.util.AttributeSet
import android.widget.Button

class SupButton : Button {

    constructor(context: Context) : super(context)

    constructor(context: Context, res: Int) : this(context) {

    }

    constructor(context: Context, attrs: AttributeSet) : super(context, attrs)

    constructor(context: Context, attrs: AttributeSet, res: Int) : super(context, attrs) {

    }


}
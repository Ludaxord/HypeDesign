package com.ludaxord.projectsup.library.text.autocompletetextview

import android.content.Context
import android.util.AttributeSet

class SupAutoCompleteTextView: AbstractSupAutoCompleteTextView {

    constructor(context: Context, res: Pair<String, String>) : super(context, res)

    constructor(context: Context, attrs: AttributeSet, res: Pair<String, String>) : super(context, attrs, res)

    constructor(context: Context, attrs: AttributeSet, defStyle: Int, res: Pair<String, String>) : super(
        context,
        attrs,
        defStyle,
        res
    )

    constructor(context: Context) : super(context)

    constructor(context: Context, attrs: AttributeSet) : super(context, attrs)

    constructor(context: Context, attrs: AttributeSet, defStyle: Int) : super(context, attrs, defStyle)

}
package com.ludaxord.projectsup.library.utilities.views

import android.graphics.drawable.GradientDrawable
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.ludaxord.projectsup.R
import com.ludaxord.projectsup.library.utilities.Defaults
import com.ludaxord.projectsup.library.utilities.UtilsException


object ViewUtils {

    fun setViewCorners(view: View, corner: Float) {
        val backgroundShape = view.background
        if (backgroundShape is GradientDrawable) {
            setCornerRadius(backgroundShape, corner)
        } else {
            throw UtilsException(view.context.getString(R.string.utils_exception_gradient_drawable_message))
        }
    }

    fun setViewCustomCorners(view: View, corners: List<Float>) {
        val backgroundShape = view.background
        if (backgroundShape is GradientDrawable) {
            setCornerRadius(
                backgroundShape,
                corners[0],
                corners[1],
                corners[2],
                corners[3]
            )
        } else {
            throw UtilsException(view.context.getString(R.string.utils_exception_gradient_drawable_message))
        }
    }

    fun getChildren(view: View): ArrayList<View> {
        return getAllChildren(view)
    }

    fun setViewToBottom(view: View, withMargin: Int) {
        setMargin(view, marginBottom = withMargin)
    }

    fun setViewsIds(rootView: View, views: ArrayList<View>) {
        if (views.isNotEmpty()) {
            for (view in views) {
                setViewId(view)
            }
        } else {
            throw UtilsException(rootView.context.getString(R.string.utils_exception_empty_view_array_list_message))
        }
    }

    fun getViewIdName(view: View): String {
        return getIdName(view)
    }

    fun setViewsToRootView(rootView: ViewGroup, views: ArrayList<View>) {
        if (views.isNotEmpty()) {
            for (view in views) {
                setSubViewToView(rootView, view)
            }
        } else {
            throw UtilsException(rootView.context.getString(R.string.utils_exception_empty_view_array_list_message))
        }
    }

    fun setWeekDayWithDefaultPrefix(
        textView: TextView,
        name: String,
        dayNames: HashMap<String, String>,
        short: Boolean
    ) {
        val dayName = name.replace(textView.context.resources.getString(R.string.prefix_text), "")
        setWeekDaysBasedOnPrefix(
            textView,
            dayName,
            dayNames,
            short
        )
    }

    fun setWeekDaysManually(
        textView: TextView,
        name: String,
        rootView: ViewGroup,
        dayNames: HashMap<String, String>,
        short: Boolean
    ) {
        setWeekDays(textView, name, rootView, dayNames, short)
    }

    private fun setWeekDays(
        textView: TextView,
        name: String,
        rootView: ViewGroup,
        dayNames: HashMap<String, String>,
        short: Boolean
    ) {
        if (short) {
            when {
                name.contains(rootView.context.resources.getString(R.string.key_language_short_monday)) || name.contains(
                    rootView.context.resources.getString(R.string.key_language_full_monday)
                ) -> {
                    textView.text = dayNames[rootView.context.resources.getString(R.string.key_language_short_monday)]
                }
                name.contains(rootView.context.resources.getString(R.string.key_language_short_tuesday)) || name.contains(
                    rootView.context.resources.getString(R.string.key_language_full_tuesday)
                ) -> {
                    textView.text = dayNames[rootView.context.resources.getString(R.string.key_language_short_tuesday)]
                }
                name.contains(rootView.context.resources.getString(R.string.key_language_short_wednesday)) || name.contains(
                    rootView.context.resources.getString(R.string.key_language_full_wednesday)
                ) -> {
                    textView.text =
                        dayNames[rootView.context.resources.getString(R.string.key_language_short_wednesday)]
                }
                name.contains(rootView.context.resources.getString(R.string.key_language_short_thursday)) || name.contains(
                    rootView.context.resources.getString(R.string.key_language_full_thursday)
                ) -> {
                    textView.text = dayNames[rootView.context.resources.getString(R.string.key_language_short_thursday)]
                }
                name.contains(rootView.context.resources.getString(R.string.key_language_short_friday)) || name.contains(
                    rootView.context.resources.getString(R.string.key_language_full_friday)
                ) -> {
                    textView.text = dayNames[rootView.context.resources.getString(R.string.key_language_short_friday)]
                }
                name.contains(rootView.context.resources.getString(R.string.key_language_short_saturday)) || name.contains(
                    rootView.context.resources.getString(R.string.key_language_full_saturday)
                ) -> {
                    textView.text = dayNames[rootView.context.resources.getString(R.string.key_language_short_saturday)]
                }
                name.contains(rootView.context.resources.getString(R.string.key_language_short_sunday)) || name.contains(
                    rootView.context.resources.getString(R.string.key_language_full_sunday)
                ) -> {
                    textView.text = dayNames[rootView.context.resources.getString(R.string.key_language_short_sunday)]
                }
            }
        } else {
            when {
                name.contains(rootView.context.resources.getString(R.string.key_language_short_monday)) || name.contains(
                    rootView.context.resources.getString(R.string.key_language_full_monday)
                ) -> {
                    textView.text = dayNames[rootView.context.resources.getString(R.string.key_language_full_monday)]
                }
                name.contains(rootView.context.resources.getString(R.string.key_language_short_tuesday)) || name.contains(
                    rootView.context.resources.getString(R.string.key_language_full_tuesday)
                ) -> {
                    textView.text = dayNames[rootView.context.resources.getString(R.string.key_language_full_tuesday)]
                }
                name.contains(rootView.context.resources.getString(R.string.key_language_short_wednesday)) || name.contains(
                    rootView.context.resources.getString(R.string.key_language_full_wednesday)
                ) -> {
                    textView.text = dayNames[rootView.context.resources.getString(R.string.key_language_full_wednesday)]
                }
                name.contains(rootView.context.resources.getString(R.string.key_language_short_thursday)) || name.contains(
                    rootView.context.resources.getString(R.string.key_language_full_thursday)
                ) -> {
                    textView.text = dayNames[rootView.context.resources.getString(R.string.key_language_full_thursday)]
                }
                name.contains(rootView.context.resources.getString(R.string.key_language_short_friday)) || name.contains(
                    rootView.context.resources.getString(R.string.key_language_full_friday)
                ) -> {
                    textView.text = dayNames[rootView.context.resources.getString(R.string.key_language_full_friday)]
                }
                name.contains(rootView.context.resources.getString(R.string.key_language_short_saturday)) || name.contains(
                    rootView.context.resources.getString(R.string.key_language_full_saturday)
                ) -> {
                    textView.text = dayNames[rootView.context.resources.getString(R.string.key_language_full_saturday)]
                }
                name.contains(rootView.context.resources.getString(R.string.key_language_short_sunday)) || name.contains(
                    rootView.context.resources.getString(R.string.key_language_full_sunday)
                ) -> {
                    textView.text = dayNames[rootView.context.resources.getString(R.string.key_language_full_sunday)]
                }
            }
        }
    }

    private fun setWeekDaysBasedOnPrefix(
        textView: TextView,
        name: String,
        dayNames: HashMap<String, String>,
        short: Boolean
    ) {
        var dayName = name
        if (dayName.contains(textView.resources.getString(R.string.prefix_language_short))) {
            if (!short) {
                dayName = dayName.replace(
                    textView.resources.getString(R.string.prefix_language_short),
                    textView.resources.getString(R.string.prefix_language_full)
                )
            }
            textView.text = dayNames[dayName]
        } else if (dayName.contains(textView.resources.getString(R.string.prefix_language_full))) {
            if (short) {
                dayName = dayName.replace(
                    textView.resources.getString(R.string.prefix_language_full),
                    textView.resources.getString(R.string.prefix_language_short)
                )
            }
            textView.text = dayNames[dayName]
        }
    }

    private fun getIdName(view: View): String {
        return if (view.id == View.NO_ID)
            "no-id"
        else
            view.resources.getResourceName(view.id)
    }

    private fun setViewId(view: View) {
        if (view.id == View.NO_ID) {
            view.id = View.generateViewId()
        }
    }

    private fun setSubViewToView(rootView: ViewGroup, view: View) {
        rootView.addView(view)
    }

    private fun setMargin(
        view: View,
        marginTop: Int = 0,
        marginBottom: Int = 0,
        marginLeft: Int = 0,
        marginRight: Int = 0
    ) {
        if (view.layoutParams is ViewGroup.MarginLayoutParams) {
            val params = view.layoutParams as ViewGroup.MarginLayoutParams
            params.setMargins(marginLeft, marginTop, marginRight, marginBottom)
            view.requestLayout()
        } else {
            throw UtilsException(view.context.getString(R.string.utils_exception_margin_message))
        }
    }

    private fun setCornerRadius(
        drawable: GradientDrawable,
        topLeft: Float,
        topRight: Float,
        bottomRight: Float,
        bottomLeft: Float
    ) {
        drawable.cornerRadii =
            floatArrayOf(topLeft, topLeft, topRight, topRight, bottomRight, bottomRight, bottomLeft, bottomLeft)
    }

    private fun setCornerRadius(drawable: GradientDrawable, radius: Float) {
        drawable.cornerRadius = radius
    }

    private fun getAllChildren(v: View): ArrayList<View> {
        if (v !is ViewGroup) {
            val viewArrayList = ArrayList<View>()
            viewArrayList.add(v)
            return viewArrayList
        }
        val result = ArrayList<View>()
        for (i in 0 until v.childCount) {

            val child = v.getChildAt(i)

            val viewArrayList = ArrayList<View>()
            viewArrayList.add(v)
            viewArrayList.addAll(getAllChildren(child))

            result.addAll(viewArrayList)
        }
        return result
    }

}
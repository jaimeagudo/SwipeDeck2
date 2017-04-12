package com.daprlabs.aaron.swipedeck.layouts;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;

import com.daprlabs.aaron.swipedeck.SwipeDeck;

/**
 * Created by aaron on 23/12/2015.
 */
public class SwipeFrameLayout extends FrameLayout {
    public SwipeFrameLayout(Context context) {
        super(context);
        setClipChildren(false);
    }

    public SwipeFrameLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        setClipChildren(false);
    }

    public SwipeFrameLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        setClipChildren(false);
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public SwipeFrameLayout(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        setClipChildren(false);
    }

    //this is so that on versions of android pre lollipop it will render the cardstack above
    //everything else within the layout
    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();

        for(int i=0; i < getChildCount(); ++i) {
            View child = getChildAt(i);
            if (child instanceof SwipeDeck) {
                removeView(child);
                addViewInLayout(child, -1, child.getLayoutParams(), false);
                return;
            }
        }
    }

}

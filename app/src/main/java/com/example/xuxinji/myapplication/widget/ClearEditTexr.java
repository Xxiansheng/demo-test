package com.example.xuxinji.myapplication.widget;

import android.content.Context;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.AppCompatEditText;
import android.util.AttributeSet;
import android.view.MotionEvent;

import com.example.xuxinji.myapplication.R;

/**
 * Created by xuxinji on 2017/8/23.
 */

public class ClearEditTexr extends AppCompatEditText {

    private int ic_deleteResID;                         //图标资源ID
    private Drawable clearDrawable, searchDrawable;     //删除图标
    private int delete_x, delete_y, delete_width, delete_height;  //删除图标七点(x,y)、删除图标宽、高(px)

    public ClearEditTexr(Context context) {
        super(context);
    }

    public ClearEditTexr(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public ClearEditTexr(Context context, AttributeSet attrs, int defStytleAttr) {
        super(context, attrs, defStytleAttr);
        init();
    }

    private void init() {
        clearDrawable = getResources().getDrawable(R.drawable.delete);
        searchDrawable = getResources().getDrawable(R.drawable.search);

        setCompoundDrawablesWithIntrinsicBounds(searchDrawable, null, null, null);

    }

    @Override
    protected void onTextChanged(CharSequence text, int start, int lengthBefore, int lengthAfter) {
        super.onTextChanged(text, start, lengthBefore, lengthAfter);
        setClearIconVisible(hasFocus() && text.length() > 0);
    }

    @Override
    protected void onFocusChanged(boolean focused, int direction, Rect previouslyFocusedRect) {
        super.onFocusChanged(focused, direction, previouslyFocusedRect);
        setClearIconVisible(focused && length() > 0);
    }

    private void setClearIconVisible(boolean visible) {
        setCompoundDrawablesWithIntrinsicBounds(searchDrawable, null, visible ? clearDrawable : null, null);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction()) {
            case MotionEvent.ACTION_UP:
                Drawable drawable = clearDrawable;
                if (drawable != null && event.getX() <= (getWidth() - getPaddingRight())
                          && event.getX() >= (getWidth() - getPaddingRight() - drawable.getBounds().width())) {
                    setText("");
                }
                break;
        }
        return super.onTouchEvent(event);
    }
}

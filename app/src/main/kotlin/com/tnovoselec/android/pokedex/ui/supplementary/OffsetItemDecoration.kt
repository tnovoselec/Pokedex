package com.tnovoselec.android.pokedex.ui.supplementary

import android.graphics.Rect
import android.support.v7.widget.RecyclerView
import android.view.View

class OffsetItemDecoration(val itemOffsetId: Int) : RecyclerView.ItemDecoration() {


    override public fun getItemOffsets(outRect: Rect, view: View, parent: RecyclerView,
                                       state: RecyclerView.State) {
        super.getItemOffsets(outRect, view, parent, state);
        val mItemOffset = view.context.resources.getDimensionPixelOffset(itemOffsetId)
        outRect.set(mItemOffset, mItemOffset, mItemOffset, mItemOffset);
    }
}

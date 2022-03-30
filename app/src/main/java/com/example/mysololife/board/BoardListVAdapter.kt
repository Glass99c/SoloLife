package com.example.mysololife.board

import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.LinearLayout
import android.widget.TextView
import com.example.mysololife.R
import com.example.mysololife.utils.FBAuth

class BoardListVAdapter(val boardList : MutableList<BoardModel>):BaseAdapter() {
    override fun getCount(): Int {
        return boardList.size
    }

    override fun getItem(p0: Int): Any {
        return boardList[p0]
    }

    override fun getItemId(p0: Int): Long {
        return p0.toLong()
    }

    override fun getView(p0: Int, p1: View?, p2: ViewGroup?): View {
        var view = p1

            view = LayoutInflater.from(p2?.context).inflate(R.layout.board_list_item, p2, false)


        val itemLinearLayoutView = view?.findViewById<LinearLayout>(R.id.itemView)
        val title = view?.findViewById<TextView>(R.id.titleArea)
        val content = view?.findViewById<TextView>(R.id.contentArea)
        val time = view?.findViewById<TextView>(R.id.timeArea)

        if(boardList[p0].uid.equals((FBAuth.getUid()))){
            itemLinearLayoutView?.setBackgroundColor(Color.parseColor("#ffa500"))
        }
        title!!.text = boardList[p0].title
        content!!.text = boardList[p0].content
        time!!.text = boardList[p0].time
        return view!!
    }
}
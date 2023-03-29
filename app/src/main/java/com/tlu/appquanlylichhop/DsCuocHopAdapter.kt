package com.tlu.appquanlylichhop

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView

class DsCuocHopAdapter constructor(var context : Context , var mangdscuochop : ArrayList<DsCuocHop>) : BaseAdapter() {
    class ViewHolder(row : View){
        var textViewtieude : TextView
        var textViewchude : TextView
        var textViewngay : TextView
        var textViewtimebg : TextView
        var textViewtimeend : TextView

        init {
            textViewtieude = row.findViewById(R.id.textView_tieude) as TextView
            textViewchude = row.findViewById(R.id.textView_chude) as TextView
            textViewngay = row.findViewById(R.id.textView_ngay) as TextView
            textViewtimebg = row.findViewById(R.id.textView_timebg) as TextView
            textViewtimeend = row.findViewById(R.id.textView_timeend) as TextView
        }
    }
    override fun getCount(): Int {
        return mangdscuochop.size
    }

    override fun getItem(position: Int): Any {
        return mangdscuochop.get(position)
    }

    override fun getItemId(p0: Int): Long {
        return p0.toLong()
    }

    override fun getView(position: Int, convertView: View?, p2: ViewGroup?): View {
        var view : View?
        var viewholder : ViewHolder
        if (convertView == null){
            var layoutinflater : LayoutInflater = LayoutInflater.from(context)
            view = layoutinflater.inflate(R.layout.dong_ds,null)
            viewholder = ViewHolder(view)
            view.tag = viewholder
        }
        else {
            view = convertView
            viewholder = convertView.tag as ViewHolder
        }
        var dscuochop : DsCuocHop = getItem(position) as DsCuocHop
        viewholder.textViewtieude.text = dscuochop.tieude
        viewholder.textViewchude.text = dscuochop.chude
        viewholder.textViewngay.text = dscuochop.date.toString()
        viewholder.textViewtimebg.text = dscuochop.timebg.toString()
        viewholder.textViewtimeend.text = dscuochop.timeend.toString()
        return view as View
    }

}
package com.tlu.appquanlylichhop

import android.app.DatePickerDialog
import android.app.TimePickerDialog
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.DatePicker
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import java.util.*

class ThemActivity : AppCompatActivity() {
    //time start
    private lateinit var TimerPickerStartBtn : Button
    private lateinit var textView_TimerStart : TextView

    //time end
    private lateinit var TimerPickerEndBtn : Button
    private lateinit var textView_TimerEnd : TextView

    //btn huy
    private lateinit var btn_Huy : Button

    //btn them
    private lateinit var btn_Them : Button

    //edt tieu de
    private lateinit var edtText_TieuDeCuocHop : EditText

    // edt chu de
    private lateinit var edtText_ChuDeCuocHop : EditText

    //tv ngay
    private lateinit var textView_Date : TextView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_themcuochop)

        //calendar
        val c = Calendar.getInstance()
        val year = c.get(Calendar.YEAR)
        val month = c.get(Calendar.MONTH)
        val day = c.get(Calendar.DAY_OF_MONTH)

        //button click to show DatePickerDialog
        var dateTv = findViewById<TextView>(R.id.textView_Date)
        var pickDateBtn = findViewById<Button>(R.id.DatePickerBtn)
        pickDateBtn.setOnClickListener {
            val dpd = DatePickerDialog (this, DatePickerDialog.OnDateSetListener{view: DatePicker?, mYear: Int, mMonth: Int, mDay: Int -> dateTv.setText(""+ mDay + "/"+ mMonth +"/"+ mYear) },year, month, day)

            //show dialog
            dpd.show()
        }

        textView_TimerStart = findViewById(R.id.textView_TimerStart)
        TimerPickerStartBtn = findViewById(R.id.TimerPickerStartBtn)

        TimerPickerStartBtn.setOnClickListener {
            val currentTime = Calendar.getInstance()
            val startHour = currentTime.get(Calendar.HOUR_OF_DAY)
            val startMinute = currentTime.get(Calendar.MINUTE)

            TimePickerDialog(this, TimePickerDialog.OnTimeSetListener { view, hourOfDay, minute -> textView_TimerStart.setText("$hourOfDay:$minute") }, startHour, startMinute, false).show()
        }

        textView_TimerEnd = findViewById(R.id.textView_TimerEnd)
        TimerPickerEndBtn = findViewById(R.id.TimerPickerEndBtn)

        TimerPickerEndBtn.setOnClickListener {
            val currentTime = Calendar.getInstance()
            val startHour = currentTime.get(Calendar.HOUR_OF_DAY)
            val startMinute = currentTime.get(Calendar.MINUTE)

            TimePickerDialog(this, TimePickerDialog.OnTimeSetListener { view, hourOfDay, minute -> textView_TimerEnd.setText("$hourOfDay:$minute") }, startHour, startMinute, false).show()
        }

        //btn huy
        btn_Huy = findViewById(R.id.btn_Huy)
        btn_Huy.setOnClickListener {
            val intent: Intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

        //

        val tieude = findViewById<EditText>(R.id.edtText_TieuDeCuocHop)
        val chude = findViewById<EditText>(R.id.edtText_ChuDeCuocHop)
        val date = findViewById<TextView>(R.id.textView_Date)
        val timebg = findViewById<TextView>(R.id.textView_TimerStart)
        val timeend = findViewById<TextView>(R.id.textView_TimerEnd)
        val thembtn = findViewById<Button>(R.id.btn_Them)

        thembtn.setOnClickListener {
            var tieude = tieude.text.toString()
            var chude = chude.text.toString()
            var date = date.text.toString()
            var timebg = timebg.text.toString()
            var timeend = timeend.text.toString()

            var intent = Intent (this, DsCuocHopAdapter::class.java)
            intent.putExtra("tieude", tieude)
            intent.putExtra("chude", chude)
            intent.putExtra("date", date)
            intent.putExtra("timebg", timebg)
            intent.putExtra("timeend", timeend)
            startActivity(intent)
        }

        //btn them
        btn_Them = findViewById(R.id.btn_Them)
        btn_Them.setOnClickListener {
            val intent: Intent = Intent(this, DsCuocHopActivity::class.java)
            startActivity(intent)
        }

        edtText_TieuDeCuocHop = findViewById(R.id.edtText_TieuDeCuocHop)
        edtText_ChuDeCuocHop = findViewById(R.id.edtText_ChuDeCuocHop)
        textView_Date = findViewById(R.id.textView_Date)

    }

}
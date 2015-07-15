package com.example.day3pm;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.TimePicker;
import android.widget.Button;
import android.widget.Toast;
import android.view.View.OnClickListener;


public class MyActivity extends Activity {
    private DatePicker dpToday = null;
    private TimePicker tpNow = null;
    private Button btnSave = null;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        dpToday = (DatePicker)super.findViewById(R.id.today);
        tpNow = (TimePicker)super.findViewById(R.id.now);
        btnSave = (Button)super.findViewById(R.id.save);
        btnSave.setOnClickListener(new SaveOnClickListener());
    }
    private class SaveOnClickListener implements OnClickListener{
        public void onClick(View view){
            int iYear = 0,iMonth = 0, iDay = 0;
            String sDate = "";
            iYear = dpToday.getYear();
            iMonth = dpToday.getMonth()+1;
            iDay = dpToday.getDayOfMonth();
            sDate = "日期：" + String.valueOf(iYear) + "年" + String.valueOf(iMonth) + "月" + String .valueOf(iDay) + "日";

            int iHour = 0, iMin = 0;
            String sTime = "";
            iHour = tpNow.getCurrentHour();
            iMin = tpNow.getCurrentMinute();
            sTime = "时间：" + String.valueOf(iHour) + "时" + String.valueOf(iMin) + "分";

            Toast.makeText(getApplicationContext(), sDate+sTime, Toast.LENGTH_LONG).show();

        }
    }
}

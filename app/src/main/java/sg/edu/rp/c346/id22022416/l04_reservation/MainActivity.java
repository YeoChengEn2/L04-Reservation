package sg.edu.rp.c346.id22022416.l04_reservation;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import android.view.View;
import android.widget.EditText;

import android.widget.TextView;

import android.widget.DatePicker;

import android.widget.TimePicker;

import android.widget.RadioGroup;

import android.widget.RadioButton;

import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText etName, etMobile, etGroup;
    TextView tvDate, tvTime, tvAll;
    DatePicker dpBook;
    TimePicker tpBook;
    RadioGroup rgArea;
    RadioButton rbSmoke, rbNo;
    Button btnConfirm, btnReset;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etName = findViewById(R.id.nameEdit);
        etMobile = findViewById(R.id.mobileNoEdit);
        etGroup = findViewById(R.id.groupSizeEdit);
        tvDate = findViewById(R.id.dateText);
        tvTime = findViewById(R.id.timeText);
        dpBook = findViewById(R.id.bookingDate);
        tpBook = findViewById(R.id.bookingTime);
        rgArea = findViewById(R.id.smokeArea);
        rbSmoke = findViewById(R.id.smoke);
        rbNo = findViewById(R.id.noSmoke);
        btnConfirm = findViewById(R.id.confirmBtn);
        btnReset = findViewById(R.id.resetBtn);
        tvAll = findViewById(R.id.allInfo);

        btnConfirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nameToast = etName.getText().toString();
                String mobToast = etMobile.getText().toString();
                String grpToast = etGroup.getText().toString();
                int dayToast = dpBook.getDayOfMonth();
                int mthToast = dpBook.getMonth();
                int yearToast = dpBook.getYear();
                String hourToast = tpBook.getCurrentHour().toString();
                String minToast = tpBook.getCurrentMinute().toString();
                int areaRadio = rgArea.getCheckedRadioButtonId();

                if(areaRadio == R.id.smoke)
                {
                    Toast.makeText(MainActivity.this, "Name: " + nameToast + ", Mobile: " + mobToast + ", Group Size: " + grpToast + ", Date: " + dayToast + "/" + mthToast + "/" + yearToast + ", Time: " + hourToast + ":" + minToast + ", Table Area: Smoking", Toast.LENGTH_SHORT).show();
                }
                else if(areaRadio == R.id.noSmoke)
                {
                    Toast.makeText(MainActivity.this, "Name: " + nameToast + ", Mobile: " + mobToast + ", Group Size: " + grpToast + ", Date: " + dayToast + "/" + mthToast + "/" + yearToast + ", Time: " + hourToast + ":" + minToast + ", Table Area: Non-Smoking", Toast.LENGTH_SHORT).show();
                }
            }
        });
        btnReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                etName.setText("");
                etMobile.setText("");
                etGroup.setText("");
                rbSmoke.setChecked(false);
                rbNo.setChecked(false);
                dpBook.updateDate(2020, 5,1);
                tpBook.setCurrentHour(19);
                tpBook.setCurrentMinute(30);
            }
        });
    }
}
package com.example.calculatorengineeringview;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

public class MainActivity extends AppCompatActivity {
    private ConstraintLayout engineeringView;
    private ConstraintLayout mainView;
    private CalcView curCalcView = CalcView.MAIN_VIEW;
    private String textBuffer;
    private TextView txtOutput;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        engineeringView = findViewById(R.id.engineeringView);
        engineeringView.setVisibility(View.GONE);
        txtOutput = findViewById(R.id.txtOutput);
        mainView = findViewById(R.id.mainView);


    }

    public void onClick(View v) {
        Button btn = (Button) v;
        String curBtn = btn.getText().toString();

        if (TextUtils.isEmpty(txtOutput.getText())) {
            textBuffer = "";
        } else {
            textBuffer = txtOutput.getText().toString();
        }

        if (curBtn.equals(getString(R.string.btn_point)) &&
                textBuffer.contains(getString(R.string.btn_point))) {
            Toast.makeText(MainActivity.this,
                    getString(R.string.error_point_already_exist), Toast.LENGTH_SHORT).show();
        } else {
            textBuffer += curBtn;
        }

        txtOutput.setText(textBuffer);
    }

    public void changeMode(View view) {
        CharSequence curTxtInOutput;

        switch (curCalcView) {
            case MAIN_VIEW:
                curCalcView = CalcView.ENGINEER_VIEW;
                mainView.setVisibility(View.GONE);
                engineeringView.setVisibility(View.VISIBLE);

                curTxtInOutput = txtOutput.getText();
                txtOutput = findViewById(R.id.txtOutputEnView);
                txtOutput.setText(curTxtInOutput);
                break;

            case ENGINEER_VIEW:
                curCalcView = CalcView.MAIN_VIEW;
                engineeringView.setVisibility(View.GONE);
                mainView.setVisibility(View.VISIBLE);
                curTxtInOutput = txtOutput.getText();
                txtOutput = findViewById(R.id.txtOutput);
                txtOutput.setText(curTxtInOutput);
                break;
        }
    }
}

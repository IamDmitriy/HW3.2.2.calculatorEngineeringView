package com.example.calculatorengineeringview;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class MainActivity extends AppCompatActivity {
    private Button btnZero;
    private Button btnOne;
    private Button btnTwo;
    private Button btnThree;
    private Button btnFour;
    private Button btnFive;
    private Button btnSix;
    private Button btnSeven;
    private Button btnEigth;
    private Button btnNine;
    private Button btnPoint;
    private TextView txtOutput;
    View.OnClickListener onButtonClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Button btn = (Button) v;
            String txt = btn.getText().toString();
            txtOutput.setText(txt);

        }
    };
    private Toolbar myToolbar;
    private FrameLayout engineeringViewFrame;
    private CalcView curCalcView = CalcView.MAIN_VIEW;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
    }

    private void initView() {
        btnZero = findViewById(R.id.btnZero);
        btnOne = findViewById(R.id.btnOne);
        btnTwo = findViewById(R.id.btnTwo);
        btnThree = findViewById(R.id.btnThree);
        btnFour = findViewById(R.id.btnFour);
        btnFive = findViewById(R.id.btnFive);
        btnSix = findViewById(R.id.btnSix);
        btnSeven = findViewById(R.id.btnSeven);
        btnEigth = findViewById(R.id.btnEight);
        btnNine = findViewById(R.id.btnNine);
        btnPoint = findViewById(R.id.btnPoint);

        txtOutput = findViewById(R.id.txtOutput);

        myToolbar = findViewById(R.id.my_toolbar);
        setSupportActionBar(myToolbar);

        engineeringViewFrame = findViewById(R.id.engineeringViewFrame);
        engineeringViewFrame.setVisibility(View.GONE);

        btnZero.setOnClickListener(onButtonClickListener);
        btnOne.setOnClickListener(onButtonClickListener);
        btnTwo.setOnClickListener(onButtonClickListener);
        btnThree.setOnClickListener(onButtonClickListener);
        btnFour.setOnClickListener(onButtonClickListener);
        btnFive.setOnClickListener(onButtonClickListener);
        btnSix.setOnClickListener(onButtonClickListener);
        btnSeven.setOnClickListener(onButtonClickListener);
        btnEigth.setOnClickListener(onButtonClickListener);
        btnNine.setOnClickListener(onButtonClickListener);
        btnPoint.setOnClickListener(onButtonClickListener);

    }

    private void changeMode(MenuItem actionChangeMode) {
        switch (curCalcView) {
            case MAIN_VIEW:
                curCalcView = CalcView.ENGINEER_VIEW;
                engineeringViewFrame.setVisibility(View.VISIBLE);
                actionChangeMode.setTitle(R.string.btn_main_view);
                break;

            case ENGINEER_VIEW:
                curCalcView = CalcView.MAIN_VIEW;
                engineeringViewFrame.setVisibility(View.GONE);
                actionChangeMode.setTitle(R.string.btn_engineering_view);
                break;
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.actionChangeMode:
                changeMode(item);
                break;
        }

        return super.onOptionsItemSelected(item);
    }
}

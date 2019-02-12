package com.rikin.jain.calculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private ImageButton btnNine, btnEight, btnSeven, btnSix, btnFive, btnFour, btnThree, btnTwo, btnOne, btnZero, btnEqual, btnAdd, btnSubtract, btnMultiply, btnDivide;
    private Button btnClear;
    private TextView txtCalculations, txtResult;
    private enum OPERATOR{
        ADD, SUBTRACT, MULTIPLY, DIVIDE,EQUAL
    }
    private String currentNumber = "";
    private String stringNumberAtLeft;
    private String stringNumberAtRight;
    private OPERATOR currentOperator;
    private int calculationsResult;
    private String calculationString;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtCalculations = findViewById(R.id.txtCalculations);
        calculationString ="";
        txtResult = findViewById(R.id.txtResult);

        findViewById(R.id.btnClear).setOnClickListener(this);
        findViewById(R.id.btnAdd).setOnClickListener(this);
        findViewById(R.id.btnSubtract).setOnClickListener(this);
        findViewById(R.id.btnMultiply).setOnClickListener(this);
        findViewById(R.id.btnDivide).setOnClickListener(this);
        findViewById(R.id.btnZero).setOnClickListener(this);
        findViewById(R.id.btnOne).setOnClickListener(this);
        findViewById(R.id.btnTwo).setOnClickListener(this);
        findViewById(R.id.btnThree).setOnClickListener(this);
        findViewById(R.id.btnFive).setOnClickListener(this);
        findViewById(R.id.btnFour).setOnClickListener(this);
        findViewById(R.id.btnSix).setOnClickListener(this);
        findViewById(R.id.btnSeven).setOnClickListener(this);
        findViewById(R.id.btnEight).setOnClickListener(this);
        findViewById(R.id.btnNine).setOnClickListener(this);
        findViewById(R.id.btnEqual).setOnClickListener(this);



    }

    @Override
    public void onClick(View v) {
         switch (v.getId()){
             case R.id.btnClear: clearTapped();
                 break;
             case R.id.btnAdd:operatorIsTapped(OPERATOR.ADD);
             calculationString += "+";
                 break;
             case R.id.btnSubtract: operatorIsTapped(OPERATOR.SUBTRACT);
             calculationString += "-";
                 break;
             case R.id.btnMultiply:operatorIsTapped(OPERATOR.MULTIPLY);
             calculationString += "*";
                 break;
             case R.id.btnDivide:operatorIsTapped(OPERATOR.DIVIDE);
             calculationString += "/";
                 break;
             case R.id.btnZero: numberIsTapped(0);
                 break;
             case R.id.btnOne: numberIsTapped(1);
                 break;
             case R.id.btnTwo:numberIsTapped(2);
                 break;
             case R.id.btnThree: numberIsTapped(3);
                 break;
             case R.id.btnFour: numberIsTapped(4);
                 break;
             case R.id.btnFive: numberIsTapped(5);
                 break;
             case R.id.btnSix: numberIsTapped(6);
                 break;
             case R.id.btnSeven: numberIsTapped(7);
                 break;
             case R.id.btnEight: numberIsTapped(8);
                 break;
             case R.id.btnNine: numberIsTapped(9);
                 break;
             case R.id.btnEqual: operatorIsTapped(OPERATOR.EQUAL);
                 break;

         }
         txtCalculations.setText(calculationString);
    }
    private void numberIsTapped(int tappedNumber){
        currentNumber = currentNumber + Integer.toString(tappedNumber);
        txtResult.setText(currentNumber);
        calculationString = currentNumber;
        txtCalculations.setText(calculationString);
    }
    private void operatorIsTapped(OPERATOR tappedOperator){
        if(currentOperator != null ){
            if (currentNumber != "") {
                stringNumberAtRight = currentNumber;
            currentNumber = "";
            switch (currentOperator){
                case ADD:
                    calculationsResult = Integer.parseInt(stringNumberAtLeft) + Integer.parseInt(stringNumberAtRight);
                    break;
                case SUBTRACT:
                    calculationsResult = Integer.parseInt(stringNumberAtLeft) -Integer.parseInt(stringNumberAtRight);
                    break;
                case MULTIPLY:
                    calculationsResult = Integer.parseInt(stringNumberAtLeft) *Integer.parseInt(stringNumberAtRight);
                    break;
                case DIVIDE:
                    calculationsResult = Integer.parseInt(stringNumberAtLeft) / Integer.parseInt(stringNumberAtRight);
                    break;

            }
            stringNumberAtLeft = Integer.toString(calculationsResult);
            txtResult.setText(stringNumberAtLeft);
            calculationString = stringNumberAtLeft;
            }
        }
        else {
            stringNumberAtLeft = currentNumber;
            currentNumber = "";
        }
        currentOperator = tappedOperator;
    }
    private void clearTapped(){
        stringNumberAtLeft = "" ;
        stringNumberAtRight = "";
        currentNumber = "" ;
        calculationsResult = 0;
        currentOperator = null;
        txtResult.setText("0");
        calculationString ="";
    }
}

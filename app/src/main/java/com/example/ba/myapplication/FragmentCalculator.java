package com.example.ba.myapplication;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class FragmentCalculator extends Fragment implements View.OnClickListener {
    private static final String TAG = "FragmentCalculator";
    private static final String PRE_LASTRESULT = "PRE_LASTRESULT";
    private static final String STR_LASTRESULT = "STR_LASTRESULT";
    private Button mButtonAc;
    private Button mButtonSign;
    private Button mButtonModolus;
    private Button mButtonDivision;
    private Button mButtonAdd;
    private Button mButtonSub;
    private Button mButtonMutiplication;
    private Button mButtonNumber0;
    private Button mButtonNumber1;
    private Button mButtonNumber2;
    private Button mButtonNumber3;
    private Button mButtonNumber4;
    private Button mButtonNumber5;
    private Button mButtonNumber6;
    private Button mButtonNumber7;
    private Button mButtonNumber8;
    private Button mButtonNumber9;
    private Button mButtonResult;
    private TextView mTextviewDisplay;
    private String mStringDisplay;
    private int mLastResult;
    private final String mError = "Something wrongs";

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        SharedPreferences mSharedPreferences = context.
                getSharedPreferences(PRE_LASTRESULT, Context.MODE_PRIVATE);
        mStringDisplay = String.valueOf(mSharedPreferences.getInt(STR_LASTRESULT, 0));
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = LayoutInflater.from(container.getContext()).
                inflate(R.layout.fragment_layout, container, false);
        initView(view);
        return view;
    }

    @Override
    public void onStop() {
        super.onStop();
        SharedPreferences mSharedPreferences = this.getActivity().
                getSharedPreferences(PRE_LASTRESULT, Context.MODE_PRIVATE);
        SharedPreferences.Editor mEditor = mSharedPreferences.edit();
        mEditor.putInt(STR_LASTRESULT, mLastResult);
        mEditor.commit();
    }

    @Override
    public void onResume() {
        super.onResume();
        mTextviewDisplay.setText(mStringDisplay);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.button_ac:
                refresh();
                break;
            case R.id.button_number0:
//                if (mStringDisplay.isEmpty() || mStringDisplay.charAt(0) ==
//                        getString(R.string.str_number0).charAt(0)) {
//                    return;
//                }
                mStringDisplay = mStringDisplay + getString(R.string.str_number0);
                mTextviewDisplay.setText(mStringDisplay);
                break;
            case R.id.button_number1:
                pressNumber(R.string.str_number1);
                break;
            case R.id.button_number2:
                pressNumber(R.string.str_number2);
                break;
            case R.id.button_number3:
                pressNumber(R.string.str_number3);
                break;
            case R.id.button_number4:
                pressNumber(R.string.str_number4);
                break;
            case R.id.button_number5:
                pressNumber(R.string.str_number5);
                break;
            case R.id.button_number6:
                pressNumber(R.string.str_number6);
                break;
            case R.id.button_number7:
                pressNumber(R.string.str_number7);
                break;
            case R.id.button_number8:
                pressNumber(R.string.str_number8);
                break;
            case R.id.button_number9:
                pressNumber(R.string.str_number9);
                break;
            case R.id.button_add:
                pressOperator(R.string.str_add);
                break;
            case R.id.button_sub:
                pressOperator(R.string.str_sub);
                break;
            case R.id.button_mutiplication:
                pressOperator(R.string.str_mutiplication);
                break;
            case R.id.button_division:
                pressOperator(R.string.str_devision);
                break;
            case R.id.button_modolus:
                pressOperator(R.string.str_modolus);
                break;
            case R.id.button_result:

                try {
                    getResult();
                } catch (Exception e) {
                    Toast.makeText(this.getContext(), mError, Toast.LENGTH_LONG).show();
                    e.printStackTrace();
                }
                break;
        }
    }

    private void refresh() {
        mStringDisplay = "";
        mLastResult = 0;
        mTextviewDisplay.setText(mStringDisplay);
    }

    private void pressOperator(int idStringOperator) {
        mStringDisplay = mStringDisplay + getString(idStringOperator);
        mTextviewDisplay.setText(mStringDisplay);
    }

    private void pressNumber(int idStringNumber) {
        mStringDisplay = mStringDisplay + getString(idStringNumber);
        mTextviewDisplay.setText(mStringDisplay);
    }

    private String getOperator() {
        String operator = "";
        String mBuff = mStringDisplay;
        if (mStringDisplay.isEmpty()) {
            return operator;
        }
        if (mStringDisplay.charAt(0) == getString(R.string.str_sub).charAt(0)) {
            mBuff = mStringDisplay.substring(1, mStringDisplay.length());
        }
        for (int i = 1; i < mBuff.length(); i++) {
            if (mBuff.charAt(i) == getString(R.string.str_add).charAt(0)) {
                operator = getString(R.string.str_add);
                break;
            } else if (mBuff.charAt(i) == getString(R.string.str_sub).charAt(0)) {
                operator = getString(R.string.str_sub);
                break;
            } else if (mBuff.charAt(i) ==
                    getString(R.string.str_mutiplication).charAt(0)) {
                operator = getString(R.string.str_mutiplication);
                break;
            } else if (mBuff.charAt(i) == getString(R.string.str_devision).charAt(0)) {
                operator = getString(R.string.str_devision);
                break;
            } else if (mBuff.charAt(i) == getString(R.string.str_add).charAt(0)) {
                operator = getString(R.string.str_modolus);
                break;
            }
        }
        return operator;
    }

    private void initView(View view) {
        mTextviewDisplay = view.findViewById(R.id.text_view_display);
        mButtonAc = view.findViewById(R.id.button_ac);
        mButtonAc.setOnClickListener(this);
        mButtonSign = view.findViewById(R.id.button_sign);
        mButtonSign.setOnClickListener(this);
        mButtonModolus = view.findViewById(R.id.button_modolus);
        mButtonModolus.setOnClickListener(this);
        mButtonDivision = view.findViewById(R.id.button_division);
        mButtonDivision.setOnClickListener(this);
        mButtonAdd = view.findViewById(R.id.button_add);
        mButtonAdd.setOnClickListener(this);
        mButtonSub = view.findViewById(R.id.button_sub);
        mButtonSub.setOnClickListener(this);
        mButtonMutiplication = view.findViewById(R.id.button_mutiplication);
        mButtonMutiplication.setOnClickListener(this);
        mButtonNumber0 = view.findViewById(R.id.button_number0);
        mButtonNumber0.setOnClickListener(this);
        mButtonNumber1 = view.findViewById(R.id.button_number1);
        mButtonNumber1.setOnClickListener(this);
        mButtonNumber2 = view.findViewById(R.id.button_number2);
        mButtonNumber2.setOnClickListener(this);
        mButtonNumber3 = view.findViewById(R.id.button_number3);
        mButtonNumber3.setOnClickListener(this);
        mButtonNumber4 = view.findViewById(R.id.button_number4);
        mButtonNumber4.setOnClickListener(this);
        mButtonNumber5 = view.findViewById(R.id.button_number5);
        mButtonNumber5.setOnClickListener(this);
        mButtonNumber6 = view.findViewById(R.id.button_number6);
        mButtonNumber6.setOnClickListener(this);
        mButtonNumber7 = view.findViewById(R.id.button_number7);
        mButtonNumber7.setOnClickListener(this);
        mButtonNumber8 = view.findViewById(R.id.button_number8);
        mButtonNumber8.setOnClickListener(this);
        mButtonNumber9 = view.findViewById(R.id.button_number9);
        mButtonNumber9.setOnClickListener(this);
        mButtonResult = view.findViewById(R.id.button_result);
        mButtonResult.setOnClickListener(this);
    }

    private int calculator(int number1, int number2, String operator) {
        int mResult = 0;
        if (operator.equals(getString(R.string.str_add))) {
            mResult = number1 + number2;
        } else if (operator.equals(getString(R.string.str_sub))) {
            mResult = number1 - number2;
        } else if (operator.equals(getString(R.string.str_mutiplication))) {
            mResult = number1 * number2;
        } else if (operator.equals(getString(R.string.str_devision))) {
            mResult = number1 / number2;
        } else if (operator.equals(getString(R.string.str_modolus))) {
            mResult = number1 % number2;
        }
        return mResult;
    }

    private boolean isSubFirst() {
        return mStringDisplay.charAt(0) == getString(R.string.str_sub).charAt(0);
    }

    private void getResult() throws Exception, ArithmeticException {
        int mNumber1;
        int mNumber2;
        String mBuff = mStringDisplay;
        if (mStringDisplay.isEmpty()) {
            return;
        }

        if (isSubFirst()) {
            mBuff = mStringDisplay.substring(1, mStringDisplay.length());
            mNumber1 = -1 *
                    Integer.valueOf(mBuff.substring(0, mBuff.indexOf(getOperator())));
        } else {
            mNumber1 =
                    Integer.valueOf(mBuff.substring(0, mBuff.indexOf(getOperator())));
        }
        mNumber2 = Integer.valueOf(mBuff.substring(mBuff.indexOf(getOperator()) + 1,
                mBuff.length()));

        mLastResult = calculator(mNumber1, mNumber2, getOperator());
        mStringDisplay = String.valueOf(mLastResult);
        mTextviewDisplay.setText(String.valueOf(mLastResult));
//        throw new Exception("some thing wrong");
    }
}

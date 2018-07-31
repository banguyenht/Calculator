package com.example.ba.myapplication;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

public class FragmentCalculator extends Fragment implements View.OnClickListener {
    private static final String TAG = "FragmentCalculator";
    private static final String PRE_LASTRESULT = "PRE_LASTRESULT";
    private static final String STR_LASTRESULT = "STR_LASTRESULT";
    private Button mButton_Ac;
    private Button mButton_Sign;
    private Button mButton_Modolus;
    private Button mButton_Division;
    private Button mButton_Add;
    private Button mButton_Sub;
    private Button mButton_Mutiplication;
    private Button mButton_Number0;
    private Button mButton_Number1;
    private Button mButton_Number2;
    private Button mButton_Number3;
    private Button mButton_Number4;
    private Button mButton_Number5;
    private Button mButton_Number6;
    private Button mButton_Number7;
    private Button mButton_Number8;
    private Button mButton_Number9;
    private Button mButton_Result;
    private TextView mTextview_Display;
    private String mString_Display;
    private int mLast_Result;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        SharedPreferences mSharedPreferences = context.
                getSharedPreferences(PRE_LASTRESULT, Context.MODE_PRIVATE);
        mString_Display = String.valueOf(mSharedPreferences.getInt(STR_LASTRESULT, 0));
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
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
        mEditor.putInt(STR_LASTRESULT, mLast_Result);
        mEditor.commit();
    }

    @Override
    public void onResume() {
        super.onResume();
        mTextview_Display.setText(mString_Display);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.button_ac:
                mString_Display = "";
                mLast_Result = 0;
                mTextview_Display.setText(mString_Display);
                break;
            case R.id.button_number0:
                if (mString_Display.isEmpty() || mString_Display.charAt(0) ==
                        getString(R.string.str_number0).charAt(0)) {
                    return;
                }
                mString_Display = mString_Display + getString(R.string.str_number0);
                mTextview_Display.setText(mString_Display);
                break;
            case R.id.button_number1:
                mString_Display = mString_Display + getString(R.string.str_number1);
                mTextview_Display.setText(mString_Display);
                break;
            case R.id.button_number2:
                mString_Display = mString_Display + getString(R.string.str_number2);
                mTextview_Display.setText(mString_Display);
                break;
            case R.id.button_number3:
                mString_Display = mString_Display + getString(R.string.str_number3);
                mTextview_Display.setText(mString_Display);
                break;
            case R.id.button_number4:
                mString_Display = mString_Display + getString(R.string.str_number4);
                mTextview_Display.setText(mString_Display);
                break;
            case R.id.button_number5:
                mString_Display = mString_Display + getString(R.string.str_number5);
                mTextview_Display.setText(mString_Display);
                break;
            case R.id.button_number6:
                mString_Display = mString_Display + getString(R.string.str_number6);
                mTextview_Display.setText(mString_Display);
                break;
            case R.id.button_number7:
                mString_Display = mString_Display + getString(R.string.str_number7);
                mTextview_Display.setText(mString_Display);
                break;
            case R.id.button_number8:
                mString_Display = mString_Display + getString(R.string.str_number8);
                mTextview_Display.setText(mString_Display);
                break;
            case R.id.button_number9:
                mString_Display = mString_Display + getString(R.string.str_number9);
                mTextview_Display.setText(mString_Display);
                break;
            case R.id.button_add:
                if (mString_Display.isEmpty() || getOperator().equals(getString(R.string.str_add))) {
                    return;
                }
                mString_Display = mString_Display + getString(R.string.str_add);
                mTextview_Display.setText(mString_Display);
                break;
            case R.id.button_sub:
                if (mString_Display.isEmpty() || getOperator().equals(getString(R.string.str_sub))) {
                    return;
                }
                mString_Display = mString_Display + getString(R.string.str_sub);
                mTextview_Display.setText(mString_Display);
                break;
            case R.id.button_mutiplication:
                if (mString_Display.isEmpty() || getOperator().
                        equals(getString(R.string.str_mutiplication))) {
                    return;
                }
                mString_Display = mString_Display + getString(R.string.str_mutiplication);
                mTextview_Display.setText(mString_Display);
                break;
            case R.id.button_division:
                if (mString_Display.isEmpty() || getOperator().
                        equals(getString(R.string.str_devision))) {
                    return;
                }
                mString_Display = mString_Display + getString(R.string.str_devision);
                mTextview_Display.setText(mString_Display);
                break;
            case R.id.button_modolus:
                if (mString_Display.isEmpty() || getOperator().
                        equals(getString(R.string.str_modolus))) {
                    return;
                }
                mString_Display = mString_Display + getString(R.string.str_modolus);
                mTextview_Display.setText(mString_Display);
                break;
            case R.id.button_result:
                int mNumber1;
                int mNumber2;
                if (mString_Display.isEmpty()) {
                    return;
                }
                if (mString_Display.charAt(0) == getString(R.string.str_sub).charAt(0)) {
                    mNumber1 = -1 * Integer.valueOf(mString_Display.
                            substring(1, mString_Display.indexOf(getOperator())));

                } else {
                    mNumber1 = Integer.valueOf(mString_Display.
                            substring(0, mString_Display.indexOf(getOperator())));
                }
                mNumber2 = Integer.valueOf(mString_Display.substring(mString_Display.indexOf(getOperator()) + 1,
                        mString_Display.length()));
                mLast_Result = calculator(mNumber1, mNumber2, getOperator());
                mString_Display = String.valueOf(mLast_Result);
                mTextview_Display.setText(String.valueOf(mLast_Result));
                break;
        }
    }

    private String getOperator() {
        String operator = "";
        for (int i = 1; i < mString_Display.length(); i++) {
            if (mString_Display.charAt(i) == getString(R.string.str_add).charAt(0)) {
                operator = getString(R.string.str_add);
                break;
            } else if (mString_Display.charAt(i) == getString(R.string.str_sub).charAt(0)) {
                operator = getString(R.string.str_sub);
                break;
            } else if (mString_Display.charAt(i) ==
                    getString(R.string.str_mutiplication).charAt(0)) {
                operator = getString(R.string.str_mutiplication);
                break;
            } else if (mString_Display.charAt(i) == getString(R.string.str_devision).charAt(0)) {
                operator = getString(R.string.str_devision);
                break;
            } else if (mString_Display.charAt(i) == getString(R.string.str_add).charAt(0)) {
                operator = getString(R.string.str_modolus);
                break;
            }
        }
        return operator;
    }

    private void initView(View view) {
        mTextview_Display = view.findViewById(R.id.text_view_display);
        mButton_Ac = view.findViewById(R.id.button_ac);
        mButton_Ac.setOnClickListener(this);
        mButton_Sign = view.findViewById(R.id.button_sign);
        mButton_Sign.setOnClickListener(this);
        mButton_Modolus = view.findViewById(R.id.button_modolus);
        mButton_Modolus.setOnClickListener(this);
        mButton_Division = view.findViewById(R.id.button_division);
        mButton_Division.setOnClickListener(this);
        mButton_Add = view.findViewById(R.id.button_add);
        mButton_Add.setOnClickListener(this);
        mButton_Sub = view.findViewById(R.id.button_sub);
        mButton_Sub.setOnClickListener(this);
        mButton_Mutiplication = view.findViewById(R.id.button_mutiplication);
        mButton_Mutiplication.setOnClickListener(this);
        mButton_Number0 = view.findViewById(R.id.button_number0);
        mButton_Number0.setOnClickListener(this);
        mButton_Number1 = view.findViewById(R.id.button_number1);
        mButton_Number1.setOnClickListener(this);
        mButton_Number2 = view.findViewById(R.id.button_number2);
        mButton_Number2.setOnClickListener(this);
        mButton_Number3 = view.findViewById(R.id.button_number3);
        mButton_Number3.setOnClickListener(this);
        mButton_Number4 = view.findViewById(R.id.button_number4);
        mButton_Number4.setOnClickListener(this);
        mButton_Number5 = view.findViewById(R.id.button_number5);
        mButton_Number5.setOnClickListener(this);
        mButton_Number6 = view.findViewById(R.id.button_number6);
        mButton_Number6.setOnClickListener(this);
        mButton_Number7 = view.findViewById(R.id.button_number7);
        mButton_Number7.setOnClickListener(this);
        mButton_Number8 = view.findViewById(R.id.button_number8);
        mButton_Number8.setOnClickListener(this);
        mButton_Number9 = view.findViewById(R.id.button_number9);
        mButton_Number9.setOnClickListener(this);
        mButton_Result = view.findViewById(R.id.button_result);
        mButton_Result.setOnClickListener(this);
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
}
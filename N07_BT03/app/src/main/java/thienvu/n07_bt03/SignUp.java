package thienvu.n07_bt03;

import android.app.DatePickerDialog;
import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.*;


import java.util.Calendar;
import java.util.TimeZone;

public class SignUp extends Activity implements View.OnClickListener, DatePickerDialog.OnDateSetListener {

    private EditText et_username;
    private EditText et_password;
    private EditText et_passwordRetype;
    private EditText et_birthday;

    private Button btn_birthdaySelect;
    private Button btn_reset;
    private Button btn_signup;
    private Button btn_exit;

    private RadioGroup rg_gender;
    private RadioButton rb_male;
    private RadioButton rb_female;

    private CheckBox cb_tennis;
    private CheckBox cb_futbal;
    private CheckBox cb_others;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bindView();
        bindOnClickEvent();
    }

    private void bindView() {
        et_username = findViewById(R.id.et_username);
        et_password = findViewById(R.id.et_password);
        et_passwordRetype = findViewById(R.id.et_passwordRetype);
        et_birthday = findViewById(R.id.et_birthday);

        btn_birthdaySelect = findViewById(R.id.btn_birthdaySelect);
        btn_reset = findViewById(R.id.btn_reset);
        btn_signup = findViewById(R.id.btn_signup);
        btn_exit = findViewById(R.id.btn_exit);

        rg_gender = findViewById(R.id.rg_gender);
        rb_male = findViewById(R.id.rb_male);
        rb_female = findViewById(R.id.rb_female);

        cb_tennis = findViewById(R.id.cb_tennis);
        cb_futbal = findViewById(R.id.cb_futbal);
        cb_others = findViewById(R.id.cb_others);
    }

    private void bindOnClickEvent() {
        btn_birthdaySelect.setOnClickListener(this);
        btn_reset.setOnClickListener(this);
        btn_signup.setOnClickListener(this);
        btn_exit.setOnClickListener(this);
    }

    private void onBirthdaySelectClick() {
        Log.d("TTV", "onBirthdaySelectClick");
        Calendar calendar = Calendar.getInstance(TimeZone.getDefault());
        DatePickerDialog dialog = new DatePickerDialog(this, this, calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DAY_OF_MONTH));
        dialog.show();
    }

    private void onResetClick() {
        et_username.setText("");
        et_password.setText("");
        et_passwordRetype.setText("");
        et_birthday.setText("");

        rb_male.setChecked(false);
        rb_female.setChecked(false);

        cb_tennis.setChecked(false);
        cb_futbal.setChecked(false);
        cb_others.setChecked(false);
    }

    private void onSignupClick() {
        String password = et_password.getText().toString();
        String passwordRetype = et_passwordRetype.getText().toString();

        if (!password.equals(passwordRetype)) {
            et_passwordRetype.setError("Password did not match");
        } else {
            Toast.makeText(this, "Sign up successful", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_birthdaySelect:
                onBirthdaySelectClick();
                break;
            case R.id.btn_reset:
                onResetClick();
                break;
            case R.id.btn_signup:
                onSignupClick();
                break;
            case R.id.btn_exit:
                finish();
                break;
        }
    }

    @Override
    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
        String date = String.valueOf(dayOfMonth) + "/" + month + "/" + year;
        et_birthday.setText(date);
    }
}

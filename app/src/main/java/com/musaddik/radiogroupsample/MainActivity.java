package com.musaddik.radiogroupsample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private RadioGroup radioGroup;
    private RadioButton sound, vibration, silent;
    private Button button;

    private TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        radioGroup = (RadioGroup) findViewById(R.id.myRadioGroup);
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
// find which radio button is selected
                if(checkedId == R.id.silent) {
                    Toast.makeText(getApplicationContext(), "choice: Silent", Toast.LENGTH_SHORT).show();
                } else if(checkedId == R.id.sound) {
                    Toast.makeText(getApplicationContext(), "choice: Sound",
                            Toast.LENGTH_SHORT).show();

                } else {
                    Toast.makeText(getApplicationContext(), "choice: Vibration",
                            Toast.LENGTH_SHORT).show();
                }
            }
        });
        sound = (RadioButton) findViewById(R.id.sound);
        vibration = (RadioButton) findViewById(R.id.vibration);
        silent = (RadioButton) findViewById(R.id.silent);
        textView = (TextView) findViewById(R.id.text);
        button = (Button)findViewById(R.id.chooseBtn);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int selectedId = radioGroup.getCheckedRadioButtonId();
// find which radioButton is checked by id

                if(selectedId == sound.getId()) {
                    textView.setText("You chose 'Sound' option");
                } else if(selectedId == vibration.getId()) {
                    textView.setText("You chose 'Vibration' option");
                } else {
                    textView.setText("You chose 'Silent' option");
                }
            }
        });
    }
}
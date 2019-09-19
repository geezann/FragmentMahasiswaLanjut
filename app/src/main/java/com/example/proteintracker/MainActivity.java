package com.example.proteintracker;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button helpBtn = (Button) findViewById(R.id.helpButton);
        helpBtn.setOnClickListener(helpButtonListener);

        TextView textView = (TextView) findViewById(R.id.mainActivityTextView);
        Button myBtn = (Button) findViewById(R.id.button1);

        textView.setText(R.string.test_untuk_update_view);
        myBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText myEditText = (EditText) findViewById(R.id.editText1);
                Log.d("Proteintracker", myEditText.getText().toString());
            }
        });

        if (savedInstanceState != null) {
            Log.d("ProteinTracker", savedInstanceState.getString("abc"));
        }
    }

    private View.OnClickListener helpButtonListener = new View.OnClickListener()
    {
        @Override
        public void onClick (View view) {
            Intent intent = new Intent(MainActivity.this,HelpActivity.class);
            Bundle b = new Bundle();
            EditText myEditText = (EditText) findViewById(R.id.editText1);
            b.putString("helpString", myEditText.getText().toString()) ;
            intent.putExtras(b);
            startActivity(intent);
        }
    };

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        outState.putString("abc","test");
        super.onSaveInstanceState(outState);
    }

    public void GoToFragment(View view) {
        Intent intent = new Intent(MainActivity.this, Main2FragmentActivity.class);
        startActivity(intent);
    }

    public void GoToMahasiswa1(View view) {
        Intent intent = new Intent(MainActivity.this, Mahasiswa1Activity.class);
        startActivity(intent);
    }
}





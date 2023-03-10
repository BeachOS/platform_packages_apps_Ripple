package org.beachos.ripple;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

public class TestActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);

        ImageButton panicButton = findViewById(R.id.panic_button);
        panicButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(TestActivity.this);
                prefs.edit().putBoolean(MainActivity.FIRST_RUN_PREF, false).apply();
                Intent intent = new Intent(TestActivity.this, PanicActivity.class);
                intent.putExtra(PanicActivity.EXTRA_TEST_RUN, true);
                startActivity(intent);
                finish();
            }
        });
    }
}

package c.gla.task07;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText edt1, edt2;
    Button btn;
    String namec, passwordc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edt1 = findViewById(R.id.edt1);
        edt2 = findViewById(R.id.edt2);
        btn = findViewById(R.id.button);

        namec = edt1.getText().toString().trim();
        passwordc = edt2.getText().toString().trim();
    }

    @Override
    protected void onPause() {
        super.onPause();
        SharedPreferences sharedPreferences = getSharedPreferences("c.gla.task07", MODE_PRIVATE);
        SharedPreferences.Editor editor  = sharedPreferences.edit();
        editor.putString("username", "ashish.maurya_mca18@gla.ac.in");
        editor.putString("password", "12345");
        editor.apply();
    }


    @Override
    protected void onResume() {
        super.onResume();
        SharedPreferences sharedPreferences = getSharedPreferences("c.gla.task07", MODE_PRIVATE);
        String name = sharedPreferences.getString("name", "ashish");
        String password = sharedPreferences.getString("password", "12345");



        if(namec.equals(name) && passwordc.equals(password)){
            Toast.makeText(this, "new activity", Toast.LENGTH_SHORT).show();
        }
        else{
            Toast.makeText(this, "error", Toast.LENGTH_SHORT).show();
        }


    }

    public void btnClick(View view) {
        onPause();
        onResume();

    }
}

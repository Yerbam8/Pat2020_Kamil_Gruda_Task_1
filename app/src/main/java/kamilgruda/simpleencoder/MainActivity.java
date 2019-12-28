package kamilgruda.simpleencoder;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTheme(R.style.AppTheme);
        setContentView(R.layout.activity_main);
        Button encodeButton = findViewById(R.id.button);
        Button decodeButton = findViewById(R.id.button1);
        encodeButton.setOnClickListener(this);
        decodeButton.setOnClickListener(this);
    }


    private String encodeText(String str) {
        char[] tab = str.toCharArray();
        StringBuilder result = new StringBuilder();

        int count = 1;
        for (int i = 1; i < str.length(); i++) {

            if (tab[i - 1] == tab[i]) {
                count++;

            } else {
                result.append(count).append(tab[i - 1]);
                count = 1;

            }
            if (i + 1 == str.length()) {
                result.append(count).append(tab[str.length() - 1]);

            }

        }
        return String.valueOf(result);
    }

    private String decodeText(String str) {
        char[] tab = str.toCharArray();
        StringBuilder result = new StringBuilder();


        for (int i = 0; i < str.length(); ) {
            int a = 0;
            while (Character.isDigit(tab[i])) {
                a = Integer.parseInt(a + String.valueOf(tab[i]));
                i++;

            }
            while (a > 0) {
                result.append(tab[i]);
                a--;
            }
            i++;
        }
        return String.valueOf(result);
    }


    @Override
    public void onClick(View v) {
        EditText editText = findViewById(R.id.editText);
        String text = editText.getText().toString().trim();
        TextView textView = findViewById(R.id.textView1);

        switch (v.getId()) {
            case R.id.button:
                textView.setText(encodeText(text));
                break;
            case R.id.button1:
                textView.setText(decodeText(text));
                break;
        }
    }
}

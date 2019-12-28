package kamilgruda.simpleencoder;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTheme(R.style.AppTheme);
        setContentView(R.layout.activity_main);
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

    public void codeText(View view) {
        EditText editText = findViewById(R.id.editText);
        String text = editText.getText().toString().trim();
        TextView textView = findViewById(R.id.textView1);
        if (view.getId()==R.id.button) {
            textView.setText(encodeText(text));
        }else if(view.getId()==R.id.button1) {
            textView.setText(decodeText(text));
        }


    }


}

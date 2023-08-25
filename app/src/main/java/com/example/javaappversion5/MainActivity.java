package com.example.javaappversion5;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    Button refresh , go , copyButton ;
    Random random = new Random() ;
    TextView displayAnswer;
    String answer="" ;
    EditText inputLength ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Window window = getWindow();

        int statusBarColor = Color.parseColor("#2F3C7E");

        window.setStatusBarColor(statusBarColor);


        intialize();






    }

    private void copyToClipboard(Context context, String texttoCopy) {
        ClipboardManager clipboard = (ClipboardManager) context.getSystemService(Context.CLIPBOARD_SERVICE);
        ClipData clip = ClipData.newPlainText("copied text", texttoCopy);
        clipboard.setPrimaryClip(clip);
    }

    public String calculation()
    {


        int a , input = 0;
        char b = 'a' ;

        if(inputLength.getText().toString().isEmpty())
        {
            answer="error";
            Toast.makeText(getApplicationContext(), "error", Toast.LENGTH_SHORT).show();


            return answer;



        } else {
             input = Integer.parseInt(String.valueOf(inputLength.getText())) ;
        }


        answer="";




        for (int i = 0; answer.length()!=input ; i++)
        {
            a = random.nextInt(1000);
            a = a%127;
            if (a>33 && a<127 && answer.length()<input)
            {
                b = (char)a ;
                answer = answer + b ;

            }
        }

            copyToClipboard(this , answer);

        return answer;
    }
    public void Copy(View view)
    {
        copyToClipboard(this , answer);
    }
    public void intialize()
    {
        go =findViewById(R.id.go);

        inputLength =findViewById(R.id.inputLength);
        displayAnswer =findViewById(R.id.displayAnswer);

    }
    public void clicked (View view)
    {
        calculation();
        displayAnswer.setText(answer);

    }


}
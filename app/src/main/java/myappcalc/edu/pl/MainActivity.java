package myappcalc.edu.pl;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private TextView display;
    private String toShow = "";
    private boolean isDotClicked;
    private boolean isEqualClicked;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        display = (TextView) findViewById(R.id.display);
        updateDisplay();
    }

    protected void updateDisplay(){
        display.setText(toShow);
    }

    public void numberClick(View v){
        Button b = (Button) v;
        String buttonValue = b.getText().toString();
        boolean isDot = buttonValue.equals(".");
        if(toShow.length() == 0){
            if(!isDot) toShow += buttonValue;
            else{
                toShow += "0";
                toShow += buttonValue;
                isDotClicked = true;
            }
        }
        else if ((isDot && !isDotClicked) || !isDot){
            String lastChar = toShow.substring(toShow.length()-1);
            if(lastChar.equals("+") || lastChar.equals("-") || lastChar.equals("*") || lastChar.equals("/") || lastChar.equals("=")) {
                if (!isDot) {
                    toShow += buttonValue;
                } else {
                    toShow += "0";
                    toShow += buttonValue;
                    isDotClicked = true;
                }
            }
             else{
                 toShow += buttonValue;
                 if(isDot) isDotClicked = true;

            }
        }
        updateDisplay();
    }

    public void operatorClick(View v) {
        Button b = (Button) v;
        String buttonValue = b.getText().toString();
        if (toShow.length() > 0) {
            String lastChar = toShow.substring(toShow.length() - 1);
            if (lastChar.equals("+") || lastChar.equals("-") || lastChar.equals("*") || lastChar.equals("/")) {
                if (lastChar.equals(buttonValue)) {
                    toShow = toShow.substring(0, toShow.length() - 1);
                    toShow += buttonValue;
                }
            }
            else {
                if (lastChar.equals(".")) toShow = toShow.substring(0, toShow.length() - 1);
                toShow += buttonValue;
            }
            isDotClicked = false;
            updateDisplay();
        }
    }

    public void equalClick(View v){
        if(!isEqualClicked){
            Button b= (Button) v;
            String buttonValue = b.getText().toString();

        }
    }
    protected void clear(){
        toShow = "";
        isDotClicked = false;
        updateDisplay();
    }

    public void clearScr(View v){
        clear();
    }
}

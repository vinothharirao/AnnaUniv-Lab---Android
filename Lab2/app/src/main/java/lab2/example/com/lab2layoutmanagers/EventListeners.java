package lab2.example.com.lab2layoutmanagers;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

public class EventListeners extends AppCompatActivity {
    TextView text;
    Button animate;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_listeners);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        text = (TextView)(findViewById(R.id.text));
        animate = (Button)findViewById(R.id.animate);

        text.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                text.setBackgroundColor(0xff2196f3);
                text.setTextColor(0xffffffff);
                return true;
            }
        });
        text.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                text.setBackgroundColor(0x00000000);
                text.setTextColor(0xff3f51b5);
            }
        });

        animate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                animate.animate().rotationBy(360).setDuration(1000);
            }
        });
    }

}

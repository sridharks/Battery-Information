package com.example.sridhar.batteryinformation;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.BatteryManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {


    ProgressBar pb;
    int health;
    int icon_small;
    int level;
    int plugged;
    boolean present;
    int scale;
    int status;
    String technology;
    int temperature;
    int voltage;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.registerReceiver(this.receiver, new IntentFilter(Intent.ACTION_BATTERY_CHANGED));
         }
    private BroadcastReceiver receiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            int level = intent.getExtras().getInt("level", 0);
 //          level = intent.getIntExtra(BatteryManager.EXTRA_LEVEL,1);
            health = intent.getIntExtra(BatteryManager.EXTRA_HEALTH, 0);
            icon_small = intent.getIntExtra(BatteryManager.EXTRA_ICON_SMALL, 0);
            plugged = intent.getIntExtra(BatteryManager.EXTRA_PLUGGED, 0);
            present = intent.getExtras().getBoolean(BatteryManager.EXTRA_PRESENT);
            scale = intent.getIntExtra(BatteryManager.EXTRA_SCALE, 0);
            status = intent.getIntExtra(BatteryManager.EXTRA_STATUS, 0);
            technology = intent.getExtras().getString(BatteryManager.EXTRA_TECHNOLOGY);
            temperature = intent.getIntExtra(BatteryManager.EXTRA_TEMPERATURE, 0);
            voltage = intent.getIntExtra(BatteryManager.EXTRA_VOLTAGE, 0);
            pb = (ProgressBar) findViewById(R.id.progressBar);
              pb.setProgress(level);
            TextView text = (TextView) findViewById(R.id.textView);
            ImageView img = (ImageView) findViewById(R.id.imageView2);

            String text1 = "Level:"+Integer.toString(level)+"\n\n"
                           +"Health:"+health+"\n\n"
               //     +"Icon Small:"+icon_small+"\n\n"
                    +"Plugged:"+plugged+"\n\n"
                    +"present:"+present+"\n\n"
                    +"Scale:"+scale+"\n\n"
                    +"Status:"+status+"\n\n"
                    +"Technology:"+technology+"\n\n"
                    +"Temperature:"+temperature+"\n\n"
                    +"Voltage:"+voltage;
            text.setText(text1);
            img.setImageResource(icon_small);
//            text.setText("Level:"+level+"\n\n"
//                    +"Health:"+health+"\n\n"
//                    +"Icon Small:"+icon_small+"\n\n"
//                    +"Plugged:"+plugged+"\n\n"
//                    +"present:"+present+"\n\n"
//                    +"Scale:"+scale+"\n\n"
//                    +"Status:"+status+"\n\n"
//                    +"Technology:"+technology+"\n\n"
//                    +"Temperature:"+temperature+"\n\n"
//                    +"Voltage:"+voltage);
        }

    };

}

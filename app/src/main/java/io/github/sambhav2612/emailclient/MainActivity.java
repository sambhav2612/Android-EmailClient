package io.github.sambhav2612.emailclient;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText et1 = null, et2 = null, et3 = null;
    Button btn = null;
    GMailSender sender = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et1 = (EditText) findViewById(R.id.enter_recipent_email);
        et2 = (EditText) findViewById(R.id.enter_subject);
        et3 = (EditText) findViewById(R.id.enter_message);

        btn = (Button) findViewById(R.id.send_mail);

        sender = new GMailSender("sambhav.portfolio.app@gmail.com", "@Shambhav2612");

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    sender.sendMail(et2.getText().toString(), et3.getText().toString(), "sambhav.portfolio.app@gmail.com", et1.getText().toString());
                    Toast.makeText(MainActivity.this, "Mail Send Successfully.....", Toast.LENGTH_SHORT).show();
                } catch (Exception e) {
                    Log.e("SendMail", e.getMessage(), e);
                    e.printStackTrace();
                }
            }
        });

        // ATTENTION: This was auto-generated to handle app links.
        Intent appLinkIntent = getIntent();
        String appLinkAction = appLinkIntent.getAction();
        Uri appLinkData = appLinkIntent.getData();
    }
}

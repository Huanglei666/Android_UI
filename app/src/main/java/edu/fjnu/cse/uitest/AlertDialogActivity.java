package edu.fjnu.cse.uitest;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.app.AlertDialog;
import android.view.View;

public class AlertDialogActivity extends AppCompatActivity {
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alert);

        AlertDialog.Builder builder = new AlertDialog.Builder(this);

        View view = View.inflate(AlertDialogActivity.this,R.layout.alert_layout,null);

        builder.setView(view);
        builder.create().show();
    }
}

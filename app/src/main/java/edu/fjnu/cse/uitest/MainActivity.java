package edu.fjnu.cse.uitest;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnListView = (Button) this.<View>findViewById(R.id.SimpleAdapter);
        btnListView.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent i = new Intent(MainActivity.this ,SimpleAdapterActivity.class);
                startActivity(i);
            }
        });

       Button btnAlertDialog = (Button) this.<View>findViewById(R.id.AlertDialog);
        btnAlertDialog.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent i = new Intent(MainActivity.this , AlertDialogActivity.class);
                startActivity(i);
            }
        });

        Button btnMenu = (Button) this.<View>findViewById(R.id.XmlMenu);
        btnMenu.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent i = new Intent(MainActivity.this , XMLMenuActivity.class);
                startActivity(i);
            }
        });

  /*      Button btnContextMenu = (Button) this.<View>findViewById(R.id.Context_Menu);
        btnContextMenu.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent i = new Intent(MainActivity.this , ContextMenuActivity.class);
                startActivity(i);
            }
        });*/



    }
}
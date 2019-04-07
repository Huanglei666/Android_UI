package edu.fjnu.cse.uitest;

import android.support.v7.app.AppCompatActivity;

import android.os.Bundle;

import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

public class XMLMenuActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.xml_menu_layout);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // 将菜单资源文件映射成菜单
        getMenuInflater().inflate(R.menu.xml_menus, menu);
        return true;
    }

    //菜单项单击事件处理方法
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        TextView text = (TextView)findViewById(R.id.TestContent);;
        switch (item.getItemId()) {

            case R.id.font_20:
                text.setTextSize(20);
                break;
            case R.id.font_16:
                text.setTextSize(16);
                break;
            case R.id.font_10:
                text.setTextSize(10);
                break;

            case R.id.normal_menu:
                Toast.makeText(this, "你单击了<普通菜单项>", Toast.LENGTH_SHORT).show();
                break;

            case R.id.red:
                text.setTextColor(android.graphics.Color.RED);
                break;
            case R.id.black:
                text.setTextColor(android.graphics.Color.BLACK);
                break;
        }
        return true;
    }
}

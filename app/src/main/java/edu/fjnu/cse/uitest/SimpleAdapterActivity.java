package edu.fjnu.cse.uitest;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SimpleAdapterActivity  extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.listview);
        final String[] picture_name = new String[]{"Lion","Cat","Monkey","Dog","Tiger","Elephant"};
        final int[] picture = new int[]{R.drawable.lion,R.drawable.cat,R.drawable.monkey,R.drawable.dog,
                R.drawable.tiger,R.drawable.elephant};
        List<Map<String,Object>> list = new ArrayList<Map<String,Object>>();

        for(int i=0;i<picture_name.length;i++){
            Map<String,Object> item = new HashMap<String,Object>();
            item.put("name",picture_name[i]);
            item.put("picture",picture[i]);
            list.add(item);
        }

        SimpleAdapter simpleAdapter = new SimpleAdapter(this,list,R.layout.simple_adapter_layout,
                new String[]{"name","picture"},new int[]{R.id.name,R.id.picture});
        ListView listView = (ListView) findViewById(R.id.List);
        listView.setAdapter(simpleAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                CharSequence item = picture_name[position];
                Toast.makeText(getApplicationContext(),item,Toast.LENGTH_LONG).show();
            }
        });
    }
}

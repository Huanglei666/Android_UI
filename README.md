# 实验三 Android_UI                                   
>                                                                               软工（1）班 黄磊 123012016005
## 一.实验内容
掌握SimpleAdapter、AlertDialog、XML定义菜单以及创建ContextMenu等。


## 二.相关概念
1.SimpleAdapter：
使用simpleAdapter的数据用一般都是HashMap构成的List，list的每一节对应ListView的每一行。HashMap的每个键值数据映射到布局文件中对应id的组件上。 

2.AlertDialog：
用于创建安卓对话框。

3.XML定义菜单：
通过使用XML可以定义并创建安卓菜单。

4.ActionMode：
ActionMode是Android 3.0以后出现的Android 3.0以前，我们处理列表的长按事件经常使用Context Menu，Android3.0以后，我们有了新的选择：ActionMode。


## 三.实验关键/核心代码
1.SimpleAdapter.xml：
 <TextView
        android:id="@+id/name"
        android:layout_width="0dp"
        android:layout_height="39dp"
        android:layout_marginStart="51dp"
        android:layout_marginTop="26dp"
        android:layout_marginEnd="197dp"
        android:text="TextView"
        app:layout_constraintEnd_toStartOf="@+id/picture"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintTop_toTopOf="parent" />

    <ImageView
        android:id="@+id/picture"
        android:layout_width="85dp"
        android:layout_height="75dp"
        android:layout_marginTop="8dp"
        android:layout_marginEnd="8dp"
        app:layout_constraintEnd_toEndOf="parent"
        app:layout_constraintStart_toEndOf="@+id/name"
        app:layout_constraintTop_toTopOf="parent"
        app:srcCompat="@drawable/dog" />
        

2.SimpleAdapterActivity.java：


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
    
    
3.AlertDialog.xml：

<ImageView
        android:id="@+id/header"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        app:layout_constraintTop_toTopOf="parent"
        app:layout_constraintLeft_toLeftOf="parent"
        app:srcCompat="@drawable/header_logo" />

    <EditText
        android:id="@+id/text1"
        android:hint="Username"
        android:textSize="25sp"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        app:layout_constraintTop_toBottomOf="@id/header"
        app:layout_constraintStart_toStartOf="parent"
        />
    <EditText
        android:id="@+id/text2"
        android:hint="Password"
        android:inputType="textPassword"
        android:textSize="25sp"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        app:layout_constraintTop_toBottomOf="@id/text1"
        app:layout_constraintLeft_toLeftOf="parent"
        />

    <LinearLayout
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:orientation="horizontal"
        app:layout_constraintTop_toBottomOf="@id/text2">
        <Button
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:layout_weight="1"
            android:text="Cancel"/>
        <Button
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:layout_weight="1"
            android:text="Sign in"/>
    </LinearLayout>
    
4.AlertDialogActivit.java：



    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alert);

        AlertDialog.Builder builder = new AlertDialog.Builder(this);

        View view = View.inflate(AlertDialogActivity.this,R.layout.alert_layout,null);

        builder.setView(view);
        builder.create().show();
    }

5.XMLMenu.xml：

    <!--     注意：string的第一个字母为小写，string.xml文件中也是！！！ -->
    <item android:title="字体大小">
        <menu>
            <group android:checkableBehavior="single" >
                <item
                    android:id="@+id/font_10"
                    android:title="小号"
                    />
                <item
                    android:id="@+id/font_16"
                    android:title="中号"/>
                <item
                    android:id="@+id/font_20"
                    android:title="大号"/>

            </group>
        </menu>
    </item>

    <item
        android:id="@+id/normal_menu"
        android:title="普通菜单选项">
    </item>

    <item android:title="字体颜色">
        <menu>
            <group android:checkableBehavior="single" >
                <item
                    android:id="@+id/red"
                    android:title="Red"
                    />
                <item
                    android:id="@+id/black"
                    android:title="Black"/>

            </group>
        </menu>
    </item>

6.XmlMenuActivity：

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
    
7.ActionMode：

<ImageView
        android:id="@+id/img"
        android:layout_width="85dp"
        android:layout_height="85dp"
        android:layout_marginTop="8dp"
        android:layout_marginStart="20dp"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintTop_toTopOf="parent"
        app:srcCompat="@drawable/android_boy" />

    <TextView
        android:id="@+id/number"
        android:layout_width="wrap_content"
        android:layout_height="85dp"
        android:layout_marginTop="20dp"
        android:textSize="30dp"
        android:textAlignment="center"
        app:layout_constraintLeft_toRightOf="@id/picture"
        app:layout_constraintTop_toTopOf="parent" />
        
        
4.Listview
    <ListView
        android:id="@+id/List"
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        android:listSelector="@color/colorAccent">
    </ListView>
    
## 4.实验运行截图

![SimpleAdapter](https://github.com/Huanglei666/Android_UI/blob/master/%E8%BF%90%E8%A1%8C%E6%88%AA%E5%9B%BE/SimpleAdapter.png)

**图1 SimpleAdapter**
                         
![AlertDialog](https://github.com/Huanglei666/Android_UI/blob/master/%E8%BF%90%E8%A1%8C%E6%88%AA%E5%9B%BE/AlertDialog.png)

**图2 AlertDialog**

![XmlMenu1](https://github.com/Huanglei666/Android_UI/blob/master/%E8%BF%90%E8%A1%8C%E6%88%AA%E5%9B%BE/XmlMenu(1).png)

**图3 XmlMenu1**

![XmlMenu2](https://github.com/Huanglei666/Android_UI/blob/master/%E8%BF%90%E8%A1%8C%E6%88%AA%E5%9B%BE/XmlMenu(2).png)

**图4 XmlMenu2**

![XmlMenu3](https://github.com/Huanglei666/Android_UI/blob/master/%E8%BF%90%E8%A1%8C%E6%88%AA%E5%9B%BE/XmlMenu(3).png)

**图5 AlertDialog**

![XmlMenu4](https://github.com/Huanglei666/Android_UI/blob/master/%E8%BF%90%E8%A1%8C%E6%88%AA%E5%9B%BE/XmlMenu(4).png)

**图6 XmlMenu4**

![XmlMenu5](https://github.com/Huanglei666/Android_UI/blob/master/%E8%BF%90%E8%A1%8C%E6%88%AA%E5%9B%BE/XmlMenu(5).png)

**图7 XmlMenu5**

![XmlMenu6](https://github.com/Huanglei666/Android_UI/blob/master/%E8%BF%90%E8%A1%8C%E6%88%AA%E5%9B%BE/XmlMenu(6).png)

**图8 XmlMenu6**

![ContextMenu](https://github.com/Huanglei666/Android_UI/blob/master/%E8%BF%90%E8%A1%8C%E6%88%AA%E5%9B%BE/ContextMenu.png)

**图9 ContextMenu**

package com.akashdubey.dialogdemo;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity  implements MyDialog.DialogListener{

   static  ArrayList<String> alName= new ArrayList<String>();
   static  ArrayList<String>alPhone= new ArrayList<String>();
   static ArrayList<String>alDob=new ArrayList<String>();
   CustomView adapter = new CustomView();

    ListView listView;
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater=getMenuInflater();
        menuInflater.inflate(R.menu.menu_main,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int itemId=item.getItemId();
                if(itemId==R.id.addMItem){
                    MyDialog myDialog=new MyDialog();
                    myDialog.show(getSupportFragmentManager(),"myDialogTagMayBe");
                }

        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView=(ListView)findViewById(R.id.listview1);

    }


    @Override
    public void PassInformation(String name, String phone, String dob) {
        alName.add(name);
        alPhone.add(phone);
        alDob.add(dob);

        listView.setAdapter(adapter);
        adapter.notifyDataSetChanged();


    }

    public class CustomView extends BaseAdapter {

        //    Context context=
        TextView name,phone,dob;
        @Override
        public int getCount() {
            return alName.size();
        }

        @Override
        public Object getItem(int i) {
            return null;
        }

        @Override
        public long getItemId(int i) {
            return 0;
        }

        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {
            LayoutInflater layoutInflater=LayoutInflater.from(getApplicationContext());
            view= layoutInflater.inflate(R.layout.custom_listview,null);
            name=(TextView)view.findViewById(R.id.nameTV);
            phone=(TextView)view.findViewById(R.id.phoneTV);
            dob=(TextView)view.findViewById(R.id.dobTV);
            name.setText(alName.get(i));
            phone.setText(alPhone.get(i));
            dob.setText(alDob.get(i));
            return view;
        }
    }

}

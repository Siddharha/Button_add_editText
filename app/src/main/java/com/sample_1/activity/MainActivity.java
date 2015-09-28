package com.sample_1.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.sample_1.R;
import com.sample_1.adapters.mListAdapter;
import com.sample_1.bean.Items;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private int i;
    private RecyclerView R_View;
    private mListAdapter mlistAdapter;
    private Button btn_del;
    List<Items> list;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initialize();
    }



    private void initialize() {
        i = 0;
        list = new ArrayList<>();
        R_View = (RecyclerView)findViewById(R.id.R_View);
        R_View.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        mlistAdapter = new mListAdapter(list,R.layout.list_layout);
        btn_del = (Button)findViewById(R.id.btn_del);
    }

    public void clk_it(View view)
    {
        if(view.getTag().toString().equals("+"))
        {
            i++;
            Items items = new Items();
            items.setNames(String.valueOf(i));
            list.add(items);

        }
        else if(view.getTag().toString().equals("-"))
        {
                i--;
            if(i>=0) {

                list.remove(i);
            }
            else
            {
                i = 0;
            }

        }

        Toast.makeText(getBaseContext(),String.valueOf(i),Toast.LENGTH_SHORT).show();
        R_View.setAdapter(mlistAdapter);

        mlistAdapter.notifyDataSetChanged();
      //  finish();
        //startActivity(new Intent(this,MainActivity.class));
    }

    //region Menu....
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
//endregion
}

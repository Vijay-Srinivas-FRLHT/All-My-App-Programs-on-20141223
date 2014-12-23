package org.frlht.neighbourhoodmedplants.neighbourhoodmedicinalplantsst2;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
//import android.widget.TextView;


public class MainActivity extends ActionBarActivity {

    private final String theCurrentTime = "2014-12-23,16:00";
    private String whichHabit;
    private int pageNo = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button buttonTree = (Button) findViewById(R.id.buttonTree);
        Button buttonHerb = (Button) findViewById(R.id.buttonHerb);
        Button buttonShrub = (Button) findViewById(R.id.buttonShrub);
        Button buttonClimber = (Button) findViewById(R.id.buttonClimber);
        Button buttonExit = (Button) findViewById(R.id.buttonExit);
        buttonTree.setOnClickListener(new View.OnClickListener (){
            @Override
            public void onClick(View view)
            {
                // TODO Auto-generated method stub
                callThis("Tree " + pageNo + " " + theCurrentTime);
            }
        });

        buttonHerb.setOnClickListener(new View.OnClickListener (){
            @Override
            public void onClick(View view)
            {
                // TODO Auto-generated method stub
                callThis("Herb " + pageNo + " " + theCurrentTime);
            }
        });

        buttonShrub.setOnClickListener(new View.OnClickListener (){
            @Override
            public void onClick(View view)
            {
                // TODO Auto-generated method stub
                callThis("Shrub " + pageNo + " " + theCurrentTime);
            }
        });

        buttonClimber.setOnClickListener(new View.OnClickListener (){
            @Override
            public void onClick(View view)
            {
                // TODO Auto-generated method stub
                callThis("Climber " + pageNo + " " + theCurrentTime);
            }
        });

        buttonExit.setOnClickListener(new View.OnClickListener (){
            @Override
            public void onClick(View view)
            {
                // TODO Auto-generated method stub
                finish();
            }
        });

    }

    /***** The User Written Methods starts here ***/
    protected void callThis(String ss) {
        // TODO Auto-generated method stub

        /*TextView showWhat = (TextView) findViewById(R.id.sampletextid);
        showWhat.setText(ss);*/

        Intent iCheck = GlobalFuncs.callThis(ss);
        startActivityForResult(iCheck, 1);
    }
    /***** The User Written Methods ends here ***/
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
}

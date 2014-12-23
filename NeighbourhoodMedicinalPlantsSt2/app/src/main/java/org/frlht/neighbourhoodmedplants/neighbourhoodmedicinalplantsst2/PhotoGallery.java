package org.frlht.neighbourhoodmedplants.neighbourhoodmedicinalplantsst2;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class PhotoGallery extends ActionBarActivity {

    private String myWhichHabit;
    private String[] whichHabit;
    private static String url_all_plants = "http://envis.frlht.org/neighbourhoodmobapp/extractingcategories.php";
    int totnoofrecs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_photo_gallery);

        Button buttonBack = (Button) findViewById(R.id.buttonBack);
        Button buttonPrev = (Button) findViewById(R.id.buttonPrev);
        Button buttonNext = (Button) findViewById(R.id.buttonNext);

        Intent i = getIntent();
        Bundle b = i.getExtras();
        myWhichHabit = b.getString(myWhichHabit);
        TextView tvw = (TextView) findViewById(R.id.photogallerymessageid);
        whichHabit = myWhichHabit.split(" ");
        tvw.setText("You are searching for " + whichHabit[0] + "\n" + "Page " + whichHabit[1] + "\n" + "Total No = " + totnoofrecs + "\nTime " + whichHabit[2]);

        buttonBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        buttonPrev.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int thePageNo = Integer.parseInt(whichHabit[1]);
                if(thePageNo != 1)
                {
                    finish();
                    Intent iCheck = GlobalFuncs.callThis(whichHabit[0] + " " + (thePageNo - 1) + " " + whichHabit[2]);
                    startActivityForResult(iCheck, 1);
                }

            }
        });

        buttonNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int thePageNo = Integer.parseInt(whichHabit[1]);
//	 				if(thePageNo != 1). The condition will be put later.
//	 				{
                finish();
                Intent iCheck = GlobalFuncs.callThis(whichHabit[0] + " " + (thePageNo + 1) + " " + whichHabit[2]);
                startActivityForResult(iCheck, 1);
//	 				}

            }
        });

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_photo_gallery, menu);
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
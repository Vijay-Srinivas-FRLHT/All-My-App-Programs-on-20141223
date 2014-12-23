package org.frlht.neighbourhoodmedplants.neighbourhoodmedicinalplantsst2;

import android.content.Intent;
import android.os.Bundle;

/**
 * Created by Vijay Srinivas on 19-12-2014.
 */
public class GlobalFuncs {
    private static String whichHabit;
    public static Intent callThis(String ss) {
        // TODO Auto-generated method stub
        Intent iCheck = new Intent("PHOTOGALLERY");
        Bundle bCheck = new Bundle();
        bCheck.putString(whichHabit, ss);
        iCheck.putExtras(bCheck);
        return iCheck;
//		startActivityForResult(iCheck, 1);
    }
}
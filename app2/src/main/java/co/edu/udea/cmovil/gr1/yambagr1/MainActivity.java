package co.edu.udea.cmovil.gr1.yambagr1;

import android.os.Bundle;


public class MainActivity extends SubActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Check if this activity was created before
        if (savedInstanceState == null) {
            // Create a fragment
            StatusFragment fragment = new StatusFragment();
            getFragmentManager().beginTransaction().add(android.R.id.content, fragment, fragment.getClass().getSimpleName()).commit();
        }
    }



}
package co.edu.udea.cmovil.gr1.yambagr1;
import android.os.Bundle;
/**
 * Created by luis on 29/09/15.
 */
public class SettingsActivity extends SubActivity{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Check if this activity was created before
        if (savedInstanceState == null) {
            // Create a fragment

            SettingFragment fragment = new SettingFragment();
            getFragmentManager().beginTransaction().add(android.R.id.content, fragment, fragment.getClass().getSimpleName()).commit();
        }
    };

}

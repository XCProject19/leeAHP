package runningmen.rmtv;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.View;

import com.gauravk.bubblenavigation.BubbleNavigationLinearView;
import com.gauravk.bubblenavigation.listener.BubbleNavigationChangeListener;

public class MainActivity extends AppCompatActivity {

    Fragment fragment = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        BubbleNavigationLinearView bubbleNavigationLinearView = findViewById(R.id.bottom_navigation);
        bubbleNavigationLinearView.setSelected(true);
        getSupportFragmentManager().beginTransaction().replace(R.id.frame_container,new HomeFragment()).commit();

        bubbleNavigationLinearView.setNavigationChangeListener(new BubbleNavigationChangeListener() {
            @Override
            public void onNavigationChanged(View view, int position) {
                switch (position) {
                    case 0 :
                        fragment = new HomeFragment();
                        break;

                    case 1 :
                        fragment = new FeedFragment();
                        break;

                }

                if (fragment != null) {
                    getSupportFragmentManager()
                            .beginTransaction()
                            .setCustomAnimations(android.R.anim.slide_in_left, android.R.anim.slide_out_right)
                            .replace(R.id.frame_container,fragment)
                            .addToBackStack(null)
                            .commit();

                }
            }
        });

    }
}
package fr.mds.droidcafev2;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    String mOrderMessage ;
    public static final String EXTRA_MESSAGE = "fr.mds.droidcafev2.extra.MESSAGE" ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
                Intent intent = new Intent(MainActivity.this, OrderActivity.class);
                intent.putExtra(EXTRA_MESSAGE, mOrderMessage);
                startActivity(intent);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        boolean ret ;
        switch (item.getItemId()) {
            case R.id.action_order:
                    Intent newIntent = new Intent(MainActivity.this, OrderActivity.class);
                    newIntent.putExtra(EXTRA_MESSAGE, mOrderMessage);
                    startActivity(newIntent);
                    ret = true;
                break;
            case R.id.action_status:
                displayToast(getString(R.string.action_status_message));
                ret = true;
                break;
            case R.id.action_favorites:
                displayToast(getString(R.string.action_favorites_message));
                ret = true;
                break;
            case R.id.action_contact:
                displayToast(getString(R.string.action_contact_message));
                ret = true;
                break;
            default:
                ret = super.onOptionsItemSelected(item);
                break;
        }
        return ret ;
    }



    public void displayToast(String message) {
        Toast.makeText(getApplicationContext(), message,
                Toast.LENGTH_SHORT).show();
    }
    /**
     * Shows a message that the donut image was clicked.
     */
    public void showDonutOrder(View view) {
        mOrderMessage = getString(R.string.donut_order_message);
        displayToast(mOrderMessage);
    }
    /**
     * Shows a message that the ice cream sandwich image was clicked.
     */
    public void showIceCreamOrder(View view) {
        mOrderMessage = getString(R.string.ice_cream_order_message);
        displayToast(mOrderMessage);
    }
    /**
     * Shows a message that the froyo image was clicked.
     */
    public void showFroyoOrder(View view) {
        mOrderMessage = getString(R.string.froyo_order_message);
        displayToast(mOrderMessage);
    }
}

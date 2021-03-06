package by.android.evgen.spring;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import com.activeandroid.query.Select;


public class MainActivity extends ActionBarActivity implements ISpringCallback<Data.Resut[]> {

    public static final String JSON_URL = "https://www.dropbox.com/s/zh8dkf0p5ia0cny/generated.json?dl=1";
    private TextView viewText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        viewText = (TextView) findViewById(R.id.viewText);
        new SpringParser().executeInThread(this, JSON_URL);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onDataLoadStart() {

    }

    @Override
    public void onDone(Data.Resut[] data) {
        data[0].save();
        Data.Resut retrievedItem = new Select().from(Data.Resut.class).executeSingle();
        viewText.setText(retrievedItem.name + "\n" + retrievedItem.email + "\n" + retrievedItem.address);

    }

    @Override
    public void onError(Exception e) {

    }
}

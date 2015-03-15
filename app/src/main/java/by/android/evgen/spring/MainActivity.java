package by.android.evgen.spring;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import com.activeandroid.query.Select;


public class MainActivity extends ActionBarActivity implements ISpringCallback<Data.Resut[]>{

    public static final String JSON_URL = "https://www.dropbox.com/s/zh8dkf0p5ia0cny/generated.json?dl=1";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
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
        Log.d("****************", data.toString());
        data[0].save();
        Data.Resut retrievedItem = new Select().from(Data.Resut.class).executeSingle();
        Log.d("****************", retrievedItem.name + retrievedItem.email);

    }

    @Override
    public void onError(Exception e) {

    }
}

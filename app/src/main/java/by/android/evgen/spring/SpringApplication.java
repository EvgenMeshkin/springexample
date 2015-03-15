package by.android.evgen.spring;

import com.activeandroid.ActiveAndroid;

/**
 * Created by evgen on 15.03.2015.
 */
public class SpringApplication extends com.activeandroid.app.Application {

    @Override
    public void onCreate() {
        super.onCreate();
        ActiveAndroid.initialize(this);
    }

}

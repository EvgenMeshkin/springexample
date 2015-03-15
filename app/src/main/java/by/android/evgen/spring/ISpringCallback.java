package by.android.evgen.spring;

/**
 * Created by evgen on 15.03.2015.
 */
public interface ISpringCallback<T> {

    void onDataLoadStart();

    void onDone(T data);

    void onError(Exception e);

}

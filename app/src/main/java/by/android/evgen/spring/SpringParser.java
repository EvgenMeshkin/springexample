package by.android.evgen.spring;

import android.os.Handler;
import android.util.Log;

import org.springframework.http.MediaType;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;

/**
 * Created by evgen on 15.03.2015.
 */
public class SpringParser {

    public void executeInThread(final ISpringCallback callback, final String... params) {
        final Handler handler = new Handler();
        callback.onDataLoadStart();
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    String url = params[0];

                    MappingJackson2HttpMessageConverter mappingJackson2HttpMessageConverter = new MappingJackson2HttpMessageConverter();
                    mappingJackson2HttpMessageConverter.setSupportedMediaTypes(Arrays.asList(new MediaType("text", "plain", MappingJackson2HttpMessageConverter.DEFAULT_CHARSET)));

                    RestTemplate restTemplate = new RestTemplate();
                    restTemplate.getMessageConverters().add(mappingJackson2HttpMessageConverter);
                    final Data.Resut[] result = restTemplate.getForObject(url, Data.Resut[].class);
                    Log.d("************r*************", result[0].name);
                    handler.post(new Runnable() {
                        @Override
                        public void run() {
                            callback.onDone(result);
                        }
                    });
                } catch (final Exception e) {
                    handler.post(new Runnable() {
                        @Override
                        public void run() {
                            e.printStackTrace();
                            callback.onError(e);
                        }
                    });
                }
            }
        }).start();

    }
}

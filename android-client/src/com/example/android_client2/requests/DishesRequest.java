package com.example.android_client2.requests;

import com.example.android_client2.ConstantsACS;
import com.example.android_client2.model.DishesFeed;
import com.octo.android.robospice.request.springandroid.SpringAndroidSpiceRequest;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;

public class DishesRequest extends SpringAndroidSpiceRequest<DishesFeed> {

    private final HttpEntity<Object> mRequestEntity;
    private final HttpHeaders headers;

    public DishesRequest() {
        super(DishesFeed.class);
        headers = new HttpHeaders();
        headers.setContentType(new MediaType("application", "json"));
        mRequestEntity = new HttpEntity<Object>(headers);
    }

    @Override
    public DishesFeed loadDataFromNetwork() throws Exception {
        return getRestTemplate().exchange(ConstantsACS.GET_DISHES_URL, HttpMethod.GET, mRequestEntity,getResultType()).getBody();
    }

    public static String getCacheKey() {
        return ConstantsACS.GET_DISHES_URL;
    }
}

package net.trapi.restapipoc.communication;

import net.trapi.restapipoc.communication.interfaces.TumblrAPI;

import retrofit2.Retrofit;
import retrofit2.converter.simplexml.SimpleXmlConverterFactory;

/**
 * Created by trapi on 03.04.2016.
 */
public class TumblrService {
    public static TumblrAPI getTumblrService(String user) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(String.format("https://%s.tumblr.com/",user))
                .addConverterFactory(SimpleXmlConverterFactory.create())
                .build();

        TumblrAPI service = retrofit.create(TumblrAPI.class);

        return service;
    }
}

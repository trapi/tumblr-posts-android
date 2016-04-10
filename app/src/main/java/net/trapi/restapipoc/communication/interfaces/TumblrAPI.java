package net.trapi.restapipoc.communication.interfaces;

import net.trapi.restapipoc.model.Tumblr;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by trapi on 03.04.2016.
 */
public interface TumblrAPI {
    @GET("api/read")
    Call<Tumblr> getData();
}

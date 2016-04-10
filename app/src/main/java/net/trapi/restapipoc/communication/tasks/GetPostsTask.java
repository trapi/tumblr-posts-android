package net.trapi.restapipoc.communication.tasks;

import android.os.AsyncTask;

import net.trapi.restapipoc.communication.TumblrService;
import net.trapi.restapipoc.communication.interfaces.TumblrAPI;
import net.trapi.restapipoc.model.Tumblr;

import java.io.IOException;
import java.lang.ref.WeakReference;
import java.util.List;

import retrofit2.Call;
import retrofit2.Response;

/**
 * Created by trapi on 03.04.2016.
 */
public class GetPostsTask extends AsyncTask<Void,Void,IOException> {

    public interface GetPostsTasksCallback {
        public void onPostsReceived(List<Tumblr.Post> posts);
        public void onPostsReceiveError(IOException e);
    }

    private WeakReference<GetPostsTasksCallback> callback;
    private List<Tumblr.Post> posts;
    private String username;

    public GetPostsTask(GetPostsTasksCallback callback, String username) {
        super();

        this.username = username;
        this.callback = new WeakReference<GetPostsTasksCallback>(callback);
    }

    @Override
    protected IOException doInBackground(Void... params) {

        TumblrAPI service = TumblrService.getTumblrService(username);
        try {
            Response<Tumblr> data = service.getData().execute();
            Tumblr body = data.body();
            if(body!=null) {
                posts = body.getPosts().getPost();
            }
        } catch (IOException e) {
            e.printStackTrace();
            return e;
        }

        return null;
    }

    @Override
    protected void onPostExecute(IOException e) {
        super.onPostExecute(e);

        GetPostsTasksCallback c = callback.get();
        if(c == null)
            return;

        if(e != null) {
            c.onPostsReceiveError(e);
            return;
        }

        c.onPostsReceived(posts);
    }
}

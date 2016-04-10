package net.trapi.restapipoc.controller.postslist;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

import net.trapi.restapipoc.R;
import net.trapi.restapipoc.communication.tasks.GetPostsTask;
import net.trapi.restapipoc.controller.post.PostViewerActivity;
import net.trapi.restapipoc.model.Tumblr;

import java.io.IOException;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

public class PostsListActivity extends AppCompatActivity implements GetPostsTask.GetPostsTasksCallback, PostsListAdapter.PostSelectedCallback {

    private static final String USERNAME_BUNDLE = "username";

    @Bind(R.id.recycler_view)
    RecyclerView recyclerView;

    @Bind(R.id.msg_text_view)
    TextView textView;

    @Bind(R.id.progress_bar)
    ProgressBar progressBar;
    private List<Tumblr.Post> posts;


    public static Intent getActivityIndent(Context ctx, String username) {
        Intent intent = new Intent(ctx, PostsListActivity.class);
        intent.putExtra(PostsListActivity.USERNAME_BUNDLE,username);

        return intent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_posts_list);
        ButterKnife.bind(this);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        String username = getIntent().getStringExtra(USERNAME_BUNDLE);
        new GetPostsTask(this, username).execute();
    }

    @Override
    public void onPostsReceived(List<Tumblr.Post> posts) {
        progressBar.setVisibility(View.GONE);

        if(posts == null) {
            textView.setText(getString(R.string.no_posts_to_display));
            textView.setVisibility(View.VISIBLE);
            return;
        }
        recyclerView.setVisibility(View.VISIBLE);
        this.posts = posts;
        recyclerView.setAdapter(new PostsListAdapter(this,posts));
    }

    @Override
    public void onPostsReceiveError(IOException e) {
        progressBar.setVisibility(View.GONE);

        textView.setText(getString(R.string.no_posts_to_display));
        textView.setVisibility(View.VISIBLE);
    }

    @Override
    public void onPostsSelected(int position) {
        Intent i = PostViewerActivity.getActivityIndent(this,posts.get(position));
        startActivity(i);
    }
}

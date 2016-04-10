package net.trapi.restapipoc.controller.post;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;

import net.trapi.restapipoc.R;
import net.trapi.restapipoc.model.Tumblr;

import butterknife.Bind;
import butterknife.ButterKnife;

public class PostViewerActivity extends AppCompatActivity {

    private static final String POST_BUNDLE = "username";

    @Bind(R.id.post_imageview)
    ImageView imageView;

    @Bind(R.id.progress_bar)
    ProgressBar progressBar;

    @Bind(R.id.text)
    WebView textView;

    public static Intent getActivityIndent(Context ctx, Tumblr.Post post) {
        Intent intent = new Intent(ctx, PostViewerActivity.class);
        intent.putExtra(PostViewerActivity.POST_BUNDLE,post);

        return intent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post_viewer);
        ButterKnife.bind(this);

        Tumblr.Post post = (Tumblr.Post) getIntent().getSerializableExtra(POST_BUNDLE);
        displayPost(post);
    }

    private void displayPost(Tumblr.Post post) {
        if(post.getPhotoUrl() != null && post.getPhotoUrl().size() > 0) {
            progressBar.setVisibility(View.VISIBLE);

            String link = post.getPhotoUrl().get(0).getLink();
            Picasso.with(this).load(link).into(imageView, new Callback() {
                @Override
                public void onSuccess() {
                    progressBar.setVisibility(View.GONE);
                    imageView.setVisibility(View.VISIBLE);
                }

                @Override
                public void onError() {
                    progressBar.setVisibility(View.GONE);
                }
            });
        }
        textView.loadData(post.getDisplayText(),"text/html", null);
    }
}

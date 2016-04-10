package net.trapi.restapipoc.controller.postslist;

import android.graphics.Bitmap;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;

import net.trapi.restapipoc.R;
import net.trapi.restapipoc.model.Tumblr;

import java.lang.ref.WeakReference;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by trapi on 08.04.2016.
 */
public class PostsListAdapter extends RecyclerView.Adapter<PostsListAdapter.PostListRowHolder>  {

    public interface PostSelectedCallback {
        public void onPostsSelected(int position);
    }

    private List<Tumblr.Post> posts;
    private WeakReference<PostSelectedCallback> callback;

    public class PostListRowHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        @Bind(R.id.text_view)
        protected TextView title;

        @Bind(R.id.img_view)
        protected ImageView image;

        public PostListRowHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }

        @Override
        public void onClick(View v) {
            PostSelectedCallback c = callback.get();
            if(c == null)
                return;
            c.onPostsSelected(getAdapterPosition());
        }
    }

    public PostsListAdapter(PostSelectedCallback callback, List<Tumblr.Post> posts) {
        super();
        this.posts = posts;
        this.callback = new WeakReference<>(callback);
    }

    @Override
    public PostsListAdapter.PostListRowHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.post_list_row, null);
        PostListRowHolder holder = new PostListRowHolder(v);

        return holder;
    }

    @Override
    public void onBindViewHolder(PostListRowHolder holder, int position) {
        Tumblr.Post post = posts.get(position);

        holder.itemView.setOnClickListener(holder);

        holder.title.setText(post.getDisplayTitle());

        holder.image.setVisibility(View.GONE);
        if(post.getType().equals(Tumblr.Post.POST_PHOTO)) {
            holder.image.setVisibility(View.VISIBLE);
            holder.image.setImageResource(R.drawable.blank);
            if(post.getPhotoUrl() != null && post.getPhotoUrl().size() > 0) {
                Picasso.with(holder.image.getContext()).load(post.getPhotoUrl().get(0).getLink()).into(holder.image);
            }
        }
    }

    @Override
    public int getItemCount() {
        return posts.size();
    }
}

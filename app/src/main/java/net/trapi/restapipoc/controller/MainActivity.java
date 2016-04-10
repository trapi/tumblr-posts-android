package net.trapi.restapipoc.controller;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import net.trapi.restapipoc.R;
import net.trapi.restapipoc.controller.postslist.PostsListActivity;

import butterknife.Bind;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    @Bind(R.id.enter_login_edit_text)
    EditText userLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

    public void onSeePostsClicked(View view) {

        String username = userLogin.getText().toString();

        if(username.isEmpty() || username.length() > 20) {
            userLogin.setError(getString(R.string.empty_username));
            return;
        }

        displayPosts(username);
    }

    private void displayPosts(String username) {
        startActivity(PostsListActivity.getActivityIndent(this, username));
    }
}

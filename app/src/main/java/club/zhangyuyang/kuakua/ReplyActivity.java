package club.zhangyuyang.kuakua;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import club.zhangyuyang.kuakua.adapter.ReplyAdapter;
import club.zhangyuyang.kuakua.base.BaseActicity;
import club.zhangyuyang.kuakua.fwk_model.AnswerBean;
import club.zhangyuyang.kuakua.fwk_model.FriendBean;
import club.zhangyuyang.kuakua.fwk_presenter.ReplyPresenter;
import club.zhangyuyang.kuakua.fwk_view.IReplyView;

public class ReplyActivity extends BaseActicity implements IReplyView, View.OnClickListener {

    public static final String EXTRA_USERNAME_REPLY = "club.zhangyuyang.kuakua.conversationactivity.EXTRA_USERNAME_REPLY";
    private ReplyPresenter mPresenter;

    private TextView mTextView;
    private RecyclerView mRecyclerView;
    private ImageView mImageView;
    private ReplyAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reply);

        mPresenter = new ReplyPresenter(this);
        mPresenter.initView();
    }

    @Override
    public void initView() {

    }

    @Override
    public void initView(String username, List<AnswerBean> list, FriendBean friendBean) {
        mTextView = (TextView) findViewById(R.id.tv_title_activity_reply);
        mRecyclerView = (RecyclerView) findViewById(R.id.rv_reply);
        mImageView = (ImageView) findViewById(R.id.iv_back_activity_reply);

        mImageView.setOnClickListener(this);
        mTextView.setText(username + " " + getResources().getString(R.string.tv_reply));
        mAdapter = new ReplyAdapter(this, list, friendBean);
        mRecyclerView.setAdapter(mAdapter);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
    }


    public static void startReplyActivity(Context context, String username) {
        Intent intent = new Intent(context, ReplyActivity.class);
        intent.putExtra(EXTRA_USERNAME_REPLY, username);
        context.startActivity(intent);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.iv_back_activity_reply:
                finish();
                break;
        }
    }

    public void refreshView() {
        mRecyclerView.setAdapter(mPresenter.getAdapter());
    }
}

package club.zhangyuyang.kuakua;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import club.zhangyuyang.kuakua.adapter.ConversationAdapter;
import club.zhangyuyang.kuakua.base.BaseActicity;
import club.zhangyuyang.kuakua.fwk_model.MessageBean;
import club.zhangyuyang.kuakua.fwk_model.UserBean;
import club.zhangyuyang.kuakua.fwk_presenter.ConversationPresenter;
import club.zhangyuyang.kuakua.fwk_view.IConversationView;

public class ConversationActivity extends BaseActicity implements IConversationView,View.OnClickListener {
    private static final String TAG = "ConversationActivity";
    public static final String EXTRA_USERNAME_GUEST="club.zhangyuyang.kuakua.conversationactivity.EXTRA_USERNAME_GUEST";

    private ConversationPresenter mPresenter;
    private ConversationAdapter mAdapter;

    private ImageView mImageView;
    private TextView mTextView;
    private RecyclerView mRecyclerView;
    private EditText mEditText;
    private Button mButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_conversation);

        mPresenter = new ConversationPresenter(this);

        mImageView = (ImageView) findViewById(R.id.iv_back_activity_conversation);
        mTextView = (TextView) findViewById(R.id.tv_title_activity_conversation);
        mRecyclerView = (RecyclerView) findViewById(R.id.rv_conversation);
        mEditText = (EditText) findViewById(R.id.et_message);
        mButton = (Button) findViewById(R.id.bt_send);

        mImageView.setOnClickListener(this);
        mButton.setOnClickListener(this);
        mPresenter.initView();
    }



    public static void startConversationActivity(Context context, String username){
        Intent intent = new Intent(context,ConversationActivity.class);
        intent.putExtra(EXTRA_USERNAME_GUEST, username);
        context.startActivity(intent);
    }

    @Override
    public void initView() {

    }

    @Override
    public void initView(List<MessageBean> list, String nickname, UserBean userBean) {
        mTextView.setText(nickname);
        mAdapter = new ConversationAdapter(list, userBean);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mRecyclerView.setAdapter(mAdapter);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.iv_back_activity_conversation:
                finish();
                break;
            case R.id.bt_send:
                String message = mEditText.getText().toString();
                if (message.equals("")) {
                    break;
                } else {
                    mEditText.setText("");
                    Log.d(TAG, "onClick: "+message);
                    mPresenter.sendMessage(message);
                }
                break;
        }
    }
}

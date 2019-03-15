package club.zhangyuyang.kuakua.fwk_presenter;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import org.litepal.LitePal;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Handler;

import club.zhangyuyang.kuakua.ConversationActivity;
import club.zhangyuyang.kuakua.R;
import club.zhangyuyang.kuakua.adapter.ConversationAdapter;
import club.zhangyuyang.kuakua.fwk_model.AnswerBean;
import club.zhangyuyang.kuakua.fwk_model.MessageBean;
import club.zhangyuyang.kuakua.fwk_model.UserBean;

/**
 * @Author :   yuyang
 * @Email :    octopusheep@gmail.com
 * @website :  www.zhangyuyang.club
 * @Date :     19-3-14 下午6:53
 * @FileName : ConversationPresenter
 * Content   : TODO
 * Other     :
 */
public class ConversationPresenter {
    private static final String TAG = "ConversationPresenter";
    private ConversationActivity mActivity;
    private SQLiteDatabase mDatabase;
    private Intent mIntent;
    private String mUsername;
    private ConversationAdapter mAdapter;
    private MessageBean mMessageBean;

    public ConversationPresenter(ConversationActivity activity) {
        mActivity = activity;
        mIntent = mActivity.getIntent();
        mUsername = mIntent.getStringExtra(ConversationActivity.EXTRA_USERNAME_GUEST);
    }

    public void initView() {

        initDatabase();
        if (isNeverTalk()) {
            mActivity.initView(getDefaultList(), getTitle(), getUserInformation());
        } else {
            mActivity.initView(getMessageList(), getTitle(), getUserInformation());
        }
    }

    public UserBean getUserInformation() {
        if (!loginBefore()) {
            initDefalutUser();
        }
        return LitePal.find(UserBean.class, 1);
    }

    public void initDatabase() {
        mDatabase = LitePal.getDatabase();
    }

    public List<MessageBean> getMessageList() {
        return LitePal.where("username like ?", mUsername).find(MessageBean.class);
    }

    public List<AnswerBean> getAnswerList() {
        return LitePal.findAll(AnswerBean.class);
    }

    public List<MessageBean> getDefaultList() {
        List<MessageBean> list = new ArrayList<>();
        list.add(new MessageBean("f1", "hello", false));
        Log.d(TAG, "getDefaultList: " + list.size());
        return list;
    }

    public boolean isNeverTalk() {
        return getMessageList() == null;
    }

    public boolean isNullAnswer() {
        return getAnswerList().size()==0;
    }

    public String getTitle() {
        return mUsername;
    }

    public boolean loginBefore() {
        return LitePal.find(UserBean.class, 1) != null;
    }

    ;

    public void initDefalutUser() {

        UserBean userBean = new UserBean();
        userBean.setNickname("Utopia");
        userBean.setUsername("admin");
        userBean.setPassword("123456");
        userBean.setUsericon(R.drawable.icon_dog);
        userBean.setGender("male");
        userBean.setMotto("I like Minecraft");
        userBean.setZone("Hangzhou");
        userBean.save();
    }


    public void sendMessage(String message) {

        mMessageBean = new MessageBean(mUsername, message, true);
        mMessageBean.save();
    }

    public ConversationAdapter getAdapter() {
        mAdapter = new ConversationAdapter(getMessageList(), getUserInformation());
        return mAdapter;
    }

    public int getAdapterLastIndex() {
        return mAdapter.getItemCount() - 1;
    }

    public boolean isInvaildMessage(String message) {
        return message.equals("");
    }

    public void excuteMessage(String message) {
        mMessageBean = new MessageBean(mUsername, getAnswer(message), false);
        mMessageBean.save();
    }

    public String getAnswer(String message) {
        initAnswerDatabase();

        return queryAnswerFromDefault(message);
    }

    private void initAnswerDatabase() {
        if (isNullAnswer()) {
            new AnswerBean("hi", "hi").save();
            new AnswerBean("hello", "hello").save();
            new AnswerBean(".", "whats mean about your dot?").save();
        }
    }

    private String queryAnswerFromDefault(String messsage) {
        List<AnswerBean> list = LitePal.where("question like ?", messsage).find(AnswerBean.class);
        if (list.size() != 0) {
            return list.get(0).getAnswer1();
        }
        return "sorry, i don't understand what u mean";
    }

}

package club.zhangyuyang.kuakua.fwk_presenter;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;

import org.litepal.LitePal;

import java.util.ArrayList;
import java.util.List;

import club.zhangyuyang.kuakua.ConversationActivity;
import club.zhangyuyang.kuakua.R;
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
    private ConversationActivity mActivity;
    private SQLiteDatabase mDatabase;
    private Intent mIntent;
    private String mUsername;

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

    private UserBean getUserInformation() {
        if (!loginBefore()) {
            initDefalutUser();
        }
        return LitePal.find(UserBean.class, 1);
    }

    public void initDatabase() {
        mDatabase = LitePal.getDatabase();
    }

    public List<MessageBean> getMessageList() {
        return LitePal.where("username like ?", mUsername).order("id").find(MessageBean.class);
    }

    public List<MessageBean> getDefaultList() {
        return new ArrayList<MessageBean>();
    }

    public boolean isNeverTalk() {
        return getMessageList() == null;
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

        MessageBean messageBean = new MessageBean(mUsername,message,true);
        messageBean.save();
    }
}

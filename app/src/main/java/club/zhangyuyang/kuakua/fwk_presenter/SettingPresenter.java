package club.zhangyuyang.kuakua.fwk_presenter;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.support.v4.app.Fragment;
import android.util.Log;

import org.litepal.LitePal;

import club.zhangyuyang.kuakua.R;
import club.zhangyuyang.kuakua.fragment.SettingFragment;
import club.zhangyuyang.kuakua.fwk_model.UserBean;

/**
 * @Author :   yuyang
 * @Email :    octopusheep@gmail.com
 * @website :  www.zhangyuyang.club
 * @Date :     19-3-14 下午2:03
 * @FileName : SettingPresenter
 * Content   : TODO
 * Other     :
 */
public class SettingPresenter {
    private static final String TAG = "SettingPresenter";

    private SettingFragment mFragment;
    private Context mContext;
    private SQLiteDatabase mDatabase;

    public SettingPresenter(Fragment fragment) {
        mFragment = (SettingFragment) fragment;
        mContext = mFragment.getActivity();
    }

    public void initView() {
        mFragment.initView(getUserInformation());
    }

    public UserBean getUserInformation() {
        initDatabase();
        if (!loginBefore()) {
            initDefalutUser();
        }
        return LitePal.find(UserBean.class, 1);

    }

    public void initDatabase() {
        mDatabase = LitePal.getDatabase();
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

}

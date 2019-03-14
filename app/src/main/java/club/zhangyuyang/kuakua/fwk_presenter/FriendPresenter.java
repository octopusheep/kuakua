package club.zhangyuyang.kuakua.fwk_presenter;

import android.database.sqlite.SQLiteDatabase;

import org.litepal.LitePal;

import club.zhangyuyang.kuakua.R;
import club.zhangyuyang.kuakua.fragment.FriendFragment;
import club.zhangyuyang.kuakua.fwk_model.FriendBean;

/**
 * @Author :   yuyang
 * @Email :    octopusheep@gmail.com
 * @website :  www.zhangyuyang.club
 * @Date :     19-3-14 下午2:54
 * @FileName : FriendPresenter
 * Content   : TODO
 * Other     :
 */
public class FriendPresenter {
    private FriendFragment mFragment;
    private SQLiteDatabase mDatabase;

    public FriendPresenter(FriendFragment fragment) {
        mFragment = fragment;
    }

    public void initView() {

        initDatabase();

        if (!loginBefore()) {
            initDefalutFriend();
        }
        mFragment.initView(LitePal.findAll(FriendBean.class));
    }

    public void initDatabase() {
        mDatabase = LitePal.getDatabase();
    }

    public boolean loginBefore() {
        return LitePal.find(FriendBean.class, 1) != null;
    }

    public void initDefalutFriend() {

        new FriendBean("f1",R.drawable.icon_bear, "僵尸").save();
        new FriendBean("f2",R.drawable.icon_dog, "骷髅").save();
        new FriendBean("f3",R.drawable.icon_bear, "苦力怕").save();
        new FriendBean("f4",R.drawable.icon_dog, "蜘蛛").save();
        new FriendBean("f5",R.drawable.icon_bear, "卫道士").save();
        new FriendBean("f6",R.drawable.icon_dog, "烈焰人").save();
        new FriendBean("f7",R.drawable.icon_bear, "粘液怪").save();
        new FriendBean("f8",R.drawable.icon_dog, "末影龙").save();
        new FriendBean("f9",R.drawable.icon_bear, "恶魂").save();
        new FriendBean("f10",R.drawable.icon_dog, "僵尸村民").save();
        new FriendBean("f11",R.drawable.icon_bear, "溺尸").save();


    }
}

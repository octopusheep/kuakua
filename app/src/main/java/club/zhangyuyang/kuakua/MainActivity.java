package club.zhangyuyang.kuakua;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import club.zhangyuyang.kuakua.base.BaseActicity;
import club.zhangyuyang.kuakua.fragment.ChatFragment;
import club.zhangyuyang.kuakua.fragment.FriendFragment;
import club.zhangyuyang.kuakua.fragment.NaviFragment;
import club.zhangyuyang.kuakua.fragment.SettingFragment;
import club.zhangyuyang.kuakua.fwk_presenter.MainPresenter;
import club.zhangyuyang.kuakua.fwk_view.IMainView;
import club.zhangyuyang.kuakua.fwk_view.assets.BottomBarItem1;
import club.zhangyuyang.kuakua.fwk_view.assets.BottomBarItem2;
import club.zhangyuyang.kuakua.fwk_view.assets.BottomBarItem3;
import club.zhangyuyang.kuakua.fwk_view.assets.BottomBarItem4;
import club.zhangyuyang.kuakua.test.TestFragment;


public class MainActivity extends BaseActicity implements IMainView, View.OnClickListener {

    private MainPresenter mPresenter;

    private BottomBarItem1 mBottomBarItem1;
    private BottomBarItem2 mBottomBarItem2;
    private BottomBarItem3 mBottomBarItem3;
    private BottomBarItem4 mBottomBarItem4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mPresenter = new MainPresenter(this);
        mPresenter.initView();
        mPresenter.showFragment(new FriendFragment());


    }

    @Override
    public void initView() {

        mBottomBarItem1 = (BottomBarItem1) findViewById(R.id.item_bottom_bar_1);
        mBottomBarItem2 = (BottomBarItem2) findViewById(R.id.item_bottom_bar_2);
        mBottomBarItem3 = (BottomBarItem3) findViewById(R.id.item_bottom_bar_3);
        mBottomBarItem4 = (BottomBarItem4) findViewById(R.id.item_bottom_bar_4);

        mBottomBarItem1.setOnClickListener(this);
        mBottomBarItem2.setOnClickListener(this);
        mBottomBarItem3.setOnClickListener(this);
        mBottomBarItem4.setOnClickListener(this);

        mPresenter.showFragment(new TestFragment());
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.item_bottom_bar_1:
                mPresenter.showFragment(new ChatFragment());
                break;
            case R.id.item_bottom_bar_2:
                mPresenter.showFragment(new FriendFragment());
                break;
            case R.id.item_bottom_bar_3:
                mPresenter.showFragment(new NaviFragment());
                break;
            case R.id.item_bottom_bar_4:
                mPresenter.showFragment(new SettingFragment());
                break;
        }
    }
}

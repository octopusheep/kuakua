package club.zhangyuyang.kuakua.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.TextView;

import java.util.List;

import club.zhangyuyang.kuakua.R;
import club.zhangyuyang.kuakua.adapter.SettingAdapter;
import club.zhangyuyang.kuakua.fwk_model.FriendBean;
import club.zhangyuyang.kuakua.fwk_model.UserBean;
import club.zhangyuyang.kuakua.fwk_presenter.SettingPresenter;
import club.zhangyuyang.kuakua.fwk_view.ISettingView;

/**
 * @Author :   yuyang
 * @Email :    octopusheep@gmail.com
 * @website :  www.zhangyuyang.club
 * @Date :     19-3-14 上午10:34
 * @FileName : SettingFragment
 * Content   : TODO
 * Other     :
 */
public class SettingFragment extends Fragment implements ISettingView {

    private SettingPresenter mPresenter;

    private ImageView mImageView;
    private TextView mTextView;
    private Switch mSwitch;
    private RecyclerView mRecyclerView;
    private SettingAdapter mAdapter;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mPresenter = new SettingPresenter(this);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_setting, container, false);

        mImageView = view.findViewById(R.id.iv_usericon_fragment_setting);
        mTextView = view.findViewById(R.id.tv_username_fragment_setting);
        mSwitch = view.findViewById(R.id.sw_setting);

        mRecyclerView = view.findViewById(R.id.rv_friend_fragment_setting);

        mPresenter.initView();

        return view;
    }

    @Override
    public void initView(UserBean userBean, List<FriendBean> list) {
        mImageView.setImageResource(userBean.getUsericon());
        mTextView.setText(userBean.getNickname());
        mAdapter = new SettingAdapter(this.getActivity(), list);
        mRecyclerView.setAdapter(mAdapter);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this.getActivity()));

        mSwitch.setChecked(false);
        mSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    mRecyclerView.setVisibility(View.VISIBLE);
                } else {
                    mRecyclerView.setVisibility(View.INVISIBLE);
                }
            }
        });
    }


}

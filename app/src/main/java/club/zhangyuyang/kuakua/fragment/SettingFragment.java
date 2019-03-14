package club.zhangyuyang.kuakua.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import club.zhangyuyang.kuakua.R;
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

        mPresenter.initView();
        return view;
    }

    @Override
    public void initView(UserBean userBean) {
        mImageView.setImageResource(userBean.getUsericon());
        mTextView.setText(userBean.getNickname());
    }
}

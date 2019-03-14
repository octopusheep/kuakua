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

import java.util.List;

import club.zhangyuyang.kuakua.R;
import club.zhangyuyang.kuakua.adapter.FriendAdapter;
import club.zhangyuyang.kuakua.fwk_model.FriendBean;
import club.zhangyuyang.kuakua.fwk_presenter.FriendPresenter;
import club.zhangyuyang.kuakua.fwk_view.IFriendView;

/**
 * @Author :   yuyang
 * @Email :    octopusheep@gmail.com
 * @website :  www.zhangyuyang.club
 * @Date :     19-3-14 上午10:34
 * @FileName : FriendFragment
 * Content   : TODO
 * Other     :
 */
public class FriendFragment extends Fragment implements IFriendView {

    private FriendPresenter mPresenter;
    private FriendAdapter mAdapter;

    private RecyclerView mRecyclerView;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mPresenter=new FriendPresenter(this);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_friend, container, false);

        mRecyclerView = view.findViewById(R.id.rv_friend);
        mPresenter.initView();

        return view;
    }

    @Override
    public void initView(List<FriendBean> list) {
        mAdapter = new FriendAdapter(this.getActivity(),list);
        mRecyclerView.setAdapter(mAdapter);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this.getActivity()));
    }
}

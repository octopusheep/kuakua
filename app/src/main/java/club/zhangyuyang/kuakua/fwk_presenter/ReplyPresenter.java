package club.zhangyuyang.kuakua.fwk_presenter;

import android.content.Intent;
import android.util.Log;

import java.util.List;

import club.zhangyuyang.kuakua.ReplyActivity;
import club.zhangyuyang.kuakua.adapter.ReplyAdapter;
import club.zhangyuyang.kuakua.fwk_model.AnswerBean;
import club.zhangyuyang.kuakua.fwk_model.DataModel;

/**
 * @Author :   yuyang
 * @Email :    octopusheep@gmail.com
 * @website :  www.zhangyuyang.club
 * @Date :     19-3-18 下午4:59
 * @FileName : ReplyPresenter
 * Content   : TODO
 * Other     :
 */
public class ReplyPresenter {
    private static final String TAG = "ReplyPresenter";
    private ReplyActivity mActivity;
    private Intent mIntent;
    private String mString;

    public ReplyPresenter(ReplyActivity activity) {
        mActivity = activity;
        mIntent = mActivity.getIntent();
        mString = mIntent.getStringExtra(ReplyActivity.EXTRA_USERNAME_REPLY);
    }

    public void initView() {

        Log.d(TAG, "username: " + mString);
        Log.d(TAG, "list size: " + DataModel.queryAllAnswerListByUsername(mString).size());

        if (mString.equals("default")) {
            mActivity.initView(
                    mString,
                    DataModel.queryAllAnswerListByUsername(mString)
            );
        } else {
            mActivity.initView(
                    DataModel.queryNicknameByUsername(mString),
                    DataModel.queryAllAnswerListByUsername(mString),
                    DataModel.queryFriendByUsername(mString)
            );
        }
    }

    public ReplyAdapter getAdapter() {
        if (mString.equals("default")) {
            return new ReplyAdapter(
                    mActivity,
                    DataModel.queryAllAnswerListByUsername(mString),
                    mString);
        } else {
            return new ReplyAdapter(
                    mActivity,
                    DataModel.queryAllAnswerListByUsername(mString),
                    DataModel.queryFriendByUsername(mString));
        }

    }

    public void addAnswerbyUsername() {
        DataModel.addAnswerByUsername(mString);
    }
}

package club.zhangyuyang.kuakua.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;

import java.util.List;

import club.zhangyuyang.kuakua.R;
import club.zhangyuyang.kuakua.ReplyActivity;
import club.zhangyuyang.kuakua.fwk_model.AnswerBean;
import club.zhangyuyang.kuakua.fwk_model.DataModel;
import club.zhangyuyang.kuakua.fwk_model.FriendBean;

/**
 * @Author :   yuyang
 * @Email :    octopusheep@gmail.com
 * @website :  www.zhangyuyang.club
 * @Date :     19-3-18 下午5:11
 * @FileName : ReplyAdapter
 * Content   : TODO
 * Other     :
 */
public class ReplyAdapter extends RecyclerView.Adapter<ReplyAdapter.VH> {

    private ReplyActivity mContext;
    private List<AnswerBean> mList;
    private FriendBean mFriendBean;
    private String mString="";

    public ReplyAdapter(Context context, List<AnswerBean> list, FriendBean friendBean) {
        mContext = (ReplyActivity) context;
        mList = list;
        mFriendBean = friendBean;
    }

    public ReplyAdapter(Context context, List<AnswerBean> list, String friendName) {
        mContext = (ReplyActivity) context;
        mList = list;
        mString = friendName;
    }

    @NonNull
    @Override
    public VH onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_reply, viewGroup, false);
        return new VH(view);
    }

    @Override
    public void onBindViewHolder(@NonNull VH vh, int i) {

        final AnswerBean answerBean = mList.get(i);
        final VH vh1 = vh;
        final int index = i;
        vh1.mQuestion.setText(answerBean.getQuestion());
        vh1.mAnswer.setText(answerBean.getAnswer1());

        if (mString.equals("default")) {

            vh1.mDelete.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    DataModel.deleteAnswerByUsernameAndQuestion(
                            mString,
                            answerBean.getQuestion(),
                            answerBean.getAnswer1());
                    mContext.refreshView();
                }
            });
            vh1.mUpdate.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    DataModel.updateAnswerByUsernameAndQuestion(
                            mString,
                            answerBean.getQuestion(),
                            answerBean.getAnswer1(),
                            vh1.mQuestion.getText().toString(),
                            vh1.mAnswer.getText().toString()
                    );
                    mContext.refreshView();
                    mContext.scrollToCurrentIndex(index);
                }
            });
        } else {

            vh1.mDelete.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    DataModel.deleteAnswerByUsernameAndQuestion(
                            mFriendBean.getUsername(),
                            answerBean.getQuestion(),
                            answerBean.getAnswer1());
                    mContext.refreshView();
                }
            });
            vh1.mUpdate.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    DataModel.updateAnswerByUsernameAndQuestion(
                            mFriendBean.getUsername(),
                            answerBean.getQuestion(),
                            answerBean.getAnswer1(),
                            vh1.mQuestion.getText().toString(),
                            vh1.mAnswer.getText().toString()
                    );
                    mContext.refreshView();
                    mContext.scrollToCurrentIndex(index);
                }
            });
        }
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    public class VH extends RecyclerView.ViewHolder {
        private EditText mQuestion;
        private EditText mAnswer;
        private ImageView mUpdate;
        private ImageView mDelete;

        public VH(@NonNull View itemView) {
            super(itemView);

            mQuestion = itemView.findViewById(R.id.et_question);
            mAnswer = itemView.findViewById(R.id.et_answer);
            mUpdate = itemView.findViewById(R.id.iv_answer_update);
            mDelete = itemView.findViewById(R.id.iv_answer_delete);
        }
    }
}

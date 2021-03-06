package club.zhangyuyang.kuakua.fwk_model;

import org.litepal.LitePal;

import java.util.ArrayList;
import java.util.List;

import club.zhangyuyang.kuakua.R;

/**
 * @Author :   yuyang
 * @Email :    octopusheep@gmail.com
 * @website :  www.zhangyuyang.club
 * @Date :     19-3-15 下午2:17
 * @FileName : DataModel
 * Content   : TODO
 * Other     :
 */
public class DataModel {
    private static final String TAG = "DataModel";
    public static final String DEFAULT_ANSWER = "sorry, I do not understand your mean.";
    public static List<AnswerBean> sAnswerBeanList = new ArrayList<>();
    public static List<FriendBean> sFriendBeanList = new ArrayList<>();
    public static UserBean sUserBean = new UserBean(R.drawable.icon_dog, "admin", "123456", "秃秃", "male", "I like Minecraft", "Hangzhou");

    static {


        sAnswerBeanList.add(new AnswerBean("hi", "hello"));

        sFriendBeanList.add(new FriendBean("f1", R.drawable.icon_a, "每皮儿"));
        sFriendBeanList.add(new FriendBean("f2", R.drawable.icon_b, "慈善赌王"));
        sFriendBeanList.add(new FriendBean("f3", R.drawable.icon_c, "二媛"));
        sFriendBeanList.add(new FriendBean("f4", R.drawable.icon_d, "拉拉"));
        sFriendBeanList.add(new FriendBean("f5", R.drawable.icon_e, "老法师"));
        sFriendBeanList.add(new FriendBean("f6", R.drawable.icon_f, "德德"));
        sFriendBeanList.add(new FriendBean("f7", R.drawable.icon_g, "柯柯"));
        sFriendBeanList.add(new FriendBean("f8", R.drawable.icon_h, "男男"));
        sFriendBeanList.add(new FriendBean("f9", R.drawable.icon_i, "冯巩"));

    }

    public static void initDB() {
        initDatabase();
        initAnswerDatabase();
        initFriendDatabase();
    }

    public static String queryAnswer(String username, String question) {

        if (isFindAnswer(username, question)) {
            return queryAnswerList(username, question).get(0).getAnswer1();
        } else if (isFindAnswer(question)) {
            return queryAnswerList(question).get(0).getAnswer1();
        } else {
            return DEFAULT_ANSWER;
        }

    }

    public static List<AnswerBean> queryAnswerList(String username, String question) {
        return LitePal.where("username = ? and question = ?", username, question).find(AnswerBean.class);
    }

    public static List<AnswerBean> queryAnswerList(String question) {
        return LitePal.where("username = ? and question = ?", "default", question).find(AnswerBean.class);
    }

    public static boolean isFindAnswer(String username, String question) {
        return queryAnswerList(username, question).size() != 0;
    }

    public static boolean isFindAnswer(String question) {
        return queryAnswerList(question).size() != 0;
    }

    public static List<AnswerBean> queryAllAnswerList() {
        return LitePal.findAll(AnswerBean.class);
    }

    public static List<FriendBean> queryAllFriendList() {
        return LitePal.findAll(FriendBean.class);
    }

    public static boolean isInitAnswer() {
        return queryAllAnswerList().size() != 0;
    }

    public static boolean isInitFriend() {
        return queryAllFriendList().size() != 0;
    }

    public static void initAnswerDatabase() {
        if (!isInitAnswer()) {
            for (AnswerBean answerBean : sAnswerBeanList) {
                answerBean.save();
            }
        }
    }

    public static void initDatabase() {
        LitePal.getDatabase();
    }

    public static List<MessageBean> queryMessageList(String username) {
        return LitePal.where("username like ?", username).find(MessageBean.class);
    }

    public static boolean isInitUser() {
        return LitePal.find(UserBean.class, 1) != null;
    }

    public static UserBean queryUserInformation() {
        if (!isInitUser()) {
            sUserBean.save();
        }
        return LitePal.find(UserBean.class, 1);
    }

    public static String queryNicknameByUsername(String guestUsername) {
        return LitePal.where("username like ?", guestUsername).find(FriendBean.class).get(0).getNickname();
    }

    public static void initFriendDatabase() {
        if (!isInitFriend()) {
            for (FriendBean friendBean : sFriendBeanList) {
                friendBean.save();
            }
        }
    }

    public static List<FriendBean> queryChatFriendList() {
        return LitePal.where("status1 like ?", "true").find(FriendBean.class);
    }

    public static String queryLastMessageByUsername(String username) {
        int lastIndex = queryMessageList(username).size();
        return queryMessageList(username).get(lastIndex - 1).getMessage();
    }

    public static List<AnswerBean> queryAllAnswerListByUsername(String username) {
        return LitePal.where("username like ?", username).find(AnswerBean.class);
    }

    public static void deleteAnswerByUsernameAndQuestion(String username, String question, String answer) {
        LitePal.deleteAll(AnswerBean.class, "username = ? and question = ? and answer1 = ?", username, question, answer);
    }

    public static FriendBean queryFriendByUsername(String username) {
        return LitePal.where("username = ?", username).find(FriendBean.class).get(0);
    }

    public static void updateAnswerByUsernameAndQuestion(String username, String oldQuestion, String oldAnswer, String newQuestion, String newAnswer) {
        AnswerBean answerBean = new AnswerBean();
        answerBean.setQuestion(newQuestion);
        answerBean.setAnswer1(newAnswer);
        answerBean.updateAll("username = ? and question = ? and answer1 = ?", username, oldQuestion, oldAnswer);
    }

    public static void addAnswerByUsername(String username) {
        AnswerBean answerBean = new AnswerBean();
        answerBean.setUsername(username);
        answerBean.setQuestion("");
        answerBean.setAnswer1("");
        answerBean.save();
    }
}



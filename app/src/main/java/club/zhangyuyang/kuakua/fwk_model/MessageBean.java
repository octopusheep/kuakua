package club.zhangyuyang.kuakua.fwk_model;

import org.litepal.crud.LitePalSupport;

/**
 * @Author :   yuyang
 * @Email :    octopusheep@gmail.com
 * @website :  www.zhangyuyang.club
 * @Date :     19-3-14 下午6:58
 * @FileName : MessageBean
 * Content   : TODO
 * Other     :
 */
public class MessageBean extends LitePalSupport {

    private String username;
    private String message;
    private boolean sendBySelf;

    private boolean status1;
    private boolean status2;
    private boolean status3;
    private boolean status4;
    private boolean status5;
    private boolean status6;
    private boolean status7;
    private boolean status8;
    private boolean status9;

    public MessageBean(String username, String message, boolean sendBySelf) {
        this.username = username;
        this.message = message;
        this.sendBySelf = sendBySelf;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public boolean isSendBySelf() {
        return sendBySelf;
    }

    public void setSendBySelf(boolean sendBySelf) {
        this.sendBySelf = sendBySelf;
    }

    public boolean isStatus1() {
        return status1;
    }

    public void setStatus1(boolean status1) {
        this.status1 = status1;
    }

    public boolean isStatus2() {
        return status2;
    }

    public void setStatus2(boolean status2) {
        this.status2 = status2;
    }

    public boolean isStatus3() {
        return status3;
    }

    public void setStatus3(boolean status3) {
        this.status3 = status3;
    }

    public boolean isStatus4() {
        return status4;
    }

    public void setStatus4(boolean status4) {
        this.status4 = status4;
    }

    public boolean isStatus5() {
        return status5;
    }

    public void setStatus5(boolean status5) {
        this.status5 = status5;
    }

    public boolean isStatus6() {
        return status6;
    }

    public void setStatus6(boolean status6) {
        this.status6 = status6;
    }

    public boolean isStatus7() {
        return status7;
    }

    public void setStatus7(boolean status7) {
        this.status7 = status7;
    }

    public boolean isStatus8() {
        return status8;
    }

    public void setStatus8(boolean status8) {
        this.status8 = status8;
    }

    public boolean isStatus9() {
        return status9;
    }

    public void setStatus9(boolean status9) {
        this.status9 = status9;
    }
}

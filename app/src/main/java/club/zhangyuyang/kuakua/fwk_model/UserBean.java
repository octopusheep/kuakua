package club.zhangyuyang.kuakua.fwk_model;

import org.litepal.annotation.Column;
import org.litepal.crud.LitePalSupport;

/**
 * @Author :   yuyang
 * @Email :    octopusheep@gmail.com
 * @website :  www.zhangyuyang.club
 * @Date :     19-3-14 下午12:15
 * @FileName : UserBean
 * Content   : TODO
 * Other     :
 */
public class UserBean extends LitePalSupport{

    private int usericon;

    private String username;
    private String password;
    private String nickname;
    private String email;
    private String gender;
    private String motto;
    private String zone;

    private boolean status1;
    private boolean status2;
    private boolean status3;
    private boolean status4;
    private boolean status5;
    private boolean status6;
    private boolean status7;
    private boolean status8;
    private boolean status9;

    public int getUsericon() {
        return usericon;
    }

    public void setUsericon(int usericon) {
        this.usericon = usericon;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getMotto() {
        return motto;
    }

    public void setMotto(String motto) {
        this.motto = motto;
    }

    public String getZone() {
        return zone;
    }

    public void setZone(String zone) {
        this.zone = zone;
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

package com.bw.duanhaitao.contract;
/*
 *@auther:段海涛
 *@Date: 2020-03-30
 *@Time:14:28
 *@Description:${DESCRIPTION}
 **/

import com.bw.duanhaitao.bean.UserBean;

public interface UserContract {
    interface View extends IBaseView{
        void registerSuccess(UserBean userBean);
        void registerFilter(String msg);

        void loginSuccess(UserBean userBean);
        void loginFilter(String msg);
    }
    interface Model{
        void register(String phone,String pwd,RegisterCallBack callBack);
        interface RegisterCallBack{
            void registerSuccess(UserBean userBean);
            void registerFilter(String msg);
        }
        void login(String phone, String pwd, LoginCallBack callBack);
        interface LoginCallBack{
            void loginSuccess(UserBean userBean);
            void loginFilter(String msg);
        }
    }
    interface Presenter{
        void register(String phone,String pwd);
        void login(String phone,String pwd);
    }
}

package com.bw.duanhaitao.presenter;
/*
 *@auther:段海涛
 *@Date: 2020-03-30
 *@Time:14:32
 *@Description:${DESCRIPTION}
 **/

import com.bw.duanhaitao.base.BasePresenter;
import com.bw.duanhaitao.bean.UserBean;
import com.bw.duanhaitao.contract.UserContract;
import com.bw.duanhaitao.model.UserModelImpl;

public class UserPresenterImpl extends BasePresenter<UserContract.View>implements UserContract.Presenter{

    private UserModelImpl model;

    @Override
    protected void initModel() {
        model = new UserModelImpl();
    }

    @Override
    public void register(String phone, String pwd) {
        model.register(phone, pwd, new UserContract.Model.RegisterCallBack() {
            @Override
            public void registerSuccess(UserBean userBean) {
                getView().registerSuccess(userBean);
            }

            @Override
            public void registerFilter(String msg) {
                getView().registerFilter(msg);
            }
        });
    }

    @Override
    public void login(String phone, String pwd) {
        model.login(phone, pwd, new UserContract.Model.LoginCallBack() {
            @Override
            public void loginSuccess(UserBean userBean) {
                getView().loginSuccess(userBean);
            }

            @Override
            public void loginFilter(String msg) {
                getView().loginFilter(msg);
            }
        });
    }
}

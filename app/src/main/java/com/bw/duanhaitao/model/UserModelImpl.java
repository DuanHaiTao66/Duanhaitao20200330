package com.bw.duanhaitao.model;
/*
 *@auther:段海涛
 *@Date: 2020-03-30
 *@Time:14:32
 *@Description:${DESCRIPTION}
 **/

import com.bw.duanhaitao.api.ApiService;
import com.bw.duanhaitao.bean.UserBean;
import com.bw.duanhaitao.contract.UserContract;
import com.bw.duanhaitao.util.RetrofitUtil;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;

public class UserModelImpl implements UserContract.Model {
    @Override
    public void register(String phone, String pwd, final RegisterCallBack callBack) {
        Retrofit retrofit = RetrofitUtil.getInstance().getRetrofit();
        ApiService apiService = retrofit.create(ApiService.class);
        Observable<UserBean> observable = apiService.getRegister(phone, pwd);
        observable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<UserBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(UserBean userBean) {
                        callBack.registerSuccess(userBean);
                    }

                    @Override
                    public void onError(Throwable e) {
                        callBack.registerFilter(e.getMessage());
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    @Override
    public void login(String phone, String pwd, final LoginCallBack callBack) {
        Retrofit retrofit = RetrofitUtil.getInstance().getRetrofit();
        ApiService apiService = retrofit.create(ApiService.class);
        Observable<UserBean> observable = apiService.getLogin(phone, pwd);
        observable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<UserBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(UserBean userBean) {
                        callBack.loginSuccess(userBean);
                    }

                    @Override
                    public void onError(Throwable e) {
                        callBack.loginFilter(e.getMessage());
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
}

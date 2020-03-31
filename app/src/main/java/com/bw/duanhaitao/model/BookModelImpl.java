package com.bw.duanhaitao.model;
/*
 *@auther:段海涛
 *@Date: 2020-03-30
 *@Time:15:25
 *@Description:${DESCRIPTION}
 **/

import com.bw.duanhaitao.App;
import com.bw.duanhaitao.CacheEntity;
import com.bw.duanhaitao.api.Api;
import com.bw.duanhaitao.api.ApiService;
import com.bw.duanhaitao.bean.BookBean;
import com.bw.duanhaitao.contract.BookContract;
import com.bw.duanhaitao.dao.CacheEntityDao;
import com.bw.duanhaitao.util.RetrofitUtil;
import com.google.gson.Gson;

import java.util.concurrent.Callable;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;

public class BookModelImpl implements BookContract.Model {
    @Override
    public void show(DataCallBack callBack) {
        Retrofit retrofit = RetrofitUtil.getInstance().getRetrofit();
        ApiService apiService = retrofit.create(ApiService.class);
        Observable<BookBean> observable = apiService.getBook();
        observable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<BookBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(BookBean bookBean) {
                        callBack.success(bookBean);
                        if (bookBean!=null){
                            Gson gson = new Gson();
                            String s = gson.toJson(bookBean);
                            CacheEntity cacheEntity = new CacheEntity("http://blog.zhaoliang5156.cn/api/book/book.json",s);
                            CacheEntityDao cacheEntityDao = App.daoSession.getCacheEntityDao();
                            cacheEntityDao.insertOrReplace(cacheEntity);
                        }

                    }

                    @Override
                    public void onError(Throwable e) {
                        callBack.filter(e.getMessage());
                        CacheEntityDao cacheEntityDao = App.daoSession.getCacheEntityDao();
                        CacheEntity cacheEntity = cacheEntityDao.load("http://blog.zhaoliang5156.cn/api/book/book.json");
                        Gson gson = new Gson();
                        BookBean bookBean = gson.fromJson(cacheEntity.getJson(), BookBean.class);
                        callBack.success(bookBean);
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
}

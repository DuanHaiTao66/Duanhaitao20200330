package com.bw.duanhaitao.presenter;
/*
 *@auther:段海涛
 *@Date: 2020-03-30
 *@Time:15:26
 *@Description:${DESCRIPTION}
 **/

import com.bw.duanhaitao.base.BasePresenter;
import com.bw.duanhaitao.contract.BookContract;
import com.bw.duanhaitao.model.BookModelImpl;

public class BookPresenterImpl extends BasePresenter<BookContract.View>implements BookContract.Presenter {

    private BookModelImpl model;

    @Override
    protected void initModel() {
        model = new BookModelImpl();
    }

    @Override
    public void show() {
        model.show(new BookContract.Model.DataCallBack() {
            @Override
            public void success(Object obj) {
                getView().success(obj);
            }

            @Override
            public void filter(String msg) {
                getView().filter(msg);
            }
        });
    }
}

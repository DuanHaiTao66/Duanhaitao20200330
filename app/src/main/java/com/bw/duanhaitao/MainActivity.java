package com.bw.duanhaitao;

import android.annotation.SuppressLint;

import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bw.duanhaitao.adapter.BookAdapter;
import com.bw.duanhaitao.base.BaseActivity;
import com.bw.duanhaitao.bean.BookBean;
import com.bw.duanhaitao.contract.BookContract;
import com.bw.duanhaitao.presenter.BookPresenterImpl;

import java.util.List;

public class MainActivity extends BaseActivity<BookPresenterImpl>implements BookContract.View {


    private RecyclerView rv;

    @Override
    protected BookPresenterImpl initPresenter() {
        return new BookPresenterImpl();
    }

    @Override
    protected void initData() {
        presenter.show();
    }

    @SuppressLint("WrongConstant")
    @Override
    protected void initView() {
        rv = findViewById(R.id.rv);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this,2);
        gridLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        rv.setLayoutManager(gridLayoutManager);
    }

    @Override
    protected int initLayout() {
        return R.layout.activity_main;
    }

    @Override
    public void success(Object obj) {
        if (obj instanceof BookBean){
            BookBean bookBean = (BookBean) obj;
            List<BookBean.DataBean.ContentBean> content = bookBean.getData().getContent();
            BookAdapter adapter = new BookAdapter(content,MainActivity.this);
            rv.setAdapter(adapter);
        }

    }

    @Override
    public void filter(String msg) {

    }
}

package com.bw.duanhaitao.contract;
/*
 *@auther:段海涛
 *@Date: 2020-03-30
 *@Time:15:23
 *@Description:${DESCRIPTION}
 **/

public interface BookContract {
    interface View extends IBaseView{
        void success(Object obj);
        void filter(String msg);
    }
    interface Model{
        void show(DataCallBack callBack);
        interface DataCallBack{
            void success(Object obj);
            void filter(String msg);
        }
    }
    interface Presenter{
        void show();
    }
}

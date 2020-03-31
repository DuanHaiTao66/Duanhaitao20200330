package com.bw.duanhaitao.api;
/*
 *@auther:段海涛
 *@Date: 2020-03-30
 *@Time:14:17
 *@Description:${DESCRIPTION}
 **/

import com.bw.duanhaitao.bean.BookBean;
import com.bw.duanhaitao.bean.UserBean;

import io.reactivex.Observable;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Url;

public interface ApiService {
    @FormUrlEncoded
    @POST(Api.REGISTERURL)
    Observable<UserBean>getRegister(@Field("phone")String phone,@Field("pwd")String pwd);
    
    @FormUrlEncoded
    @POST(Api.LOGINURL)
    Observable<UserBean>getLogin(@Field("phone")String phone,@Field("pwd")String pwd);

    @GET(Api.BOOKURL)
    Observable<BookBean>getBook();
}

package com.bw.duanhaitao;
/*
 *@auther:段海涛
 *@Date: 2020-03-30
 *@Time:15:04
 *@Description:${DESCRIPTION}
 **/

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Environment;

import com.bw.duanhaitao.dao.DaoMaster;
import com.bw.duanhaitao.dao.DaoSession;
import com.facebook.cache.disk.DiskCacheConfig;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.imagepipeline.core.ImagePipelineConfig;

public class App extends Application {
    public static Context context;
    public SharedPreferences sp;
    public static DaoSession daoSession;

    @Override
    public void onCreate() {
        super.onCreate();
        context = this;
        sp = context.getSharedPreferences("config", MODE_PRIVATE);
        initFresco();
        initGreenDao();
    }

    private void initGreenDao() {
        daoSession = DaoMaster.newDevSession(context,"canche");
    }

    private void initFresco() {
        DiskCacheConfig cacheConfig = DiskCacheConfig.newBuilder(context)
                .setMaxCacheSize(1024*1024*10)
                .setBaseDirectoryPath(Environment.getExternalStorageDirectory())
                .setBaseDirectoryName("cacheConfig")
                .build();
        ImagePipelineConfig config = ImagePipelineConfig.newBuilder(context)
                .setMainDiskCacheConfig(cacheConfig)
                .build();
        Fresco.initialize(context,config);
    }
}

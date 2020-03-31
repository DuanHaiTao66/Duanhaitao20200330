package com.bw.duanhaitao;

import android.app.ProgressDialog;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.bw.duanhaitao.base.BaseActivity;
import com.bw.duanhaitao.bean.UserBean;
import com.bw.duanhaitao.contract.UserContract;
import com.bw.duanhaitao.presenter.UserPresenterImpl;

public class UserActivity extends BaseActivity<UserPresenterImpl>implements UserContract.View {


    public ProgressDialog progressDialog;
    private EditText editPhone;
    private EditText editPwd;
    private Button btn_register;
    private Button btn_login;

    @Override
    protected UserPresenterImpl initPresenter() {
        return new UserPresenterImpl();
    }

    @Override
    protected void initData() {

    }

    @Override
    protected void initView() {
        editPhone = findViewById(R.id.edit_phone);
        editPwd = findViewById(R.id.edit_pwd);
        btn_register = findViewById(R.id.btn_register);
        btn_login = findViewById(R.id.btn_login);
        btn_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String phone = editPhone.getText().toString().trim();
                String pwd = editPwd.getText().toString().trim();
                if (phone!=null&&pwd!=null){
                    presenter.register(phone,pwd);
                }else{
                    Toast.makeText(UserActivity.this, "输入手机号和密码", Toast.LENGTH_SHORT).show();
                }
            }
        });
        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String phone = editPhone.getText().toString().trim();
                String pwd = editPwd.getText().toString().trim();
                if (phone!=null&&pwd!=null){
                    presenter.login(phone,pwd);
                }else{
                    Toast.makeText(UserActivity.this, "输入手机和密码", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    @Override
    protected int initLayout() {
        return R.layout.activity_user;
    }

    @Override
    public void registerSuccess(UserBean userBean) {
        if (userBean!=null){
            Toast.makeText(this, ""+userBean.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void registerFilter(String msg) {

    }

    @Override
    public void loginSuccess(UserBean userBean) {
        if (userBean!=null&&userBean.getStatus().equals("0000")){
            SharedPreferences config = App.context.getSharedPreferences("config", MODE_PRIVATE);
            config.edit().putInt("userId",userBean.getResult().getUserId());
            config.edit().putString("sessionId",userBean.getResult().getSessionId());
            config.edit().commit();
            progressDialog=ProgressDialog.show(UserActivity.this, "请等待...", "请稍后...",true);
            progressDialog.dismiss();
            startActivity(new Intent(UserActivity.this,MainActivity.class));
            Toast.makeText(this, ""+userBean.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void loginFilter(String msg) {

    }
}

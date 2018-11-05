package hbs.vn.ui.login;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import hbs.vn.R;
import hbs.vn.databinding.ActivityLoginBinding;
import hbs.vn.ui.main.MainActivity;

public class LoginActivity extends AppCompatActivity implements LoginNavigator {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityLoginBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_login);
        UserModelView vm = new UserModelView(this);
        binding.setVm(vm);
    }

    @Override
    public void gotoMain() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        finish();
    }
}

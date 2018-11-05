package hbs.vn.source.user;

import android.text.TextUtils;

import hbs.vn.model.User;

public class UsersRepository {

    public boolean login(User user) {
        if (!TextUtils.isEmpty(user.username)
                || !TextUtils.isEmpty(user.password)) {
            return true;
        }
        return false;
    }
}
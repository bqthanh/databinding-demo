package hbs.vn.ui.login;

import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.databinding.Observable;
import android.databinding.ObservableBoolean;
import android.databinding.ObservableField;
import android.text.TextUtils;

import java.util.Locale;

import hbs.vn.BR;
import hbs.vn.model.User;
import hbs.vn.source.user.UsersRepository;
import hbs.vn.util.AppLog;

public class UserModelView extends BaseObservable {
    public static final String TAG = UserModelView.class.getSimpleName();

    private UsersRepository mUserRepository;
    private LoginNavigator mNavigator;

    public final ObservableField<String> username = new ObservableField<>();
    public final ObservableField<String> password = new ObservableField<>();
    public final ObservableBoolean checkbox = new ObservableBoolean();

    public UserModelView(LoginNavigator navigator) {
        this.mNavigator = navigator;
        this.mUserRepository = new UsersRepository();

        Observable.OnPropertyChangedCallback callback = new Observable.OnPropertyChangedCallback() {
            @Override
            public void onPropertyChanged(Observable sender, int propertyId) {
                notifyPropertyChanged(BR.loginEnabled);
            }
        };
        username.addOnPropertyChangedCallback(callback);
        password.addOnPropertyChangedCallback(callback);
        checkbox.addOnPropertyChangedCallback(callback);
    }

    @Bindable
    public boolean getLoginEnabled() {
        if (checkbox.get()
                && !TextUtils.isEmpty(username.get())
                && !TextUtils.isEmpty(password.get())) {
            return true;
        }
        return false;
    }

    public void onLoginButtonClicked() {
        boolean login = mUserRepository.login(new User(username.get(), password.get()));
        if (login) {
            if (mNavigator != null) {
                mNavigator.gotoMain();
            }
        }
    }
}

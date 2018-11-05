package hbs.vn.ui.base;

import android.net.Uri;
import android.support.v4.app.Fragment;

/**
 * Created by thanhbui on 2018/05/18.
 */

public interface FragmentEventListener {
    void onPageChanged(Uri uri, Fragment fragment);
}
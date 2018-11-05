package hbs.vn.ui.base.binding;

import android.databinding.BindingAdapter;
import android.text.TextUtils;
import android.widget.ImageView;

/**
 * Created by thanhbui on 2018/10/21.
 */

public class ImageViewDataBinding {

    @BindingAdapter(value={"image", "bind:type"}, requireAll=false)
    public static void loadImage(final ImageView view, String url, String type) {
        if (TextUtils.isEmpty(url)) {
            //TODO: Load image from internet
        }
    }
}
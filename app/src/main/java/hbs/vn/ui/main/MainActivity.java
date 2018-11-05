package hbs.vn.ui.main;

import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;

import hbs.vn.R;
import hbs.vn.ui.base.FragmentEventListener;
import hbs.vn.ui.main.home.detail.ProductDetailFragment;
import hbs.vn.ui.main.home.ProductListFragment;
import hbs.vn.util.ActivityUtils;
import hbs.vn.util.AppLog;

public class MainActivity extends AppCompatActivity implements FragmentEventListener {
    public static final String TAG = MainActivity.class.getSimpleName();

    public static final String PRODUCT_DETAIL = "product_detail";
    public static final String PRODUCT_LIST = "product_list";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ActivityUtils.addFragmentToActivity(getSupportFragmentManager(),
                ProductListFragment.newInstance(),
                R.id.main_content);
    }

    @Override
    public void onPageChanged(Uri uri, Fragment fragment) {
        Fragment nextFragment = null;
        AppLog.d(TAG, "On page changed: " + uri.getAuthority());

        switch (uri.getAuthority()) {
            case PRODUCT_DETAIL:
                int productId = Integer.parseInt(uri.getQueryParameter(ProductDetailFragment.ARG_PRODUCT_ID));
                nextFragment = ProductDetailFragment.newInstance(productId);
                break;
            case PRODUCT_LIST:
                nextFragment = ProductListFragment.newInstance();
                break;
            default:
                AppLog.d(TAG, "Page not found!");
                break;
        }
        if (nextFragment != null) {
            ActivityUtils.replaceFragmentToActivity(getSupportFragmentManager(), nextFragment, R.id.main_content, null);
        }
    }
}
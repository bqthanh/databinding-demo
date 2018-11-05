/*
 * Copyright 2016, The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package hbs.vn.ui.base.binding;

import android.databinding.BindingAdapter;
import android.support.v7.widget.RecyclerView;

import java.util.List;

import hbs.vn.model.Product;
import hbs.vn.ui.adapter.ProductListViewAdapter;

/**
 * Created by thanhbui on 2018/05/22.
 */

public class RecycleViewDataBindings {

    @BindingAdapter("app:items")
    public static void setItems(RecyclerView recyclerView, List<Product> items) {
        RecyclerView.Adapter adapter = recyclerView.getAdapter();
        if (adapter instanceof ProductListViewAdapter) {
            ((ProductListViewAdapter) adapter).setProducts(items);
        }
    }
}
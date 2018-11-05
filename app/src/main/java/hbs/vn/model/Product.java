package hbs.vn.model;

import android.databinding.BaseObservable;

import java.io.Serializable;
import java.util.Locale;
import java.util.Objects;

/**
 * Created by thanhbui on 2018/10/20.
 */

public class Product extends BaseObservable implements Serializable {

    public int id;

    public String title;

    public String description;

    public String thumbnail;

    public boolean liked;

    public Product(int id, String title, String description, String thumbnail, Boolean liked) {
        this.id = id;
        this.title = title;
        this.thumbnail = thumbnail;
        this.description = description;
        this.liked = liked;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if(o == null
                || getClass() != o.getClass()) return false;
        if (o instanceof Product) {
            Product other = (Product) o;
            return id == other.id;
         }
         return false;
    }

    @Override
    public String toString() {
        return String.format(Locale.US,
                "Product: { id: %d, title: %s, description: %s, thumbnail: %s, liked: %s }",
                safeToString(id),
                safeToString(title),
                safeToString(description),
                safeToString(thumbnail),
                safeToString(liked));
    }

    private String safeToString(Object o) {
        if (o == null) {
            return "null";
        } else {
            return o.toString();
        }
    }
}
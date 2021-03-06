package org.clientefiel;

import android.graphics.drawable.Drawable;

/**
 * Created by carlos.morales on 22/10/2016.
 */
public class ItemEmpresa {

    private String title;
    private String categoryId;
    private String description;
    private Drawable imagen;

    public ItemEmpresa() {
        super();
    }

    public ItemEmpresa(String categoryId, String title, String description, Drawable imagen) {
        super();
        this.title = title;
        this.description = description;
        this.imagen = imagen;
        this.categoryId = categoryId;
    }


    public String getTitle() {
        return title;
    }

    public void setTittle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Drawable getImage() {
        return imagen;
    }

    public void setImagen(Drawable imagen) {
        this.imagen = imagen;
    }

    public String getCategoryId(){return categoryId;}

    public void setCategoryId(String categoryId){this.categoryId = categoryId;}

}

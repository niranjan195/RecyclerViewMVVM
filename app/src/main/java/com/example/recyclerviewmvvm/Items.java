package com.example.recyclerviewmvvm;

public class Items {
    /**
     * Resource id of the image to be used for the list item
     */
    private int mImageResourceId;

    /**
     * Description of the textView
     */
    private String mDescription;

    public Items(int imageResourceId, String description) {
        this.mDescription = description;
        this.mImageResourceId = imageResourceId;
    }

    public int getImageResourceId() {
        return this.mImageResourceId;
    }

    public String getDescription() {
        return this.mDescription;
    }
}

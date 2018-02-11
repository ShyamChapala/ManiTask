package com.example.manikandan.wipro.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ApiResponse {
    @SerializedName("title")
    @Expose
    String title;

    @SerializedName("rows")
    @Expose
    List<Rows> rows;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<Rows> getRows() {
        return rows;
    }

    public void setRows(List<Rows> rows) {
        this.rows = rows;
    }



    public class Rows{
        @SerializedName("title")
        @Expose
        String title;

        @SerializedName("description")
        @Expose
        String description;

        @SerializedName("imageHref")
        @Expose
        String imageHref;

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public String getImageHref() {
            return imageHref;
        }

        public void setImageHref(String imageHref) {
            this.imageHref = imageHref;
        }
    }
}

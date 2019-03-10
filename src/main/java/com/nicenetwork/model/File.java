package com.nicenetwork.model;

import org.springframework.web.multipart.MultipartFile;

import java.util.Date;

/**
 * Created by gsp on 15/07/2016.
 */
public class File {


    private int id;
    private int parent_id;
    private String file;
    private String name;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getParent_id() {
        return parent_id;
    }

    public void setParent_id(int parent_id) {
        this.parent_id = parent_id;
    }

    public String getFile() {
        return file;
    }

    public void setFile(String file) {
        this.file = file;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "File{" +
                "id=" + id +
                ", parent_id=" + parent_id +
                ", file=" + file +
                '}';
    }
}

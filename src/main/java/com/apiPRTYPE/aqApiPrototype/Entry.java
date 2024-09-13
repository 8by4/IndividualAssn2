package com.apiPRTYPE.aqApiPrototype;

public class Entry {

    //Characteristic declarations
    public String name;
    public String id;
    public String description;
    public String image;



    //Setter and getter methods for each.
    public Entry(String name, String id, String description, String image) {
        this.name = name;
        this.id = id;
        this.description = description;
        this.image = image;

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDescription() {
        return description;

    }
    public void setDescription(String description) {

        this.description = description;
    }

    public String getimage() {
        return image;
    }

    public void setimage(String image) {
        this.image = image;
    }



}

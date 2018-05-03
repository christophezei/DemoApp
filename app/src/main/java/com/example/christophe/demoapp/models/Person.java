package com.example.christophe.demoapp.models;

public class Person {
    private String personName;
    private String personAddress;
    private String imageUrl;

    public String getPersonAddress() {
        return personAddress;
    }

    public void setPersonAddress(String personAddress) {
        this.personAddress = personAddress;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getPersonName() {

        return personName;
    }

    public void setPersonName(String personName) {
        this.personName = personName;
    }

    /*public void setPersonInfo(String personName,String personAddress,String imageUrl){
        this.personName=personName;
        this.personAddress=personAddress;
        this.imageUrl=imageUrl;
    }
    public String getPersonInfo(){
        return personName + " " +personAddress + " " +imageUrl;
    }*/
}

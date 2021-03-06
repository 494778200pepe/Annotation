package com.hopechart.sq.annotation.Demo2;

/**
 * Created by mingwei on 12/2/16.
 */
public class Person {

    @Age(22)
    @Name({"阿特罗伯斯","米开朗基罗","达芬奇"})
    private String name;

    @Gender(gender = Gender.GenderType.Male)
    private String gender;

    @Profile(id = 1001, height = 180, nativePlace = "CN")
    private String profile;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getProfile() {
        return profile;
    }

    public void setProfile(String profile) {
        this.profile = profile;
    }
}

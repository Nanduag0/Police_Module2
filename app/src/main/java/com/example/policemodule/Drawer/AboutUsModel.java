package com.example.policemodule.Drawer;

public class AboutUsModel
{
    private Integer  image ;
    private String member_name;
    private String member_work;

    public AboutUsModel(Integer image, String member_name, String member_work) {
        this.image = image;
        this.member_name = member_name;
        this.member_work = member_work;
    }

    public Integer getImage() {
        return image;
    }

    public void setImage(Integer image) {
        this.image = image;
    }

    public String getMember_name() {
        return member_name;
    }

    public void setMember_name(String member_name) {
        this.member_name = member_name;
    }

    public String getMember_work() {
        return member_work;
    }

    public void setMember_work(String member_work) {
        this.member_work = member_work;
    }
}

package com.sweta.soul_adores.model;

public class Student {
    private String sname;
    private int id;
    private String branch;
    private int age;
    private String imageurl;
    public Student()
    {

    }
    public Student(String sname,int id,String branch,int age,String imageurl)
    {
        this.sname=sname;
        this.id=id;
        this.branch=branch;
        this.age=age;
        this.imageurl=imageurl;
    }
    public String getSname(){
        return sname;
    }
    public void setSname(){
        this.sname=sname;
    }
    public int getid(){
        return id;
    }
    public void setid(){
        this.id=id;
    }
    public String getBranch(){
        return branch;
    }
    public void setBranch(){
        this.branch=branch;
    }
    public int getAge(){
        return age;
    }
    public void setAge(){
        this.age=age;
    }
    public String getImageurl(){
        return imageurl;
    }
    public void setImageurl(){
        this.imageurl=imageurl;
    }


}

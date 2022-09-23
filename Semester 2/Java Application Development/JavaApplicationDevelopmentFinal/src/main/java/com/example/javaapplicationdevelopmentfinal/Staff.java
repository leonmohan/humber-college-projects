package com.example.javaapplicationdevelopmentfinal;

public class Staff
{
    private int ID;
    private String name;
    private String job;

    public Staff(int ID, String name, String job)
    {
        this.ID = ID;
        this.name = name;
        this.job = job;
    }

    public int getID()
    {
        return ID;
    }

    public void setID(int ID)
    {
        this.ID = ID;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getJob()
    {
        return job;
    }

    public void setJob(String job)
    {
        this.job = job;
    }

}

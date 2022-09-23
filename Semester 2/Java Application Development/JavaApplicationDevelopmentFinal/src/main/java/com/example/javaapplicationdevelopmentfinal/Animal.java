package com.example.javaapplicationdevelopmentfinal;

public class Animal
{
    private int ID;
    private String NAME;
    private String GENDER;
    private int AGE;
    private String ANIMAL;

    public Animal(int ID, String NAME, String GENDER, int AGE, String ANIMAL)
    {
        this.ID = ID;
        this.NAME = NAME;
        this.GENDER = GENDER;
        this.AGE = AGE;
        this.ANIMAL = ANIMAL;
    }

    public int getID() { return ID; }

    public void setID(int ID) { this.ID = ID; }

    public String getNAME() { return NAME; }

    public void setNAME(String NAME) { this.NAME = NAME; }

    public String getGENDER() { return GENDER; }

    public void setGENDER(String GENDER) { this.GENDER = GENDER; }

    public int getAGE() { return AGE; }

    public void setAGE(int AGE) { this.AGE = AGE; }

    public String getANIMAL() { return ANIMAL; }

    public void setANIMAL(String ANIMAL) { this.ANIMAL = ANIMAL; }
}

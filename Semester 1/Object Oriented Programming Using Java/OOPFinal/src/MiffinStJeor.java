public class MiffinStJeor extends TdeeFormula
{
    public MiffinStJeor(String gender, double kg, double centimeters, int age, double exerciseLevel)
    {
        this.gender = gender.toUpperCase();
        this.kilograms = kg;
        this.centimeters = centimeters;
        this.age = age;
        this.exerciseLevel = exerciseLevel;
    }

    @Override
    public double calculate()
    {
        if (this.exerciseLevel == 1)
        {
            this.multiplier = 1.2;
        }
        else if (this.exerciseLevel == 2)
        {
            this.multiplier = 1.3;
        }
        else if (this.exerciseLevel == 3)
        {
            this.multiplier = 1.55;
        }
        else if (this.exerciseLevel == 4)
        {
            this.multiplier = 1.725;
        }
        else if (this.exerciseLevel == 5)
        {
            this.multiplier = 1.9;
        }

        if (gender.equals("MALE"))
        {
            return this.multiplier * ((10 * kilograms) + (6.25 * centimeters) - (5 * (double) age) + 5);
        }
        else if (gender.equals("FEMALE"))
        {
            return this.multiplier * ((10 * kilograms) + (6.25 * centimeters) - (5 * (double) age) - 161);
        }

        return 0;
    }
}

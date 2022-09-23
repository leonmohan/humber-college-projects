public class HarrisBenedictRevised extends TdeeFormula
{
    public HarrisBenedictRevised(double kg, double centimeters, int age, String gender, double exerciseLevel)
    {
        this.kilograms = kg;
        this.centimeters = centimeters;
        this.age = age;
        this.gender = gender.toUpperCase();
        this.exerciseLevel = exerciseLevel;
    }

    @Override
    public double calculate() {

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

        if(gender.equals("MALE"))
        {
            return this.multiplier * ((13.397 * kilograms) + (4.799 * centimeters) - (5.677 * (double) age) + 88.362);
        }
        else if (gender.equals("FEMALE"))
        {
            return this.multiplier * ((9.247 * kilograms) + (3.098 * centimeters) - (4.330 * (double) age) + 447.593);
        }

        return 0;
    }
}
public class KatchMcArdle extends TdeeFormula
{
    public KatchMcArdle(double kg, int bodyfatPercentage, double exerciseLevel)
    {
        this.kilograms = kg;
        this.bodyfatPercentage = bodyfatPercentage;
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

        return this.multiplier * (370 + (21.6 * (kilograms * (100 - (double) bodyfatPercentage) / 100)));
    }
}

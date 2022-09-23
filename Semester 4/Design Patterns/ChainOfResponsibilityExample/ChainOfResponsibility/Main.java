public class Main
{
    public static void main(String args[])
    {
        Score score = new Score(100);

        Mathematics math = new Mathematics();
        Chemistry chem = new Chemistry();
        Biology bio = new Biology();

        math.setNextChain(chem);
        chem.setNextChain(bio);

        math.giveTest(score);
    }
}

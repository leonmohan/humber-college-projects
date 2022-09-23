import java.util.Scanner;

public class Chemistry implements Test
{
    Scanner scanner = new Scanner(System.in);
    private Test test;

    @Override
    public void setNextChain(Test test)
    {
        this.test = test;
    }

    @Override
    public void giveTest(Score score)
    {
        if(score.getScore() > 80)
        {
            System.out.println("Is gas considered a state? (Yes/No)");
            String answerOne = scanner.next();

            System.out.println("Is solid considered a state? (Yes/No)");
            String answerTwo = scanner.next();

            System.out.println("Is plasma considered a state? (Yes/No)");
            String answerThree = scanner.next();

            if(!answerOne.equals("Yes")){score.setScore(score.getScore()-15);}
            if(!answerTwo.equals("Yes")){score.setScore(score.getScore()-15);}
            if(!answerThree.equals("Yes")){score.setScore(score.getScore()-15);}

            this.test.giveTest(new Score(score.getScore()));
        }
        else
        {
            System.out.println("FAIL");
        }
    }
}

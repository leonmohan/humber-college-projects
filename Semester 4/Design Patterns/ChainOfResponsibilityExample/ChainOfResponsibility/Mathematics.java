import java.util.Scanner;

public class Mathematics implements Test
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
            System.out.println("What is 10+10?");
            int answerOne = scanner.nextInt();

            System.out.println("What is 5*2?");
            int answerTwo = scanner.nextInt();

            System.out.println("What is 10/2?");
            int answerThree = scanner.nextInt();

            if(answerOne != 20){score.setScore(score.getScore()-15);}
            if(answerTwo != 10){score.setScore(score.getScore()-15);}
            if(answerThree != 5){score.setScore(score.getScore()-15);}

            this.test.giveTest(new Score(score.getScore()));
        }
        else
        {
            System.out.println("FAIL");
        }
    }
}

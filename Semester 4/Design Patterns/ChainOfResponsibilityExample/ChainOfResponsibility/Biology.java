import java.util.Scanner;

public class Biology implements Test
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
            System.out.println("Is a salamander warm blooded? (Yes/No)");
            String answerOne = scanner.next();

            System.out.println("Are most plants green? (Yes/No)");
            String answerTwo = scanner.next();

            System.out.println("Do frogs live in saltwater? (Yes/No)");
            String answerThree = scanner.next();

            if(!answerOne.equals("No")){score.setScore(score.getScore()-15);}
            if(!answerTwo.equals("Yes")){score.setScore(score.getScore()-15);}
            if(!answerThree.equals("No")){score.setScore(score.getScore()-15);}

            if(score.getScore()>80)
            {
                System.out.println("You passed!");
            }
            else
            {
                System.out.println("FAIL");
            }
        }
        else
        {
            System.out.println("FAIL");
        }
    }
}

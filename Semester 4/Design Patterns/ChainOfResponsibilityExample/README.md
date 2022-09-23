# Chain of Responsibility Pattern

### An assignment for my "Design Patterns" course at Humber in 2022 that showcases what a Chain of Responsibility pattern might look like in Java. I structured this example with three subjects: Math, Chemistry, and Biology. If you don't score atleast 80% for each subject you automatically fail. The chain of responsibility pattern will ensure that the tests don't continue if the user's overall score is lower that 80

## Tech used: ![Java](https://img.shields.io/badge/java-%23ED8B00.svg?style=for-the-badge&logo=java&logoColor=white)
Test.java is an interface that all the Test classes will be implementing. (Mathematics.java, Chemistry.java, and Biology.java). The interface ensures that each class will have a setNextChain method and a giveTest method. setNextChain will set the next test that needs to be taken and giveTest will give the user the test to complete.

Mathematics.java, Chemistry.java, and Biology.java all work the same; They first check if the score is greater than 80. If it is, the test continues. Then they check whether the answers entered were correct. For each incorrect answer, 15 points are taken off and the next test is loaded with the score of the previous test. The whole process is then repeated.

Score.java is what's used to mainly keep track of what the test taker's overall score is. The test classes change or read the score by using the getters and setters in this class.

Main.java creates a score object, an object of each of the test classes, and sets their chain in the desired order. Math -> Chemistry -> Biology. After it sets the chain, it starts the chain by calling Mathematics.java's giveTest method.

## Optimizations
There is room for improvement with this project. Instead of writing if statements directly inside the giveTest method I could have probably created a method that calculates the results for each test. Also, there is no way of clearly knowing that Biology is the last "chainlink" in this design pattern. That could be problematic for a developer if they read my code

## Lessons Learned:
I see how this design pattern could be useful if you have a project that contains multiple steps that sometimes need to be stopped. 

# Factory Design Pattern
![FactoryPattern](https://user-images.githubusercontent.com/101066826/191902951-7f6ff7a0-23c2-4782-a79b-b073d11f9360.png)

### An assignment for my "Design Patterns" course at Humber in 2022 that showcases what a Factory Pattern might look like. From my understanding, a factory pattern decides what object to create out of a bunch of subclasses. Then it returns that object to the client to use a common method. With this basic idea in mind, I decided to demonstrate the factory pattern by writing a program that allows the user to write a message and choose the database that they save it to.

## Tech used: ![Java](https://img.shields.io/badge/java-%23ED8B00.svg?style=for-the-badge&logo=java&logoColor=white) ![MySQL](https://img.shields.io/badge/mysql-%2300f.svg?style=for-the-badge&logo=mysql&logoColor=white) ![Postgres](https://img.shields.io/badge/postgres-%23316192.svg?style=for-the-badge&logo=postgresql&logoColor=white) ![Oracle](https://img.shields.io/badge/OracleSQL-F80000?style=for-the-badge&logo=oracle&logoColor=white)
The project can be broken down into three sections: the database classes, the factory class, and the main class.

The first database class is Database.java. This class is going to serve as the super class for all the other  database classes. Each class inheriting Database.java will have to implement a method called insertMessage which takes a String argument. Main.java also uses this class to initialize a database class object. PostgresSQL.java, MySQL.java, and OracleSQL.java all have an almost identical structure. They all use JDBC to connect to their respective databases and they all implement the insertMessage() method with a String argument.

DatabaseFactory.java contains a method called getDbObject() that returns a Database object. It decides which database object to return based off what was entered in its arguments. If it doesn't recognize the database that the user wants to implement, it will throw an error.

Main.java creates a Scanner object, creates a null Database.java object, and a DatabaseFactory object. When the users input is gathered via the Scanner object, The null Database object is populated using the DatabaseFactory's object's method called insertMessage() 

## Optimizations
There is room for improvement with this project. I should have written comments that explain the basic logic of what everything does. I also should have scanned input using another class to make the project more decoupled in general

## Lessons Learned:
I would say I learned the basics of how to add PostgresSQL and OracleSQL to Java projects. In the past, I had added MySQL to a Java project so the transition wasn't big. My only experience with OracleSQL was by using the developer and Linux terminal. So it was nice to have a taste of how its implemented on Java projects. Lastly, it showed me how much more simple creational patterns make your project. If I were to make changes to Main.java, I wouldn't have to worry about breaking any code that deals with the databases because it's all abstracted

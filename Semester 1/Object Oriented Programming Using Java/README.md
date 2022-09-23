# Object Oriented Programming Using Java Final
![OOPFinalPicture](https://user-images.githubusercontent.com/101066826/191892428-45c4fac0-cbe9-49a3-ab0f-13c53af376e4.png)

### A calculator project that I created in 2020 as a final project for the "Object Oriented Programming Using Java" course at Humber in semester 1. The goal of this project was to create a simple program that's designed with an OOP principle. So I decided to create a calculator that uses 4 formulas to calculate a person's TDEE (Total Daily Energy Expenditure).

## Tech used: ![Java](https://img.shields.io/badge/java-%23ED8B00.svg?style=for-the-badge&logo=java&logoColor=white)
In this project, I chose to use inheritance because I noticed that each formula that calculated TDEE had some common variables. Instead of declaring new variables in each class, I could just declare them in one class and extend that class. This saved me some time and allowed my code to be more reusable in case I wanted to add a new formula. In the main class, a Scanner object is used to gather input from the user. The input gathered is then stored in variables (kilograms, centimeters in height, gender, age, and body fat percentage). Next, an object of each formula's class is created. The parameters are then populated with whatever is required. (Eg. the Cunningham formula only needs the person's weight in kg, body fat percentage, and exercise level). The results of each object's calculate() method are then printed.

## Optimizations
Some thing I can do to optimize this project is to add some more readability to my code. For example, in every calculate() function I could have separated the sections of code that calculate the TDEE's multiplier variable into a separate method. It would also help if those calculations contained some comments that explained what it was doing. Another thing I could do to optimize this project is to add some validations. For example, the program terminates and throws an exception if you type a number as a gender. Instead what I could do is catch that exception and write some code to give the user another chance at entering the input until it's either "Male" or "Female".

## Lessons Learned:
Overall I could see how useful OOP is for code that has similarities. I feel like this project also gave me some valuable experience with turning formulas into code. Since the arithmetics had multiple steps, I had to make sure to put the right expressions in brackets so the formula could be calculated properly.

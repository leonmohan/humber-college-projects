# Numeric Computing Final
![NumericComputing](https://user-images.githubusercontent.com/101066826/191889858-9bce26e8-a8d2-4cde-ab4b-efcbac46bb2c.png)


### A final project I created in 2020 for "Numeric Computing" course. What this program does is calculate how a simple interest formula will grow over a specified amount of years and put that information into an .xlsx spreadsheet file.

## Tech used: ![Java](https://img.shields.io/badge/java-%23ED8B00.svg?style=for-the-badge&logo=java&logoColor=white) ![Apache](https://img.shields.io/badge/apache%20POI-%23D42029.svg?style=for-the-badge&logo=apache&logoColor=white)
The first step was to gather the user's input, I used a scanner object to populate the variables that hold the user's principal amount, interest rate, and amount of years the simple interest will grow. The second step was to use Apache POI objects to represent how the Excel file would look like. I did this by creating a XSSFWorkbook object, then attaching it to a XSSFSheet object. For the rows I first created the hardcoded the heading row and cells. Then I created a for loop that creates a new row, and writes the year in the first cell and calculates the formula in the second cell. The third step was to take that workbook and write it to a file path using FileOutputStream.

## Optimizations
The program right now seems simple, but there is a lot of room for improvement. First, it would probably be better if I changed the design pattern of the project. Instead of doing everything in the Main class, I could have separated each step into their own respective classes. For example, if I created a class called SimpleInterest that had a method that gathered and stored input the program would be a lot more dynamic.

## Lessons Learned:
This is the first time I used a library outside of the course curriculum to finish a project so it was somewhat difficult when it came to downloading the jar folders and adding them to my project structure.

# Facade Pattern

### An assignment for my "Design Patterns" course at Humber in 2022 showcases what a Facade Pattern might look like. If you look at my Semester 1 folder, this program is my <a href="https://github.com/leonmohan/humber-college-projects/tree/master/Semester%201/Numeric%20Computing">Numeric Computing Final project</a> implemented with a Facade pattern. The program calculates how a simple interest formula will grow over a specified amount of years and put that information into a .xlsx spreadsheet.

## Tech used: ![Java](https://img.shields.io/badge/java-%23ED8B00.svg?style=for-the-badge&logo=java&logoColor=white) ![Apache](https://img.shields.io/badge/apache%20POI-%23D42029.svg?style=for-the-badge&logo=apache&logoColor=white)
When thinking of a way to restructure this folder, I tried to apply the single responsibility principle where one class should be responsible for one thing. GenerateExcelFile is responsible for using the Apache POI to create the Excel file and ScannerInput is responsible for gathering the user's input using a Scanner object. The ExcelFacade class then passes the arguments generated from a method in the ScannerInput class and places them inside a GenerateExcelFile object. All you have to do in the Main method is create an object of ExcelFacade and invoke the "generateExcelReport" method

## Optimizations
The only criticism I have for this project is the method I used to gather user input. The ScannerInput class returns an array of what each input is going to be. I then plug the 0th, 1st, and 2nd index of the array into a new GenerateExcelFile object. This could be confusing if someone else were to access this code and try to figure out what the inputs were. A solution I've thought of for this is to use getter methods to get each input. That way, the programmer knows exactly what I'm plugging into each object.

## Lessons Learned:
In general I am happy with the way the project turned out. I really appreciate how Facade patterns sort of seperates the "complex code" from the business logic. It also makes the project a lot easier to refactor as you automatically know where to go if you want to change the way user input is gathered or how the excel file is generated. 

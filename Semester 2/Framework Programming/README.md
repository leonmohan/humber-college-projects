# Framework Programming - Rent Calculator Form
![FrameworkProgramming](https://user-images.githubusercontent.com/101066826/191894214-32b54168-42a3-43b8-804b-4ef87c916cca.png)

### A project that was created in 2021 in my "Framework Programming" class. The assignment was to create a C# form application with the .NET Framework that calculates the total cost of renting a house based on what the user selects in the form.

## Tech used: ![C#](https://img.shields.io/badge/c%23-%23239120.svg?style=for-the-badge&logo=c-sharp&logoColor=white)
First, the program collects the user's information with a form. The form asks for the first name, last name, property type, number of bedrooms, and number of bathrooms. When the user presses the "Buy" button, a Rent object is created which calculates the rent. The results can then be retrieved from the classes' toString() method and added to the label.

## Optimizations
I would redo a lot of things differently in this project. First of all, more descriptive comments would help a lot. Things are just being set to true
or false with no clear explanation. A comment would give us more insight into what they do. For example, in Form1.cs, the "radCondo_CheckedChanged" function sets cboxHouse.Enabled to false, cboxHouse.Text to null, and cboxCondo.Enabled to true. Doing some digging I figured out that this function disables the house combo box on the form when the "condo" radio button is clicked, the text is set to null and the condo combo box is enabled.

## Lessons Learned:
The teacher had instructed that the label's message should be from each classes toString() method. Doing this was very interesting and I will think about that design pattern in the future. 

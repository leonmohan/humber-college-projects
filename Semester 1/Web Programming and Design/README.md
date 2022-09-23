# Web Programming and Design Final Project - Portfolio
![WebProgrammingAndDesign](https://user-images.githubusercontent.com/101066826/191893143-e11fbfed-f4ba-4f91-a7b8-24f8e921d50a.png)

### The portfolio that I created in 2020 as a final project for the "Web Programming and Design" course at Humber in semester 1.

## Tech used: ![HTML5](https://img.shields.io/badge/html5-%23E34F26.svg?style=for-the-badge&logo=html5&logoColor=white) ![CSS3](https://img.shields.io/badge/css3-%231572B6.svg?style=for-the-badge&logo=css3&logoColor=white) ![JavaScript](https://img.shields.io/badge/javascript-%23323330.svg?style=for-the-badge&logo=javascript&logoColor=%23F7DF1E)
My goal was to create a portfolio that had a simple UX design in HTML5 and CSS3. The index consists of a header, hyperlinks to the other areas of the website, and a footer. The about page contains three columns that share some information about me. The contact page contains a form that allows the user to enter their name and contact information. When the form is submitted, it just redirects to a page that shows the information that was typed. The resume page shows my resume at the time in simple HTML. The projects allows you to download some of my projects that I worked on in other classes. Each time a radio button is clicked, JS is used to change the hyperlink that contains downloadable content. Lastly, the Linkedin page redirects the user to my Linkedin profile.

## Optimizations
Some of the things I can do to improve this project is to use more descriptive tags in HTML. On the index page, there are just 5 hyperlinks. Instead, I could have atleast contained them all in a < nav > tag to indicate that those hyperlinks were navigational content. 

The contact form could also be modified to actually send the form's information to my email. One way this can be done is if I change the file's extension from .html to .php and use PHP's mail() function and pass the information from the form. 

The page that shows my project could also be written much cleaner. First I would remove the JavaScript from the HTML page and give it its own .js file that is referenced to instead. Then I would change the JS code to have only one changeImage() method that recieves a parameter so it knows what hyperlink to change to. 

Lastly, I this website could be more mobile friendly. The CSS files could contain some media querys that change the layout based off the device-width.

## Lessons Learned:
I learned the importance of the separation of concerns principle. I found it was much easier to navigate through my code when I separated the HTML, CSS, and JS.

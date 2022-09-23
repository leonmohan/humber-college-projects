# XML Classplan Assignment
![Classplan](https://user-images.githubusercontent.com/101066826/191897641-5fa9a5b6-b34f-41b2-a685-76038c1e9e42.PNG)

### I created this app in 2021 in the third semester as an assignment for the "XML" course at Humber. The assignment was done to get us used to using and creating XML. We were instructed to create an XML file from scratch that stored data from a portion of our class plan. This classplan needed to have a Schema. We had the option of using either DTD or XSD so I chose XSD. After that, We were instructed to convert transform the XML file into an HTML file using XSLT. This XSLT also needed to be styled. In general, I would say this project got me comfortable using XML and XSLT. 

## Tech used: ![XML](https://img.shields.io/badge/-XML-lightgrey) ![XSD](https://img.shields.io/badge/-XSD-lightgrey) ![XSLT](https://img.shields.io/badge/-XSLT-lightgrey) ![CSS3](https://img.shields.io/badge/css3-%231572B6.svg?style=for-the-badge&logo=css3&logoColor=white)
The project can be broken up into two parts: XML, and then XSLT

classplan.xml defines 3 main parts: The table's headers, Modules that go into the table, and a summary. The headers I decided to use were the week, the topic, the activities, and the grading weight. The modules are going to be the actual information that goes inside the table. Each module defines a week, module name, topic with information, and activity that shows the grading percentage. The summary is going to hold information that sums up the whole course. It defines information about the labs, quizzes, assignments, projects, and total course grades.

classplan.xml also has an XSD schema. It mostly defines the name and datatype that the elements should be. Sometimes it defines the occurrences elements should be having. I've decided to make everything have a string datatype because we're not going to be doing anything mathematical with the data. It's meant to be information that's converted into HTML.


classplan.xslt is in charge of converting classplan.xml into basically an HTML file. When it comes to gathering a bunch of information and generating HTML, the XSL styling language helped me a lot here. For the headers, I just extracted the values using < xsl:value-of >. However, when it came to displaying all of the week modules I had to generate a table row with data for each module, then use < xsl:value-of > inside of the loop to grab the current value of whatever module that was being iterated. When it came to creating the summary table, I just created a table and extracted the value of each header and its information
using < xsl:value-of >.

classplan.css was fairly simple to implement. I just made both tables the width of the page, centered the text, and changed the colors of the headers and the header in them. On the table, I used nth-child(even) to change the color of every table row that was even

## Optimizations
Some areas of improvement this project could use are increasing the readability. For example, in my .xslt file when you look at my code that iterates over ClassPlan/WeekModule, the < td > tags that hold will hold the week and modulename values could be spread out more. Everything is just on one line. Despite this I will say at least there was an attempt with comments that explains my logic 

## Lessons Learned:
Like I mentioned earlier this was a good assignment that got me more familiar and comfortable with seeing and writing XML. I learned the XSLT version 2 is not supported when opened locally. This forced me to just use version 1 only. I also learned about figured out that there are a bunch of unique CSS selectors that you can use. 

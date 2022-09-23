# Final Chat Project
![ChatApp](https://user-images.githubusercontent.com/101066826/191905301-0f23edf4-7651-4663-a8b6-f12f272e210f.png)

### The final project I submitted for my "Distributed Computing" course at Humber in 2022. In this project, we were instructed to create a simple chat app that saves and retrieves data from a database via a servlet. I decided to add a way to clear the messages aswell.

## Tech used: ![Java](https://img.shields.io/badge/java-%23ED8B00.svg?style=for-the-badge&logo=java&logoColor=white) ![Postgres](https://img.shields.io/badge/postgres-%23316192.svg?style=for-the-badge&logo=postgresql&logoColor=white) ![jQuery](https://img.shields.io/badge/jquery-%230769AD.svg?style=for-the-badge&logo=jquery&logoColor=white) ![Payara](https://img.shields.io/badge/-PAYARA%20SERVER-blue) ![HTML5](https://img.shields.io/badge/html5-%23E34F26.svg?style=for-the-badge&logo=html5&logoColor=white)
index.html contains jQuery code that can be broken down into three sections. 

First, there is a function called updateChat() that sends an ajax GET request to the messages servlet. The messages servlet then responds with HTML code. If the GET request is successful, the HTML code then replaces the child elements of an element with the id "history" with the HTML that was received from the ajax request. This function is invoked as soon as the document is fully loaded. 

Second, a click event listener is added to the message button with the id "post". When the button is clicked, the value in the textarea element with the id "message" is stored in a variable. a POST ajax request is then made with the textarea's value as the message. The message's servlet will then receive this request and store the new message in the database. Lastly, the updateChat() function is invoked the refresh the chat's history

Third, a click event listener is added to the delete button with the id "delete". When the button is clicked, a DELETE ajax request is sent to the messages servlet. The messages servlet will then proceed to delete every record in the database. When this is done, the updateChat function is invoked; refreshing the chat history.  


GetMessages.html is the Servlet that receives and responds to the GET, POST, and DELETE requests.

GET: When the servlet receives a get request, the processRequest function is invoked which then invokes a function from the Messages
EJB called getMessages(). The HTML that the getMessages() returns is then sent as the response.

POST: When the servlet receives a post request, the value from a parameter called "message" is received and stored in a variable.
insertMessage() from the EJB is then invoked with the value from the parameter passed to it.

DELETE: When the servlet receives a delete request, the deleteMessages() method is invoked from the Messages EJB. 


Messages EJB
The Messages EJB has three methods: insertMessage(String arg), getMessages(), and deleteMessages().

insertMessage(String message) inserts the argument that was passed to it into the messages table. First, it creates a connection, then it creates an INSERT statement the insert statement uses the String that was passed to it. The statement is then executed and then the connection gets closed.

getMessages() creates a connection and executes a select query. The results that get returned are stored in a ResultSet object. This result set is then processed with a while loop. Basically what the while loop does is get each message in the result set, create a paragraph tag and store the message as the paragraph tag's value. The generated tag is then appended to a large String. The database connection is then closed and the large string is returned to Servlet which then converts the whole string into HTML.

deleteMessages() creates a connection, and executes a DELETE query which deletes everything from the database. The connection is then
closed.

## Optimizations
Looking back, I can say that this project has a lot of room for improvement. For starters, the jQuery probably should have been done externally. The messages servlet could also have been done differently. For one, the servlet is named "GetMessages" when it does more than that (GET, POST, DELETE). What I should have done is creates multiple servlets that all have a single responsibility. Lastly, the Messages EJB also has some flaws. For starters, the dbURL, username, and password are all stored in private Strings. This is not that important since everything is local in this project but I can imagine that that type of information would be hidden somehow in production. The next flaw is how vulnerable the queries are. For example, when I insert a value, if that value has an apostrophe ('), it will cause an error. After researching I found that using a PreparedStatement can prevent this from happening.

## Lessons Learned:
Although the project does not have the best coding practices, I think it gave me a good introduction to servlets, JDBC, making requests to servlets, and making me think about some issues to look out for when structuring a web project.

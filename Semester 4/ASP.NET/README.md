# Hospital Management System using ASP.NET Core MVC 6
![VectorPicture](https://user-images.githubusercontent.com/101066826/191898900-23714b9b-d187-4aaa-b2e2-6246eb29ea1d.PNG)

### This was the final project I did in the "ASP.NET" course in 2022. The project's instructions were to create a hospital management system using ASP.NET MVC along with the Entity framework for databases. The project is supposed to consist of three tables: Doctors, Patients, and Visits. Patients should have a foreign key that references a doctor and Visits should have two foreign keys that reference a doctor and a patient. All pictures and names were generated for free

## Tech used: ![MicrosoftSQLServer](https://img.shields.io/badge/Microsoft%20SQL%20Sever-CC2927?style=for-the-badge&logo=microsoft%20sql%20server&logoColor=white) ![ASPNET](https://img.shields.io/badge/-ASP.NET%20MVC%206-blueviolet) ![EntityFramework](https://img.shields.io/badge/-Entity%20Framework-blueviolet)
Since the project is built with the MVC design pattern, I think it's best to explain it in that order
 
#### Models:
There are three models: Doctor, Patient, and Visit. Each of these models uses data annotations to define non-null, primary key, and foreign key columns. Each model has a column defined named "Id" that's set as the primary key for that model. Excluding the Id column:

The Doctor model consists of three columns: Name, Office, and Practice. All of these columns are set to non-null. 

The Patient model consists of two columns: DoctorID and Name. The Doctor property in the class is used to hold a Doctor object. This object is used to do things like extract the name of the patient's doctor. DoctorID is a foreign key at contains the ID of the patient's doctor. The Name column is non-nullable

The Visit model consists of three columns: DoctorNotes, DoctorID, and PatientID. DoctorNotes is non-nullable. DoctorID is a foreign key that holds the ID of the doctor that conducted the visit. PatientID is another foreign key that holds the ID of the patient that conducted the visit.
# 
#  
#### Views:
Each page has a Create, Delete, Edit, Index and Search view except for the Home page which only has an Index and Privacy page. Home's index
page basically has a welcome message that uses a logo from wwwroot. Home's privacy page is a generated copy and pasted text. For the rest of
the pages:

Index.cshtml:
A form that redirects you to the search action is at the top of a table that loops through the Model and populates the table. Two anchor tags are added to the end of the table. The first one redirects you to the Edit action and the second one redirects you to the Delete action.

Create.cshtml:
This view consists of a form that sends a POST request to the create action.

Edit.cshtml:
Similar to create, this view consists of a form. However, this form is prepopulated with the details of the row you chose to Edit.

Delete.cshtml:
This view is a prepopulated form that has all of its inputs disabled. The purpose of the form is to see the row's details before the user decides to delete it. Something interesting about this form is that there is a hidden ID input. The importance of this will be explained in the Controllers section

Search.cshtml:
This view is a table that shows the results from a search that can be made in Index.cshtml. The way it functions is the same as Index.cshtml. 

_Layout.cshtml:
This view is important because it's responsible for showing the navigation bar throughout the whole project. 
# 
# 
#### Controllers:
Almost every controller is identical except for the Home controller. The home controller shows the Index and Privacy view. The rest of the controllers are structured like this:

A local variable named _db is created. This variable is what will be used to perform CRUD on the database. Before it can be used, it first has to be populated by the constructor with the DbContext. The DbContext I set up is called "ApplicationDbContext". The _db variable gets populated with ApplicationDbContext.

The first action is Index(). Basically what it does is get a list of all the records in the model using _db and pass that list to the view.

The second action is a Search. This action needs to be posted with a form. From that form, it receives a string (declared as searchTerm).
This searchTerm is used to return all the rows results that contain the string. That list is then passed to the view.

The third action named Create simple returns a view. The view will have a form that sends a POST request to the fourth Action, named Create.

The fourth POST action named Create receives the input from the third action's form (Create GET). First, it preforms a validation on the ModelState to check if it is valid. If it is, it uses _db to insert the new row into the database and saves the changes. The user is then redirected to the Index view. If the validation fails, the view Create GET is returned.

The fifth action is named Edit (GET request). Edit receives an integer that's supposed to be the ID of the record that the user wants to Edit.
This ID is used to find the record that has that ID (using _db). If no record was found, a NotFound page is returned. If a record was found, then a view is returned with the record object passed in its argument. This is how the view prepopulates all the fields in its form. When the view's form is POSTED, the sixth action is invoked.

The sixth action is named Edit (POST request). It expects to receive a Doctor object POSTED from the view's form. First, it performs a validation on the ModelState to check if it is valid. If it is, it uses _db to insert the new row into the database and saves the changes. If the ModelState is not valid, the form is returned

The seventh action is named Delete (GET request). It expects an integer. First, it checks if the integer that it receives is null or equal to 0. If it is, then a NotFound error is thrown. Next, an object is created. Using _db, the object should be populated with the specific record that we believe the user is requesting (based on the id). If nothing gets populated in the object, a NotFound error is thrown. Lastly, A view is returned with the specific record object passed in its argument. This view will display a view that asks if they're sure that they want to delete the record with a form that displays all the information. If the user presses delete the form is POSTed to the eighth action

The eighth action named Delete (POST request) receives an int that represents the ID of the row that the user wants to delete. This id is
gathered from a hidden input on the GET form. This action stores a reference to the record that the user wants to be deleted. Then, it checks
if the reference is null. If it is, a NotFound error is thrown. Otherwise, it removes the record and saves the changes. The user is then redirected to the index view.

## Optimizations
Since this class was sort of an introduction to ASP.NET, I am happy with the way this project turned out. Having that said, there are probably some bad practices in this project. For example, in the Patient controller to populate the Doctor property, I run a foreach loop that populates the records Doctor object using the foreign key's id. This method works but I feel like there is some cleaner way of doing it. I also believe I could have experimented with master pages a little more. This is because throughout the application I noticed that all the pages have a similar style. For example, maybe I could have created a master page that defines the table for the views.

## Lessons Learned:
I learned a lot about the Entity Framework and the advantages of the MVC design pattern. I remember the project being easy to debug because if I had an error, I knew generally what Model, View, or Controller to look inside. In my opinion, I like the code-first approach but I have a feeling that it might not be as flexible compared to something like a DAO.

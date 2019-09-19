# QuizApp-using-Android-MVC-
This project contains a basic Quiz App having few True/False Question implemented using Android MVC(Model,View,Controller) architecture.

MVC Architecture:

MVC design pattern splits an application into three main aspects: Model, View and Controller.
It forces a separation of concerns, it means domain model and controller logic are
decoupled from user interface (view). As a result maintenance and testing of the application become simpler and easier.

Model:-
The Model represents a set of classes that describe the business logic i.e. business model as well as data access operations i.e. data model.
It also defines business rules for data means how the data can be changed and manipulated.

View:-
The View represents the UI components. It is only responsible for displaying the data that is received
from the controller as the result. This also transforms the model(s) into UI.

Controller:-
The Controller is responsible to process incoming requests. It receives input from users via the View, 
then process the user’s data with the help of Model and passing the results back to the View. 
Typically, it acts as the coordinator between the View and the Model.

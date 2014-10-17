bettrhuman-sleepyhead
=====================

A Google Cloud Endpoints in Java project for Bettrhumans's REST API.

#Getting Started with this Project

##Why Cloud Endpoints?

A Google Cloud Endpoints project is a special Google App Engine project dedicated to building a REST API. It provides A LOT of nice features, such as automatically creating client libraries for Android and IOS, as well as giving access to a nifty API explorer in your web browser.

[Overview of Google Cloud Endpoints][1]

**An important note**: We should be careful to not tightly couple ourselves to Google Cloud Endpoints. Our REST API is simply an interface we offer to our service layer, so no components of the REST API should leak down into our service. At any time we should be able to move the service layer of our project to a completely new framework for exposing REST endpoints without much of a headache at all. Keep this in mind as developing.

##Install Eclipse
Setting up App Engine isn't too difficult. The first step is to install [Eclipse EE][2] (I use Luna). Also make sure you have Java 7 installed. (You must use Java 7 with Google Cloud Endpoints). 

##Install Maven
You must have [Apache Maven 3 installed][3]. We mostly use Maven for dependency management. Without Maven, anytime we rely on an third-party library we would have to manually download that and add it to our project, on everyone's machines. It's an effing nightmare, to be technical. Maven makes this EXTREMELY easy. 

##Install Maven Eclipse Plugin
Go [here][4] to install the Plugin for integrating Maven with Eclipse.

##Install the App Engine Plugin for Eclipse
Next, follow the steps here to [install the App Engine plugin for Eclipse][5]. It will take care of installing the App Engine SDK on your machine and such. Don't install the stuff for Android or another one about GWT or something

##Git & Import the project
Clone this project to your harddrive somewhere and import it into Eclipse as an existing Maven project.

#Dev

##Running It
Running this project locally is made easy by Google App Engine. 

- Right click the project and move your cursor to Debug. In the pop out menu, select "Debug on Server". 
- A dialog will appear. Create a new 'Google App Engine' server and click finish.
- You should see some text scrolling in your console that means Java is starting a server and deploying your stuff to it. At the end, a browser might appear.

##Playing with It
You'll probably see an error on the home page of your project, which is expected because there is nothing interesting here. Instead, go to root/\_ah/api/explorer (http://localhost:8888/\_ah/api/explorer) to access the API explorer for this Google Cloud Endpoints library. 

You'll be able to see available APIs and explore their endpoints here. Use this to create and send requests and test your changes.

#Prod

##Deploying It
Right click on your project, scroll down to "Google App Engine WTP", and in the popout menu select "Deploy Project to Remote Server".

After it finishes, the latest code has been deployed and is publically accessible. Access the API explorer by going to [https://apis-explorer.appspot.com/apis-explorer/?base=https://mobile-foxy-proxy.appspot.com/\_ah/api#p/][7].



[1]: https://developers.google.com/appengine/docs/java/endpoints/
[2]: http://www.eclipse.org/downloads/packages/eclipse-ide-java-ee-developers/lunar
[3]: http://maven.apache.org/download.cgi#Installation
[4]: http://maven.apache.org/eclipse-plugin.html
[5]: https://developers.google.com/eclipse/docs/install-eclipse-4.4
[6]: http://projectlombok.org/download.html
[7]: https://apis-explorer.appspot.com/apis-explorer/?base=https://mobile-foxy-proxy.appspot.com/_ah/api#p/

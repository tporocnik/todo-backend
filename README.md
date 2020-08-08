# Todo app backend

REST backend for a simple Todo application implemented with Quarkus. The app supports 

* List tasks
* Add and update tasks
* Delete tasks


### Configuration 

To configure ports etc use:

	src/main/resources/application.properties

### Start developer mode

    mvn quarkus:dev

### Start

For running the app outside of an IDE run.bat can be used. It simply calls:
	
	java -jar -Dquarkus.http.host=0.0.0.0 todo-1.0-SNAPSHOT-runner.jar

### Testing

For simple checking the responsiveness of the backend you can call: [http://localhost:8088/todo/tasks/](http://localhost:8088/todo/tasks/)

Once the app is started, the integration tests can be used to make a simple CRUD test against the backend. 


### Debugging

Start application with -Ddebug. Default debug port is 5005
	

### See also 

 * https://quarkus.io/guides/getting-started-guide
 



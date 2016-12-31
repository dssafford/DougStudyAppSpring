manifest case sensitive on services


to build the jar for cf push you can use
mvn package, then it won't run the tests, some 
which can fail.  So run the tests from the ide
then set up for packaging and pushing.

** doesn't matter what command line does, even if set to dev the package
still works fine when pushed to cf.

for the maven install you have to have the active profile=dev in
the application.properties file

cf push doug-study-app-spring -p target/dougstudyappspring-0.0.1-SNAPSHOT.JAR

make sure that all junit files use profile=dev or "edit configurations" 
= -Dspring.profiles.active=dev -ea

** must set active profile in all cases


For Selenium testing with Firefox must use firefox 46, still, get a connection
error on localhost otherwise.  Selenium 3 and chrome works and selenium 3 and
firefox.
manifest case sensitive on services

Note: prior to cf push you have to go into edit configurations and 
make sure that profile = cf, otherwise you will never get the 
right database credentials.


cf push doug-study-app-spring -p target/dougstudyappspring-0.0.1-SNAPSHOT.JAR

make sure that all junit "edit configurations" 
= -Dspring.profiles.active=dev -ea

** must set active profile in all cases
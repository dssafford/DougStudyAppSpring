manifest case sensitive on services

cf push doug-study-app-spring -p target/dougstudyappspring-0.0.1-SNAPSHOT.JAR

make sure that all junit "edit configurations" 
= -Dspring.profiles.active=dev -ea

** must set active profile in all cases
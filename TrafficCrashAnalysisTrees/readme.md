To run the application without sql, you can just directly execute. The below steps are specifically to run the queries related to the experiments through database.

Steps to run  the application with SQL results : 

1. Run the SQL_TrafficAccident.sql in the workbench to create the database.
2. Go to SQLExperiments.java and in line number 18, add your database root password inside the "".
3. Go to TrafficAnalysisUI.java and in line number 23, add your database root password inside the "".
4. Uncomment Line number 34 in TrafficAnalysisUI.java  to start inserting into database.





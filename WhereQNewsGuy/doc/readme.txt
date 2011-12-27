Maven Command:

Create DB:
mvn hibernate3:hbm2ddl -Dmaven.initdb.skip=false

Init DB:
mvn dbunit:operation 
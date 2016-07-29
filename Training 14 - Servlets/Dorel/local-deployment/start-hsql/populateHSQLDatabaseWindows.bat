@echo on
REM Parameters ${hsqldb.ddl.sql.script} ${hsqldb.insert.sql.script} ${host} ${hsql.port} ${hsql.database.name} ${hsql.database.username} ${hsql.database.password}
sleep 30
echo "Executing populateHSQLDatabaseWindows.bat"
cd target/hsqlServer/
java -jar sqltool.jar --inlineRC=url=jdbc:hsqldb:hsql://%3:%4/%5,user=%6,password=%7 ../../../../%1 ../../../../%2
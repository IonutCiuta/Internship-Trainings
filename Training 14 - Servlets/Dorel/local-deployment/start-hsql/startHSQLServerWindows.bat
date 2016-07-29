@echo on
REM Parameters: ${hsql.port} ${hsql.database.file.name} ${hsql.database.name}
echo "Executing startHSQLServerWindows.bat"
cd target/hsqlServer/
java -Xmx512M -classpath hsqldb.jar org.hsqldb.server.Server --port %1 --database.0 file:%2 --dbname.0 %3
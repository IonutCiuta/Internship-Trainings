@echo on
echo "Executing start-servers.bat"
taskkill /f /fi "pid gt 0" /im java.exe
mvn clean install
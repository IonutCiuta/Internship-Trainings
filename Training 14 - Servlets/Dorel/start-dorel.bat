@echo on
echo "Executing start-dorel.bat"
taskkill /f /fi "pid gt 0" /im java.exe
mvn clean install
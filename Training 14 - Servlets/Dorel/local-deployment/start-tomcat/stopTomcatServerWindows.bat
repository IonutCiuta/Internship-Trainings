@echo on
echo "Executing stopTomcatServerWindows.bat"
echo %1
REM Kill process by port %1. 
REM Depending on the version of Windows the value of the 'tokens' property might be 4 or 5
FOR /F "tokens=5 delims= " %%P IN ('netstat -a -n -o ^| findstr :%1') DO TaskKill.exe /F /FI "PID gt 0" /PID %%P
FOR /F "tokens=4 delims= " %%P IN ('netstat -a -n -o ^| findstr :%1') DO TaskKill.exe /F /FI "PID gt 0" /PID %%P
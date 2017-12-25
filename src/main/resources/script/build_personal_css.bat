@echo off

REM settaggi
SET JAVA_DIR=C:\Program Files\Java\jdk1.7.0_80\bin\
SET CLASSPATH=%CLASSPATH%;lib\*
REM "%JAVA_DIR%\java" -version

SET START_TIME=%date:~-4%.%date:~3,2%.%date:~0,2%.%time:~0,2%.%time:~3,2%.%time:~6,2%
echo "Started process at %START_TIME% 
"%JAVA_DIR%\java" -jar ".\lib\buildCSS-1.0.jar"  -cp "\lib\" -conf "./conf/environment.properties"
SET END_TIME=%date:~-4%.%date:~3,2%.%date:~0,2%.%time:~0,2%.%time:~3,2%.%time:~6,2%
echo "Runned process between %START_TIME% AND %END_TIME%" 

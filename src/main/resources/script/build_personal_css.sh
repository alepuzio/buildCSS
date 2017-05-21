#!/bin/sh
echo Start script Diagnostico Posizioni:  "$(date)"
                      
oggi=$(date +"%Y-%m-%d")
now=$(date +"%Y.%m.%d.%H.%M")

CLASSPATH=$CLASSPATH:lib/*
CLASSPATH=$CLASSPATH:coresystem-batch-0.0.1-SNAPSHOT.jar

echo Start Diagnostico Posizioni:  "$(date)"


# ---TODO: set path to java---
java "-Dpath.environment.properties=conf/environment.properties" "-Dpath.database.properties=conf/database.properties" "-Dlogback.configurationFile=conf/logConfig/logback-diagnosticoPosizioni.xml" -cp "lib/*;coresystem-batch-0.0.1-SNAPSHOT.jar" org.springframework.batch.core.launch.support.CommandLineJobRunner /META-INF/spring/launchContext.xml jobDiagnosticoPosizioniBatch schedule.timeExcetuion=$now

javarc=$?             

echo Stop  Diagnostico Posizioni:  "$(date)"

exit ${javarc}

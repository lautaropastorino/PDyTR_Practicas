#!/bin/bash

java -cp ../jade/lib/jade.jar:classes jade.Boot -gui -container  &
java -cp ../jade/lib/jade.jar:classes jade.Boot -gui -container  &
java -cp ../jade/lib/jade.jar:classes jade.Boot -gui -container  &
java -cp ../jade/lib/jade.jar:classes jade.Boot -gui -container  &
java -cp ../jade/lib/jade.jar:classes jade.Boot -gui -container  &

java -cp ../jade/lib/jade.jar:../jade/lib/commons-codec-1.15/commons-codec-1.15.jar:../jade/classes/ jade.Boot -container -host localhost -agents FSA:ejercicio3.FileServerAgent

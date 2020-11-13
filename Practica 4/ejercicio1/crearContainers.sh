#!/bin/bash

# Creacion de los containers que recorreremos

#java -cp ../jade/lib/jade.jar jade.Boot -gui -host &
#java -cp ../jade/lib/jade.jar jade.Boot -gui -host 172.17.0.2 &
java -cp ../jade/lib/jade.jar:classes jade.Boot -gui -container -host localhost &
java -cp ../jade/lib/jade.jar:classes jade.Boot -gui -container -host localhost &
java -cp ../jade/lib/jade.jar:classes jade.Boot -gui -container -host localhost &
java -cp ../jade/lib/jade.jar:classes jade.Boot -gui -container -host localhost &
java -cp ../jade/lib/jade.jar:classes jade.Boot -gui -container -host localhost &
java -cp ../jade/lib/jade.jar:classes:classes/ejercicio1 jade.Boot -gui -container -host localhost -agents age:Agente 







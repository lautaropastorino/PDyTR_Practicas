#!/bin/bash

# Creacion de los containers que recorreremos

java -cp ../jade/lib/jade.jar:classes jade.Boot -gui -container  &
java -cp ../jade/lib/jade.jar:classes jade.Boot -gui -container  &
java -cp ../jade/lib/jade.jar:classes jade.Boot -gui -container  &
java -cp ../jade/lib/jade.jar:classes jade.Boot -gui -container  &
java -cp ../jade/lib/jade.jar:classes jade.Boot -gui -container  &

sleep 3 # Así se crean bien los containers

# Hay que cambiar el puerto porque el 1099 ya va a estar ocupado
java -cp ../jade/lib/jade.jar:../jade/classes jade.Boot -gui -container -agents ej1:ejercicio1.Agente -local-port 1234






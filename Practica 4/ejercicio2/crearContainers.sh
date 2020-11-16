#!/bin/bash

# Creo el container al que migraremos

java -cp ../jade/lib/jade.jar:classes jade.Boot -gui -container  &

sleep 3 # Así se crea bien el container

# Hay que cambiar el puerto porque el 1099 ya va a estar ocupado
java -cp ../jade/lib/jade.jar:../jade/classes jade.Boot -gui -container -agents 'ej2:ejercicio2.AgenteEj2(Container-1 archivo.txt)' -local-port 1234






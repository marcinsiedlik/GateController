#include <Arduino.h>
#include "FirebaseConnection.h"
#include "GateRemote.h"

FirebaseConnection connection;
GateRemote remote(D5, D6);

void setup()
{
  Serial.begin(9600);
  connection.connect();
}

void loop()
{
}
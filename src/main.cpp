#include <Arduino.h>
#include "FirebaseConnection.h"

FirebaseConnection connection;

void setup()
{
  Serial.begin(9600);
  connection.begin();
}

String gateStateToString(GateState state)
{
  switch (state)
  {
  case GateState::OPENING:
    return "OPENING";
  case GateState::CLOSING:
    return "CLOSING";
  default:
    return "NOT_MOVING";
  }
}

void loop()
{
  Serial.println(gateStateToString(connection.getGateState()));
Serial.println(connection.getGateOpenRequest());
  Serial.println(connection.getGateCloseRequest());
  delay(1000);
}
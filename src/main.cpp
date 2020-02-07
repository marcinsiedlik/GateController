#include <Arduino.h>
#include "FirebaseConnection.h"
#include "GateRemote.h"

FirebaseConnection connection;
GateRemote remote(D5, D6);

void handleOpenGateRequests();
void handleCloseGateRequests();
void delayedGateStateReset();

void setup()
{
  Serial.begin(9600);
  connection.connect();
}

void loop()
{
  handleOpenGateRequests();
  handleCloseGateRequests();

  //Added to save some mobile data
  delay(2000);
}

void handleOpenGateRequests()
{
  if (connection.getGateOpenRequest())
  {
    connection.setGateOpenValue(false);
    remote.pressOpenButton();
    connection.setGateState(GateState::OPENING);
    delayedGateStateReset();
  }
}

void handleCloseGateRequests()
{
  if (connection.getGateCloseRequest())
  {
    connection.setGateCloseValue(false);
    remote.pressCloseButton();
    connection.setGateState(GateState::CLOSING);
    delayedGateStateReset();
  }
}

void delayedGateStateReset()
{
  delay(16000);
  connection.setGateState(GateState::NOT_MOVING);
}
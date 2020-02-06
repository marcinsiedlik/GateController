#include "FirebaseESP8266.h"
#include <ESP8266WiFi.h>
#include "GateState.h"

#ifndef FirebaseConnection_H
#define FirebaseConnection_H

class FirebaseConnection
{
    FirebaseData firebaseData;
    void initWifiConnection();
    void initFirebaseConnection();

public:
    FirebaseConnection();
    bool getGateOpenRequest();
    bool getGateCloseRequest();
    void setGateOpenValue(bool value);
    void setGateCloseValue(bool value);
};

#endif
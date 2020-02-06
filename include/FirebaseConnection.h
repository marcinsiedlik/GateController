#include "FirebaseESP8266.h"
#include <ESP8266WiFi.h>
#include "GateState.h"

#ifndef FirebaseConnection_H
#define FirebaseConnection_H

class FirebaseConnection
{
    static const String GATE_OPEN_PATH;
    static const String GATE_CLOSE_PATH;
    static const String GATE_STATE_PATH;

    FirebaseData firebaseData;

    void initWifiConnection();
    void initFirebaseConnection();
    bool getPathBoolean(const String path);
    void setPathBoolean(const String path, bool value);
    void setPathString(const String path, String value);

public:
    FirebaseConnection();
    void begin();
    bool getGateOpenRequest();
    bool getGateCloseRequest();
    GateState getGateState();
    void setGateOpenValue(bool value);
    void setGateCloseValue(bool value);
    void setGateState(GateState state);
};

#endif
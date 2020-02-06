#include "FirebaseConnection.h"
#include "Credentials.h"

#define GATE_OPEN_PATH "/open_request"
#define GATE_CLOSE_PATH "/close_request"
#define GATE_STATE_PATH "/gate_state"

void FirebaseConnection::connect()
{
    initWifiConnection();
    initFirebaseConnection();
}

void FirebaseConnection::initWifiConnection()
{
    WiFi.begin(WIFI_SSID, WIFI_PASSWORD);
    while (WiFi.status() != WL_CONNECTED)
    {
        delay(500);
    }
    Serial.print("Connected with IP: ");
    Serial.println(WiFi.localIP());
}

void FirebaseConnection::initFirebaseConnection()
{
    Firebase.begin(FIREBASE_HOST, FIREBASE_AUTH);
    Firebase.reconnectWiFi(true);
    Firebase.setMaxRetry(this->firebaseData, 5);
}

bool FirebaseConnection::getGateOpenRequest()
{
    return this->getPathBoolean(GATE_OPEN_PATH);
}

bool FirebaseConnection::getGateCloseRequest()
{
    return this->getPathBoolean(GATE_CLOSE_PATH);
}

GateState FirebaseConnection::getGateState()
{
    if (Firebase.getString(this->firebaseData, GATE_STATE_PATH))
    {
        if (this->firebaseData.dataType() == "string")
        {
            String gateState = this->firebaseData.stringData();
            if (gateState == "OPENING")
                return GateState::OPENING;
            if (gateState == "CLOSING")
                return GateState::CLOSING;
            if (gateState == "NOT_MOVING")
                return GateState::NOT_MOVING;
        }
    }
    return GateState::NOT_MOVING;
}

void FirebaseConnection::setGateOpenValue(bool value)
{
    this->setPathBoolean(GATE_OPEN_PATH, value);
}

void FirebaseConnection::setGateCloseValue(bool value)
{
    this->setPathBoolean(GATE_CLOSE_PATH, value);
}

void FirebaseConnection::setGateState(GateState state)
{
    switch (state)
    {
    case GateState::OPENING:
        this->setPathString(GATE_STATE_PATH, "OPENING");
        break;
    case GateState::CLOSING:
        this->setPathString(GATE_STATE_PATH, "CLOSING");
        break;
    case GateState::NOT_MOVING:
        this->setPathString(GATE_STATE_PATH, "NOT_MOVING");
        break;
    default:
        return;
    }
}

bool FirebaseConnection::getPathBoolean(const String path)
{
    if (Firebase.getBool(this->firebaseData, path))
    {
        if (this->firebaseData.dataType() == "boolean")
            return this->firebaseData.boolData();
    }
    return false;
}

void FirebaseConnection::setPathBoolean(const String path, bool value)
{
    Firebase.setBool(this->firebaseData, path, value);
}

void FirebaseConnection::setPathString(const String path, String value)
{
    Firebase.setString(this->firebaseData, path, value);
}

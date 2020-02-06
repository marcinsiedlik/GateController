#include "FirebaseConnection.h"
#include "Credentials.h"

#define FIREBASE_GATE_OPEN_PATH "/open_request"
#define FIREBASE_GATE_CLOSE_PATH "/close_request"

FirebaseConnection::FirebaseConnection()
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
    Firebase.setMaxRetry(firebaseData, 5);
}
#include "FirebaseConnection.h"
#include "FirebaseESP8266.h"
#include <ESP8266WiFi.h>

class FirebaseConnection
{
    FirebaseData firebaseData();

    void initWifiConnection()
    {
        WiFi.begin(WIFI_SSID, WIFI_PASSWORD);
        while (WiFi.status() != WL_CONNECTED)
        {
            Serial.print(".");
            delay(500);
        }
        Serial.println("Connected with IP: ");
        Serial.println(WiFi.localIP());
    }

    void initFirebaseConnection()
    {
        Firebase.begin(FIREBASE_HOST, FIREBASE_AUTH);
        Firebase.reconnectWiFi(true);
        Firebase.setMaxRetry(firebaseData, 5);
    }

public:
    FirebaseConnection()
    {
        initWifiConnection();
        initFirebaseConnection();
    };
};
#include "GateRemote.h"
#include "Arduino.h"

GateRemote::GateRemote(uint8_t openPin, uint8_t closePin)
{
    this->openPin = openPin;
    this->closePin = closePin;
    initPinModes();
}

void GateRemote::initPinModes()
{
    pinMode(this->openPin, OUTPUT);
    pinMode(this->closePin, OUTPUT);
    pinMode(LED_BUILTIN, OUTPUT);
    digitalWrite(LED_BUILTIN, HIGH);
}

void GateRemote::pressOpenButton()
{
    this->pressButton(this->openPin);
}

void GateRemote::pressCloseButton()
{
    this->pressButton(this->closePin);
}

void GateRemote::pressButton(uint8_t buttonPin)
{
    this->blinkLed();
    digitalWrite(buttonPin, HIGH);
    delay(300);
    digitalWrite(buttonPin, LOW);
}

void GateRemote::blinkLed()
{
    digitalWrite(LED_BUILTIN, LOW);
    delay(100);
    digitalWrite(LED_BUILTIN, HIGH);
}
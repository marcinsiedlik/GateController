#include <stdint.h>

#ifndef GateRemote_H
#define GateRemote_H

class GateRemote
{
private:
    uint8_t openPin;
    uint8_t closePin;
    void initPinModes();
    void pressButton(uint8_t buttonPin);
    void blinkLed();

public:
    GateRemote(uint8_t openPin, uint8_t closePin);
    void pressOpenButton();
    void pressCloseButton();
};

#endif
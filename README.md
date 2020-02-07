# GateController

An simple app for controlling gate remote for ESP8266 written in Arduino framework and utilizing Firease Realtime Database.

## Requirements

* ESP8266 board - WEMOS D1 in this case
* [PlatformIO IDE](https://platformio.org/platformio-ide) (plugin for VS Code/Atom)
* Installed [Firebase ESP8266 Client](https://platformio.org/lib/show/6247/Firebase%20ESP8266%20Client) library

## Run

Just import project to IDE, set your Wifi and Firebase credentials in `Credentials.h` compile code and upload to the board

## Fireabse Database Structure

    /
        /close_request: Boolean
    	/open_request: Boolean
    	/gate_state: Enum

//
// Copyright 2015 Google Inc.
//
// Licensed under the Apache License, Version 2.0 (the "License");
// you may not use this file except in compliance with the License.
// You may obtain a copy of the License at
//
//     http://www.apache.org/licenses/LICENSE-2.0
//
// Unless required by applicable law or agreed to in writing, software
// distributed under the License is distributed on an "AS IS" BASIS,
// WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// See the License for the specific language governing permissions and
// limitations under the License.
//

// FirebaseDemo_ESP8266 is a sample that demo the different functions
// of the FirebaseArduino API.

#include <ESP8266WiFi.h>
#include <FirebaseArduino.h>

// Set these to run example.
//#define FIREBASE_HOST "techeventr.firebaseio.com/"
#define FIREBASE_HOST "FIREBASE_HOST.firebaseio.com"
#define FIREBASE_AUTH "FIREBASE_AUTH"

#define WIFI_SSID "WIFI_SSID"
#define WIFI_PASSWORD "WIFI_PASSWORD"

String ptr[7];

void setup() {
  Serial.begin(9600);
  pinMode(LED_BUILTIN, OUTPUT);     // Initialize the LED_BUILTIN pin as an output
  digitalWrite(LED_BUILTIN, HIGH);
  // connect to wifi.
  WiFi.begin(WIFI_SSID, WIFI_PASSWORD);
  Serial.print("connecting");
  while (WiFi.status() != WL_CONNECTED) {
    Serial.print(".");
    delay(500);
  }
  Serial.println();
  Serial.print("connected: ");
  Serial.println(WiFi.localIP());

  Firebase.begin(FIREBASE_HOST, FIREBASE_AUTH);

  delay(300);
  for (int il = 1; il < 7; il++) {
    String num = "num";
    num += il;
    String asd = Firebase.getString(num);
    ptr[il] = asd;
    Serial.println("------");
    komutIsle(ptr[il], il);
    Serial.print(num);
    Serial.print("  :");
    Serial.println( ptr[il]);
  }

}

int n = 0;


void loop() {
  for (int il = 1; il < 7; il++) {
    String num = "num";
    num += il;
    String asd = Firebase.getString(num);

    if (ptr[il] != asd) {
      Serial.print(num);
      Serial.print("  :");
      Serial.println(asd);
      ptr[il] = asd;
      komutIsle(ptr[il], il);
    }
  }
}
void komutIsle(String data , int dt) {
  String komutGonder = "rly";
  komutGonder += dt;
  if (data == "true") {
    komutGonder += "on\n";
    Serial.print(komutGonder);
    // digitalWrite(LED_BUILTIN, LOW);  // Turn the LED off by making the voltage HIGH
  }
  if (data == "false") {
    komutGonder += "off\n";
    Serial.print(komutGonder);
    //  digitalWrite(LED_BUILTIN, HIGH);   // Turn the LED on (Note that LOW is the voltage level
  }
}


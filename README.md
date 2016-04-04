# random-repo

Airports data from http://ourairports.com/data/ (released under public domain)

## Building

To build the project on Linux execute the following on shell: ```./gradlew clean jar```

To build the project on Windows execute the following on command line prompt: ```gradle.exe clean jar```

## Running

To execute use the following syntax: ```Usage: java -jar <jar filename> [query <country>|reports]```. The country may be a two letters code (i.e. BR or NL) or at least the first three letters of the country's name (i.e. Bra returns data from Brazil).

Example: ```java -jar lunatech-assesment.jar query argentina```

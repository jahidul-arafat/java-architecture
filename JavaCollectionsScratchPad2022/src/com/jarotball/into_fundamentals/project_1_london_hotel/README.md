#### Problem Statement:
The London Hotel would like to manage the rooms and understand the potential 
revenue from them being booked.

```aidl
# Expected Output
Welcome to London Hotel
Initializing Room Management System ...
Adding 8 rooms into the RMS....Existing Inventory Size: 8
After adding new Rooms (rms.createRoom()), Inventory Size: 15

Adding the roomArray into the room inventory ...
After adding new Rooms (rms.createRoom(Room[] roomArray)): 24

Deleting Room (R16) from Management SystemAfter delete ops, Room Count: 23

Checking inventory if a room exists ....!!!
Room/(R16) Exists: false 
Room/(R14) Exists: true 

Getting all rooms as Array in the order_of_add

Potential Revenue By Type: {3star=1460.0, 2star=2120.0, 4star=840.0, 5star=1750.0, 1star=1300.0}
Total Room Count by Type: {3star=6, 2star=8, 4star=2, 5star=4, 1star=3}
Average Room rate by Type: {3star=243.0, 2star=265.0, 4star=420.0, 5star=438.0, 1star=433.0}
Average Room rate by Type: OptionalDouble[324.7826086956522]

Searching for Rooms of Type ....
[Kolly, R5, R7]

Searching rooms by capacity ...
[Polly, Solly]

Process finished with exit code 0

```
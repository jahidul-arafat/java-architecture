# London Hotel Guest Checkinlist by LoyaltyProgramMember

```aidl
// 1.1 billy and dilly came to the London hotel lobby for checkin, billy comes first
0: Billy
1: Dilly
------

// 1.2 Now suddenly cilly, who is a loyaltyProgramMember came for checkin.
// Constrain: A loyalty program member has preferences in checkin over the non-loyalty program member
// so, cilly being loyalty_program_member will become first in the checkin list
0: Cilly
1: Billy
2: Dilly
-------

// 1.3 Seeing, the benefits of being a loyalty_program_member,
// Dilly --> decided to become loyalty_program_member
// eventually, eilly (loyaltyProgramMember)--> comes to lobby for checkin; but Dilly already become a loyalty program member
0: Cilly
1: Dilly
2: Eilly
3: Billy
4: Dilly
-------

// 1.4 an earlier non-loyalty Dilly (Duplicate) exists ; Remove this
0: Cilly
1: Dilly
2: Eilly
3: Billy
-------

// 1.5 Now Billy who came first for checkin, becomes confused and wants to know his serial
Mr. Billy , your checkin serial is pos 4
```
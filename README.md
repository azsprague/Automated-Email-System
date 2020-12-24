# Automated Email System
## Overview
This is a software system that allows the user to create an email reminder to be sent to any number
of recipients at a given time of day. As long as the program is running, the reminders will continue
to be sent; this allows for either a one-time or daily reminder. The system can only be run from a
Gmail account, no others will (currently) work.

The system is run from the Runner class. From the command line, it can be executed with 0 or 1 
parameters. Using no parameters will prompt the user to input desired information at the command
line one by one; otherwise, the name of a file can be provided and the script will read directly
from it. Keep in mind, the fields must be in the following order:
1. Header
2. Body
3. Your Email
4. Your Password
5. Recipients (separated with spaces)
6. Time of Reminder (24h, format HH:MM:SS)

## Libraries
Several external libraries are used, chiefly JavaMail. To use this library, download it here:
https://javaee.github.io/javamail/ and add it to the buildpath.

## Notes
There are many things that could be improved with the system; chiefly, NOT storing user passwords in
memory (especially for a prolonged amount of time). Additional features could also be implemented
such as multiple messages, quicker frequency, and better password protection.  
  
NOTE: Messages can be sent as texts if you postfix a phone number with the proper provider email
(i.e. @vtext.com, @txt.att.net, etc). This can be more useful than an email reminder.

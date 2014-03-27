FlashRemote
===========

FlashRemote uses WebSockets and Java to send keystrokes in real time to your computer from any mobile device.

 + Send Keystrokes remotely from any computer / mobile device

 + Cross Platform - All you need is Java

 + Use a smartphone to advance PowerPoints!
  
On PC / Mac
-----------
On the machine that will RECEIVE the keystrokes, Build and run the Client Jar.  Main method is in /src/Client/Gui.java.  You need Java 7 to run this. Java is what keeps FlashRemote simple and flexible.

On Mobile
----------
In any web browser, go to rsmc.tk/socket. Start the desktop client first, and it will give you a UUID to enter.

Thanks to...
---------
The web end implements the fastclick library from https://github.com/ftlabs/fastclick

Thanks to @TooTallNate for the Java WebSocket Library at https://github.com/TooTallNate/Java-WebSocket

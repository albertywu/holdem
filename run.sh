
#!/bin/bash

javac poker/*.java poker/actions/*.java 
java poker.Game
rm -rf poker/*.class poker/actions/*.class

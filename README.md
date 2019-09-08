# ToyRobotSimulator
Zone Digital Technical Test

Java implementation of the Toy Robot Simulator technical test for Zone Digital

The implemenation has a REPL for interacting with the robot on the 5x5 grid, as well as support for loading a series of
commands from a file.

The project can be build by cloning the repo and executing the  ``` mvn clean install  ``` command.

When the application compiles the application is packaged as a jar.

To run the app via the command line navigate to the generated target folder and execute the following command to start the REPL

 ``` java -cp ToyRobotSimulator-0.0.1-SNAPSHOT.jar com.zonedigital.toyrobotsimulator.repl.ToyRobotSimulator  ```

if successful you'll be greeted with a startup message and a prompt, help commands can be listed at any point entering --help at
the prompt

# Improvements
While the code is compact, with more time improvments could no doubt be found by running static analysis tools on the codebase to assist in identifying optimisations.

Test coverage could be improved.

The modular nature of the code base means it should be easy to add a UI to represent the state of the play area, or expose the 
commands via a REST service to enable the game to be played by any device capable of running a rest client remotely over the internet.

# WolframCellularAutomaton
This is some demos and source code based on the concept of the elementary cellular automaton from Stephan Wolfram. It contains a runnable text demo showing that it functions properly using the classes I created.

## CellFactory
This contains one function, used to generate a cell based on a rule and its parents. It uses a helper function which gets the nth bit of a number. This is used to get the child based on the parent, getting the parent bit of the rule number yields the correct child.

## GenerationFactory
This contains two functions. The first, generateChildren, takes in a generation of parents as well as the rule number to generate the resulting children. The second, creatGeneration, takes in the rule, number of generations, and the width(size of each generation), and uses that to make an array of Cell generations.

This factory is particularly important, and can be used generally for displaying or future computation in other demos or applications.

# Demos
This repository contains two main examples based on the java implementation, the first is a text based one for testing and simple demonstration, and a graphical one which can show any of the 256 rules with a set width for each cell and a number of generations.

## Usage
The Runner file can be run as is, and can be modified to show other generations or rules.
The GraphicsRunner needs three command line args: rule(0-255), width(> zero), and generation(> zero). There is no checking in place for these requirements, the demo is a simple one, and this type of checking can be done in future demos or as seperate work. 

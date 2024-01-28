THIS WAS A COLLEGE PROJECT.

## Program

It takes a city, expressed as buildings with an initial x, a final x and a height and outputs its skyline, expressed as a series of inflection points given by two coordinates.  
To accomplish that, it divides the problem recursively till the solution is trivial (the skyline of a single building). On its way back it reassembles tuples of skylines.

## Usage

Run the generator to create a .txt file that describes a valid randomly generated city that fits some parameters (configurable within the code). Run then the main program to get its skyline.  
I don't remember the exact possible combinations, but it can accept up to four arguments, in this order: -h for help, -t to activate a log, the path of the input file and the path of the output file. The input file is required.
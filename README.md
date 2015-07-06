![Campbell](http://public.pieterbos.me/campbell.png)

Campbell is a programming language with static typing and function-as-values.

# Compiling Campbell
Campbell compiles to SprIl using util.Main, which takes an input file ```input.ham``` as its first parameter and an output
file ```output.hs``` as its output. NB: the compiler needs all four jars included in the source archive.

The generated code in ```output.hs``` can be run by navigating the command line to
the source directory of sprockell (/sprockell/src), which is included in the supplied archive and running ghci. You
can then use ghci to load the compiled program (e.g. :l /src/examples/functions.hs) and typing the command main.
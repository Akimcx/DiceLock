OPTS = -Wall -Wextra
INC = ./raylib-5.0/include/
LIB = ./raylib-5.0/lib/

dice: dice.c
	cc $(OPTS) -o dice dice.c -I$(INC) -L$(LIB) -lraylib -lm

run: dice
	./dice

clean:
	rm dice

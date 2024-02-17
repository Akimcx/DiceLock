cli:
	javac -d bin/main -p $$HOME/programming/binaries/picocli-4.7.3.jar --module-source-path src/main --module cx.ksim.dicelock.core,cx.ksim.dicelock.cli
	cp src/main/cx.ksim.dicelock.core/resources/* bin/main/cx.ksim.dicelock.core/

gui:
	javac -d bin/main -p $$HOME/programming/binaries/javafx-sdk-17.0.7/lib/ --module-source-path src/main --module cx.ksim.dicelock.core,cx.ksim.dicelock.gui
	cp src/main/cx.ksim.dicelock.gui/cx/ksim/dicelock/gui/Layout.fxml bin/main/cx.ksim.dicelock.gui/cx/ksim/dicelock/gui/

test: cli
	javac -d bin/test -cp "bin/main/cx.ksim.dicelock.core:junit-platform-console-standalone-1.9.3.jar" `find src/test/ -name *.java`

run:
	java -p bin/main:$HOME/programming/binaries/picocli-4.7.3.jar -m cx.ksim.dicelock.cli/cx.ksim.dicelock.cli.DiceLockCLI $@

launch: gui
	java -p bin/main:$HOME/programming/binaries/javafx-sdk-17.0.7/lib -m cx.ksim.dicelock.gui/cx.ksim.dicelock.gui.Main

check: 
	java --add-opens cx.ksim.dicelock.core/cx.ksim.dicelock.core=ALL-UNNAMED  \
		--add-modules=cx.ksim.dicelock.core                              \
		-p bin/main                                                \
		--patch-module "cx.ksim.dicelock.core=$PWD/bin/test"            \
		--add-reads cx.ksim.dicelock.core=ALL-UNNAMED                   \
		-jar junit-platform-console-standalone-1.9.3.jar           \
		-e junit-jupiter                                           \
		-p cx.ksim.dicelock.core                                        \
		--reports-dir=reports

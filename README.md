# DiceLock

Passphrase generator app using the dicewar method

## Quick Start

```console
$ java java src/cx/ksim/dicelock/DiceLock.java
```

## Build yourself

```console
$ jar vcfe dicelock.jar cx.ksim.dicelock.DiceLock -C bin/ .
$ jpackage --name dicelock -p .\dicelock.jar -m DiceLock/cx.ksim.dicelock.DiceLock --app-version 1.0 --win-console --win-dir-chooser
```

# DiceLock

Passphrase generator app using the dicewar method

## Quick Start

```console
$ javac @compile-src
$ cp src/resources/* bin/main/cx.ksim.dicelock
$ java @run
```

## Test
Follow the step in `Quick Start` then run
```console
$ javac @compile-test
$ java @test
```

## Build yourself

```console
$ jar vcfe dicelock.jar cx.ksim.dicelock.DiceLock -C bin/ .
$ jpackage --name dicelock -p .\dicelock.jar -m DiceLock/cx.ksim.dicelock.DiceLock --app-version 1.0 --win-console --win-dir-chooser
```

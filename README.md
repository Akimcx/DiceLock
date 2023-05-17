[![.github/workflows/main.yml](https://github.com/Akimcx/DiceLock/actions/workflows/main.yml/badge.svg?event=pull_request)](https://github.com/Akimcx/DiceLock/actions/workflows/main.yml)
# DiceLock

Passphrase generator app using the dicewar method

## Test Summary
![test summary](https://camo.githubusercontent.com/810325957d5e9ea86aad9fb226caeb558eb21781bb64979ac8f0f2c8694f9043/68747470733a2f2f7376672e746573742d73756d6d6172792e636f6d2f64617368626f6172642e7376673f703d3326663d3026733d30)

## Quick Start

```console
$ javac @compile-src
$ cp src/resources/* bin/main/cx.ksim.dicelock
$ java @run
```

## Test
Follow the step in [Quick Start](#quick-start) then run
```console
$ javac @compile-test
$ java @test
```

## Build yourself

```console
$ jar vcfe dicelock.jar cx.ksim.dicelock.DiceLock -C bin/ .
$ jpackage --name dicelock -p .\dicelock.jar -m DiceLock/cx.ksim.dicelock.DiceLock --app-version 1.0 --win-console --win-dir-chooser
```

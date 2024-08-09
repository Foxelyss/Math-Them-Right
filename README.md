# Простая игра для J2ME "Посчитай их правильно"

Простая игра для устройств с поддержкой J2ME приложений. Может использоваться как болванка.

![Gameplay](https://foxelyss.github.io/assets/misc/maththemright1.png)

## Сборка

Для сборки нужен Nokia Series 40 SDK и [Apache Ant]. Нужно поменять эти переменные среды:
`NOKIA_SERIES40_SDK_PREVERIFY` и `NOKIA_SERIES40_SDK`, `JAVA_6_CMD`, на путь к вашей версии SDK, preverify.exe и java 1.6 соответственно.

Также измените вызовите ant как в этом примере.
```ps
PS Math-Them-Right> $env:NOKIA_SERIES40_SDK_PREVERIFY="C:\Nokia\Devices\S40_6th_Edition_SDK\bin\preverify.exe"
PS Math-Them-Right> $env:JAVA_6_CMD="C:\Program Files\Zulu\zulu-6\bin\javac.exe"
PS Math-Them-Right> $env:NOKIA_SERIES40_SDK="C:\Nokia\Devices\S40_6th_Edition_SDK"
PS Math-Them-Right> &"C:\Program Files\apache-ant\bin\ant.bat"
```

_J2ME Loader не работает с этим приложением, т.к. функционал используемый в этом примере не имеет хорошую поддержку.
Для тестирования лучше всегда используйте эмулятор предоставляемый с SDK, либо реальное устройство._

------

# Simple math game for J2ME!

Works on Symbian devices. Can be used as template for your applications.

## Building

To build this app you need to use Nokia Series 40 SDK, also [Apache Ant] and change these environment variables:
`NOKIA_SERIES40_SDK_PREVERIFY` и `NOKIA_SERIES40_SDK`, `JAVA_6_CMD`, to your SDK, preverify.exe and java 1.6 instance respectively.

Change `executable` to your preverify file or to `${sdk_location}\bin\preverify.exe`

```ps
PS Math-Them-Right> $env:NOKIA_SERIES40_SDK_PREVERIFY="C:\Nokia\Devices\S40_6th_Edition_SDK\bin\preverify.exe"
PS Math-Them-Right> $env:JAVA_6_CMD="C:\Program Files\Zulu\zulu-6\bin\javac.exe"
PS Math-Them-Right> $env:NOKIA_SERIES40_SDK="C:\Nokia\Devices\S40_6th_Edition_SDK"
PS Math-Them-Right> &"C:\Program Files\apache-ant\bin\ant.bat"
```

Then call `ant` as in example above.

_J2ME Loader is better working with graphics applications while this example doesn't work because it isn't one. 
J2ME Loader probably doesn't support `Form`s very well. 
To test apps better always use Nokia's SDK Emulator or real hardware._


[Apache Ant]:https://ant.apache.org/

# Простая игра для J2ME "Посчитай их правильно"

Простая игра для устройств с поддержкой J2ME приложений. Может использоваться как болванка.

![Gameplay](https://foxelyss.github.io/assets/misc/maththemright1.png)

## Сборка

Для сборки нужен Nokia Series 40 SDK и [Apache Ant]. Нужно поменять эти переменные в файле `targets/build.xml`:
`sdk_location`, `java_cmd` на ваш SDK и java 1.6 соответственно.

Также измените `executable` на ваш путь к вашему файлу `preverify.exe`, либо на `${sdk_location}\bin\preverify.exe`
```xml
<target name="preverify">

    <mkdir dir="${preverified}"/>
    <exec executable="./targets/preverify.sh"  failonerror="true">
	
      <arg line="-classpath ${myclasspath}"/>
      <arg line="-d ${preverified}"/>
      <arg line="${classes}"/>
    </exec>
    <copy todir="${preverified}"  failonerror="false">
      <fileset dir="${src}" excludes="**/*.java"/>
    </copy>
</target>
```

Затем запустите `ant` в директории `targets`.

_J2ME Loader не работает с этим приложением, т.к. функционал используемый в этом примере не имеет хорошую поддержку.
Для тестирования лучше используйте эмулятор предоставляемый с SDK, либо реальное устройство._

------

# Simple math game for J2ME!

Works on Symbian devices. Can be used as template for your applications.

## Building

To build this app you need to use Nokia Series 40 SDK, also [Apache Ant] and change variables in `targets/build.xml`: `sdk_location` and `java_cmd`
to your SDK and java 1.6 instance respectively.

Change `executable` to your preverify file or to `${sdk_location}\bin\preverify.exe`
```xml
<target name="preverify">

    <mkdir dir="${preverified}"/>
    <exec executable="./targets/preverify.sh"  failonerror="true">
	
      <arg line="-classpath ${myclasspath}"/>
      <arg line="-d ${preverified}"/>
      <arg line="${classes}"/>
    </exec>
    <copy todir="${preverified}"  failonerror="false">
      <fileset dir="${src}" excludes="**/*.java"/>
    </copy>
</target>
```

Then call `ant` in `targets` directory.

_J2ME Loader is better working with graphics applications while this example doesn't work because it isn't one. 
J2ME Loader probably doesn't support `Form`s very well. 
To test apps better always use Nokia's SDK Emulator or real hardware._


[Apache Ant]:https://ant.apache.org/

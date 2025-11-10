@echo off
chcp 65001 >nul
echo.
echo ====================================
echo    CORRIGINDO GRADLE WRAPPER
echo ====================================
echo.

echo 📱 Configurando Gradle para o BarberApp...
echo.

:: Verificar se está na pasta correta
if not exist "app" (
    echo ❌ Pasta 'app' não encontrada!
    echo 💡 Certifique-se de estar na pasta BarberApp
    pause
    exit /b 1
)

:: Criar gradlew.bat se não existir
if not exist "gradlew.bat" (
    echo 📄 Criando gradlew.bat...
    (
        echo @if "%DEBUG%" == "" @echo off
        echo @rem ##########################################################################
        echo @rem
        echo @rem  Gradle startup script for Windows
        echo @rem
        echo @rem ##########################################################################
        echo.
        echo @rem Set local scope for the variables with windows NT shell
        echo if "%OS%"=="Windows_NT" setlocal
        echo.
        echo set DIRNAME=%%~dp0
        echo if "%%DIRNAME%%" == "" set DIRNAME=.
        echo set APP_BASE_NAME=%%~n0
        echo set APP_HOME=%%DIRNAME%%
        echo.
        echo @rem Add default JVM options here. You can also use JAVA_OPTS and GRADLE_OPTS to pass JVM options to this script.
        echo set DEFAULT_JVM_OPTS="-Xmx64m" "-Xms64m"
        echo.
        echo @rem Find java.exe
        echo if defined JAVA_HOME goto findJavaFromJavaHome
        echo.
        echo set JAVA_EXE=java.exe
        echo %%JAVA_EXE%% -version >NUL 2>&1
        echo if "%%ERRORLEVEL%%" == "0" goto execute
        echo.
        echo echo.
        echo echo ERROR: JAVA_HOME is not set and no 'java' command could be found in your PATH.
        echo echo.
        echo echo Please set the JAVA_HOME variable in your environment to match the
        echo echo location of your Java installation.
        echo.
        echo goto fail
        echo.
        echo :findJavaFromJavaHome
        echo set JAVA_HOME=%%JAVA_HOME:"=%%%
        echo set JAVA_EXE=%%JAVA_HOME%%/bin/java.exe
        echo.
        echo if exist "%%JAVA_EXE%%" goto execute
        echo.
        echo echo.
        echo echo ERROR: JAVA_HOME is set to an invalid directory: %%JAVA_HOME%%
        echo echo.
        echo echo Please set the JAVA_HOME variable in your environment to match the
        echo echo location of your Java installation.
        echo.
        echo goto fail
        echo.
        echo :execute
        echo @rem Setup the command line
        echo.
        echo set CLASSPATH=%%APP_HOME%%\gradle\wrapper\gradle-wrapper.jar
        echo.
        echo @rem Execute Gradle
        echo "%%JAVA_EXE%%" %%DEFAULT_JVM_OPTS%% %%JAVA_OPTS%% %%GRADLE_OPTS%% -classpath "%%CLASSPATH%%" org.gradle.wrapper.GradleWrapperMain %%
        echo.
        echo :end
        echo @rem End local scope for the variables with windows NT shell
        echo if "%%ERRORLEVEL%%"=="0" goto mainEnd
        echo.
        echo :fail
        echo rem Set variable GRADLE_EXIT_CONSOLE if you need the script to finish as well.
        echo set GRADLE_EXIT_CONSOLE=1
        echo exit /b 1
        echo.
        echo :mainEnd
        echo if "%%OS%%"=="Windows_NT" endlocal
        echo.
        echo :omega
    ) > "gradlew.bat"
)

:: Criar pasta gradle/wrapper se não existir
if not exist "gradle\wrapper" (
    mkdir "gradle\wrapper"
)

:: Criar gradle-wrapper.properties se não existir
if not exist "gradle\wrapper\gradle-wrapper.properties" (
    echo 📄 Criando gradle-wrapper.properties...
    (
        echo distributionBase=GRADLE_USER_HOME
        echo distributionPath=wrapper/dists
        echo distributionUrl=https\://services.gradle.org/distributions/gradle-8.0-bin.zip
        echo distributionSha256Sum=2351de4a2e1d0e87e42d6c6c6001595a078ec32a3aa4d2bd4d9838c894d9b6d9
        echo zipStoreBase=GRADLE_USER_HOME
        echo zipStorePath=wrapper/dists
    ) > "gradle\wrapper\gradle-wrapper.properties"
)

echo.
echo ✅ GRADLE CONFIGURADO!
echo 🚀 Agora execute: gradlew assembleDebug
echo.

pause
@echo off
title Laras Fantasy
cd /d "%~dp0"

echo Iniciando Laras Fantasy...
echo Carpeta: %cd%
echo.

REM Verifica Java
java -version
if errorlevel 1 (
  echo.
  echo ERROR: No se encontro Java. Instala Java 21 o agrega Java al PATH.
  pause
  exit /b
)

REM Inicia el jar en una nueva ventana (para que se quede corriendo)
start "LarasFantasy Server" cmd /k "cd /d %cd% && java -jar larasnetweb-0.0.1-SNAPSHOT.jar"

REM Espera un poco y abre el navegador
timeout /t 8 /nobreak >nul
start "" "http://localhost:8080"

echo.
echo Si ves "localhost rechazo la conexion", revisa la ventana "LarasFantasy Server" para ver el error.
pause

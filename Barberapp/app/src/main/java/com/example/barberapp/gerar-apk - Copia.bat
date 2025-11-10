@echo off
chcp 65001 >nul
echo.
echo ====================================
echo    CORRIGINDO ESTRUTURA DO PROJETO
echo ====================================
echo.

echo 🔧 Verificando estrutura de pastas...
if exist "app\app" (
    echo ❌ Estrutura duplicada encontrada!
    echo 📁 Corrigindo...

    if not exist "app-backup" (
        mkdir "app-backup"
    )

    echo Movendo arquivos...
    xcopy "app\app\*" "app\" /E /I /Y
    rmdir "app\app" /S /Q

    echo ✅ Estrutura corrigida!
) else (
    echo ✅ Estrutura já está correta!
)

echo.
echo 📋 Estrutura atual:
dir "app" /B

echo.
pause
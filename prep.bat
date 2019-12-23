@echo off

if not exist SistemaTesteGPU.jar (
    echo App SistemaTesteGPU.jar nao encontrado.
    pause > nul
    goto :eof
)

if not exist db.properties (
    echo Arquivo de configuracao db.properties nao foi encontrado.
    pause > nul
    goto :eof
)

java -jar SistemaTesteGPU.jar
echo.

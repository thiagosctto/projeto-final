# Configurações
$Data = Get-Date -Format "yyyyMMddHHmmss"  # Data atual para nomeação do arquivo
$BackupDir = "C:\Backups\Pixel_Mart"  # Diretório para armazenar backups
$LogFile = "C:\Backups\pixel_mart_backup.log"  # Arquivo de log
$DBName = "Pixel_Mart"  # Nome do banco de dados
$DBUser = "admin"  # Usuário do banco
$DBPass = "admin"  # Senha do banco
$DBHost = "localhost"  # Endereço do servidor PostgreSQL (alterado de Host para DBHost)

# Garantir que o diretório de backup exista
If (-Not (Test-Path $BackupDir)) {
    New-Item -Path $BackupDir -ItemType Directory
}

# Exportar senha para pg_dump
$Env:PGPASSWORD = $DBPass

# Realizar o backup
Add-Content $LogFile -Value ("[" + (Get-Date) + "] Iniciando backup do banco de dados " + $DBName)

# Comando pg_dump
& "C:\Program Files\PostgreSQL\13\bin\pg_dump.exe" -U $DBUser -h $DBHost -F c -b -v -f "$BackupDir\backup_$Data.sql" $DBName 2>> $LogFile

# Verificar se o backup foi bem-sucedido
If ($?) {
    Add-Content $LogFile -Value ("[" + (Get-Date) + "] Backup concluído com sucesso. Arquivo: backup_$Data.sql")
} Else {
    Add-Content $LogFile -Value ("[" + (Get-Date) + "] ERRO: Falha no backup do banco de dados $DBName")
}

# Remover backups antigos (manter 7 dias)
Get-ChildItem -Path $BackupDir -File | Where-Object { $_.LastWriteTime -lt (Get-Date).AddDays(-7) } | Remove-Item

Add-Content $LogFile -Value ("[" + (Get-Date) + "] Backups antigos removidos.")

<#
.SYNOPSIS
    Verifica se as ferramentas necessarias para o projeto estao instaladas e imprime suas versoes.
.DESCRIPTION
    Executa java -version, node -v, pnpm -v, docker version, git --version e gh --version.
    Se alguma ferramenta estiver ausente, o script falha (exit code 1).
#>

$ErrorActionPreference = 'Stop'

$tools = @(
    @{ Name = 'java';   Command = 'java';   Args = @('-version') }
    @{ Name = 'node';   Command = 'node';   Args = @('-v') }
    @{ Name = 'pnpm';   Command = 'pnpm';   Args = @('-v') }
    @{ Name = 'docker'; Command = 'docker'; Args = @('version') }
    @{ Name = 'git';    Command = 'git';    Args = @('--version') }
    @{ Name = 'gh';     Command = 'gh';     Args = @('--version') }
)

$missing = @()

foreach ($tool in $tools) {
    Write-Host "==> $($tool.Name)" -ForegroundColor Cyan

    $cmd = Get-Command $tool.Command -ErrorAction SilentlyContinue
    if (-not $cmd) {
        Write-Host "  NAO ENCONTRADO: $($tool.Command)" -ForegroundColor Red
        $missing += $tool.Name
        continue
    }

    & $tool.Command @($tool.Args)
    if ($LASTEXITCODE -ne 0) {
        Write-Host "  FALHOU (exit code $LASTEXITCODE): $($tool.Command)" -ForegroundColor Red
        $missing += $tool.Name
    }

    Write-Host ''
}

if ($missing.Count -gt 0) {
    Write-Host "Ferramentas ausentes ou com falha: $($missing -join ', ')" -ForegroundColor Red
    exit 1
}

Write-Host 'Todas as ferramentas necessarias estao instaladas.' -ForegroundColor Green
exit 0

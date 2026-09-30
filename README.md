# Agendify

> 🚧 **Em construção.** Este é um projeto de portfólio sendo desenvolvido publicamente, semana a semana. Acompanhe o progresso pelas [issues](../../issues) e [pull requests](../../pulls).

Plataforma SaaS de agendamento multi-tenant para pequenos negócios de serviços (barbearias, clínicas, estúdios, autônomos). Cada negócio publica sua agenda e seus clientes reservam horários por uma página pública, sem precisar criar conta.

<!-- Badges (adicionados conforme as tasks avançam):
- CI da API → T0.7
- CI do front → T7.2
- Cobertura de testes → T0.7
- Licença → já pode adicionar
-->

## Stack

- **Backend:** Java 21, Spring Boot 3, PostgreSQL, Flyway
- **Frontend:** Next.js (App Router), TypeScript, Tailwind, shadcn/ui
- **Infra local:** Docker Compose (Postgres, Mailpit, Prometheus/Grafana/Tempo)
- **CI/CD:** GitHub Actions
- **Deploy:** Azure Container Apps (feito só ao final do desenvolvimento local — ver [planejamento](#))

## Como rodar localmente

<!-- Preencher conforme o ambiente for ficando funcional (a partir da T0.4) -->

```bash
docker compose -f infra/docker-compose.yml up -d
# instruções completas de setup em docs/setup.md
```

## Status do projeto

Este projeto está sendo construído 100% localmente antes de qualquer publicação — veja o plano de tasks para o roadmap completo.

<!-- Quando publicado (Épico 9 / T9.6), esta seção vira:
## Demo
🔗 [link da demo] — credenciais de teste: usuário / senha
-->

## Licença

MIT

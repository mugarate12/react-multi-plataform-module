## Subindo ambiente local de desenvolvimento

> O objeto é subir um ambiente local com zabbix e módulo instalado no mesmo para desenvolvimento e testes fora do ambiente de produção

Créditos ao `Thiago Santos`, pela configuração base do Zabbix via Docker-Compose: [Repositório](https://github.com/zthiagosantos/zbx-server-docker). A partir dele foi possível montar este ambiente de desenvolvimento.

- [GitHub - Thiago Santos](https://github.com/zthiagosantos)
- [Linkedin - Thiago Santos](https://www.linkedin.com/in/thiago-souza-694057212)

### Requisitos

- Docker
- Docker-Compose
- Makefile (opcional)

### Rodando ambiente de desenvolvimento

> Ao final do processo o Zabbix irá estar disponível em: `http://localhost:80`
> Usuário: `Admin` | Senha: `zabbix`

1. Clone este repositório
2. Acesse o diretório do projeto clonado
3. Execute um dos comandos abaixo:

   ```bash
   make run-dev
   ```

   ou

   ```bash
   docker compose -f ./infra/compose.yml up --build -d
   ```

4. Aguarde alguns instantes até que os containers estejam totalmente iniciados.
5. Realize as configurações necessárias no Zabbix e instale o módulo conforme a documentação [Registrando módulo](https://www.zabbix.com/documentation/current/en/devel/modules/file_structure/register)
6. O modulo se encontrará em:

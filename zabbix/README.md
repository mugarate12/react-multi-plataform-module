# Ambiente Zabbix

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

   <img src="./../docs/images/onde-o-modulo-se-encontra.png" alt="onde o módulo se encontra" />

## Em Produção

> Vamos assumir que você já tenha um servidor Zabbix rodando em produção.

1. Clone esse repositório no servidor onde o Zabbix está instalado.

2. Navegue até o diretório do módulo clonado.

3. Crie um arquivo `.env` na raiz do diretório do módulo (neste projeto, a pasta zabbix-module) com as variáveis de ambiente necessárias para o funcionamento do módulo. Exemplo:

> Você encontrará um arquivo `.env.example` no lugar para referência.

```env
VITE_IFRAME_URL=http://seu-endereco-do-app-react
```

4. Copie o arquivo do módulo para o diretório de módulos do Zabbix. Normalmente, esse diretório está localizado em `/usr/lib/zabbix/modules/` ou `/usr/local/lib/zabbix/modules/` ou `/usr/share/zabbix/modules`, dependendo da sua instalação.

   ```bash
   cp path/to/cloned/repo/zabbix_module.so/zabbix/zabbix-module /usr/lib/zabbix/modules/React
   ```

5. Ajuste as permissões do arquivo do módulo para garantir que o usuário que executa o Zabbix tenha acesso a ele:

   ```bash
    chown zabbix:zabbix /usr/lib/zabbix/modules/React
    chmod 755 /usr/lib/zabbix/modules/React
   ```

6. Realize as configurações necessárias no Zabbix e instale o módulo conforme a documentação [Registrando módulo](https://www.zabbix.com/documentation/current/en/devel/modules/file_structure/register)

7. O modulo se encontrará em:

   <img src="./../docs/images/onde-o-modulo-se-encontra.png" alt="onde o módulo se encontra" />

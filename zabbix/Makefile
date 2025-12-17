run-zabbix:
# 	cd app && npm run build
# 	powershell -Command "Remove-Item -Path ./zabbix-module/dist* -Recurse -Force"
# 	powershell -Command "Copy-Item -Path ./app/dist/* -Destination ./zabbix-module/dist -Recurse -Force"
	docker compose -f ./infra/compose.yml up --build -d

stop-zabbix:
	docker compose -f ./infra/compose.yml down

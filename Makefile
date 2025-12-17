build-android:
	npm run build
	rm -rf ./android/app/src/main/assets/*
	cp -r ./dist ./android/app/src/main/assets

build-android-powershell:
	npm run build
	powershell -Command "New-Item -ItemType Directory -Force -Path ./android/app/src/main/assets"
	powershell -Command "Remove-Item -Path ./android/app/src/main/assets/* -Recurse -Force"
	powershell -Command "Copy-Item -Path ./dist/* -Destination ./android/app/src/main/assets -Recurse -Force"

build-apk-powershell:
	npm run build
	powershell -Command "New-Item -ItemType Directory -Force -Path ./android/app/src/main/assets"
	powershell -Command "Remove-Item -Path ./android/app/src/main/assets/* -Recurse -Force"
	powershell -Command "Copy-Item -Path ./dist/* -Destination ./android/app/src/main/assets -Recurse -Force"
	docker compose -f .\compose.yml run --rm build-android

build-zabbix-powershell:
	npm run build
	powershell -Command "New-Item -ItemType Directory -Force -Path ./zabbix/zabbix-module/assets"
	powershell -Command "Remove-Item -Path ./zabbix/zabbix-module/assets/* -Recurse -Force"
	powershell -Command "Copy-Item -Path ./dist/* -Destination ./zabbix/zabbix-module/assets -Recurse -Force"
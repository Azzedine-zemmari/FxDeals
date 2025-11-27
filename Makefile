APP_NAME = deal-app
MYSQL_CONTAINER = progressoft-mysql
NETWORK = progres-net
MYSQL_IMAGE = mysql:8.0
SPRING_IMAGE = docker.io/azzedine122/progresssoft-app
DB_NAME = deal_db
DB_USER = user
DB_PASSWORD = userpass
ROOT_PASSWORD = root
APP_PORT = 8090
MYSQL_PORT = 3307


start-app:
	docker compose up --build

test:
	mvn test

# Makefile são TAB-SENSITIVE!
# Tome muito CUIDADO em não confundir espaços com tabs
# Isso aqui são   4 espaços:    |
# Isso aqui é     1     tab:	|



run:
	rm -f sqlite3.db
	   mvn package \
	&& java -cp target/SwiftLog-1.0-SNAPSHOT.jar br.com.ies.core.Main

test:
	rm -f sqlite3.db
	mvn test

clean:
	rm -f sqlite3.db
	mvn clean



.PHONY: run test clean

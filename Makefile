# Makefile são TAB-SENSITIVE!
# Tome muito CUIDADO em não confundir espaços com tabs
# Isso aqui são   4 espaços:    |
# Isso aqui é     1     tab:	|



run:
	mvn package
	java -cp target/SwiftLog-1.0-SNAPSHOT.jar br.com.ies.core.Main

clean:
	mvn clean

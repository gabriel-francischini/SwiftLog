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
	-rm -f sqlite3.db
	mvn clean
	-rm -rfv ./build_docs/sphinx/* ./build_docs/sphinx/\.*
	-rm -rfv ./build_docs/doxygen/* ./build_docs/doxygen/\.*
	touch ./build_docs/doxygen/garantir_diretorio_pro_git.txt
	touch ./build_docs/sphinx/garantir_diretorio_pro_git.txt

docs:
	doxygen
	-pip install sphinx-rtd-theme groundwork-sphinx-theme
	-pip3 install sphinx-rtd-theme groundwork-sphinx-theme
	sphinx-build -aE . ./build_docs/sphinx/


.PHONY: run test clean docs

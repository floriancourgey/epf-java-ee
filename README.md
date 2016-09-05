training-computer-database-template
============================

### Problématique
Un client vous a demandé de développer une application web pour la gestion de son parc d'ordinateur. Il vous fournit une base de données et un template sur lequel s'appuyer pour tout ce qui est graphique.

Il veut pouvoir :
* lister les ordinateurs
* Ajouter un ordinateur

Les ordinateur ont un nom, une date d'entrée dans le parc de l'entreprise et une date de sortie s'ils ne sont plus présents. Ils ont aussi une compagnie, qui correspond à leur constructeur. Il vous a prévenu aussi que la base de données n'est pas consistante : il faudra dons faire attention aux données.

### Contraintes
L'application que vous allez développer doit être en Java/JEE et doit utiliser les technologies correspondantes.

Vous devrez proposer une architecture n-tier et utiliser les tags JSTL dans les JSP.

Vous avez le choix pour l'accès à la BDD et pourrez utiliser soit JDBC soit Hibernate.

### Bonus
Vous pourrez proposer des fontionnalités supplémentaires utiles dans le cadre de la problématique.

Vous pourrez aussi présenter une autre interface que celle proposée.

Si vous avez une autre idée, envoyez moi un mail à malbert@excilys.com et nous verrons ensemble si c'est une bonne idée et si vous pourrez la faire.

### Instructions
Dans le dossier projet, vous avez 2 scripts sql à éxécuter dans l'ordre (1 puis 2) pour créer votre BDD.

Le projet est à rendre avant le 30/09 23h59.

Vous pouvez le rendre soit par git (pull request) soit par mail avec le war zippé (Sous eclipse File -> Export -> Web -> WAR file -> cochez export sources files)
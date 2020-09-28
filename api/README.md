# Code source de l'API avec REST

## Projet Lombok

### Présentation

Tout au long du projet nous utilisons la libraire Lombok.
Celle-ci permet un code plus clair et plus conscis.

[Vous pourrez trouver la documentation de la librairie ici.](https://projectlombok.org/)

### @Data

[Documentation de @Data](https://projectlombok.org/features/Data)

Il s'agit de l'annotation que l'on utlisera principalement.
Elle regroupe :

- @Setter/Getter
  - Ces anotations génèrent un setter/getter pour le champs annoté.
    Dans le cas de @Data cela génère des setter/getter pour tout les champs.
- @ToString
  - Génère une redéfinition de `toString` comprenant le nom de la classe ansi que tout les champs, dans l'ordre, séparé par des virgules.
- @EqualsAndHashCode
  - Génère une redéfinition de `equals` ansi qu'une redéfinition de `hashCode`. Par défaut la méthode utilise tout les champs qui ne sont pas statiques.
- @RequiredArgsConstructor
  - Génère une constructeur avec en paramètres tout les arguments corespondant aux champs de l'objet.

### @Getter/Setter

[Documentation de @Getter @Setter](https://projectlombok.org/features/GetterSetter)

Si l'on utilise l'anotation @Data, un getter/setter public sera géneré pour chaque attributs.
Cependant si l'on ne souhaite pas qu'un ou plusieurs getter/setter ne soit public ou même accesible, il est possible de mettre des restrictions sur certains de ces champs.

- @Getter/Setter(AccessLevel.PRIVATE)
  - Le setter/getter en question sera privé.
- @Getter/Setter(AccessLevel.PROTECTED)
  - Le setter/getter en question sera protegé
- @Getter/Setter(AccessLevel.NONE)
  - Le setter/getter en question ne sera pas accessible.

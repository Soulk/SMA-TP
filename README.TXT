FITOUSSI DAVID - DECOTTIGNIES SIMON

Nous avons réalisé l'ensemble des fonctionnalités demandé dans le tp 3 à l'exception du comportement des Defenders (pas d'inversion de
l'algo de dijsktra protégeant l'Avatar). Le jeu peut être en torique ou non. La vitesse des différents éléments et du jeu ainsi que
son arrêt reprise est géré. L'apparition de la porte de sortie et les conditions de victoires ou de défaite sont également mise en places.


Les tp sont tous lançables via les Main des différents packages en modifiant le fichier "multi_agents.properties" correctement pour ne pas
avoir de reliquat de tp inadéquates.


TP 1 : Les paramètres important pour le bon fonctionnement à vérifier sont :
- la mise à "particules" de la propriété "game" puis le lancement
devrait se faire normalement.

TP 2 : Les paramètres important pour le bon fonctionnement à vérifier sont :
 - la mise à "water" de la propriété "game"
 - la mise à (nbFish + nbShark) de la proprieté "nbParticules" puis le lancement devrait se faire normalement

TP 3 : Les paramètres important pour le bon fontionnement à vérifier sont :
 -la mise à "hunter" de la propriété "game"
 -la mise à (nbWalls/100)*(gridSizeX*gridSizeY) + nbHunter + 1 (arrondi au supérieur) de la proprieté "nbParticules"
  ( ou pour éviter le calcul, un int plus grand que celui du calcul)

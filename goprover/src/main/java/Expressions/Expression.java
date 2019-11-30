package Expressions;

import Prove.ProveContext;

// Interfejs wyrażenia arytmetycznego i logicznego
public interface Expression {
    // Zamienia każde wystąpienie zmiennej będącej pierwszym parametrem funkcji
    // wyrażeniem będącym drugim parametrem funkcji.
    // parametr: a - zmienna pod którą następuje podstawienie.
    // parametr: b - podstawiane wyrażenie.
    // return: wyrażenie po podstawieniu.
    Expression replace(Expression a, Expression b);
    // Sprawdza czy wyrażenie zawiera zmienną.
    // parametr: a - zmienna do sprawdzenia.
    // return: true jeśli wyrażenie zawiera zmienną, w przeciwnym przypadku false.
    boolean contains(Expression a);
    // Przekształca wyrażenia logiczne zawierające 'if' na wyrażenie kożystające z
    // operatorów koniunkcji i alternatywy.
    // return: przekształcone wyrażenie.
    Expression removeTernary();
    // Sprawdza czy wyrażenie nie zawiera zmiennych niezadeklarowanych w danym kontekście.
    // return: false jeśli wyrażenie zawiera niezadeklarowane zmienne, w przeciwnym
    // przypadku true.
    void checkDeclaration(ProveContext proveContext);
}

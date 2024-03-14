public class ListaComArray {
    private int[] array;
    private boolean resizable;
    private int initialCapacity;
    private int counter = 0;
    private int x;

    //Constrói uma lista vazia de tamanho 10, que pode ser
    //redimensionada.
    public ListaComArray() {
        this.initialCapacity = 10;
        this.array = new int[this.initialCapacity];
        this.resizable = true;
        this.counter = 0;
        this.x = initialCapacity;
    }
    //Constrói uma lista vazia com tamanho passado por parâmetro, que
    //pode ser redimensionada.
    public ListaComArray(int initialCapacity) {
        this.resizable = true;
        this.initialCapacity = initialCapacity;
        this.array = new int[this.initialCapacity];
        this.counter = 0;
        this.x = initialCapacity;
    }
    //Constrói uma lista vazia com tamanho passado por parâmetro,
    //podendo ou não ser redimensionável, depende do parâmetro
    //booleano. Além disso, define a capacidade inicial conforme
    //capacidade passada por parâmetro e, inicializa o contador de
    //elementos com zero.
    public ListaComArray(int initialCapacity, boolean resizable) {
        this.resizable = resizable;
        this.initialCapacity = initialCapacity;
        this.array = new int[this.initialCapacity];
        this.counter = 0;
        this.x = initialCapacity;
    }
        
    //+ add(Integer) : void
    //• Adiciona o elemento passado por parâmetro ao final da lista. Ao
    //final, dependendo se a lista é redimensionável ou não, faz a
    //chamada para o método responsável por redimensionar o array
    public void add(int valor){
        // Verifica se o array ainda tem espaço e adiciona o elemento nele
        if (counter < x) {
            array[counter] = valor;
            counter++;
        }
        // se o array estiver cheio mas for redimensionável ele redimensiona e adiciona o elemento
        else if (resizable){
            resizeArrayList();
            array[counter] = valor;
            counter++;
        }
        // Se não for redimensionável ele retorna lista cheia
        else {
            System.out.println("Lista cheia!");
        }
    }

    //+ add(int, Integer) : void
    //• Adiciona o elemento passado por parâmetro na posição informada.
    //Realoca o elemento que antes existia naquela posição e todos os
    //seguintes para a direita. Ao final, dependendo se a lista é
    //redimensionável ou não, faz a chamada para o método responsável
    //por redimensionar o array. Esse método pode lançar exceção caso o
    //índice passado por parâmetro seja menor do que 0 ou maior do que
    //o tamanho da lista.

    public void add(int valor, int posicao){
        // verifica se a posição informada for menor que zero e for maior que a
        // composição do array, retornado uma exceção
        if (posicao < 0 || posicao > counter){
            throw new IndexOutOfBoundsException("Posição inválida!");
        }
        // reposiciona os elementos do array seguintes aquela posição
        for (int i = counter; i > posicao; i--) {
            array[i] = array[i - 1];
        }
        array[posicao] = valor;
        counter++;
        // se o array for redimensionável e estiver cheio chama o
        // método que o redimensiona
        if (resizable && counter == x) {
            resizeArrayList();
            x++;
        }
    }
    public void resizeArrayList(){
        int[] novoArray = new int[x + 1];
        for (int i = 0; i < x; i++) {
                novoArray[i] = array[i];
        }
        array = novoArray;
        x++;
    }

    public int get(int posicao){
        if (posicao < 0 || posicao >=counter) {
            throw new IndexOutOfBoundsException("Posição Inválida! ");
        }
        return array[posicao];
    }
    public void clear(){
        for (int i = 0; i < x; i++) {
            array[i] = 0;
        }
        counter = 0;
        if (resizable) {
            array = new int[initialCapacity];
            x = initialCapacity;
        }
    }

    public boolean isEmpty(){
        if (counter == 0) {
            System.out.println("O array está vazio! ");
            return true;
        }
        else {
            System.out.println("O array está populado! ");
            return false;
        }
    }

    public boolean isFull(){
        if (resizable == false && counter == x) {
            System.out.println("O array está cheio! ");
           return true;

        }
        else if (resizable == true && counter < x) {
            System.out.println("O array não está cheio! ");
            return false;
        }
        return false;
    }

    public int size(){
        return counter;
    }
    public int remove(int posicao) {
        if (posicao < 0 || posicao >= counter) {
            throw new IndexOutOfBoundsException("Posição Inválida! ");
        }
        else {
            int valorRemovido = array[posicao];
            array[counter] = posicao;
            counter++;
            for (int i = counter; i < posicao; i+) {
                array[i] = array[i + 1];
            }
        }
        counter--;
        return array[posicao];
    }
}

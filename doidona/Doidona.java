class Doidona{
    private No raiz;

    public boolean pesquisar(String palavra){
        // pegar o primeiro caracter
        char caracter = palavra.charAt(0);
        // primeiro nível: pesquisar na árvore
        No encontrado = pesquisarNo(caracter, raiz);
        if(encontrado == null) return false;
        else{
            T1 t1 = encontrado.t1;
            char ultimoCaracter = palavra.charAt(palavra.length()-1);
            int pos1 = t1.hashT1(ultimoCaracter);
            if(t1.palavras[pos1] == ""){
                return false;
            } else{
                if(t1.palavras[pos1].equals(palavra)){ 
                    return true; // encontrei a palavra no hash
                }else{
                    int pos2 = t1.rehashT1(ultimoCaracter);
                    if(t1.palavras[pos2] == ""){
                        return false;
                    }else{
                        if(t1.palavras[pos2].equals(palavra)){
                            return true; // encontrei a palavra no rehash
                        }else{
                            // não encontrei na T1, tenho que buscar na T2
                            int numCaracteres = palavra.length();
                            T2 t2 = t1.t2;
                            int pos3 = t2.hashT2(numCaracteres);

                            // buscar dentro da lista da posição pos3
                            CelulaT2 celulaT2 = t2.celulast2[pos3];
                            if(celulaT2.buscar(palavra) == true){
                                return true; // encontrei na lista
                            }else{
                                return false; // não encontrei na lista
                            }
                        }
                    }
                }
            }
        }
    }

    public No pesquisarNo(char c, No i){
        No resp;
        if(i == null){
            // não encontrei o nó
            resp = null;
        }
        if(c == i.caracter){
            // encontrei o nó
            resp = i;
        } else if(c > i.caracter){
            // andar para a direita
            resp = pesquisarNo(c, i.dir);
        } else {
            // andar para a esquerda
            resp = pesquisarNo(c, i.esq);
        }
        return resp;
    }
}

public class No {
    public char caracter;
    public T1 t1;
    public No esq, dir;
}

public class T1 {
    public String palavras[];
    public T2 t2;
    final int TAM1 = 15;

    public T1(){
        palavras = new String[TAM1];
        for(int i=0; i<TAM1; i++){
            palavras[i] = "";
        }
        t2 = new T2();
    }

    public int hashT1(char x){
        return x % TAM1;
    }

    public int rehashT1(char x){
        return (x + 1) % TAM1;
    }
}

public class T2 {
    public CelulaT2 celulast2[];
    final int TAM2 = 10;

    public T2(){
        celulast2 = new CelulaT2[TAM2];
        for(int i=0; i<TAM2; i++){
            celulast2[i] = new CelulaT2();
        }
    }

    public int int hashT2(int x){
        return x % TAM2;
    }
}

public class CelulaT2 {
    public Celula inicio;
    public Celula fim;

    public CelulaT2(){
        inicio = null;
        fim = null;
    }

    public boolean buscar(String busca){
        if(inicio == null){
            return false; // a lista está vazia
        }else{
            Celula tmp = inicio;
            while(tmp != null && tmp.palavra.compareTo(busca) <= 0){
                if(tmp.palavra.equals(busca)){
                    return true;
                }else{
                    tmp = tmp.prox;
                }
            }
            return false;
        }
    }
}

public class Celula {
    public String palavra;
    public Celula prox;
}
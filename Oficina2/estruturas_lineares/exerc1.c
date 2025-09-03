#define MAX_EMERGENCY 10
#define MAX_PERIODIC 20
#define MAX_BACKGROUND 30

typedef struct {
    int task_id ;
    int priority ; // 0 -10 (0 = maxima prioridade )
} Task ;

Task get_next_task(){
    //to implement
}

void promote_to_emergency(){
    //to implement
}

void push_emergency(Task t){
    // to implement
}
Task pop_emergency(){
    // to implement
}

void enqueue_periodic(Task t){
    // to implement
}
Task dequeue_periodic(){
    // to implement
}

void insert_background(Task t){
    // to implement
}
Task remove_background(){
    // to implement
}

void criarTarefa(){
    int id;
    int prioridade;
    printf("ID:\n");
    scanf("%d", &id);
    printf("Prioridade:\n");
    scanf("%d", &prioridade);
    printf("1-Inserir na Pilha\n2-Inserir na Fila\n3-Inserir na lista\n");
    int local;
    scanf("%d", &local);
    Task tarefa;
    tarefa.task_id = id;
    tarefa.priority = prioridade;
    if(local == 1) push_emergency(tarefa);
    else if(local == 2) enqueue_periodic(tarefa);
    else insert_background(tarefa);
}


int main(){
    Task pilha[MAX_EMERGENCY];
    Task fila[MAX_PERIODIC];
    Task lista[MAX_BACKGROUND];

    int opcao;
    printf("Entre com a opcao:\n");
    printf("1-Criar\n2-Processar\n3-Promover\n0-Sair\n");
    scanf("%d", &opcao);
    while(opcao != 0){
        if(opcao == 1){
            criarTarefa();
        }else if(opcao == 2){
            get_next_task();
        }else if(opcao == 3){
            promote_to_emergency();
        }

        printf("1-Criar\n2-Processar\n3-Promover\n0-Sair\n");
        scanf("%d", &opcao);
    }
    return 0;
}
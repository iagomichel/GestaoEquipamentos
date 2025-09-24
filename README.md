# Tecnologias e Ferramentas

- **Kotlin**
- **Jetpack Compose**
- **MVVM (Model-View-ViewModel)**
- **Arquitetura Clean Code**
- **Room** para persistência local
- **Hilt** para injeção de dependência
- **Paging 3** para listagens paginadas
- **Coroutines** para operações assíncronas

![Tecnologias](https://github.com/user-attachments/assets/01789e7e-dd4f-40f9-881c-58390227f434)

---

# Estrutura do Projeto

![Estrutura](https://github.com/user-attachments/assets/9155394d-edd4-4a3d-a38a-8bd9d70eabe7)

O projeto segue **Clean Architecture** com camadas bem definidas:

- **Data**: Implementações de repositórios, fontes de dados (API / Room), mapeadores  
- **Domain**: Casos de uso e entidades do negócio  
- **Presentation**: UI em Compose, ViewModels, gerenciamento de estado  

---

# Padrão MVVM

- **View**: Telas em Compose observando estados do ViewModel  
- **ViewModel**: Mantém o estado da UI, manipula dados e expõe eventos  
- **Model / Domain**: Entidades e lógica de negócio, casos de uso  
- **DI**: Módulo de injeção de dependência com Hilt

---

# Funcionalidades

## Cadastro de Equipamento

- Formulário com campos essenciais do equipamento  
- Validações de entrada  
- Persistência via Room  
- Atualiza lista de equipamentos em tempo real  

## Edição de Equipamento

- Permite alterar informações do equipamento existente  
- Reutiliza a mesma estrutura de UI do cadastro  
- Persistência via Room  

---

## Certifique-se que está usando:

- AGP 8.13.0

- Kotlin 2.2.20

- Execute o app em um dispositivo ou emulador



## Evidência




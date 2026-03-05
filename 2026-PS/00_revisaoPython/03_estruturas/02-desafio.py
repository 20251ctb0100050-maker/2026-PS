# ============================================
# Nome: Seu Nome
# Disciplina: Programação
# Data: 05/03/2026
# Descrição: Sistema simples de catálogo de livros
# ============================================

# -----------------------------
# CATÁLOGO INICIAL DE LIVROS
# -----------------------------

catalogo = [
    {"titulo": "Dom Casmurro", "autor": "Machado de Assis", "ano": 1899, "disponivel": True},
    {"titulo": "1984", "autor": "George Orwell", "ano": 1949, "disponivel": False},
    {"titulo": "O Hobbit", "autor": "J.R.R. Tolkien", "ano": 1937, "disponivel": True}
]


# -----------------------------
# FUNÇÃO PARA EXIBIR LIVROS
# -----------------------------

def exibir_livros():
    print("\n Catálogo de Livros:\n")

    for livro in catalogo:
        status = "Disponível" if livro["disponivel"] else "Emprestado"
        print(f"Título: {livro['titulo']}")
        print(f"Autor: {livro['autor']}")
        print(f"Status: {status}")
        print("-" * 30)


# -----------------------------
# CADASTRAR NOVO LIVRO
# -----------------------------

def cadastrar_livro():
    print("\n Cadastro de novo livro")

    titulo = input("Título: ")
    autor = input("Autor: ")
    ano = int(input("Ano: "))

    novo_livro = {
        "titulo": titulo,
        "autor": autor,
        "ano": ano,
        "disponivel": True
    }

    catalogo.append(novo_livro)

    print(" Livro cadastrado com sucesso!")


# -----------------------------
# BUSCA POR AUTOR
# -----------------------------

def buscar_por_autor():
    busca = input("\nDigite o nome do autor: ").lower()

    encontrados = []

    for livro in catalogo:
        if busca in livro["autor"].lower():
            encontrados.append(livro)

    if encontrados:
        print("\n Livros encontrados:\n")
        for livro in encontrados:
            print(livro["titulo"])
    else:
        print(" Nenhum livro encontrado para esse autor.")


# -----------------------------
# EMPRÉSTIMO / DEVOLUÇÃO
# -----------------------------

def alternar_emprestimo():
    titulo = input("\nDigite o título do livro: ").lower()

    for livro in catalogo:
        if livro["titulo"].lower() == titulo:
            livro["disponivel"] = not livro["disponivel"]

            if livro["disponivel"]:
                print(" Livro devolvido!")
            else:
                print(" Livro emprestado!")

            return

    print(" Livro não encontrado.")


# -----------------------------
# CONTAGEM DE LIVROS
# -----------------------------

def contagem():
    disponiveis = 0
    emprestados = 0

    for livro in catalogo:
        if livro["disponivel"]:
            disponiveis += 1
        else:
            emprestados += 1

    print(f"\nDisponíveis: {disponiveis}")
    print(f"Emprestados: {emprestados}")


# -----------------------------
# RELATÓRIO FINAL
# -----------------------------

def relatorio_final():
    total = len(catalogo)

    disponiveis = [l for l in catalogo if l["disponivel"]]
    emprestados = [l for l in catalogo if not l["disponivel"]]

    print("\n RELATÓRIO FINAL")
    print("-" * 30)

    print(f"Total de livros: {total}")
    print(f"Disponíveis: {len(disponiveis)}")
    print(f"Emprestados: {len(emprestados)}")

    if emprestados:
        print("\nLivros emprestados:")
        for livro in emprestados:
            print("-", livro["titulo"])


# -----------------------------
# MENU PRINCIPAL
# -----------------------------

while True:

    print("\n===== MENU =====")
    print("1 - Ver catálogo")
    print("2 - Cadastrar livro")
    print("3 - Buscar por autor")
    print("4 - Empréstimo / Devolução")
    print("5 - Contagem de livros")
    print("0 - Sair")

    opcao = input("Escolha: ")

    if opcao == "1":
        exibir_livros()

    elif opcao == "2":
        cadastrar_livro()

    elif opcao == "3":
        buscar_por_autor()

    elif opcao == "4":
        alternar_emprestimo()

    elif opcao == "5":
        contagem()

    elif opcao == "0":
        relatorio_final()
        print("Encerrando programa...")
        break

    else:
        print(" Opção inválida.")
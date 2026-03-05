# =========================================================
# SISTEMA DE BIBLIOTECA
# =========================================================
# Discplina  : Programação de Sistemas (PS)
# Aula       : 05 - Revisão: Estruturas de Dados
# Autor      : [Gustavo Ferreira Koller Da Silva]
# Data       : [24/02/2026]
# Repositório: https://github.com/[20251ctb0100050-maker]/2026-PS
# ==========================================================
# 
# DESCRIÇÃO:
# Catálogo de livros que demonstra o uso de listas
# e dicionários para armazenar, consultar e filtrar
# dados estruturados.
# ==========================================================

# ==== LISTAS: CONCEITOS BÁSICO ====

# Criando uma lista de títulos
titulos = [
    "O Programador Pragmático",
    "Código Limpo",
    "Entendendo Algoritmos",
]

# Acesso por indice (começa em 0, não em 1!)
print("Primeiro livro:", titulos[0])
print("Últimos livro :", titulos[-1])    # índice -1 = último elemento
print("Total de livros:", len(titulos))

print("\n --- Operações na lista --- ")

# Lista inicial (caso ainda não tenha sido criada)
titulos = ["Clean Code", "Entendendo Algoritmos", "O Programador Pragmático"]

# Adicionar um item ao final
titulos.append("Python Fluente")
print("Após append:", titulos)

# Verificar se um item existe
busca = "Codigo Limpo"

if busca in titulos:
    print(f'"{busca}" está no catálogo.')
else:
    print(f'"{busca}" não encontrado.')

# Ordenar a lista
titulos.sort()
print("Lista ordenada:", titulos)

# Remover um item
titulos.remove("Entendendo Algoritmos")
print("Após remove:", titulos)

print("\n--- Catálogo numerado ---")

for indice, titulo in enumerate(titulos, start=1):
    print(f"{indice}. {titulo}")

# ==== DICIONARIOS: CONCEITO BÁSICO ====

# Um dicionário representa um livro com seus atributos
livro = {
    "titulo": "O Programador Pragmático",
    "autor": "Andrew Hunt",
    "ano": 1999,          # int, não string
    "disponivel": True    # bool
}

# Acessando valores pelas chaves
print("Título:", livro["titulo"])
print("Autor:", livro["autor"])
print("Ano:", livro["ano"])
print("Status:", "Disponível" if livro["disponivel"] else "Emprestado")

# ==== MODIFICANDO E CONSULTANDO ====

# Atualizando um valor existente
livro["disponivel"] = False # livro foi emprestado
print("\nApós empréstimo:", livro["disponivel"])

# Adicionando uma nova chava
livro["paginas"] = 352
print("Páginas:", livro["paginas"])

# .get() - acesso seguro: retorna None (ou padrão) se a chave não existir
editora = livro.get("editora", "Não informada")
print("Editora:", editora) #não lança KeyError, retorna o padrão

# CATÁLOGO: LISTA DE DICIONÁRIOS

catalogo = [
    {
        "titulo": "O Programador Pragmático",
        "autor": "Andrew Hunt",
        "ano": 1999,
        "disponivel": True
    },
    {
        "titulo": "Código Limpo",
        "autor": "Robert C. Martin",
        "ano": 2008,
        "disponivel": False
    },
    {
        "titulo": "Entendendo Algoritmos",
        "autor": "Aditya Bhargava",
        "ano": 2016,
        "disponivel": True
    }
]

print("=== Catálogo da Biblioteca ===")
print()

# Percorrendo cada livro com for
for livro in catalogo:
    status = "Disponível" if livro["disponivel"] else "Emprestado"
    
    print(f"{livro['titulo']} ({livro['ano']})")
    print(f"Autor: {livro['autor']} | Status: {status}")
    print("-" * 40)

# Adicionando um quarto livro
catalogo.append({
    "titulo": "Python Fluente",
    "autor": "Luciano Ramalho",
    "ano": 2015,
    "disponivel": True
})

print("=== Catálogo da Biblioteca ===\n")

# Percorrendo cada livro com for e numerando
for indice, livro in enumerate(catalogo, start=1):
    status = "Disponível" if livro["disponivel"] else "Emprestado"
    
    print(f"{indice}. {livro['titulo']} ({livro['ano']})")
    print(f"Autor: {livro['autor']} | Status: {status}")
    print("-" * 40)


# Exemplo de catálogo de livros
catalogo = [
    {"titulo": "Dom Quixote", "autor": "Miguel de Cervantes", "disponivel": True},
    {"titulo": "1984", "autor": "George Orwell", "disponivel": False},
    {"titulo": "O Pequeno Príncipe", "autor": "Antoine de Saint-Exupéry", "disponivel": True},
]

# ==== CONSULTAS E FILTROS ====

# =========================
# Livros disponíveis
# =========================
print("\n=== Livros disponíveis ===")
for livro in catalogo:
    if livro["disponivel"]:
        print(f"- {livro['titulo']}")  # Mostra apenas os disponíveis

# =========================
# Busca por título
# =========================
print("\n=== Busca por título ===")
busca = input("Digite o título (ou parte dele): ").lower()
encontrado = False

for livro in catalogo:
    if busca in livro["titulo"].lower():  # Ignora maiúsculas/minúsculas
        print(f"Encontrado: {livro['titulo']} - {livro['autor']}")
        encontrado = True

if not encontrado:
    print("Nenhum livro encontrado com esse termo.")

# =========================
# Atributos do primeiro livro
# =========================
print("\n=== Atributos do primeiro livro ===")
for chave, valor in catalogo[0].items():  # Retorna pares (chave, valor)
    print(f"{chave}: {valor}")

# =========================
# Contagem de livros disponíveis e emprestados
# =========================
disponiveis = 0
emprestados = 0

for livro in catalogo:
    if livro["disponivel"]:
        disponiveis += 1
    else:
        emprestados += 1

print(f"\n=== Resumo do Catálogo ===")
print(f"Disponíveis: {disponiveis} | Emprestados: {emprestados}")

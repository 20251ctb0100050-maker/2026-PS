# Arquivo: 01b-debug.py
# ATENÇÂO: 4 erros propositais. Encontre e corrija todos!

# Catalogo de livros
catalogo = [
    {"titulo": "Código Limpo", "autor": "Robert C. Martin", "disponivel": True},
    {"titulo": "Entendendo Algoritmos", "autor": "Aditya Bhargava", "disponivel": False},
    {"titulo": "Python Fluente", "autor": "Luciano Ramalho", "disponivel": True}
]

# Primeiro livro
print("Primeiro livro:", catalogo[0]["titulo"])

# Livros disponíveis
print("\nLivros disponíveis:")
for livro in catalogo:
    if livro["disponivel"]:
        print("-", livro["titulo"])

# Total de livros
total = len(catalogo)
print(f"\nTotal de livros: {total}")

# Mostrar detalhes do primeiro livro
print("\nDetalhes do primeiro livro:")
for chave, valor in catalogo[0].items():
    print(f"{chave}: {valor}")

# Autor do primeiro livro
primeiro_autor = catalogo[0]["autor"]
print("\nAutor do primeiro livro:", primeiro_autor)
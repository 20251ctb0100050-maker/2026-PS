# =========================================================
# SISTEMA DE APROVAÇÃO DE ALUNOS
# =========================================================
# Discplina  : Programação de Sistemas (PS)
# Aula       : 04 - Revisão: Variáveis, Tipos e Controle de Fluxo
# Autor      : [Gustavo Ferreira Koller Da Silva]
# Data       : [24/02/2026]
# Repositório: https://github.com/[20251ctb0100050-maker]/2026-PS
# ==========================================================
# 
# DESCRIÇÃO:
# Este programa processa as notas de uma turma e determina
# a situação de cada aluno (aprovado, Recuperação ou Reprovado).
# Conceito utilizados: variáveis, tipos de dados, operadores,
# estruturas de seleção e estruturas de repetição.
# ==========================================================
# ==== ENTRADA DE DADOS ====

turma = [
    {"nome": "Gustavo", "nota1": 8.0, "nota2": 7.5},
    {"nome": "João", "nota1": 4.5, "nota2": 5.0},
    {"nome": "Matheus", "nota1": 2.0, "nota2": 3.5},
]

print("--- Resultado da Turma ---\n")

for aluno in turma:
    nome = aluno["nome"]
    nota1 = aluno["nota1"]
    nota2 = aluno["nota2"]

    media = (nota1 + nota2) / 2

    if media >= 6.0:
        situacao = " Aprovado"
    elif media >= 4.0:
        situacao = " Recuperação"
    else:
        situacao = " Reprovado"

    print(f"Aluno   : {nome}")
    print(f"Média   : {media:.2f}")
    print(f"Situação: {situacao}")
    print("-" * 30)

continuar = "v"

while continuar == "v":

    continuar = input("\nDeseja processar outro aluno? (v/n): ").lower()

    if continuar == "v":

        nome = input("Digite o nome do aluno: ")
        nota1 = float(input("Digite a nota 1 (0 a 10): "))
        nota2 = float(input("Digite a nota 2 (0 a 10): "))

        media = (nota1 + nota2) / 2

        if media >= 6.0:
            situacao = " Aprovado"
        elif media >= 4.0:
            situacao = " Recuperação"
        else:
            situacao = " Reprovado"

        print("\n--- Resultado ---")
        print(f"Aluno   : {nome}")
        print(f"Média   : {media:.2f}")
        print(f"Situação: {situacao}")
        print("-" * 30)

print("\nEncerrando o programa...")
print("-" * 40)
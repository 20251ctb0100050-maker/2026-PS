import json
import os

ARQUIVO_JSON = "2026-PS/02_poo/hotel_pets_json/pets.json"


class Pet:
    def __init__(
        self,
        nome,
        especie,
        idade,
        peso,
        nome_dono,
        vacinado,
        data_nascimento,
        raca,
        hospedado=False
    ):
        self.nome = nome
        self.especie = especie
        self.idade = idade
        self.peso = peso
        self.nome_dono = nome_dono
        self.vacinado = vacinado
        self.data_nascimento = data_nascimento
        self.raca = raca
        self.hospedado = hospedado

    def exibir_dados(self):
        print("\n--- Dados do Pet ---")
        print(f"Nome: {self.nome}")
        print(f"Espécie: {self.especie}")
        print(f"Raça: {self.raca}")
        print(f"Idade: {self.idade}")
        print(f"Data de nascimento: {self.data_nascimento}")
        print(f"Peso: {self.peso} kg")
        print(f"Dono: {self.nome_dono}")
        print(f"Vacinado: {'Sim' if self.vacinado else 'Não'}")
        print(f"Hospedado: {'Sim' if self.hospedado else 'Não'}")

    def registrar_entrada(self):
        if self.hospedado:
            print(f"{self.nome} já está hospedado.")
        else:
            self.hospedado = True
            print(f"{self.nome} entrou no hotel.")

    def registrar_saida(self):
        if not self.hospedado:
            print(f"{self.nome} não está hospedado.")
        else:
            self.hospedado = False
            print(f"{self.nome} saiu do hotel.")

    def para_dicionario(self):
        return {
            "nome": self.nome,
            "especie": self.especie,
            "idade": self.idade,
            "peso": self.peso,
            "nome_dono": self.nome_dono,
            "vacinado": self.vacinado,
            "data_nascimento": self.data_nascimento,
            "raca": self.raca,
            "hospedado": self.hospedado
        }

    @staticmethod
    def criar_de_dicionario(dados):
        """
        Corrigido para evitar erro em JSONs antigos
        """

        return Pet(
            dados.get("nome", ""),
            dados.get("especie", ""),
            dados.get("idade", 0),
            dados.get("peso", 0.0),
            dados.get("nome_dono", ""),
            dados.get("vacinado", False),
            dados.get("data_nascimento", "Não informado"),
            dados.get("raca", "Não informada"),
            dados.get("hospedado", False)
        )


def salvar_pets(lista_pets):
    """
    Salva os pets no arquivo JSON
    """

    lista_dicionarios = []

    for pet in lista_pets:
        lista_dicionarios.append(pet.para_dicionario())

    with open(ARQUIVO_JSON, "w", encoding="utf-8") as arquivo:
        json.dump(lista_dicionarios, arquivo, ensure_ascii=False, indent=4)

    print("Dados salvos com sucesso!")


def carregar_pets():
    """
    Carrega os pets do JSON
    """

    if not os.path.exists(ARQUIVO_JSON):
        return []

    with open(ARQUIVO_JSON, "r", encoding="utf-8") as arquivo:
        lista_dicionarios = json.load(arquivo)

    lista_pets = []

    for dados in lista_dicionarios:
        pet = Pet.criar_de_dicionario(dados)
        lista_pets.append(pet)

    return lista_pets


def cadastrar_pet(lista_pets):
    print("\n--- Cadastro de Pet ---")

    nome = input("Nome do pet: ")
    especie = input("Espécie: ")
    raca = input("Raça: ")
    idade = int(input("Idade: "))
    data_nascimento = input("Data de nascimento: ")
    peso = float(input("Peso: "))
    nome_dono = input("Nome do dono: ")

    resposta = input("O pet está vacinado? (s/n): ").lower()
    vacinado = resposta == "s"

    pet = Pet(
        nome,
        especie,
        idade,
        peso,
        nome_dono,
        vacinado,
        data_nascimento,
        raca
    )

    lista_pets.append(pet)

    print("Pet cadastrado com sucesso!")


def listar_pets(lista_pets):
    print("\n--- Lista de Pets ---")

    if not lista_pets:
        print("Nenhum pet cadastrado.")
        return

    for i, pet in enumerate(lista_pets, 1):
        print(f"\nPet {i}:")
        pet.exibir_dados()


def registrar_entrada_pet(lista_pets):

    if not lista_pets:
        print("Nenhum pet cadastrado.")
        return

    listar_pets(lista_pets)

    numero = int(input("Número do pet: "))

    if 1 <= numero <= len(lista_pets):
        lista_pets[numero - 1].registrar_entrada()
    else:
        print("Número inválido.")


def registrar_saida_pet(lista_pets):

    if not lista_pets:
        print("Nenhum pet cadastrado.")
        return

    listar_pets(lista_pets)

    numero = int(input("Número do pet: "))

    if 1 <= numero <= len(lista_pets):
        lista_pets[numero - 1].registrar_saida()
    else:
        print("Número inválido.")


def menu():

    pets = carregar_pets()

    while True:

        print("\n========= HOTEL PARA PETS =========")
        print("1 - Cadastrar pet")
        print("2 - Listar pets")
        print("3 - Registrar entrada")
        print("4 - Registrar saída")
        print("5 - Salvar dados")
        print("0 - Sair")

        opcao = input("Escolha uma opção: ")

        if opcao == "1":
            cadastrar_pet(pets)

        elif opcao == "2":
            listar_pets(pets)

        elif opcao == "3":
            registrar_entrada_pet(pets)

        elif opcao == "4":
            registrar_saida_pet(pets)

        elif opcao == "5":
            salvar_pets(pets)

        elif opcao == "0":
            salvar_pets(pets)
            print("Sistema encerrado.")
            break

        else:
            print("Opção inválida.")


if __name__ == "__main__":
    menu()
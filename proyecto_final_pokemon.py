import random

class Pokemon:
    def __init__(self,nombre,tipo,vida,defensa,lista_ataques):
        self.nombre=nombre
        self.tipo=tipo
        self.vida=vida
        self.defensa=defensa
        self.lista_ataques=lista_ataques

    def atacar(self,enemigo,ataque):
        daño=ataque.daño -enemigo.defensa
        if daño<0:
            daño=0
        enemigo.vida -=daño
        return f"{enemigo.nombre} ahora tiene {enemigo.vida} de vida"

class Ataque:
    def __init__(self, nombre, daño, tipo):
        self.nombre = nombre
        self.daño = daño
        self.tipo = tipo

impactrueno=Ataque('impactrueno',30,'electrico')
placaje = Ataque("Placaje", 18, "normal")
#-----------------------------------------------
ascuas=Ataque('ascuas',25,'fuego')
arañazo=Ataque('arañazo',20,'normal')
#-----------------------------------------------
ataques_pikachu=[impactrueno,placaje]
ataques_charmander=[arañazo,ascuas]
#-----------------------------------------------
pokemon1=Pokemon("picachu",'electrico',100,15,ataques_pikachu)
pokemon_enemigo=Pokemon("charmander",'fuego',100,10,ataques_charmander)

class Combate:
    def __init__(self,pokemon1,pokemon_enemigo):
        self.pokemon1 = pokemon1
        self.pokemon_enemigo = pokemon_enemigo
    def iniciar(self):
        while self.pokemon1.vida >0 and self.pokemon_enemigo.vida>0:
            print('ES HORA DE ATACAR!\nElige tu ataque \n1.impactrueno\n2.placaje')
            op=int(input("que ataque eliges: "))
            if op==1:
                ataque_elegido=impactrueno
            elif op==2:
                ataque_elegido=placaje
            print('==================',pokemon1.atacar(pokemon_enemigo,ataque_elegido),'==================')
            if self.pokemon_enemigo.vida<=0:
                print(f'{self.pokemon_enemigo.nombre} ha perdido toda su vida X_X\nGANASTE!')
                break
            print('ATACA',pokemon_enemigo.nombre,'!')
            ataque_enemigo=random.choice(pokemon_enemigo.lista_ataques)
            print(f"{pokemon_enemigo.nombre} usa {ataque_enemigo.nombre}")
            print(pokemon_enemigo.atacar(pokemon1, ataque_enemigo))
            if self.pokemon1.vida<=0:
                print(f'{self.pokemon1.nombre} ha perdido toda su vida X_X\nGANASTE!')
                break

combate = Combate(pokemon1, pokemon_enemigo)
combate.iniciar()

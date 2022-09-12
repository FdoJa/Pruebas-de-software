import logging

root_logger= logging.getLogger()
root_logger.setLevel(logging.INFO) 
handler = logging.FileHandler('informacion.log', 'w', 'utf-8') 
formatter = logging.Formatter('%(asctime)s %(message)s') 
handler.setFormatter(formatter) 
root_logger.addHandler(handler)

class Pila: 
    def __init__(self):
        self.elements = []
        self.maxi = ""
        self.mini = ""

    def push(self, data): 
        self.elements.append(data)

        if self.large() == 1:
            self.maxi = data
            self.mini = data
            logging.info('Se ha agregado el 1er valor a la pila: {} - Se ha inicializado el fondo de la pila, su valor maximo y minimo con este valor.'.format(data))
            return data

        if len(data) > len(self.maxi):
            self.maxi = data
        elif len(data) == len(self.maxi):
            logging.info('Se ha agregado el texto: {}, que tiene el mismo largo que el máximo guardado: {}, ahora {} será el nuevo máximo.'.format(data, self.max, data))
            self.maxi = data
        
        if len(data) < len(self.mini):
            self.mini = data
        elif len(data) == len(self.mini):
            logging.info('Se ha agregado el texto: {}, que tiene el mismo largo que el minimo guardado: {}, ahora {} será el nuevo minimo.'.format(data, self.mini, data))
            self.mini = data

        logging.info('Se ha añadido el texto {} a la pila, no se ha modificado el máximo ni minimo de la pila.'.format(data))
        return data 

    def max(self):
        return self.maxi

    def min(self):
        return self.mini
        
    def pop(self): 
        return self.elements.pop() 
         
    def get_specific(self,n):
        aux = self.elements[:]
        for i in range(len(aux) - n ):
            aux.pop()
        texto = aux.pop()
        logging.info('Obteniendo el texto que ocupa el puesto {} en la pila, se obtuvo el texto: {}'.format(n, texto))
        return texto

    def compare(self,n1,n2):
        aux = self.elements[:]

        if n1 > n2:
            for i in range(len(aux) - n1):
                aux.pop()
            text1 = aux.pop()

            for k in range(len(aux) - n2):
                aux.pop()
            text2 = aux.pop()

        elif n1 < n2:
            for j in range(len(aux) - n2):
                aux.pop()
            text2 = aux.pop()

            for z in range(len(aux) - n1):
                aux.pop()
            text1 = aux.pop() 
        if len(text1) > len(text2):
            logging.info('Comparando el texto número {} de la pila: {} - con el texto número {}: {} -> {} es más largo.'.format(n1, text1, n2, text2, text1))
            print("El texto",n1,":",text1,", es más largo que el texto",n2,":",text2,"\n")
        elif len(text2) > len(text1):
            logging.info('Comparando el texto número {} de la pila: {} - con el texto número {}: {} -> {} es más largo.'.format(n1, text1, n2, text2, text2))
            print("El texto",n2,":",text2,", es más largo que el texto",n1,":",text1,"\n")
        else:
            logging.info('Comparando el texto número {} de la pila: {} - con el texto número {}: {} -> Ambos son del mismo tamaño.'.format(n1, text1, n2, text2))
            print("Ambos textos ->",n1,":",text1," - ",n2,":",text2," tienen el mismo largo.\n")
        
    def is_empty(self): 
        return len(self.elements) == 0

    def large(self):
        return len(self.elements)

def opciones():
    print("¿Que desea realizar?\n  1. Agregar texto\n  2. Obtener texto más largo y más corto\n  3. Obtener un texto\n  4. Comparar dos textos\n  5. Salir\nIngrese el número de su opción")

if __name__ == '__main__':
    pila = Pila()
    print("Bienvenido ")
    while True:
        opciones()


        opc = int(input())
        
        if opc == 1:
            print("\nIngrese el texto a añadir:")
            
            try:
                nuevo = str(input())
            except ValueError:
                print("Ingrese una cadena valido\n")
                logging.info('Texto a añadir no puede ser convertido a una cadena.\n')
                continue
            
            pila.push(nuevo)
            print("Texto añadido con exito.\n")
            continue
        
        elif opc == 2:
            if pila.is_empty():
                # Pila vacia
                print("No hay textos almacenados, no es posible encontrar máximo y minimo.\n")
                logging.info('No existen textos almacendaos, no se puede realizar busqueda de máximo y minimo.\n')
                continue
            
            maxi = pila.max()
            mini = pila.min()
            print("\nMenor: ",mini, "con",len(mini),"caracteres.")
            print("Mayor: ",maxi,"con",len(maxi),"caracteres.""\n")
            continue

        elif opc == 3:
            if pila.is_empty():
                # Pila vacia
                print("No hay textos almacenados para buscar.\n")
                logging.info('No existen textos almacendaos, no se puede realizar busqueda.\n')
                continue
            
            l = pila.large()
            print("\nSe tienen",l,"textos guardados, ingresa el número asociado al orden en que se guardo el texto:")

            try:
                n = int(input())
            except ValueError:
                print("Ingrese un valor valido\n")
                logging.info('Indice ingresado para buscar no es un número.\n')
                continue

            if n > l or n <= 0:
                print("Ingrese un valor valido\n")
                logging.info('Indice ingresado no esta dentro del rango (1 a {}).\n'.format(l))
                continue
            
            found = pila.get_specific(n)
            print("El texto es el siguiente: ",found,"\n")
            continue

        elif opc == 4:
            if pila.is_empty():
                # Pila vacia
                print("No hay textos almacenados, no es posible comparar.\n")
                logging.info('No existen textos almacendaos, no se puede realizar comparación.\n')
                continue
            
            l = pila.large()
            print("\nSe tienen",l,"textos guardados")

            try:
                t1 = int(input("Ingresa el número asociado al primer texto a comparar: "))
                t2 = int(input("Ahora el del segundo texto: "))
            except ValueError:
                print("Ingrese un valor valido\n")
                logging.info('Algún indice ingresado no es un número.\n')
                continue

            if t1 > l or t2 > l or t1 <= 0 or t2 <= 0:
                print("Ingrese un valor valido\n")
                logging.info('Indice ingresado no esta dentro del rango (1 a {}).\n'.formar(l))
                continue
    
            pila.compare(t1,t2)
            continue

        elif opc == 5:
            print("\nCerrando...")
            logging.info('Se cierra el programa'.formar(l))
            break

//Jogo do bixo
//TODO: Encontrar método para formatar strings deixando primeira letra maiúscula
//TODO: Verificar se o usuário deseja finalizar o jogo ou continuar

fun main() {
    var listaBichos = mutableListOf<String>("cachorro", "macaco", "cobra", "jacaré",
        "coelho")

    var bichoSorteado = listaBichos.random()

    var bichoEscolhido = escolheBicho(listaBichos)

    if(bichoSorteado == bichoEscolhido){
        println("Parabéns, você ganhou!")
    }else{
        println("Não foi dessa vez, mas continue tentando! ;)")
    }

    println("O bicho sorteado foi: $bichoSorteado" +
            "\nO bicho que você escolheu foi: $bichoEscolhido")

}


fun escolheBicho(listaDeBichos : List<String>) : String{
    var bichoEscolhido = ""
    var naoContemBicho : Boolean

    do{
        println("Por favor, escolha um dos bichos a seguir: ")
        listaDeBichos.forEach{
            println(it)
        }

        bichoEscolhido = readLine()!!.lowercase()
        naoContemBicho = !listaDeBichos.contains(bichoEscolhido)

        if(naoContemBicho){
            println("O bicho escolhido não está na lista. Por favor, tente " +
                    "novamente")
        }

    }while (naoContemBicho)

    listaDeBichos.contains(bichoEscolhido)

    return bichoEscolhido
}
//Jogo do bixo
//TODO: calcular odd com base no número de animais da lista
//TODO: desenvolver acumulo de premio e carteira do usuário
//TODO: desenvolver sistema de comunicação entre conta da banca e do carteira usuário
//TODO: desenvolvedor um modo do usuário poder apostar em mais de um bicho
var carteiraUsuario = 0.0

fun main() {
    var listaBichos = mutableListOf<String>("Cachorro", "Macaco", "Cobra", "Jacaré",
        "Coelho")

    var continuarExecucao = true
    var respostaUsuario = ""
    var contador = 0

    while (continuarExecucao) {

        println("\nVocê deseja fazer uma aposta?\nDigite \"Sim\" para continuar e " +
                "\"Não\" para sair do programa.")
        respostaUsuario = readLine()!!.uppercase()

        if(respostaUsuario == "NÃO") continuarExecucao = false
        if(contador == 0) {
            print("\nDigite qual é a quantia que você tem: ")
            carteiraUsuario = readLine()!!.toDouble()
            contador++
        }

        var bichoSorteado = listaBichos.random()
        var bichoEscolhido = escolheBicho(listaBichos)
        var apostaUsuario = fazAposta(bichoEscolhido)

        if (apostaUsuario <= carteiraUsuario) {
            if (bichoSorteado == bichoEscolhido) {
                println("\nParabéns, você ganhou!")
                carteiraUsuario += apostaUsuario * calculaOdd(listaBichos)
            } else {
                println("\nNão foi dessa vez, mas continue tentando! ;)")
            }

            println("\nO bicho sorteado foi: $bichoSorteado" +
                    "\nO bicho que você escolheu foi: $bichoEscolhido"+
                    "\n\nSeu saldo restante: $carteiraUsuario")
        } else if (carteiraUsuario == 0.0) {
            println("\nVocê faliu 💀💀💀")
            continuarExecucao = false
        }
    }
}

fun escolheBicho(listaDeBichos : List<String>) : String{
    var bichoEscolhido = ""
    var naoContemBicho : Boolean

    do{
        println("\nPor favor, escolha um dos bichos a seguir: ")
        listaDeBichos.forEach{
            println(it)
        }

        bichoEscolhido = readLine()!!.replaceFirstChar { it.uppercase() }
        naoContemBicho = !listaDeBichos.contains(bichoEscolhido)

        if(naoContemBicho){
            println("\nO bicho escolhido não está na lista. Por favor, tente " +
                    "novamente")
        }

    } while (naoContemBicho)

    listaDeBichos.contains(bichoEscolhido)

    return bichoEscolhido
}

fun calculaOdd(lista: List<String>): Int {
    val odd = lista.size
    return odd
}

fun fazAposta(bicho: String): Double {
    print("\nDigite a quantia que você quer apostar no $bicho: ")
    var aposta = readLine()!!.toDouble()
    if (aposta > carteiraUsuario) println("\nSaldo insuficiente")
    else carteiraUsuario -= aposta
    return aposta
}